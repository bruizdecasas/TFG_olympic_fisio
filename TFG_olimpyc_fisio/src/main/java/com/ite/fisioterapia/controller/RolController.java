package com.ite.fisioterapia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ite.fisioterapia.entities.Rol;
import com.ite.fisioterapia.service.RolService;

@RequestMapping("/rol")
@Controller
public class RolController {
	
	@Autowired private RolService rolServ;
	
	@GetMapping ("/alta")
	public String altaRol() {	
		return "/admin/altaRol";
	}
	
	@PostMapping("/alta")
	public String altaRol(Rol rol, RedirectAttributes attr) {
		if (rolServ.altaRol(rol) == 1) 			
			attr.addFlashAttribute("mensajeExito", "Rol dado de alta correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido realizar el alta del rol");
		
		return "forward:/admin/listaRoles";
	}
	
	@GetMapping("/editar/{id}")
	public String editarrRol (Model model, @PathVariable(name="id") int  codigo) {
		Rol rol = rolServ.findById(codigo);
		model.addAttribute("rol", rol);
		return "forward:/admin/editarRol";
	}

	@PostMapping("/editar")
	public String editarRol(Rol rol, RedirectAttributes attr) {
		if (rolServ.editarRol(rol) == 1) 
			attr.addFlashAttribute("mensajeExito", "Rol editado correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido editar el rol");
		return "redirect:/admin/detalleRoles";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarRol (Model model, @PathVariable(name="id") int  codigo) {
		if (rolServ.eliminarRol(codigo) == 1)
			model.addAttribute("mensaje", "rol eliminado");
		else
			model.addAttribute("mensaje", "rol no eliminado");
		
		return "forward:/admin/roles";
	}
	
	@GetMapping("/todos")
	public String mostrarRoles(Model model) {
		List<Rol> rol = rolServ.findAll();
		model.addAttribute("listaRoles", rol);
		return "/admin/listaRoles";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleRoles(Model model, @PathVariable(name="id") int codigo) {
		Rol rol = rolServ.findById(codigo);
		model.addAttribute("rol", rol);
		return "/admin/detalleRoles";
	}

}
