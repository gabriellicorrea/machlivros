package com.matchlivros.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class IndexController {
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("mensagem","Ola, " + request.getUserPrincipal().getName());
		return mv;
	}
}