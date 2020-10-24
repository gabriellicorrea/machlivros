package com.matchlivros.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matchlivros.models.Usuarios;
import com.matchlivros.service.ServicoUsuario;

@Controller
public class CadastroController {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@GetMapping("/login")
	public String login() {
	 return "conta/login";	
	}

	
	
	@GetMapping("/cadastrar")
	public ModelAndView registrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuarios());
		
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView registrar(@Valid Usuarios usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuarios usr = servicoUsuario.procurarPorEmail(usuario.getEmail());
		if(usr != null) {
			result.rejectValue("email", "", "Usuario ja cadastrado!");
		}
		if (result.hasErrors()) {
			mv.setViewName("conta/registrar");
			mv.addObject("usuario", usuario);
		} else {
			servicoUsuario.salvar(usuario);
			mv.setViewName("conta/login");
		}
		return mv;	
	}
}