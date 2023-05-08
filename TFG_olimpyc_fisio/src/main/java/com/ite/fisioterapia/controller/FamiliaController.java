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

import com.ite.fisioterapia.entities.Familia;
import com.ite.fisioterapia.service.FamiliaService;

@RequestMapping("/familia")
@Controller
public class FamiliaController {
	
	@Autowired private FamiliaService familiaServ;

	@GetMapping ("/alta")
	public String altaFamilia() {	
		return "/producto/altaFamilia";
	}
	
	@PostMapping("/alta")
	public String altaFamilia(Familia familia, RedirectAttributes attr, Model model) {
		if (familiaServ.altaFamilia(familia) == 1) 
			model.addAttribute("mensajeExito", "Familia dada de alta correctamente");
		else 
			model.addAttribute("mensajeError", "Error al dar de alta la familia");
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String editarFamilia (Model model, @PathVariable(name="id") int  codigo) {
		Familia familia = familiaServ.findById(codigo);
		model.addAttribute("familia", familia);
		return "/producto/editarFamilias";
	}

	@PostMapping("/editar")
	public String editarFamilia(Familia familia, RedirectAttributes attr, Model model) {
		if (familiaServ.editarFamilia(familia) == 1) 
			model.addAttribute("mensajeExito", "Familia editada correctamente");
		else if (familiaServ.editarFamilia(familia) == 2) 
			model.addAttribute("mensajeError", "familia no encontrada");
		else
			model.addAttribute("mensajeError", "error al eliminar la familia");
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarFamilia (Model model, @PathVariable(name="id") int  codigo) {
		if (familiaServ.eliminarFamilia(codigo) == 1)
			model.addAttribute("mensaje", "familia eliminado");
		else if (familiaServ.eliminarFamilia(codigo) == 2)
			model.addAttribute("mensaje", "familia no encontrada");
		else 
			model.addAttribute("mensaje", "error al eliminar la familia");		
		return "redirect:/";
	}
	
	@GetMapping("/todas")
	public String mostrarFamilias(Model model) {
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilias", familia);
		return "/producto/listaFamilias";
	}
}
