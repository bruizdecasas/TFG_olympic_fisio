package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.repository.UsuarioRepository;


/**
 * Class that implements the UsuarioService interface.
 * @author jesus
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository urepo;
	
	/**
	 * Method to register a new user.
	 * @param user Represents the user object to be registered.
	 * @return If the appointment is saved successfully, it returns 1. Otherwise, it returns 0.
	 */	
	@Override
	public int altaUsuario(Usuario usuario) {
        try {
            this.urepo.save(usuario);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to delete an user.
	 * @param idUsuario Represents the ID of the user to be deleted.
	 * @return If the user is deleted successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int eliminarUsuario(int idUsuario) {
        try {
            this.urepo.deleteById(idUsuario);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }
	
	/**
	 * Method to edit an user.
	 * @param usuario Represents the user object to be edit.
	 * @return If the user is edited successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int editarUsuario(Usuario usuario) {
		try {
			urepo.save(usuario);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Method to find an user.
	 * @param idUsuario Represents the ID of the user to be found.
	 * @return If the user is found successfully, it returns the entity Usurio with the given id. Otherwise, it returns null.
	 */
	@Override
	public Usuario findById(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}
	
	/**
	 * Method to find all users.
	 * @return A list with all the users in the repository.
	 */
	@Override
	public List<Usuario> findAll() {
		return this.urepo.findAll();
	}

	/**
	 * Method to search for a user by its email.
	 * @param email Represents the email object to be found.
	 * @return  The user object whose email matches
	 */	
	@Override
	public Usuario findByEmail(String email) {
		return urepo.findByEmail(email);
	}
	
	/**
	 * Method to search all users with the same rol.
	 *@param idRol The ID of the role to filter the users by 
	 * @return  The user object whose email matches
	 */
	@Override
	public List<Usuario> findByRol(int idRol) {
		return this.urepo.findByRol(idRol);
	}

}
