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


import com.ite.fisioterapia.entities.Cita;
import com.ite.fisioterapia.service.CitaService;

@Controller
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired CitaService citaserv;
	
	@GetMapping("/todas")
	public String mostrarCitas (Model model) {
		List<Cita> cita = citaserv.findAll();
		model.addAttribute("listacitas", cita);
		return "/admin/listaUsuarios";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleCita(Model model, @PathVariable(name="id") int codigo) {
		Cita cita = citaserv.findById(codigo);
		model.addAttribute("cita", cita);
		return "/admin/detalleUsuarios";
	}	
	
	@GetMapping("/editar/{id}")
	public String editarCita (Model model, @PathVariable(name="id") int  codigo) {
		Cita cita = citaserv.findById(codigo);
		model.addAttribute("cita", cita);
		return "/admin/editarFamilias";
	}

	@PostMapping("/editar")
	public String editarCita (Cita cita, RedirectAttributes attr, Model model) {
		if (citaserv.editarCita(cita) == 1) 
			model.addAttribute("mensajeExito", "Cita editada correctamente");
		else if (citaserv.editarCita(cita) == 2) 
			model.addAttribute("mensajeError", "Cita no encontrada");
		else
			model.addAttribute("mensajeError", "error al editar la cita");
		return "/comunes/mensaje";
	}
	
	@GetMapping ("/alta")
	public String altaCita() {
	
		return "/admin/altaFamilia";
	}
	
	@PostMapping("/alta")
	public String altaCita (Cita cita, RedirectAttributes attr, Model model) {
		if (citaserv.altaCita(cita) == 1) 
			model.addAttribute("mensajeExito", "Cita dada de alta correctamente");
		else 
			model.addAttribute("mensajeError", "Error al dar de alta la cita");
		return "/comunes/mensaje";
	}
	
	@GetMapping("/reserva/{id}")
	public String reservarCita (Model model, @PathVariable(name="id") int codigo) {
		Cita cita = citaserv.findById(codigo);
		cita.setDisponible(0);
		model.addAttribute("cita", cita);
		return "/comunes/mensaje";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo) {
		if (citaserv.eliminarCita(codigo) == 1)
			model.addAttribute("mensajeExito", "producto eliminado");
		else
			model.addAttribute("mensajeError", "producto no eliminado");
		return "forward:/";	 
	}

}
