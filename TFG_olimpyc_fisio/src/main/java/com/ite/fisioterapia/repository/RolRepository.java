package com.ite.fisioterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ite.fisioterapia.entities.Rol;



@Repository
public interface RolRepository extends JpaRepository <Rol,Integer>{
	
	
	
}
