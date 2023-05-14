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
import com.ite.fisioterapia.entities.Producto;
import com.ite.fisioterapia.service.FamiliaService;
import com.ite.fisioterapia.service.ProductoService;


/**
 * This is the controller relative to all operations performed around Productos
 */
@RequestMapping ("/producto")
@Controller
public class ProductoController {
	
	@Autowired private ProductoService productoServ;
	@Autowired private FamiliaService familiaServ;
	
	/**
	 * Displays the registration form for a new Producto and adds a list of Familias to the model.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to which the Familia attribute will be added.
	 * @return the name of the view for registering a new Producto .
	 */	
	@GetMapping("/alta")
	public String altaProducto (Model model) {
		 List<Familia> familia = familiaServ.findAll();
		 model.addAttribute("listaFamilia", familia);
	    return "/producto/altaProducto";
			}
	
	/**
	 * This method handles the HTTP POST request for creating a new Producto.It receives a Producto object from the request's body, 
	 * tries to add it to the database via the productoServ service,and returns a redirect to the homepage with a success or error message.
	 * @author: Benjamín Ruiz
	 * @param producto the Producto object representing the new Producto to be added
	 * @param idFamilia the ID of the family to which the product belongs
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @param model the Model object used to add attributes to the view
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String altaProducto (Producto producto,int idFamilia, RedirectAttributes attr, Model model) {		
		Familia familia = familiaServ.findById(idFamilia);
		producto.setFamilia(familia);				
		if (productoServ.altaProducto(producto) == 1) 		
			attr.addFlashAttribute("mensajeExito", "Producto dado de alta correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido realizar el alta del producto");	
		return "redirect:/";
	}
	
	/**
	 * Retrieves the Producto data to be edited and the list of available Familias to be displayed in the form.
	 * @author: Benjamín Ruiz
	 * @param model the model to be used to add the Producto and Familia attributes to be displayed in the form
	 * @param codigo the ID of the Producto to be edited
	 * @return the path of the view to display the form for editing the Producto data
	 */
	@GetMapping("/editar/{id}")
	public String editarProductos (Model model, @PathVariable(name="id") int  codigo) {
		Producto producto = productoServ.findById(codigo);
		model.addAttribute("producto", producto); 
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilia", familia);
	    return "/producto/editarProducto";
			}	
	
	/**
	 * Handles the POST request to edit an existing Producto.
	 * @author: Benjamín Ruiz
	 * @param producto The Producto to be edited.
	 * @param idFamilia the ID of the producto´s Familia.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@PostMapping("/editar")
	public String editarProducto(Producto producto, int idFamilia, RedirectAttributes attr, Model model) {		
		Familia familia = familiaServ.findById(idFamilia);
		producto.setFamilia(familia);
		if (productoServ.altaProducto(producto) == 1) 	
			attr.addFlashAttribute("mensajeExito", "Producto editado correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido editar el producto");		
		return "redirect:/";
	}
	
	/**
	 * Handles a GET requests to delete a Producto with the given ID.
	 * @author: Benjamín Ruiz
	 * @param codigo the ID of the Producto to be deleted.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {
		
		if (productoServ.eliminarProducto(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "producto eliminado");
		else
			attr.addFlashAttribute("mensajeError", "producto no eliminado");
		return "redirect:/";
	}
	
	/**
	 * Retrieves the details of a specific Producto using a GET request.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to which the Producto attribute will be added.
	 * @param codigo the ID of the Producto to retrieve.
	 * @return the name of the view that displays the Producto details.
	 */	
	@GetMapping("/detalle/{id}")
	public String verUno(Model model, @PathVariable(name="id") int  codigo) {
		Producto producto = productoServ.findById(codigo);
		model.addAttribute("producto", producto);		
		return "/producto/detalleProducto";	 		
	}
	
	/**
	 * Returns a list of all the Productos in the database.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to be populated with the list of Productos
	 * @return the name of the view for displaying the list of Productos
	 */
	@GetMapping("/todos")
	public String mostrarProductos(Model model) {
		List<Producto> producto = productoServ.findAll();
		model.addAttribute("listaProductos", producto);
		return "/producto/listaProducto";
	}
	
	/**
	 * Returns a list of all the Productos in the database that belong to a certain family, determined by the codigo.
	 * @author: Benjamín Ruiz
	 * @param model the Model object to be populated with the list of Productos
	 * @param codigo the ID of the Familia whose Productos we are going to show
	 * @return the name of the view that displays the list of Producto
	 */	
	@GetMapping("/productosFamilia/{id}")
	public String mostrarProductosFamilia(Model model,@PathVariable(name="id") int  codigo) {
		List<Producto> producto = productoServ.findPorFamilia(codigo);
		model.addAttribute("listaProductos", producto);
		return "/producto/listaProducto";
	}

}
