package com.matchlivros.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.matchlivros.models.Usuarios;



public interface RepositorioUsuario extends JpaRepository<Usuarios, Long> {

	Usuarios findByEmail(String email);
	
}