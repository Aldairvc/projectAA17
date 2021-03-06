package com.springboot.app.models.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.Factura;
import com.springboot.app.models.entity.ItemFactura;
import com.springboot.app.models.entity.Producto;
import com.springboot.app.models.service.ClienteServiceImpl;
import com.springboot.app.models.service.IClienteService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
    
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId,
			Map<String, Object> model,
			RedirectAttributes flash){
		
		Cliente cliente = clienteService.findOne(clienteId);
		if(cliente == null){
			flash.addFlashAttribute("error","el cliente ni existe en la base de datos");
			return "redirect:/listar";
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		
		model.put("factura", factura);
		model.put("titulo", "crear factura");
		return "factura/form";
	}
	
	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.finByNombre(term);
	}

	
	
}
