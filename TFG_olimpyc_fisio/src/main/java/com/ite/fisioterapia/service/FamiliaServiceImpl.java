package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Familia;
import com.ite.fisioterapia.repository.FamiliaRepository;

/**
 * Class that implements the FamiliaService interface.
 * @author jesus
 */
@Service
public class FamiliaServiceImpl implements FamiliaService{
	
	@Autowired
	private FamiliaRepository frepo;

	/**
	 * Method to register a new family.
	 * @param familia Represents the family object to be registered.
	 * @return If the appointment is saved successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int altaFamilia(Familia familia) {
        try {
            this.frepo.save(familia);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to delete a family.
	 * @param idFamilia Represents the ID of the family to be deleted.
	 * @return If the family is deleted successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int eliminarFamilia(int idFamilia) {
        try {
            this.frepo.deleteById(idFamilia);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	/**
	 * Method to edit a family.
	 * @param famlia Represents the family object to be edit.
	 * @return If the family is edited successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int editarFamilia(Familia familia) {
		if (findById(familia.getIdFamilia()) == null) return 0;
		try {
			frepo.save(familia);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Method to find a family.
	 * @param idFamilia Represents the ID of the family to be found.
	 * @return If the family is found successfully, it returns the entity Familia with the given id. Otherwise, it returns null.
	 */
	@Override
	public Familia findById(int idFamilia) {
		return frepo.findById(idFamilia).orElse(null);
	}
	
	/**
	 * Method to find all families.
	 * @return A list with all the families in the repository.
	 */
	@Override
	public List<Familia> findAll() {
		return this.frepo.findAll();
	}

}
