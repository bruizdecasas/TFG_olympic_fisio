package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Cita;
import com.ite.fisioterapia.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
	private CitaRepository repositorioCitas;
	
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

	@Override
	public Cita findById(int idCita) {

		return repositorioCitas.findById(idCita).orElse(null);
	}

	@Override
	public List<Cita> findAll() {

		return repositorioCitas.findAll();
	}

	@Override
	public List<Cita> findByEspecialista(int idEspecialista) {
		//revisar la query de esta consulta en el respository
		return repositorioCitas.findByEspecialista(idEspecialista);
	}

}
