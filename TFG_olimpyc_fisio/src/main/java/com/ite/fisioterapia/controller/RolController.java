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

/**
 * This is the controller relative to all operations performed around Roles
 */
@RequestMapping("/rol")
@Controller
public class RolController {
	
	@Autowired private RolService rolServ;
	
	/**
	 * Displays the registration form for a new Rol
	 * @author: Benjamín Ruiz
	 * @return the name of the view for registering a new Rol .
	 */	
	@GetMapping ("/alta")
	public String altaRol() {	
		return "/usuarios/altaRol";
	}
	
	/**
	 * This method handles the HTTP POST request for creating a new Rol.It receives a Rol object from the request's body, 
	 * tries to add it to the database via the rolServ service,and returns a redirect to the homepage with a success or error message.
	 * @author: Benjamín Ruiz
	 * @param rol the Rol object representing the new Rol to be added
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String altaRol(Rol rol, RedirectAttributes attr) {
		if (rolServ.altaRol(rol) == 1) 			
			attr.addFlashAttribute("mensajeExito", "Rol dado de alta correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido realizar el alta del rol");	
		return "redirect:/";
	}
	
	/**
	 * Retrieves the Rol data to be edited in the form.
	 * @author: Benjamín Ruiz
	 * @param model the model to be used to add the Rol to be displayed in the form
	 * @param codigo the ID of the Rol to be edited
	 * @return the path of the view to display the form for editing the Rol data
	 */
	@GetMapping("/editar/{id}")
	public String editarrRol (Model model, @PathVariable(name="id") int  codigo) {
		Rol rol = rolServ.findById(codigo);
		model.addAttribute("rol", rol);
		return "/usuarios/editarRol";
	}

	/**
	 * Handles the POST request to edit an existing Rol.
	 * @author: Benjamín Ruiz
	 * @param rol The Rol to be edited.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@PostMapping("/editar")
	public String editarRol(Rol rol, RedirectAttributes attr) {
		if (rolServ.editarRol(rol) == 1) 
			attr.addFlashAttribute("mensajeExito", "Rol editado correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido editar el rol");
		return "redirect:/";
	}
	
	/**
	 * Handles a GET requests to delete a Rol with the given ID.
	 * @author: Benjamín Ruiz
	 * @param codigo the ID of the Rol to be deleted.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarRol (Model model,@PathVariable(name="id") int  codigo, RedirectAttributes attr) {
		if (rolServ.eliminarRol(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "Rol eliminado correctamente");
		else
			attr.addFlashAttribute("mensajeError", "No se ha podido eliminar el rol");
		
		return "redirect:/";
	}
	
	/**
	 * Returns a list of all the Roles in the database.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to be populated with the list of Roles
	 * @return the name of the view for displaying the list of Roles
	 */
	@GetMapping("/todos")
	public String mostrarRoles(Model model) {
		List<Rol> rol = rolServ.findAll();
		model.addAttribute("listaRoles", rol);
		return "/usuarios/listaRoles";
	}	
}

