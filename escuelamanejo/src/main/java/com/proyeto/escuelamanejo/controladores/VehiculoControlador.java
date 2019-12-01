package com.proyeto.escuelamanejo.controladores;
/**/
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyeto.escuelamanejo.entidades.Vehiculo;
import com.proyeto.escuelamanejo.repositorios.RepoVehiculo;

@Controller
public class VehiculoControlador {
	
	@Autowired
	RepoVehiculo repo;
	
	// Ruta get / (listado)
	@GetMapping("/verAutomoviles")
	public String inicio(Model model) {
		//Listado de alumnos
		model.addAttribute("vehiculos", repo.findAll());
		return "verAutomoviles";
	}
	
	// Ruta get /nuevo
	@GetMapping("/NuevoVehiculo")
	public String nuevo() {
		return "";
	}
	
	
	// Ruta post / registrar
	@PostMapping("/RegistrarVehiculo")
	public String registrar(@Valid @ModelAttribute("vehiculo")Vehiculo vehiculo, BindingResult result ) {
		
		repo.save(vehiculo);
		
		return "redirect:/Vehiculos";					
	}
	
	// Ruta get /editar/{id}
	@GetMapping("/EditarVehiculo/{id}")
	public String editar(@PathVariable("id")int id,Model model) {
		model.addAttribute("vehiculo", repo.findById(id));
		return "";
	}
	
	
	// Ruta post /editar
	
	@PostMapping("/ActualizarVehiculo")
	public String actualizar(@Valid @ModelAttribute("vehiculo")Vehiculo vehiculo, BindingResult result ) {
		
		repo.save(vehiculo);
		
		return "redirect:/Vehiculoss";		
	}
	
	// Ruta get /eliminar/{id}
	@GetMapping("/EliminarVehiculo/{id}")
	public String eliminar(@PathVariable("id")int id) {
		Vehiculo vehiculo = repo.findById(id).get();
		vehiculo.setEstado(2);
		repo.save(vehiculo);
		return "redirect:/verAutomoviles";
	}
}
