package com.springboot.app.models.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;


	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listarCliente";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "formCliente";
	}
	

	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Cliente cliente = null;

		
		if(id > 0) {
			cliente = clienteService.findOne(id);
		} else {
			return "redirect:/listarCliente";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "formCliente";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "formCliente";
		}
		
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listarCliente";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			clienteService.delete(id);
		}
		return "redirect:/listarCliente";
	}
}