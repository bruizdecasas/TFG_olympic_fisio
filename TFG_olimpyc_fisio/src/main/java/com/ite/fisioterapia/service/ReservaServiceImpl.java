package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Reserva;
import com.ite.fisioterapia.repository.ReservaRepository;

/**
 * Class that implements the ReservaService interface.
 * @author: Benjamín Ruiz
 * @author: Jesús Raboso
 * @author: Silvia Piñel
 */
@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repositorioReservas;
	
	/**
	 * Method to register a new reservation.
	 * @param reserva Represents the reservation object to be registered.
	 * @return If the appointment is saved successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int altaReserva(Reserva reserva) {
		try {
            this.repositorioReservas.save(reserva);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to delete a reservation.
	 * @param idReserva Represents the ID of the reservation to be deleted.
	 * @return If the reservation is deleted successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int eliminarReserva(int idReserva) {
		try {
            this.repositorioReservas.deleteById(idReserva);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	/**
	 * Method to edit a reservation.
	 * @param reserva Represents the reservation object to be edit.
	 * @return If the reservation is edited successfully, it returns 1. Otherwise, it returns 0.
	 */
	@Override
	public int editarReserva(Reserva reserva) {
		try {
            this.repositorioReservas.save(reserva);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}
	
	/**
	 * Method to find a reservation.
	 * @param idReserva Represents the ID of the reservation to be found.
	 * @return If the reservation is found successfully, it returns the entity Reserva with the given id. Otherwise, it returns null.
	 */
	@Override
	public Reserva findById(int idReserva) {

		return repositorioReservas.findById(idReserva).orElse(null);
	}
	
	/**
	 * Method to find all reservations.
	 * @return A list with all the reservations in the repository.
	 */
	@Override
	public List<Reserva> findAll() {

		return repositorioReservas.findAll();
	}
	
	/**
	 * Method to search for the list of reservations for a user.
	 * @param idUsuario Represents the ID of the user to be found.
	 * @return  A list with all the reservations of the user in the repository.
	 */
	@Override
	public List<Reserva> findByUsuario(int idUsuario) {

		return repositorioReservas.findByUsuario(idUsuario);
	}

}
