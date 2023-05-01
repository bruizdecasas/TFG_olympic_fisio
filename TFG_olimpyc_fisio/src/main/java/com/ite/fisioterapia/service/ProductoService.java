package com.ite.fisioterapia.service;

import java.util.List;

import com.ite.fisioterapia.entities.Producto;

public interface ProductoService {
	int altaProducto(Producto producto);
	int eliminarProducto (int idProducto);
	int editarProducto (Producto producto);
	Producto findById(int idProducto);
    List<Producto> findAll();
    List<Producto> findPorFamilia(int idFamilia);    
}
