package com.ite.fisioterapia.service;

import java.util.List;

import com.ite.fisioterapia.entities.Cita;

public interface CitaService {
	int altaCita(Cita cita);
	int eliminarCita (int idCita);
	int editarCita (Cita cita);
	Cita findById(int idCita);
    List<Cita> findAll();
   	List<Cita> findByEspecialista(int idUsuario); 
    List<Cita> findByDisponible (int disponible);
}
