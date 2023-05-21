package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Producto;
import com.ite.fisioterapia.repository.ProductoRepository;


/**
 * Class that implements the ProductoService interface.
 * @author: Benjamín Ruiz
 * @author: Jesús Raboso
 * @author: Silvia Piñel
 */
@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
    private ProductoRepository prepo;

	/**
	 * Method to register a new product.
	 * @param producto Represents the product object to be registered.
	 * @return If the appointment is saved successfully, it returns 1. Otherwise, it returns 0.
	 */
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
	
	/**
	 * Method to delete a product.
	 * @param idProducto Represents the ID of the product to be deleted.
	 * @return If the product is deleted successfully, it returns 1. Otherwise, it returns 0.
	 */
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
	
	/**
	 * Method to edit a product.
	 * @param producto Represents the appointment object to be edit.
	 * @return If the product is edited successfully, it returns 1. Otherwise, it returns 0.
	 */
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
	
	/**
	 * Method to find a product.
	 * @param idProducto Represents the ID of the product to be found.
	 * @return If the product is found successfully, it returns the entity Producto with the given id. Otherwise, it returns null.
	 */
	@Override
	public Producto findById(int idProducto) {
		return prepo.findById(idProducto).orElse(null);
	}
	/**
	 * Method to find all products.
	 * @return A list with all the products in the repository.
	 */
	@Override
	public List<Producto> findAll() {
		return this.prepo.findAll();
	}
	
	/**
	 * Method to search for the list of products for a family.
	 * @param idFamilia Represents the ID of the family to be found.
	 * @return  A list with all the products of the family in the repository.
	 */
	@Override
	public List<Producto> findPorFamilia(int idFamilia) {
		return prepo.findPorFamilia(idFamilia);
	}
}
