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

import com.springboot.app.models.entity.Categoria;
import com.springboot.app.models.service.ICategoriaService;


@Controller
@SessionAttributes("categoria")
public class CategoriaController {
	

	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping(value =  "/listarCategoria", method =  RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de Categorias");
		model.addAttribute("categorias", categoriaService.findAll());
		
		return "listarCategoria";
	}
	
	
	@RequestMapping(value = "/crearCategoria")
	public String crear(Map<String, Object> model) {
		Categoria categoria = new Categoria();
		
		model.put("categoria", categoria);
		model.put("titulo", "Formulario Categoria");
		return "editarCategoria";
		
	}

	@RequestMapping(value="/editarCategoria/{idcategoria}")
	public String editar(@PathVariable(value="idcategoria") Long idcategoria, Map<String, Object> model) {
		Categoria categoria = null;
		
		if( idcategoria > 0) {
			categoria = categoriaService.findOne(idcategoria);
		} else {
			return "redirect:/listarCategoria";
		}
		model.put("categoria", categoria);
		model.put("titulo", "Editar Categoria");
		return "editarCategoria";
	}

	@RequestMapping(value = "/editarCategoria", method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Categoria");
			return "editarCategoria";
		}
		
		categoriaService.save(categoria);
		status.setComplete();
		return "redirect:listarCategoria";
	}
	
	
	@RequestMapping(value="/eliminarCategoria/{idcategoria}")
	public String eliminar(@PathVariable(value="idcategoria") Long idcategoria) {
		
		if(idcategoria > 0) {
			categoriaService.delete(idcategoria);
		}
		return "redirect:/listarCategoria";
	}
}
