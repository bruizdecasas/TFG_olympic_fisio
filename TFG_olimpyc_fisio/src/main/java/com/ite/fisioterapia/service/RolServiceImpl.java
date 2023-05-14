package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Rol;
import com.ite.fisioterapia.repository.RolRepository;

/**
 * Class that implements the RolService interface.
 * @author jesus
 */
@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolrepo;

	/**
	 * Method to register a new rol.
	 * @param rol Represents the rol object to be registered.
	 * @return If the appointment is saved successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int altaRol(Rol rol) {
        try {
            this.rolrepo.save(rol);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	/**
	 * Method to delete a rol.
	 * @param idRol Represents the ID of the rol to be deleted.
	 * @return If the rol is deleted successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int eliminarRol(int idRol) {
        try {
            this.rolrepo.deleteById(idRol);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to edit a rol.
	 * @param rol Represents the rol object to be edit.
	 * @return If the rol is edited successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int editarRol(Rol rol) {
		if (findById(rol.getIdRol()) == null) return 0;
		try {
			rolrepo.save(rol);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Method to find a rol.
	 * @param idRol Represents the ID of the rol to be found.
	 * @return If the rol is found successfully, it returns the entity Rol with the given id. Otherwise, it returns null.
	 */
	@Override
	public Rol findById(int idRol) {
		return rolrepo.findById(idRol).orElse(null);
	}
	
	/**
	 * Method to find all roles.
	 * @return A list with all the roles in the repository.
	 */
	@Override
	public List<Rol> findAll() {
		return this.rolrepo.findAll();
	}
	
}
