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
import com.springboot.app.models.entity.Producto;
import com.springboot.app.models.service.IProductoService;

@Controller
@SessionAttributes("producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;

	
	@RequestMapping(value="/listarProducto", method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productoService.findAll());
		
		return "listarProducto";
	}
	@RequestMapping(value = "/crearProducto")
	public String crear(Map<String, Object> model) {
		Producto producto = new Producto();
		Categoria categoria = new Categoria();

		
		model.put("producto", producto);
		model.put("categoria", categoria);
		model.put("titulo", "Formulario Producto");
		return "formProducto";
		
	}

	@RequestMapping(value="/editarProducto/{idproducto}")
	public String editar(@PathVariable(value="idproducto") Long idproducto, Map<String, Object> model) {
		Producto producto = null;
		Categoria categoria = null;

		
		if( idproducto > 0) {
			producto = productoService.findOne(idproducto);
		} else {
			return "redirect:/listarProducto";
		}
		model.put("producto", producto);
		model.put("categoria", categoria);
		model.put("titulo", "Editar Producto");
		return "formProducto";
	}

	@RequestMapping(value = "/crearProducto", method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Producto");
			return "formProducto";
		}
		
		productoService.save(producto);
		status.setComplete();
		return "redirect:listarProducto";
	}
	
	
	@RequestMapping(value="/eliminarProducto/{idproducto}")
	public String eliminar(@PathVariable(value="idproducto") Long idproducto) {
		
		if(idproducto > 0) {
			productoService.delete(idproducto);
		}
		return "redirect:/listarProducto";
	}
	
	
	

}
