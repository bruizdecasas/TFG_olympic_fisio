package com.ite.fisioterapia.service;

import java.util.List;

import com.ite.fisioterapia.entities.Rol;

public interface RolService {
	int altaRol(Rol rol);
	int eliminarRol (int idRol);
	int editarRol (Rol rol);
	Rol findById(int idRol);
	List<Rol> findAll();
}
