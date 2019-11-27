package com.proyeto.escuelamanejo.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotEmpty
	@Column(name="Fecha_Contrato")
	private Date fechacontrato;
	@NotEmpty
	@Column(name="Monto_Final")
	private double montofinal;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdServicio")
		private Servicio servicio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdHorrio")
		private Horario horario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdInstructor")
		private Instructor instructor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAlumno")
		private Alumno alumno;
	
	//Builders
	
	public Contrato() {}

	public Contrato(int id, @NotEmpty Date fechacontrato, @NotEmpty double montofinal, Servicio servicio, Horario horario,
			Instructor instructor, Alumno alumno) {
		Id = id;
		this.fechacontrato = fechacontrato;
		this.montofinal = montofinal;
		this.servicio = servicio;
		this.horario = horario;
		this.instructor = instructor;
		this.alumno = alumno;
	}
	
	public Contrato(@NotEmpty Date fechacontrato, @NotEmpty double montofinal, Servicio servicio, Horario horario,
			Instructor instructor, Alumno alumno) {
		this.fechacontrato = fechacontrato;
		this.montofinal = montofinal;
		this.servicio = servicio;
		this.horario = horario;
		this.instructor = instructor;
		this.alumno = alumno;
	}
	
	//Getters && Setters

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
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
	
}
