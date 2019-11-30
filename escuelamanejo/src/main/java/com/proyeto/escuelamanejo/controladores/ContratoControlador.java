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
	/**/
	/* 
	 * registros tabla alumno
	INSERT INTO ALUMNO VALUES( 1,'Alas Tobar','Reubicacion #1, Chalatenango','12345678-9',21,'Alvaro Daniel','74859632',1);
	INSERT INTO ALUMNO VALUES( 2,'Castaneda Villalobos','Los Prados, Chalatenango','47345678-9',18,'Katherine Rocio','77759632',1);
	INSERT INTO ALUMNO VALUES( 3,'Ayala Ramos','La Sierpe, Chalatenango','17745678-9',33,'Ledy Stefany','70459632',1)
	
	* registros tabla instructor
	INSERT INTO INSTRUCTOR VALUES(1,'Peñate  Mena','Chalatenango','47345678-9',20,1,'Francisco Daniel','77759632');
	INSERT INTO INSTRUCTOR VALUES(2, 'Monge Rauda','Reubicacion #2, Chalatenango','12345678-9',21,1,'Julio Cesar','74859632');
	INSERT INTO INSTRUCTOR VALUES(3, 'Alas Navarrete','Reubicacion #3, Chalatenango','65445678-9',22,1,'Karla Liseth','71717632')
    
    * registros tabla vehiculo (tipovehiculo 1=sedan y 2= pickup; transmision 1=standar y 2=automatica
    INSERT INTO VEHICULO VALUES(1, 'Chevrolet Spark 2012',1,'P748-987',1,1);
	INSERT INTO VEHICULO VALUES( 2,'Toyota Hilux 2018',1,'P512-123',2,1);
	INSERT INTO VEHICULO VALUES( 3,'Nissan NP300 2018',1,'P345-654',2,1)
	
	* registros tabla servicio
	INSERT INTO SERVICIO VALUES(1,12,1,10,2,'Basico',150.00,1);
	INSERT INTO SERVICIO VALUES( 2,16,1,14,2,'Normal',225.00,2);
	INSERT INTO SERVICIO  VALUES( 3,20,1,18,2,'Exclusivo',300.00,3)
	
	* registros tabla contrato
	INSERT INTO CONTRATO VALUES(1,1,'2019-11-01','10:00:00','08:00:00',150.00,6,1,1,1);
	INSERT INTO CONTRATO VALUES(2,1,'2019-11-01','12:00:00','10:00:00',225.00,8,2,2,2);
	INSERT INTO CONTRATO VALUES(3,1,'2019-11-01','02:00:00','12:00:00',300.00,10,3,3,3)
	
	* registros tabla pago
	INSERT INTO PAGO VALUES(1,75.00,'2019-11-01',1);
	INSERT INTO PAGO VALUES(2,125.00,'2019-11-01',2);
	INSERT INTO PAGO VALUES(3,175.00,'2019-11-01',3)
    
    
	*/
}
