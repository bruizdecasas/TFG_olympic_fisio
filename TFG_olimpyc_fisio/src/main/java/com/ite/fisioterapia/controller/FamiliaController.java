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


/**
 * This is the controller relative to all operations performed around Familia
 * @author: Benjamín Ruiz
 * @author: Jesús Raboso
 * @author: Silvia Piñel
 */
@RequestMapping("/familia")
@Controller
public class FamiliaController {
	
	@Autowired private FamiliaService familiaServ;

	/**
	 * Displays the registration form for a new Familia
	 * @return the name of the view for registering a new Familia .
	 */	
	@GetMapping ("/alta")
	public String altaFamilia() {	
		return "/producto/altaFamilia";
	}
	
	/**
	 * This method handles the HTTP POST request for creating a new Familia.It receives a Familia object from the request's body, 
	 * tries to add it to the database via the familiaServ service,and returns a redirect to the homepage with a success or error message.
	 * @param familia the Familia object representing the new Familia to be added
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @param model the Model object used to add attributes to the view
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String altaFamilia(Familia familia, RedirectAttributes attr, Model model) {
		if (familiaServ.altaFamilia(familia) == 1) 
			attr.addFlashAttribute("mensajeExito", "Familia dada de alta correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "Error al dar de alta la familia");
		return "redirect:/familia/todas";
	}
	
	/**
	 * Retrieves the Familia data to be edited in the form.
	 * @param model the model to be used to add the Familia to be displayed in the form
	 * @param codigo the ID of the Familia to be edited
	 * @return the path of the view to display the form for editing the Familia data
	 */
	@GetMapping("/editar/{id}")
	public String editarFamilia (Model model, @PathVariable(name="id") int  codigo) {
		Familia familia = familiaServ.findById(codigo);
		model.addAttribute("familia", familia);
		return "/producto/editarFamilias";
	}

	/**
	 * Handles the POST request to edit an existing Cita.
	 * @param familia The Familia to be edited.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@PostMapping("/editar")
	public String editarFamilia(Familia familia, RedirectAttributes attr, Model model) {
		if (familiaServ.editarFamilia(familia) == 1) 
			attr.addFlashAttribute("mensajeExito", "Familia editada correctamente");
		else if (familiaServ.editarFamilia(familia) == 2) 
			attr.addFlashAttribute("mensajeError", "familia no encontrada");
		else
			attr.addFlashAttribute("mensajeError", "error al eliminar la familia");
		return "redirect:/familia/todas";
	}
	
	/**
	 * Handles a GET requests to delete a Familia with the given ID.
	 * @param codigo the ID of the Familia to be deleted.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarFamilia (Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {
		if (familiaServ.eliminarFamilia(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "Familia eliminada correctamente");
		else if (familiaServ.eliminarFamilia(codigo) == 2)
			attr.addFlashAttribute("mensajeError", "Familia no encontrada");
		else 
			attr.addFlashAttribute("mensajeError", "Error al eliminar la familia");		
		return "redirect:/familia/todas";
	}
	
	/**
	 * Returns a list of all the Familias in the database.
	 * @param model the Model object to be populated with the list of families
	 * @return the name of the view for displaying the list of families
	 */
	@GetMapping("/todas")
	public String mostrarFamilias(Model model) {
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilias", familia);
		return "/producto/listaFamilias";
	}
}
