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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyeto.escuelamanejo.entidades.Vehiculo;
import com.proyeto.escuelamanejo.repositorios.RepoVehiculo;

@Controller
public class VehiculoControlador {
	
	@Autowired
	RepoVehiculo repo;
	
	// Ruta geter / (listado)
	@GetMapping("/verAutomoviles")
	public String inicio(Model model) {
		//Listado de alumnos
		model.addAttribute("vehiculos", repo.findAll());
		return "verAutomoviles";
	}
	
	// Ruta get /nuevo
		@GetMapping("/nuevoVehiculo")
		public String nuevo() {
			return "nuevoAuto";
		}
		
		
		// Ruta post / registrar
		@PostMapping("/registrarVehiculo")
		public String registrar(@Valid @ModelAttribute("vehiculo")Vehiculo vehiculo, BindingResult result ) {
			
			repo.save(vehiculo);
			
			return "redirect:/verAutomoviles";					
		}
		
	
	// Ruta get /editar/{id}
	@GetMapping("/editarVehiculo/{id}")
	public String editar(@PathVariable("id")int id,Model model) {
		model.addAttribute("vehiculo", repo.findById(id));
		return "editarAuto";
	}
	
	
	// Ruta post /editar
	
	@PostMapping("/actualizarAuto")
	public String actualizar(@Valid @ModelAttribute("vehiculo")Vehiculo vehiculo, BindingResult result,RedirectAttributes redirectAttrs ) {
		
		repo.save(vehiculo);
		redirectAttrs
        .addFlashAttribute("mensaje", "Vehiculo Modificado")
        .addFlashAttribute("clase", "primary");
		
		return "redirect:/verAutomoviles";		
	}
	
	// Ruta get /eliminar/{id}
		@GetMapping("/eliminarVehiculo/{id}")
		public String traer(@PathVariable("id")int id,Model model) {
			model.addAttribute("vehiculo", repo.findById(id));
			return "eliminarAuto";
		}
		
	
	// Ruta get /delete/{id}
	@PostMapping("/delVehiculo")
	public String eliminar(@Valid @ModelAttribute("vehiculo")Vehiculo vehiculo, BindingResult result) {
		int Id = vehiculo.getId();
		Vehiculo eliminar = repo.findById(Id).get();
		eliminar.setEstado(2);
		repo.save(eliminar);
		
		return "redirect:/verAutomoviles";
	}
	
	@GetMapping("/volver4")
	public String volver4() {
		return "redirect:/verAutomoviles";
	}
	/*	@PostMapping("/delVehiculo")
		public String eliminar(@ModelAttribute("vehiculo")Vehiculo vehiculo, RedirectAttributes redirectAttrs) {
			//Vehiculo vehiculo = repo.findById().get();
			vehiculo.setEstado(2);
			repo.save(vehiculo);
			
			redirectAttrs
	        .addFlashAttribute("mensaje", "Vehiculo Eliminado(inactivo)")
	        .addFlashAttribute("clase", "primary");
			
			return "redirect:/verAutomoviles";
		} */
}

