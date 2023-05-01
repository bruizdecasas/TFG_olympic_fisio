package com.ite.fisioterapia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ite.fisioterapia.entities.Usuario;
import com.ite.fisioterapia.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository urepo;
	
	
	@Override
	public int altaUsuario(Usuario usuario) {
        try {
            this.urepo.save(usuario);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarUsuario(int idUsuario) {
        try {
            this.urepo.deleteById(idUsuario);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }
		@Override
	public int editarUsuario(Usuario usuario) {
		try {
			urepo.save(usuario);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
		@Override
	public Usuario findById(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	@Override
	public List<Usuario> findAll() {
		return this.urepo.findAll();
	}

	@Override
	public Usuario findByEmail(String email) {
		return urepo.findByEmail(email);
	}

}
