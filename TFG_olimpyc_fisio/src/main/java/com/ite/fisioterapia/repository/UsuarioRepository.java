package com.ite.fisioterapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ite.fisioterapia.entities.Usuario;






@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {

	 @Query(nativeQuery = true, value = "select * from usuarios u inner join direcciones_usuarios du on u.id_usuario = du.id_usuario"
	 		+"inner join direcciones d on d.id_direccion = du.id_direccion where d.cp like ?%")
		
	 				public List<Usuario> usuarioPorCp();
	 
	 @Query(nativeQuery = true, value ="select * from Usuarios u where u.email_usuario = ?1")
	 
				
	 	public Usuario findByEmail (String email);				
	
}



