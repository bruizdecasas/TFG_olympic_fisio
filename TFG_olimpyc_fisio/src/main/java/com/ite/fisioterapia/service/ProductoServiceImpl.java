package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Producto;
import com.ite.fisioterapia.repository.ProductoRepository;



@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
    private ProductoRepository prepo;

	@Override
	public int altaProducto(Producto producto) {
		try {
            this.prepo.save(producto);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarProducto (int idProducto) {
		try {
            this.prepo.deleteById(idProducto);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarProducto(Producto producto) {
		try {
            this.prepo.save(producto);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public Producto findById(int idProducto) {
		return prepo.findById(idProducto).orElse(null);
	}

	@Override
	public List<Producto> findAll() {
		return this.prepo.findAll();
	}

	@Override
	public List<Producto> findPorFamilia(int idFamilia) {
		return prepo.findPorFamilia(idFamilia);
	}
}
