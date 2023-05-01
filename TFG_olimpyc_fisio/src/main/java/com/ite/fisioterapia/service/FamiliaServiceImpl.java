package com.ite.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fisioterapia.entities.Familia;
import com.ite.fisioterapia.repository.FamiliaRepository;

@Service
public class FamiliaServiceImpl implements FamiliaService{
	
	@Autowired
	private FamiliaRepository frepo;

	@Override
	public int altaFamilia(Familia familia) {
        try {
            this.frepo.save(familia);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarFamilia(int idFamilia) {
        try {
            this.frepo.deleteById(idFamilia);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarFamilia(Familia familia) {
		if (findById(familia.getIdFamilia()) == null) return 0;
		try {
			frepo.save(familia);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Familia findById(int idFamilia) {
		return frepo.findById(idFamilia).orElse(null);
	}

	@Override
	public List<Familia> findAll() {
		return this.frepo.findAll();
	}

}
