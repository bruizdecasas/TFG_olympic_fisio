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
import com.ite.fisioterapia.entities.Reserva;
import com.ite.fisioterapia.service.ReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired ReservaService reserserv;
	
	@GetMapping("/todas")
	public String mostrarReservas (Model model) {
		List<Reserva> reserva = reserserv.findAll();
		model.addAttribute("listareservas", reserva);
		return "/admin/listaUsuarios";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleReserva(Model model, @PathVariable(name="id") int codigo) {
		Reserva reserva = reserserv.findById(codigo);
		model.addAttribute("reserva", reserva);
		return "/admin/detalleUsuarios";
	}	
	
	@GetMapping("/editar/{id}")
	public String editarReserva (Model model, @PathVariable(name="id") int  codigo) {
		Reserva reserva = reserserv.findById(codigo);
		model.addAttribute("reserva", reserva);
		return "/admin/editarFamilias";
	}

	@PostMapping("/editar")
	public String editarReserva (Reserva reserva, RedirectAttributes attr, Model model) {
		if (reserserv.editarReserva(reserva) == 1) 
			model.addAttribute("mensajeExito", "Reserva editada correctamente");
		else if (reserserv.editarReserva(reserva) == 2) 
			model.addAttribute("mensajeError", "Reserva no encontrada");
		else
			model.addAttribute("mensajeError", "Error al editar la reserva");
		return "/comunes/mensaje";
	}
	
	@GetMapping ("/alta")
	public String altaReserva() {	
		return "/admin/altaFamilia";
	}
	
	@PostMapping("/alta")
	public String altaReserva (Reserva reserva, RedirectAttributes attr, Model model) {
		if (reserserv.altaReserva(reserva) == 1) 
			model.addAttribute("mensajeExito", "Reserva dada de alta correctamente");
		else 
			model.addAttribute("mensajeError", "Error al dar de alta la reserva");
		return "/comunes/mensaje";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelarReserva (Model model, @PathVariable(name="id") int codigo) {
		Reserva reserva = reserserv.findById(codigo);
		Cita cita = reserva.getCita();
		cita.setDisponible(1);
		reserva.setCita(cita);
		model.addAttribute("reserva", reserva);
		return "/comunes/mensaje";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarReserva (Model model, @PathVariable(name="id") int  codigo) {
		if (reserserv.eliminarReserva(codigo) == 1)
			model.addAttribute("mensajeExito", "Reserva eliminada");
		else
			model.addAttribute("mensajeError", "Reserva no eliminado");
		return "forward:/";	 
	}
}
