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

import com.proyeto.escuelamanejo.entidades.Servicio;
import com.proyeto.escuelamanejo.repositorios.RepoServicio;
import com.proyeto.escuelamanejo.repositorios.RepoVehiculo;

@Controller
public class ServicioControlador {
	@Autowired
	RepoVehiculo	repovehiculo;
	@Autowired
	RepoServicio	reposervicio;
	
	//Ruta get/ (listado)
	@GetMapping("/Servicios")
	public String inicio(Model model) {
		model.addAttribute("servicios", reposervicio.findAll());
		return "";
	}
	
	//Ruta get/ (nuevo)
	@GetMapping("/NuevoServicio")
	public String nuevo() {
		return "";
	}
	
	//Ruta post/ (registrar)
	@PostMapping("/RegistrarServicio")
	public String registrar(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
		reposervicio.save(servicio);
		return "redirect:/Servicios";
	}
	
	//Ruta get/ (editar)
	@GetMapping("/EditarServicio/{id}")
	public String editar(@PathVariable("id")int id ) {
		reposervicio.findById(id);
		return "";
	}
	
	//Ruta post/ (actualizar)
	@PostMapping("/ActualizarServicio")
	public String actualizar(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
		reposervicio.save(servicio);
		return "redirect:/Servicios";
	}
	
	//Ruta get/ (eliminar)
	public String eliminar(@PathVariable("id")int id) {
		Servicio servicio = reposervicio.findById(id).get();
		servicio.setEstado(2);
		reposervicio.save(servicio);
		return "redirect:/Servicios";
	}
}
