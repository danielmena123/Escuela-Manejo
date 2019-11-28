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

import com.proyeto.escuelamanejo.entidades.Contrato;
import com.proyeto.escuelamanejo.repositorios.RepoAlumno;
import com.proyeto.escuelamanejo.repositorios.RepoContrato;
import com.proyeto.escuelamanejo.repositorios.RepoInstructor;
import com.proyeto.escuelamanejo.repositorios.RepoServicio;

@Controller
public class ContratoControlador {

	@Autowired
	RepoContrato repocontrato;
	@Autowired
	RepoServicio reposervicio;
	@Autowired
	RepoAlumno	repoalumno;
	@Autowired
	RepoInstructor	repoinstructor;
	
	
	// Ruta get / (listado)
	@GetMapping("/")
	public String inicio(Model model) {
		//Listado de empleados
		model.addAttribute("contratos", repocontrato.findAll());
		return "typography";
	}
	
	//Ruta get/ (nuevo)
	@GetMapping("/NuevoContrato")
	public String nuevo() {
		return "";
	}
	
	//Ruta Post/ (registrar)
	@PostMapping("/RegistarContrato")
	public String registrar(@Valid @ModelAttribute("contrato")Contrato contrato, BindingResult result) {
		repocontrato.save(contrato);
		return "redirect:/";
	}
	
	//Ruta Get/ (nuevo)
	@GetMapping("/EditarContrato/{id}")
	public String editar(@PathVariable("id")int id, Model model) {
		model.addAttribute("vendedor", repocontrato.findById(id));
		return "";
	}
	
	//Ruta Post/ (actualizar)
	@PostMapping("/ActualizarContrato")
	public String actualizar(@Valid @ModelAttribute("contrato")Contrato contrato, BindingResult result) {
		repocontrato.save(contrato);
		return "redirect:/";
	}
	 //Ruta Get/ (eliminar)
	@GetMapping("/EliminarContrato")
	public String eliminar(@PathVariable("id")int id) {
		Contrato contrato = repocontrato.findById(id).get();
		contrato.setEstado(2);
		repocontrato.save(contrato);
		return "redirect:/";
	}
}
