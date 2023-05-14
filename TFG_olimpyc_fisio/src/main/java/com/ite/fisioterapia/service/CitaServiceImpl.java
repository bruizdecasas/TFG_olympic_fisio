package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Cita;
import com.ite.fisioterapia.repository.CitaRepository;

/**
 * Class that implements the CitaService interface.
 * @author jesus
 */
@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
	private CitaRepository repositorioCitas;
	
/**
 * Method to register a new appointment.
 * @param cita Represents the appointment object to be registered.
 * @return If the appointment is saved successfully, it returns 1. Otherwise, it returns 0.
 */
	@Override
	public int altaCita(Cita cita) {
		try {
            this.repositorioCitas.save(cita);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to delete an appointment.
	 * @param idCita Represents the ID of the appointment to be deleted.
	 * @return If the appointment is deleted successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int eliminarCita(int idCita) {
		try {
            this.repositorioCitas.deleteById(idCita);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to edit an appointment.
	 * @param cita Represents the appointment object to be edit.
	 * @return If the appointment is edited successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int editarCita(Cita cita) {
		try {
            this.repositorioCitas.save(cita);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to find an appointment.
	 * @param idCita Represents the ID of the appointment to be found.
	 * @return If the appointment is found successfully, it returns the entity Cita with the given id. Otherwise, it returns null.
	 */
	@Override
	public Cita findById(int idCita) {

		return repositorioCitas.findById(idCita).orElse(null);
	}
	
	/**
	 * Method to find all appointments.
	 * @return A list with all the appointments in the repository.
	 */
	@Override
	public List<Cita> findAll() {

		return repositorioCitas.findAll();
	}
	
	/**
	 * Method to search for the list of appointments for a specialist.
	 * @param idCita Represents the ID of the specialist to be found.
	 * @return  A list with all the appointments of the specialist in the repository.
	 */
	@Override
	public List<Cita> findByEspecialista(int idEspecialista) {
		//revisar la query de esta consulta en el respository
		return repositorioCitas.findByEspecialista(idEspecialista);
	}

}
