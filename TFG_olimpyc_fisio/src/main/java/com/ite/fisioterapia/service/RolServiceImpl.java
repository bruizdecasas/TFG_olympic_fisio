package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Rol;
import com.ite.fisioterapia.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolrepo;

	@Override
	public int altaRol(Rol rol) {
        try {
            this.rolrepo.save(rol);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarRol(int idRol) {
        try {
            this.rolrepo.deleteById(idRol);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarRol(Rol rol) {
		if (findById(rol.getIdRol()) == null) return 0;
		try {
			rolrepo.save(rol);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Rol findById(int idRol) {
		return rolrepo.findById(idRol).orElse(null);
	}

	@Override
	public List<Rol> findAll() {
		return this.rolrepo.findAll();
	}

	

	
}
