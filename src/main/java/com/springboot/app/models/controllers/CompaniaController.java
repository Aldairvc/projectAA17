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

import com.springboot.app.models.entity.Compania;
import com.springboot.app.models.service.ICompaniaService;

@Controller
@SessionAttributes("compania")
public class CompaniaController {
	
	@Autowired
	private ICompaniaService companiaService;
	
	@RequestMapping(value =  "/listarCompania", method =  RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de Compañia");
		model.addAttribute("companias", companiaService.findAll());
		
		return "listarCompania";
	}
	
	
	@RequestMapping(value = "/crearCompania")
	public String crear(Map<String, Object> model) {
		Compania compania = new Compania();
		
		model.put("compania", compania);
		model.put("titulo", "Formulario Compañia");
		return "formCompania";
		
	}

	@RequestMapping(value="/editarCompania/{idcompania}")
	public String editar(@PathVariable(value="idcompania") Long idcompania, Map<String, Object> model) {
		Compania compania = null;
		
		if( idcompania > 0) {
			compania = companiaService.findOne(idcompania);
		} else {
			return "redirect:/listarCompania";
		}
		model.put("compania", compania);
		model.put("titulo", "Editar Compañia");
		return "formCompania";
	}

	@RequestMapping(value = "/editarCompania", method = RequestMethod.POST)
	public String guardar(@Valid Compania compania, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Compañia");
			return "formCompania";
		}
		
		companiaService.save(compania);
		status.setComplete();
		return "redirect:listarCompania";
	}
	
	
	@RequestMapping(value="/eliminarCompania/{idcompania}")
	public String eliminar(@PathVariable(value="idcompania") Long idcompania) {
		
		if(idcompania > 0) {
			companiaService.delete(idcompania);
		}
		return "redirect:/listarCompania";
	}
	
	

}
