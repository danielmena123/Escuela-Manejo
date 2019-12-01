package com.proyeto.escuelamanejo.entidades;
/**/
import java.sql.Date;
import java.sql.Time;

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
	private int id;
	@NotEmpty
	@Column(name="Fecha_Contrato")
	private Date fechacontrato;
	@NotEmpty
	@Column(name="Monto_Final")
	private double montofinal;
	@NotEmpty
	@Column(name="Hora_Inicio")
	private Time horainicio;
	@NotEmpty
	@Column(name="Hora_Final")
	private Time horafinal;
	@NotEmpty
	@Column(name="Plazo_Dias")
	private int plazo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdServicio")
		private Servicio servicio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdInstructor")
		private Instructor instructor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAlumno")
		private Alumno alumno;
	@Column(name="Estado_Vehiculo")
	private int estado;
	
	//Builders
	
	public Contrato() {}
	
	public Contrato(int id, @NotEmpty Date fechacontrato, @NotEmpty double montofinal, @NotEmpty Time horainicio,
			@NotEmpty Time horafinal, @NotEmpty int plazo, Servicio servicio, Instructor instructor, Alumno alumno,
			int estado) {
		this.id = id;
		this.fechacontrato = fechacontrato;
		this.montofinal = montofinal;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.plazo = plazo;
		this.servicio = servicio;
		this.instructor = instructor;
		this.alumno = alumno;
		this.estado = estado;
	}
	
	public Contrato(@NotEmpty Date fechacontrato, @NotEmpty double montofinal, @NotEmpty Time horainicio,
			@NotEmpty Time horafinal, @NotEmpty int plazo, Servicio servicio, Instructor instructor, Alumno alumno,
			int estado) {
		this.fechacontrato = fechacontrato;
		this.montofinal = montofinal;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.plazo = plazo;
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

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
