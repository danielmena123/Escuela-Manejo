package com.proyeto.escuelamanejo.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyeto.escuelamanejo.entidades.Pago;
import com.proyeto.escuelamanejo.repositorios.RepoContrato;
import com.proyeto.escuelamanejo.repositorios.RepoPago;

@Controller
public class PagoControlador {
	@Autowired
	RepoPago repopago;
	@Autowired
	RepoContrato repocontrato;
	
	//Ruta Get/ (listado)
	@GetMapping("/Pagos")
	public String listad(Model model) {
		model.addAttribute("pago", repopago.findAll());
		return "";
	}
	
	//Ruta Get/ (nuevo)
	@GetMapping("/NuevoPago")
	public String nuevo() {
		return "";
	}
	
	//Ruta Post/ (registrar)
	@PostMapping("/RegistrarPago")
	public String registar(@Valid @ModelAttribute("pago")Pago pago, BindingResult result) {
		repopago.save(pago);
		return "redirect:/Pagos";
	}
	
	//Ruta Get/ (editar)
	@GetMapping("/EditarPago")
	public String editar(@PathVariable("id")int id, Model model) {
		model.addAttribute("pago", repopago.findById(id));
		return "";
	}
	
	//Ruta Post/ (actualizar)
	@PostMapping("/ActualizarPago")
	public String actualizar(@Valid @ModelAttribute("pago")Pago pago, BindingResult reslt) {
		repopago.save(pago);
		return "redirect:/Pagos";
	}
	
}
