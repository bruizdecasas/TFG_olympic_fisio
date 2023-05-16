package com.ite.fisioterapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ite.fisioterapia.entities.Usuario;






@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {
	 
	 @Query(nativeQuery = true, value ="select * from Usuarios u where u.email_usuario = ?1")
			
	 	public Usuario findByEmail (String email);
	 
	 @Query (nativeQuery = true, value="select * from usuarios where id_rol = ?1")
	 
		 public List<Usuario> findByRol(int idRol);

}




