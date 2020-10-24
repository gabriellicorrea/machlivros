package com.matchlivros.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchlivros.models.Usuarios;
import com.matchlivros.repository.RepositorioUsuario;



@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
		
	public Usuarios procurarPorEmail(String email) {
		return repositorioUsuario.findByEmail(email);
	}
	
	public void salvar(Usuarios usuario) {
	
		repositorioUsuario.save(usuario);
	}
}