package com.ite.fisioterapia.service;

import java.util.List;

import com.ite.fisioterapia.entities.Reserva;

public interface ReservaService {

	int altaReserva(Reserva reserva);
	int eliminarReserva (int idReserva);
	int editarReserva (Reserva reserva);
	Reserva findById(int idReserva);
    List<Reserva> findAll();
    List<Reserva> findByUsuario(int idUsuario); 
}
