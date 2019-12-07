package com.proyeto.escuelamanejo.controladores;


import java.text.ParseException;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.metadata.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyeto.escuelamanejo.entidades.Contrato;
import com.proyeto.escuelamanejo.entidades.Pago;
import com.proyeto.escuelamanejo.entidades.Servicio;
import com.proyeto.escuelamanejo.repositorios.RepoAlumno;
import com.proyeto.escuelamanejo.repositorios.RepoContrato;
import com.proyeto.escuelamanejo.repositorios.RepoInstructor;
import com.proyeto.escuelamanejo.repositorios.RepoPago;
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
	@Autowired
	RepoPago repopago;
	
	@GetMapping("/")
	public String index(Model model) {
		//Listado de empleados
		model.addAttribute("contratos", repocontrato.findAll());
		return "typography";
	}
	// Ruta get / (listado)
	@GetMapping("/verContratos")
	public String inicio(Model model) {
		//Listado de empleados
		model.addAttribute("contratos", repocontrato.findAll());
		return "verContratos";
	}
	
	//Ruta get/ (nuevo)
	@GetMapping("/nuevoContrato")
	public String nuevo(Model model) {
		model.addAttribute("servicios", reposervicio.findAll());
		model.addAttribute("alumnos", repoalumno.findAll());
		model.addAttribute("instructores", repoinstructor.findAll());
		return "nuevoContrato";
	}
	
	@RequestMapping(value = "/montofinal/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String montofinal(@PathVariable("id")int id) 
	{
		double monto = repocontrato.findById(id).get().getMontofinal();
		return String.valueOf(monto);
	}
	
	//Ruta Post/ (registrar)
	@PostMapping("/registrarContrato")
	public String registrar(@RequestParam(value="instructor") int instructor, @RequestParam(value="alumno") int alumno, @RequestParam(value="servicio") int servicio, @RequestParam(value="horafinal") String horafinal, @RequestParam(value="horainicio") String horainicio) throws ParseException {
		
		horainicio = horainicio + ":00";
		horafinal = horafinal + ":00";
		Date date = new Date();		
		Contrato contrato = new Contrato();
		contrato.setFechacontrato(date);
		contrato.setAlumno(repoalumno.findById(alumno).get());
		contrato.setHorainicio(java.sql.Time.valueOf(horainicio));
		contrato.setHorafinal(java.sql.Time.valueOf(horafinal));
		contrato.setInstructor(repoinstructor.findById(instructor).get());
		contrato.setServicio(reposervicio.findById(servicio).get());
		contrato.setMontofinal(reposervicio.findById(contrato.getServicio().getId()).get().getPrecio());
		contrato.setEstado(1);
		repocontrato.save(contrato);
		return "redirect:/verContratos";
	}
	
	//Ruta Get/ (editar)
	@GetMapping("/EditarContrato/{id}")
	public String editar(@PathVariable("id")int id, Model model) {
		model.addAttribute("servicios", reposervicio.findAll());
		model.addAttribute("alumnos", repoalumno.findAll());
		model.addAttribute("instructores", repoinstructor.findAll());
		model.addAttribute("contrato", repocontrato.findById(id));
		return "editarContrato";
	}
	
	//Ruta Post/ (actualizar)
	@PostMapping("/ActualizarContrato")
	public String actualizar(@RequestParam(value="estado") int estado, @RequestParam(value="id") int Id,@RequestParam(value="instructor") int instructor, @RequestParam(value="horafinal") String horafinal, @RequestParam(value="horainicio") String horainicio) throws ParseException {
		horainicio = horainicio + ":00";
		horafinal = horafinal + ":00";
		Contrato contrato = repocontrato.findById(Id).get();
		contrato.setHorainicio(java.sql.Time.valueOf(horainicio));
		contrato.setHorafinal(java.sql.Time.valueOf(horafinal));
		contrato.setInstructor(repoinstructor.findById(instructor).get());
		contrato.setEstado(estado);
		repocontrato.save(contrato);
		return "redirect:/verContratos";
	}
	 //Ruta Get/ (eliminar)
	@GetMapping("/EliminarContrato/{id}")
	public String eliminar(@PathVariable("id")int id) {
		Contrato contrato = repocontrato.findById(id).get();
		contrato.setEstado(2);
		repocontrato.save(contrato);
		return "redirect:/verContratos";
	}
	
	//Ruta Get/ (pagos)
	@GetMapping("/verPagosContrato/{id}")
	public String pagos(@PathVariable("id")int id, Model model) {
		model.addAttribute("pagos", repocontrato.findById(id).get().getPagos());
		model.addAttribute("contrato",repocontrato.findById(id).get());
		return "verPagos";
	}
	
	//Ruta Get/ (nuevo)
	@GetMapping("/nuevoPago/{id}")
	public String nuevopago(@PathVariable("id")int id, Model model) {
		model.addAttribute("contrato", repocontrato.findById(id).get());
		return "nuevoPago";
	}
	
	//Ruta Post/ (registrar)
	@RequestMapping(value = "/registrarPago", method = RequestMethod.POST)
	public String registrarpago(@Valid @ModelAttribute("pago")Pago pago, Model model, BindingResult result) {
		Date date = new Date();		
		pago.setFechapago(date);
		repopago.save(pago);
		
		model.addAttribute("pagos", repocontrato.findById(pago.getContrato().getId()).get().getPagos());
		model.addAttribute("contrato",repocontrato.findById(pago.getContrato().getId()).get());
		return "verPagos";
	}
	
	//Saldo
	@PostMapping("/saldo/{id}")
	@ResponseBody
	public String saldo(@PathVariable("id")int id) {
		double SaldoAnterior = 0.00;
        double deposito = 0.00;
        Servicio servicio = repocontrato.findById(id).get().getServicio();
        java.util.List<Pago> pagos = repocontrato.findById(id).get().getPagos();
        for (Pago pago : pagos) {
			deposito += pago.getAbono();
		}
        SaldoAnterior = servicio.getPrecio() - deposito;
        
		return String.valueOf(SaldoAnterior);
	}

}
