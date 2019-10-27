package com.emilianomacias0.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emilianomacias0.app.models.dao.IClienteDao;

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("clientedaojpa")
	private IClienteDao clientedao;
	
	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public String Listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes",clientedao.findAll());
		return "listar";
	}
}
