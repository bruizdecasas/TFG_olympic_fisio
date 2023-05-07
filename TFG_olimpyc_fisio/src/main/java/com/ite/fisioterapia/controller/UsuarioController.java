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
        return "/usuario/misDatos";
    }
	@PostMapping("/misDatos")
	public String mostrardatos() {
		
		return "usuario";
	}
	@GetMapping("/alta")
	public String registrar(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    return "/altaUsuario";
	}
	
	@PostMapping("/alta")
	public String registrarse(Usuario usuario, RedirectAttributes attr) {
		System.out.println(usuario);
		if (usuarioServ.findByEmail(usuario.getEmailUsuario()) != null) {
			attr.addFlashAttribute("mensajeError", "Nombre de usuario ya existe");
			return "/altausuario";
		}
	
		usuario.setEnabled(1);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
	
		if (usuarioServ.altaUsuario(usuario) == 1) {
			attr.addFlashAttribute("mensajeExito", "Registro completo con &eacute;xito");
			return "redirect:/login";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al procesar el alta");
			return "redirect:/altausuario";
		}

	}
	
	@GetMapping("/editar/{id}")
	public String editarUsuario (Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
		model.addAttribute("usuario", usuario);
		return "forward:/admin/editarUsuario";
	}
	
	
	@PostMapping("/editar")
	public String editarUsuario(Usuario usuario, RedirectAttributes attr, Model model) {
		if (usuarioServ.editarUsuario(usuario) == 1) 
			model.addAttribute("mensajeExito", "Usuario editado correctamente");
		else 
			model.addAttribute("mensajeError", "No se ha podido editar el usuario");
		return "/comunes/mensaje";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario (Model model, @PathVariable(name="id") int  codigo) {	
		if (usuarioServ.eliminarUsuario(codigo) == 1)
			model.addAttribute("mensaje", "usuario eliminado");
		else
			model.addAttribute("mensaje", "usuario NO eliminado");
		
		return "forward:/admin/usuarios";	 
	}
	
	@GetMapping("/todos")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuario = usuarioServ.findAll();
		model.addAttribute("listaUsuarios", usuario);
		return "/admin/listaUsuarios";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleUsuario() {		
		return "/admin/detalleUsuarios";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
