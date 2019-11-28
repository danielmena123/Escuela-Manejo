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

import com.proyeto.escuelamanejo.entidades.Instructor;
import com.proyeto.escuelamanejo.repositorios.RepoInstructor;

@Controller
public class IntructorControlador {
	@Autowired
	RepoInstructor repo;
	
	//Ruta get/ (listado)
	@GetMapping("/Instructores")
	public String inicio(Model model) {
		model.addAttribute("instructores", repo.findAll());
		return "";
	}
	
	//Ruta get/ (nuevo)
	@GetMapping("/NuevoInstructor")
	public String nuevo(Model model) {
		
		return "";
	}
	
	//Ruta post/ (registrar)
	@PostMapping("/RegistrarInstructor")
	public String registrar(@Valid @ModelAttribute("instructor")Instructor instructor,BindingResult result) {
		repo.save(instructor);
		return "redirect:/Instructores";
	}
	
	//Ruta get/ (editar)
	@GetMapping("/EditarInstructor/{id}")
	public String editar(@PathVariable("id")int id, Model model) {
		model.addAttribute("instructor", repo.findById(id));
		return "";
	}
	
	//Ruta post/ (actualizar)
	@PostMapping("/ActualizarInstructor")
	public String actualizar(@Valid @ModelAttribute("instructor")Instructor instructor , BindingResult result) {
		repo.save(instructor);
		return "redirect:/Instructores";
	}
	
	//Ruta get/ (eliminar)
	@GetMapping("/EliminarInstructor")
	public String eliminar(@PathVariable("id")int id, Model model) {
		Instructor instructor = repo.findById(id).get();
		instructor.setEstado(2);
		repo.save(instructor);
		return "redirect:/Instructores";
	}
}
