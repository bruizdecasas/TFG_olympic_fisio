package com.ite.fisioterapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.fisioterapia.entities.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva,Integer>{
    @Query(nativeQuery = true, value = "select * from citas where id_usuario=?")
				List<Reserva> findByUsuario(int idUsuario);

}
