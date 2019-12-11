package com.proyeto.escuelamanejo.entidades;
import java.util.ArrayList;
/**/
import java.util.Date;
import java.util.List;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Fecha_Contrato")
	private Date fechacontrato;
	@NotNull
	@Column(name="Monto_Final")
	private double montofinal;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="Hora_Inicio")
	private Time horainicio;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="Hora_Final")
	private Time horafinal;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdServicio")
		private Servicio servicio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdInstructor")
		private Instructor instructor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAlumno")
		private Alumno alumno;
	@NotNull
	@Column(name="Estado_Contrato")
	private int estado;
	@OneToMany(mappedBy = "contrato",cascade = CascadeType.ALL)
	private List<Pago> pagos = new ArrayList<Pago>();	
	
	//Builders
	
	public Contrato() {}
	
	public Contrato(int id, @NotEmpty Date fechacontrato, @NotEmpty double montofinal, @NotEmpty Time horainicio,
			@NotEmpty Time horafinal, Servicio servicio, Instructor instructor, Alumno alumno,
			int estado) {
		this.id = id;
		this.fechacontrato = fechacontrato;
		this.montofinal = montofinal;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.servicio = servicio;
		this.instructor = instructor;
		this.alumno = alumno;
		this.estado = estado;
	}
	
	public Contrato(@NotEmpty Date fechacontrato, @NotEmpty double montofinal, @NotEmpty Time horainicio,
			@NotEmpty Time horafinal, Servicio servicio, Instructor instructor, Alumno alumno,
			int estado) {
		this.fechacontrato = fechacontrato;
		this.montofinal = montofinal;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.servicio = servicio;
		this.instructor = instructor;
		this.alumno = alumno;
		this.estado = estado;
	}

	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechacontrato() {
		return fechacontrato;
	}

	public void setFechacontrato(Date fechacontrato) {
		this.fechacontrato = fechacontrato;
	}

	public double getMontofinal() {
		return montofinal;
	}

	public void setMontofinal(double montofinal) {
		this.montofinal = montofinal;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Time getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public Time getHorafinal() {
		return horafinal;
	}

	public void setHorafinal(Time horafinal) {
		this.horafinal = horafinal;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
}
