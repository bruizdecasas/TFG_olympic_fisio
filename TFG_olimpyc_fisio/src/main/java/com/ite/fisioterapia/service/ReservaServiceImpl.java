package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Reserva;
import com.ite.fisioterapia.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repositorioReservas;
	
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

	@Override
	public Reserva findById(int idReserva) {

		return repositorioReservas.findById(idReserva).orElse(null);
	}

	@Override
	public List<Reserva> findAll() {

		return repositorioReservas.findAll();
	}

	@Override
	public List<Reserva> findByUsuario(int idUsuario) {

		return repositorioReservas.findByUsuario(idUsuario);
	}

}
