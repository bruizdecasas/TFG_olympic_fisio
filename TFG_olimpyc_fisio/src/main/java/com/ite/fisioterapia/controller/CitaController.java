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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ite.fisioterapia.entities.Cita;
import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.service.CitaService;
import com.ite.fisioterapia.service.UsuarioService;

/**
 * This is the controller relative to all operations performed around Citas
 * @author: Benjamín Ruiz
 * @author: Jesús Raboso
 * @author: Silvia Piñel
 */
@Controller
@RequestMapping("/cita")
public class CitaController {
	
	@Autowired private CitaService citaserv;
	@Autowired private UsuarioService usuarioServ;
	
	/**
	 * Returns a list of all the Citas in the database.
	 * @param model the Model object to be populated with the list of Citas
	 * @return the name of the view for displaying the list of Citas
	 */
	@GetMapping("/todas")
	public String mostrarCitas (Model model) {
		List<Cita> cita = citaserv.findAll();
		model.addAttribute("listacitas", cita);
		List<Usuario> usuario = usuarioServ.findByRol(2);
		model.addAttribute("listaUsuarios", usuario);
		return "/reservas/listaCitas";
	}
	
	/**
	 * Returns a list of all the Citas in the database relative to the user who created them.
	 * @param model the Model object to be populated with the list of Citas
	 * @return the name of the view for displaying the list of Citas
	 */
	@GetMapping("/todas/{id}")
	public String mostrarCitasEspecialista (Model model,@PathVariable(name = "id") int codigo) {
		List<Cita> cita = citaserv.findByEspecialista(codigo);
		model.addAttribute("listacitas", cita);
		return "/reservas/listaCitas";
	}
	
	
	
	/**
	 * Returns a list of all available Citas in the database.
	 * @param model the Model object to be populated with the list of available Citas 
	 * @return the name of the view for displaying the list of available Citas 
	 */
	@GetMapping ("/disponible")
	public String mostrarCitasDisponibles (Model model) {
		List<Cita> cita = citaserv.findByDisponible(1);
		model.addAttribute("listacitas", cita);
		return "/reservas/listaCitasDisponibles";
	}
	
	/**
	 * Retrieves the Cita data to be edited in the form.
	 * @param model the model to be used to add the Cita to be displayed in the form
	 * @param codigo the ID of the Cita to be edited
	 * @return the path of the view to display the form for editing the Cita data
	 */
	@GetMapping("/editar/{id}")
	public String editarCita (Model model, @PathVariable(name="id") int  codigo) {
		Cita cita = citaserv.findById(codigo);
		model.addAttribute("cita", cita);
		return "/reservas/editarCita";
	}

	/**
	 * Handles the POST request to edit an existing Cita.
	 * @param aut: an Authentication object that represents the authentication information of the user making the request.
	 * @param cita The Cita to be edited.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@PostMapping("/editar")
	public String editarCita (Authentication aut, Cita cita, RedirectAttributes attr, Model model) {
		cita.setDisponible(1);
		Usuario usuario = usuarioServ.findByEmail(aut.getName());
		cita.setUsuario(usuario);
		if (citaserv.editarCita(cita) == 1) 
			attr.addFlashAttribute("mensajeExito", "Cita editada correctamente");
		else if (citaserv.editarCita(cita) == 2) 
			attr.addFlashAttribute("mensajeError", "Cita no encontrada");
		else
			attr.addFlashAttribute("mensajeError", "error al editar la cita");
		return "redirect:/cita/todas";
	}
	
	/**
	 * Displays the registration form for a new Cita, It retrieves the logged in user's information and adds it to the model.
	 * @param aut the authentication object containing the Usuario´s credentials
	 * @param model the model object to be used in the view
	 * @param misesion the HttpSession object for the current user session
	 * @return the name of the view to display the Cita creation form
	 */	
	@GetMapping ("/alta")
	public String altaCita(Authentication aut, Model model, HttpSession misesion) {
		Usuario usuario = usuarioServ.findByEmail(aut.getName());
		model.addAttribute("usuario", usuario);
		return "/reservas/altaCita";
	}
		
	/**
	 * This method handles the HTTP POST request for creating a new Cita.It receives a Cita object from the request's body, 
	 * tries to add it to the database via the citaserv service,and returns a redirect to the homepage with a success or error message.
	 * @param aut: an Authentication object that represents the authentication information of the user making the request.
	 * @param cita the Cita object representing the new Cita to be added
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @param model the Model object used to add attributes to the view
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String altaCita (Authentication aut, Cita cita, RedirectAttributes attr, Model model, HttpSession session) {
		cita.setDisponible(1);
		Usuario usuario = usuarioServ.findByEmail(aut.getName());
		cita.setUsuario(usuario);
		if (citaserv.altaCita(cita) == 1) 
			attr.addFlashAttribute("mensajeExito", "Cita dada de alta correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "Error al dar de alta la cita");
		return "redirect:/cita/todas";
	}
	
	/**
	 * Handles a GET requests to delete a Cita with the given ID.
	 * @param codigo the ID of the Cita to be deleted.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {
		if (citaserv.eliminarCita(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "Cita eliminada");
		else
			attr.addFlashAttribute("mensajeError", "Cita no eliminada");
		return "redirect:/cita/todas";	 
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
