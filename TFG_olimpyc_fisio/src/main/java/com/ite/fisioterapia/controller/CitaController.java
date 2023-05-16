package com.ite.fisioterapia.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.fisioterapia.entities.Cita;
import com.ite.fisioterapia.entities.Reserva;
import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.service.CitaService;
import com.ite.fisioterapia.service.ReservaService;
import com.ite.fisioterapia.service.UsuarioService;

/**
 * This is the controller relative to all operations performed around Reservas
 */
@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired ReservaService reserserv;
	@Autowired private UsuarioService usuarioServ;
	@Autowired private CitaService citaserv;
	
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
		return "/reservas/listaReservas";
	}
	
	/**
	 * Returns a list of all the Reservas in the database relative to the user who is connected.
	 * @author: Benjamín Ruiz
	 * @param aut the Authentication represents the authenticated user
	 * @param model the Model object to be populated with the list of Reservas
	 * @return the name of the view for displaying the list of Reservas
	 */
	@GetMapping("/misResevas")
	public String mostrarMisReservas (Model model, Authentication aut, HttpSession misesion) {
		Usuario usuario = usuarioServ.findByEmail(aut.getName());
		List<Reserva> reserva = reserserv.findByUsuario(usuario.getIdUsuario());
		model.addAttribute("listareservas", reserva);
		return "/reservas/listaReservas";
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
		return "/reservas/detalleReserva";
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
		return "/reservas/editarReserva";
	}

	/**
	 * Handles the POST request to edit an existing Reserva.
	 * @author: Benjamín Ruiz
	 * @param reserva The Reserva to be edited.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@PostMapping("/editar")
	public String editarReserva (Reserva reserva, RedirectAttributes attr) {
	    int resultado = reserserv.editarReserva(reserva);
	    if (resultado == 1) {
	        attr.addFlashAttribute("mensajeExito", "Reserva editada correctamente");
	    } else if (resultado == 2) {
	        attr.addFlashAttribute("mensajeError", "Reserva no encontrada");
	    } else {
	        attr.addFlashAttribute("mensajeError", "Error al editar la reserva");
	    }
		return "/";
	}
	
	/**
	 * Displays the registration form for a new Reserva 
	 * @author: Benjamín Ruiz
	 * @param model the Model object to which the Reserva attribute will be added.
	 * @return the name of the view for registering a new Reserva .
	 */	
	@GetMapping ("/alta/{id}")
	public String altaReserva(Model model, @PathVariable(name="id") int  codigo) {
		Cita cita = citaserv.findById(codigo);
		model.addAttribute("cita", cita);
		return "/reservas/altaReserva";
	}
	
	/**
	 * This method handles the HTTP POST request for creating a new Reserva.It receives a Reserva object from the request's body, 
	 * tries to add it to the database via the reserserv service,and returns a redirect to the homepage with a success or error message.
	 * @author: Benjamín Ruiz
	 * @param reserva the Reserva object representing the new Reserva to be added
	 * @param idCita The ID of the associated Cita.
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @param model the Model object used to add attributes to the view
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String altaReserva (@RequestParam("idCita") int idCita, Reserva reserva, RedirectAttributes attr, Model model, Authentication aut, HttpSession misesion) {
	    Usuario usuario = usuarioServ.findByEmail(aut.getName());
	    reserva.setUsuario(usuario);
	    Cita cita = citaserv.findById(idCita);
	    reserva.setCita(cita);	
	    if (reserserv.altaReserva(reserva) == 1) {
	        model.addAttribute("mensajeExito", "Reserva dada de alta correctamente");
	        Cita citaReservada = reserva.getCita();
	        citaReservada.setDisponible(0);
	        citaserv.editarCita(citaReservada);
	    } else { 
	        model.addAttribute("mensajeError", "Error al dar de alta la reserva");
	    }   
	    return "redirect:/";
	}
	
	/**
	 * Handles a GET requests to cancell a Reserva with the given ID. 
	 * This method deletes the Reserva and makes the associated Cita available again.
	 * @author: Benjamín Ruiz
	 * @param codigo the ID of the Reserva to be cancelled.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/cancelar/{id}")
	public String cancelarReserva (@PathVariable(name="id") int codigo, RedirectAttributes attr) {
		Reserva reserva = reserserv.findById(codigo);
		Cita cita = reserva.getCita();
		cita.setDisponible(1);
		reserserv.eliminarReserva(codigo);
		attr.addFlashAttribute("mensajeExito", "Has cancelado la reserva");
		return "redirect:/";
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
	
	/**
	 * This custom editor will parse incoming date strings into Date objects and format Date objects into strings in the specified format..
	 * @param webDataBinder the WebDataBinder allow binding of dates in the specified format.
	 */	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
