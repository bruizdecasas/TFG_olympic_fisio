package com.ite.fisioterapia.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/cita")
public class CitaController {
	
	@Autowired CitaService citaserv;
	
	@GetMapping("/todas")
	public String mostrarCitas (Model model) {
		List<Cita> cita = citaserv.findAll();
		model.addAttribute("listacitas", cita);
		return "/reservas/listaCitas";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleCita(Model model, @PathVariable(name="id") int codigo) {
		Cita cita = citaserv.findById(codigo);
		model.addAttribute("cita", cita);
		return "/reservas/detalleCita";
	}	
	
	@GetMapping("/editar/{id}")
	public String editarCita (Model model, @PathVariable(name="id") int  codigo) {
		Cita cita = citaserv.findById(codigo);
		model.addAttribute("cita", cita);
		return "/reservas/editarCita";
	}

	@PostMapping("/editar")
	public String editarCita (Cita cita, RedirectAttributes attr, Model model) {
		if (citaserv.editarCita(cita) == 1) 
			model.addAttribute("mensajeExito", "Cita editada correctamente");
		else if (citaserv.editarCita(cita) == 2) 
			model.addAttribute("mensajeError", "Cita no encontrada");
		else
			model.addAttribute("mensajeError", "error al editar la cita");
		return "redirect:/";
	}
	
	@GetMapping ("/alta")
	public String altaCita() {
		return "/reservas/altaCita";
	}
	
	@PostMapping("/alta")
	public String altaCita (Cita cita, RedirectAttributes attr, Model model, HttpSession session) {
		if (citaserv.altaCita(cita) == 1) 
			model.addAttribute("mensajeExito", "Cita dada de alta correctamente");
		else 
			model.addAttribute("mensajeError", "Error al dar de alta la cita");
		return "redirect:/";
	}
	
	@GetMapping("/reserva/{id}")
	public String reservarCita(@PathVariable(name="id") int codigo, RedirectAttributes attr) {
	    Cita cita = citaserv.findById(codigo);
	    if (cita == null) {
	        attr.addFlashAttribute("mensajeError", "La cita no existe");
	        return "redirect:/";
	    } else if (cita.getDisponible() == 0) {
	        attr.addFlashAttribute("mensajeError", "La cita ya ha sido reservada");
	        return "redirect:/";
	    } else {
	        cita.setDisponible(0);
	        citaserv.editarCita(cita);
	        attr.addFlashAttribute("mensajeExito", "Cita reservada con éxito");
	        return "redirect:/";
	    }
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo) {
		if (citaserv.eliminarCita(codigo) == 1)
			model.addAttribute("mensajeExito", "producto eliminado");
		else
			model.addAttribute("mensajeError", "producto no eliminado");
		return "redirect:/";	 
	}

}
