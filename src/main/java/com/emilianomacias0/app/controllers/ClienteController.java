package com.emilianomacias0.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emilianomacias0.app.models.dao.IClienteDao;
import com.emilianomacias0.app.models.entity.Cliente;

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
	
	@RequestMapping(value="/form")
	public String crear(Map<String,Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de cliente");
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value = "id")Long id, Map<String,Object> model) {
		Cliente cliente = null;
		if(id > 0) {
			cliente = clientedao.findOne(id);
		}else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "form";
	}
	
	
	@RequestMapping(value="/form",method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de clientes");
			//model.addAttribute("error","Formulario de clientes");
			return "form";
		}
		clientedao.save(cliente);
		return "redirect:listar";
	}
}
