package com.ite.fisioterapia.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.fisioterapia.entities.Producto;
import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.service.ProductoService;
import com.ite.fisioterapia.service.RolService;
import com.ite.fisioterapia.service.UsuarioService;



@Controller
public class HomeController {
	@Autowired
	ProductoService prodServe;
	@Autowired
	UsuarioService userServe;
	@Autowired
	RolService rolServe;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String verTodos(Model model, Authentication aut) {
		
		List<Producto> lista = prodServe.findAll();
		model.addAttribute("listaProductos", lista);
		
		return "/comunes/listaProducto";
		 		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
		
	@GetMapping("/altausuario")
	public String registrar(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    return "/altausuario";
	}
	
	@PostMapping("/altausuario")
	public String registrarse(Usuario usuario, RedirectAttributes attr) {
		System.out.println(usuario);
		if (userServe.findByEmail(usuario.getEmailUsuario()) != null) {
			attr.addFlashAttribute("mensajeError", "Nombre de usuario ya existe");
			return "/altausuario";
		}
	
		usuario.setEnabled(1);
		usuario.setRol(rolServe.findById(2));
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
	
		if (userServe.altaUsuario(usuario) == 1) {
			attr.addFlashAttribute("mensajeExito", "Registro completo con &eacute;xito");
			return "redirect:/login";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al procesar el alta");
			return "redirect:/altausuario";
		}

	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion, HttpServletRequest req) {
		sesion.invalidate();
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(req, null, null);
		return "redirect:/login";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
}
