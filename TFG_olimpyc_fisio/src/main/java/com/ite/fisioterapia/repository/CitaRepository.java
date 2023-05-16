package com.ite.fisioterapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ite.fisioterapia.entities.Cita;



@Repository
public interface CitaRepository extends JpaRepository <Cita,Integer>{
    
	@Query(nativeQuery = true, value = "select * from citas where especialista=?")
				List<Cita> findByEspecialista(int idUsuario);
	
	@Query(nativeQuery = true, value = "select * from citas where disponible=?")
				List<Cita> findByDisponible(int disponible);
}
