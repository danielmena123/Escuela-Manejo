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

import com.proyeto.escuelamanejo.entidades.Alumno;
import com.proyeto.escuelamanejo.entidades.Vehiculo;
import com.proyeto.escuelamanejo.repositorios.RepoAlumno;

@Controller
public class AlumnoControlador {
	@Autowired
	RepoAlumno	repo;
	
	// Ruta get  / (listados)
	@GetMapping("/verAlumnos")
	public String inicio(Model model) {
		//Listado de alumnos
		model.addAttribute("alumnos", repo.findAll());
		return "verAlumnos";
	}
	
	// Ruta get /nuevo
	@GetMapping("/nuevoAlumno")
	public String nuevo() {
		return "nuevoAlumno";
	}
	
	// Ruta post / registrar
	@PostMapping("/registrarAlumno")
	public String registrarAlumno( 
			@Valid @ModelAttribute("alumno")Alumno alumno,
			BindingResult result, RedirectAttributes redirectAttrs ) {
		
		repo.save(alumno);
		
		redirectAttrs.addFlashAttribute("mensaje", "Alumno Agregado correctamente")
        .addFlashAttribute("clase", "success");
		
		return "redirect:/verAlumnos";					
	}
	

	// Ruta get /editar/{id}
	@GetMapping("/EditarAlumno/{id}")
	public String editar(@PathVariable("id")int id,Model model) {
		model.addAttribute("alumno", repo.findById(id));
		return "editarAlumno";
	}
	
	
	// Ruta post /editar
	
	@PostMapping("/ActualizarAlumno")
	public String actualizar( 
			@Valid @ModelAttribute("alumno")Alumno alumno,
			BindingResult result ) {
		
		repo.save(alumno);
		
		return "redirect:/verAlumnos";		
	}
	
	// Ruta get /eliminar/{id}
	@GetMapping("/eliminarAlumno/{id}")
	public String traer(@PathVariable("id")int id,Model model) {
		model.addAttribute("alumno", repo.findById(id));
		return "eliminarAlumno";
	}
	
	// Ruta get /delete/{id}
		@PostMapping("/delAlumno")
		public String eliminar(@Valid @ModelAttribute("alumno")Alumno alumno, BindingResult result) {
			int Id = alumno.getId();
			Alumno eliminar = repo.findById(Id).get();
			eliminar.setEstado(2);
			repo.save(eliminar);
			
			return "redirect:/verAlumnos";
		}
}
