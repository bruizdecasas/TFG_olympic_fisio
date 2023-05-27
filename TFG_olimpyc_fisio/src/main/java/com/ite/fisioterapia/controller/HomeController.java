package com.ite.fisioterapia.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ite.fisioterapia.entities.Producto;
import com.ite.fisioterapia.service.ProductoService;
import com.ite.fisioterapia.service.RolService;
import com.ite.fisioterapia.service.UsuarioService;


/**
 * This is the controller to redirect to the home or index page.
 */
@Controller
public class HomeController {
	@Autowired
	ProductoService prodServe;
	@Autowired
	UsuarioService userServe;
	@Autowired
	RolService rolServe;
	
/**
 * Method to navigate to the home page whether the user is logged in or not.	
 * @param model Object that holds the attributes to be used in the view.
 * @return A String representing the redirect page URL.
 */
	@GetMapping("/")
	public String home(Model model) {			
		List<Producto> lista = prodServe.findAll();		
		model.addAttribute("listaProductos", lista);		
		return "/index";		 		
	}
	
	
	
	
}