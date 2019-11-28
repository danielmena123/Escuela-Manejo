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

import com.proyeto.escuelamanejo.entidades.Alumno;
import com.proyeto.escuelamanejo.repositorios.RepoAlumno;

@Controller
public class AlumnoControlador {
	@Autowired
	RepoAlumno	repo;
	
	// Ruta get / (listado)
	@GetMapping("/Alumnos")
	public String inicio(Model model) {
		//Listado de alumnos
		model.addAttribute("alumnos", repo.findAll());
		return "";
	}
	
	// Ruta get /nuevo
	@GetMapping("/NuevoAlumno")
	public String nuevo() {
		return "";
	}
	
	
	// Ruta post / registrar
	@PostMapping("/RegistrarAlumno")
	public String registrar( 
			@Valid @ModelAttribute("alumno")Alumno alumno,
			BindingResult result ) {
		
		repo.save(alumno);
		
		return "redirect:/Alumnos";					
	}
	
	// Ruta get /editar/{id}
	@GetMapping("/EditarAlumno/{id}")
	public String editar(@PathVariable("id")int id,Model model) {
		model.addAttribute("alumno", repo.findById(id));
		return "";
	}
	
	
	// Ruta post /editar
	
	@PostMapping("/ActualizarAlumno")
	public String actualizar( 
			@Valid @ModelAttribute("alumno")Alumno alumno,
			BindingResult result ) {
		
		repo.save(alumno);
		
		return "redirect:/Alumnos";		
	}
	
	// Ruta get /eliminar/{id}
	@GetMapping("/EliminarAlumno/{id}")
	public String eliminar(@PathVariable("id")int id) {
		Alumno alumno = repo.findById(id).get();
		alumno.setEstado(2);
		repo.save(alumno);
		return "redirect:/Alumnos";
	}
}
