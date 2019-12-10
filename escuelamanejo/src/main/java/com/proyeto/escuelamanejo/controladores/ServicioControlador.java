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

import com.proyeto.escuelamanejo.entidades.Instructor;
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
	@GetMapping("/verServicios")
	public String inicio(Model model) {
		model.addAttribute("servicios", reposervicio.findAll());
		return "verServicios";
	}
	
	//Ruta get/ (nuevo)
	@GetMapping("/nuevoServicio")
	public String nuevo(Model model) {
		model.addAttribute("vehiculos", repovehiculo.findAll());
		return "nuevoServicio";
	}
	
	//Ruta post/ (registrar)
	@PostMapping("/registrarServicio")
	public String registrar(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
		reposervicio.save(servicio);
		return "redirect:/verServicios";
	}
	
	@GetMapping("/volver3")
	public String volver3() {
		return "redirect:/verServicios";
	}
	
	/* //Ruta get/ (editar)
	@GetMapping("/editarServicio/{id}")
	public String editar(@PathVariable("id")int id, Model model ) {
		model.addAttribute("servicio", reposervicio.findById(id));
		model.addAttribute("vehiculos", repovehiculo.findAll());
		return "editarServicio";
	}
	
	//Ruta post/ (actualizar)
	@PostMapping("/actualizarServicio")
	public String actualizar(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
		reposervicio.save(servicio);
		return "redirect:/verServicios";
	}
	
	//Ruta get/ (eliminar)
	@GetMapping("/eliminarServicio/{id}")
	public String eliminar(@PathVariable("id")int id) {
		Servicio servicio = reposervicio.findById(id).get();
		servicio.setEstado(2);
		reposervicio.save(servicio);
		return "redirect:/verServicios";
	}  */
	//Ruta get/ (editar)
		@GetMapping("/editarServicio/{id}")
		public String editar(@PathVariable("id")int id, Model model ) {
			model.addAttribute("servicio", reposervicio.findById(id));
			model.addAttribute("vehiculos", repovehiculo.findAll());
			return "editarServicio";
		}
		
		//Ruta post/ (actualizar)
		@PostMapping("/actualizarServicio")
		public String actualizar(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
			reposervicio.save(servicio);
			return "redirect:/verServicios";
		}
		
		/*//Ruta get/ (eliminar)
		@GetMapping("/eliminarServicio/{id}")
		public String eliminar(@PathVariable("id")int id) {
			Servicio servicio = reposervicio.findById(id).get();
			servicio.setEstado(2);
			reposervicio.save(servicio);
			return "redirect:/verServicios";
		}*/
		// Ruta get /eliminar/{id}
		@GetMapping("/eliminarServicio/{id}")
		public String traer(@PathVariable("id")int id,Model model) {
			model.addAttribute("servicio", reposervicio.findById(id));
			model.addAttribute("vehiculos", repovehiculo.findAll());
			return "eliminarServicio";
		}
			
	// Ruta get /delete/{id}
		@PostMapping("/delServicio")
		public String eliminar(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
			int Id = servicio.getId();
			Servicio eliminar = reposervicio.findById(Id).get();
			eliminar.setEstado(2);
			reposervicio.save(eliminar);
			
			return "redirect:/verServicios";
		}
}
