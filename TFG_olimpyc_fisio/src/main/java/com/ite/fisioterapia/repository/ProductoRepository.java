package com.ite.fisioterapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ite.fisioterapia.entities.Producto;



@Repository
public interface ProductoRepository extends JpaRepository <Producto,Integer>{
	
    @Query(nativeQuery = true, value = "select * from productos where id_familia=?")
				List<Producto> findPorFamilia(int id_familia);
 
}
