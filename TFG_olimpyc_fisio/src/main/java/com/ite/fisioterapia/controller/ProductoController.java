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


@RequestMapping ("/producto")
@Controller
public class ProductoController {
	
	@Autowired private ProductoService productoServ;
	@Autowired private FamiliaService familiaServ;
	
	@GetMapping("/alta")
	public String altaProducto (Model model) {
		 List<Familia> familia = familiaServ.findAll();
		 model.addAttribute("listaFamilia", familia);
	    return "/producto/altaProducto";
			}
	
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
	
	@GetMapping("/editar/{id}")
	public String editarProductos (Model model, @PathVariable(name="id") int  codigo) {
		Producto producto = productoServ.findById(codigo);
		model.addAttribute("producto", producto); 
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilia", familia);
	    return "/producto/editarProducto";
			}	
	
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
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {
		
		if (productoServ.eliminarProducto(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "producto eliminado");
		else
			attr.addFlashAttribute("mensajeError", "producto no eliminado");
		return "redirect:/";
	}
	
	@GetMapping("/detalle/{id}")
	public String verUno(Model model, @PathVariable(name="id") int  codigo) {
		Producto producto = productoServ.findById(codigo);
		model.addAttribute("producto", producto);		
		return "/producto/detalleProducto";	 		
	}
	
	@GetMapping("/todos")
	public String mostrarProductos(Model model) {
		List<Producto> producto = productoServ.findAll();
		model.addAttribute("listaProductos", producto);
		return "/producto/listaProducto";
	}
	
	@GetMapping("/productosFamilia/{id}")
	public String mostrarProductosFamilia(Model model,@PathVariable(name="id") int  codigo) {
		List<Producto> producto = productoServ.findPorFamilia(codigo);
		model.addAttribute("listaProductos", producto);
		return "/producto/listaProducto";
	}

}
