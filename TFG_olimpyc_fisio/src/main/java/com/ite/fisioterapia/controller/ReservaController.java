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

/**
 * This is the controller relative to all operations performed around Reservas
 */
@Controller
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired ReservaService reserserv;
	
	/**
	 * Returns a list of all the Reservas in the database.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to be populated with the list of Reservas
	 * @return the name of the view for displaying the list of Reservas
	 */
	@GetMapping("/todas")
	public String mostrarReservas (Model model) {
		List<Reserva> reserva = reserserv.findAll();
		model.addAttribute("listareservas", reserva);
		return "/admin/listaUsuarios";
	}
	
	/**
	 * Retrieves the details of a specific Reserva using a GET request.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to which the Reserva attribute will be added.
	 * @param codigo the ID of the Reserva to retrieve.
	 * @return the name of the view that displays the Reserva details.
	 */	
	@GetMapping("/detalle/{id}")
	public String detalleReserva(Model model, @PathVariable(name="id") int codigo) {
		Reserva reserva = reserserv.findById(codigo);
		model.addAttribute("reserva", reserva);
		return "/admin/detalleUsuarios";
	}	
	
	/**
	 * Retrieves the Reserva data to be edited in the form.
	 * @author: Benjamín Ruiz
	 * @param model the model to be used to add the Reserva to be displayed in the form
	 * @param codigo the ID of the Reserva to be edited
	 * @return the path of the view to display the form for editing the Reserva data
	 */
	@GetMapping("/editar/{id}")
	public String editarReserva (Model model, @PathVariable(name="id") int  codigo) {
		Reserva reserva = reserserv.findById(codigo);
		model.addAttribute("reserva", reserva);
		return "/admin/editarFamilias";
	}

	/**
	 * Handles the POST request to edit an existing Reserva.
	 * @author: Benjamín Ruiz
	 * @param reserva The Reserva to be edited.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
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
	
	/**
	 * Displays the registration form for a new Reserva 
	 * @author: Benjamín Ruiz
	 * @param model the Model object to which the Reserva attribute will be added.
	 * @return the name of the view for registering a new Reserva .
	 */	
	@GetMapping ("/alta")
	public String altaReserva() {	
		return "/admin/altaFamilia";
	}
	
	/**
	 * This method handles the HTTP POST request for creating a new Reserva.It receives a Reserva object from the request's body, 
	 * tries to add it to the database via the reserserv service,and returns a redirect to the homepage with a success or error message.
	 * @author: Benjamín Ruiz
	 * @param reserva the Reserva object representing the new Reserva to be added
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @param model the Model object used to add attributes to the view
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String altaReserva (Reserva reserva, RedirectAttributes attr, Model model) {
		if (reserserv.altaReserva(reserva) == 1) 
			model.addAttribute("mensajeExito", "Reserva dada de alta correctamente");
		else 
			model.addAttribute("mensajeError", "Error al dar de alta la reserva");
		return "/comunes/mensaje";
	}
	
	//TO DO
	@GetMapping("/cancelar/{id}")
	public String cancelarReserva (Model model, @PathVariable(name="id") int codigo) {
		Reserva reserva = reserserv.findById(codigo);
		Cita cita = reserva.getCita();
		cita.setDisponible(1);
		reserva.setCita(cita);
		model.addAttribute("reserva", reserva);
		return "/comunes/mensaje";
	}
	
	/**
	 * Handles a GET requests to delete a Reserva with the given ID.
	 * @author: Benjamín Ruiz
	 * @param codigo the ID of the Reserva to be deleted.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarReserva (Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {
		if (reserserv.eliminarReserva(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "Reserva eliminada");
		else
			attr.addFlashAttribute("mensajeError", "Reserva no eliminado");
		return "forward:/";	 
	}
}
