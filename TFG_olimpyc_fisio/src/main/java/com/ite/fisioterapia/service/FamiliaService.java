package com.ite.fisioterapia.service;

import java.util.List;

import com.ite.fisioterapia.entities.Familia;

public interface FamiliaService {
	int altaFamilia(Familia familia);
	int eliminarFamilia (int idFamilia);
	int editarFamilia (Familia familia);
	Familia findById(int idFamilia);
	List<Familia> findAll();
}
