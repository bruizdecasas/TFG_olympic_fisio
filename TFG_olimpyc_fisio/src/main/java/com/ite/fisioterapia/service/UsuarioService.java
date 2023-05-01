package com.ite.fisioterapia.service;

import java.util.List;


import com.ite.fisioterapia.entities.Usuario;

public interface UsuarioService {
	int altaUsuario(Usuario usuario);
	int eliminarUsuario (int idUsuario);
	int editarUsuario (Usuario usuario);
	
	Usuario findById(int idUsuario);
	Usuario findByEmail (String email);
	
    List<Usuario> findAll();
  
}
