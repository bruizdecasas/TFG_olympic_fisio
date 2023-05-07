package com.ite.fisioterapia.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/")
	public String home(Model model) {			
		List<Producto> lista = prodServe.findAll();		
		model.addAttribute("listaProductos", lista);		
		return "/index";		 		
	}
	
	@GetMapping("/registrado")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {	
		Usuario usuario = userServe.findByEmail(aut.getName());
		System.out.println("LOGIN ID ====== "+usuario.getIdUsuario());
		misesion.setAttribute("IDusuario", usuario.getIdUsuario());
		return "/index";
	}


	
}
