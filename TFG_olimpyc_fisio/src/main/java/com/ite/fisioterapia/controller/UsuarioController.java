package com.ite.fisioterapia.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.fisioterapia.entities.Rol;
import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.service.RolService;
import com.ite.fisioterapia.service.UsuarioService;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {
	
	@Autowired private UsuarioService usuarioServ;
	@Autowired RolService roleServe;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@GetMapping("/misDatos")
	public String mostrardatos(Authentication aut, Model model, HttpSession misesion) {	
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = usuarioServ.findByEmail(aut.getName());
        model.addAttribute("usuario", usuario);
        return "/usuarios/detalleUsuarios";
    }

	@GetMapping("/alta")
	public String registrar(Model model) {
		List<Rol> rol = roleServe.findAll();
	    model.addAttribute("listaRol", rol);
	    return "/usuarios/altaUsuario";
	}
	
	@PostMapping("/alta")
	public String registrarse(Usuario usuario, RedirectAttributes attr, int idRol) {
		System.out.println(usuario);
		
		if (usuarioServ.findByEmail(usuario.getEmailUsuario()) != null) {
			attr.addFlashAttribute("mensajeError", "Nombre de usuario ya existe");
			return "/usuarios/altaUsuario";
		}
	
		usuario.setEnabled(1);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		Rol rol = roleServe.findById(idRol);
		usuario.setRol(rol);
		
		if (usuarioServ.altaUsuario(usuario) == 1) {
			attr.addFlashAttribute("mensajeExito", "Usuario creado correctamente");
			return "redirect:/";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al procesar el alta");
			return "redirect:/";
		}

	}
	
	@GetMapping ("/password/{id}")
	public String cambiarPassword (Model model, @PathVariable(name="id") int  codigo) {
		return "/usuarios/password";
	}
	
	@PostMapping ("/password")
	public String cambiarPassword (Model model) {
		return "redirect:/";
	}
		
	
	@GetMapping("/editar/{id}")
	public String editarUsuario (Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
		model.addAttribute("usuario", usuario);
		List<Rol> rol = roleServe.findAll();
	    model.addAttribute("listaRol", rol);
		return "/usuarios/editarUsuario";
	}
	
	
	@PostMapping("/editar")
	public String editarUsuario(Usuario usuario, RedirectAttributes attr, Model model, int idRol) {
		Rol rol = roleServe.findById(idRol);
		usuario.setRol(rol);
		if (usuarioServ.editarUsuario(usuario) == 1) 
			attr.addFlashAttribute("mensajeExito", "Usuario editado correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "Error al editar el usuario");;
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario (Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {	
		if (usuarioServ.eliminarUsuario(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "usuario eliminado");
		else
			attr.addFlashAttribute("mensajeError", "usuario NO eliminado");
		
		return "redirect:/";	 
	}
	
	@GetMapping("/todos")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuario = usuarioServ.findAll();
		model.addAttribute("listaUsuarios", usuario);
		return "/usuarios/listaUsuarios";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleUsuario(Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
        model.addAttribute("usuario", usuario);
		return "/usuarios/detalleUsuarios";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
