package com.ite.fisioterapia.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.fisioterapia.entities.Rol;
import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.service.RolService;
import com.ite.fisioterapia.service.UsuarioService;

/**
 * This is the controller relative to all operations performed around Usuarios
 * @author: Benjamín Ruiz
 * @author: Jesús Raboso
 * @author: Silvia Piñel
 */
@RequestMapping("/usuario")
@Controller
public class UsuarioController {
	
	@Autowired private UsuarioService usuarioServ;
	@Autowired private RolService roleServe;
	@Autowired private PasswordEncoder passwordEncoder;
	
	/**
	 * Retrieves the details of a specific Usuario using a GET request.
	 * @param aut the Authentication represents the authenticated user
	 * @param model the Model object to which the Usuario attribute will be added.
	 * @param misesion the HttpSession represents the HTTP session that allows data to be stored and retrieved during a user's session.
	 * @return the name of the view that displays the Usuario details.
	 */	
	@GetMapping("/misDatos")
	public String mostrardatos(Authentication aut, Model model, HttpSession misesion) {	
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = usuarioServ.findByEmail(aut.getName());
        model.addAttribute("usuario", usuario);
        return "/usuarios/detalleUsuarios";
    }


	/**
	 * Displays the registration form for a new Usuario and adds a list of Roles to the model.
	 * @param model the Model object to which the Rol List attribute will be added.
	 * @return the name of the view for registering a new Usuario .
	 */	
	@GetMapping("/alta")
	public String registrar(Model model) {
		List<Rol> rol = roleServe.findAll();
	    model.addAttribute("listaRol", rol);
	    return "/usuarios/altaUsuario";
	}
	
	/**
	 * This method handles the HTTP POST request for creating a new Usuario.It receives a Usuario object from the request's body, 
	 * tries to add it to the database via the usuarioServ service,and returns a redirect to the homepage with a success or error message.
	 * @param usuario the Usuario object representing the new Usuario to be added
	 * @param idRol the ID of the rol to which the usuario belongs
	 * @param attr a RedirectAttributes object used to send flash attributes to the redirected page
	 * @return a String representing the URL to be redirected to after the POST request is processed
	 */	
	@PostMapping("/alta")
	public String registrarse(Usuario usuario, RedirectAttributes attr, Integer idRol) {
	    if (usuarioServ.findByEmail(usuario.getEmailUsuario()) != null) {
	        attr.addFlashAttribute("mensajeError", "Nombre de usuario ya existe");
	        return "redirect:/usuarios/altaUsuario";
	    }
	    if (idRol != null) {
	        Rol rol = roleServe.findById(idRol);
	        usuario.setRol(rol);
	    } else {
	    	usuario.setRol(roleServe.findById(3));
	    }
	    usuario.setEnabled(1);
	    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	    if (usuarioServ.altaUsuario(usuario) == 1) {
	        attr.addFlashAttribute("mensajeExito", "Usuario creado correctamente");
	        return "redirect:/";
	    } else {
	        attr.addFlashAttribute("mensajeError", "Error al procesar el alta");
	        return "redirect:/";
	    }
	}
	//TO DO
	@GetMapping ("/password/{id}")
	public String cambiarPassword (Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
		model.addAttribute("usuario", usuario);
		return "/usuarios/password";
	}
	//TO DO
	@PostMapping ("/password")
	public String cambiarPassword (@ModelAttribute("usuario") Usuario usuario,@RequestParam("nuevaPassword") String nuevaPassword, RedirectAttributes attr) {
	    usuario.setPassword(passwordEncoder.encode(nuevaPassword));	    
	    if (usuarioServ.editarUsuario(usuario) == 1) {
	        attr.addFlashAttribute("mensajeExito", "Contraseña cambiada correctamente");
	    } else {
	        attr.addFlashAttribute("mensajeError", "Error al cambiar la contraseña");
	    }	    
	    return "redirect:/";
	}
	
	/**
	 * Retrieves the Usuario data to be edited and the list of available Roles to be displayed in the form.
	 * @param model the model to be used to add the Usuario and Rol attributes to be displayed in the form
	 * @param codigo the ID of the Usuario to be edited
	 * @return the path of the view to display the form for editing the Usuario data
	 */	
	@GetMapping("/editar/{id}")
	public String editarUsuario (Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
		model.addAttribute("usuario", usuario);
		List<Rol> rol = roleServe.findAll();
	    model.addAttribute("listaRol", rol);
		return "/usuarios/editarUsuario";
	}
	
	/**
	 * Handles the POST request to edit an existing Usuario.
	 * @param usuario The Usuario to be edited.
	 * @param idFamilia the ID of the usuario´s Rol.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@PostMapping("/editar")
	public String editarUsuario(Usuario usuario, RedirectAttributes attr, Model model, int idRol) {
		Rol rol = roleServe.findById(idRol);
		usuario.setRol(rol);
		if (usuarioServ.editarUsuario(usuario) == 1) 
			attr.addFlashAttribute("mensajeExito", "Usuario editado correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "Error al editar el usuario");;
		return "redirect:/";
	}

	/**
	 * Handles a GET requests to delete a Usuario with the given ID.
	 * @param codigo the ID of the Usuario to be deleted.
	 * @param model Object that holds the attributes to be used in the view.
	 * @param attr Object that contains attributes for the redirect page.
	 * @return A String representing the redirect page URL.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario (Model model, @PathVariable(name="id") int  codigo, RedirectAttributes attr) {	
		if (usuarioServ.eliminarUsuario(codigo) == 1)
			attr.addFlashAttribute("mensajeExito", "usuario eliminado");
		else
			attr.addFlashAttribute("mensajeError", "usuario NO eliminado");
		
		return "redirect:/";	 
	}
	
	/**
	 * Returns a list of all the Usuarios in the database.
	 * @param model the Model object to be populated with the list of Usuarios
	 * @return the name of the view for displaying the list of Usuarios
	 */
	@GetMapping("/todos")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuario = usuarioServ.findAll();
		model.addAttribute("listaUsuarios", usuario);
		return "/usuarios/listaUsuarios";
	}
	
	/**
	 * Returns a list of all the Usuarios in the database filtered by a certain role.
	 * @param model the Model object to be populated with the list of Usuarios
	 * @return the name of the view for displaying the list of Usuarios
	 */
	@GetMapping("/rol/{id}")
	public String mostrarUsuariosPorRol(Model model, @PathVariable(name = "id") int codigo) {
	    List<Usuario> usuario = usuarioServ.findByRol(codigo);
	    model.addAttribute("listaUsuarios", usuario);
	    return "/usuarios/listaUsuarios";
	}
	
	/**
	 * Retrieves the details of a specific Usuario using a GET request.
	 * @param model the Model object to which the Usuario attribute will be added.
	 * @param codigo the ID of the Usuario to retrieve.
	 * @return the name of the view that displays the Usuario details.
	 */	
	@GetMapping("/detalle/{id}")
	public String detalleUsuario(Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
        model.addAttribute("usuario", usuario);
		return "/usuarios/detalleUsuarios";
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
