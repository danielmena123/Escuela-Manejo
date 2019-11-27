package com.proyeto.escuelamanejo.entidades;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotEmpty
	@Column(name="Hora_Inicio")
	private Time horainicio;
	@NotEmpty
	@Column(name="Hora_final")
	private Time horafinal;
	@NotEmpty
	@Column(name="Cantidad_Horas")
	private Time cantidadhoras;
	
	//Builders
	
	public Horario() {}

	public Horario(int id, @NotEmpty Time horainicio, @NotEmpty Time horafinal, @NotEmpty Time cantidadhoras) {
		Id = id;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.cantidadhoras = cantidadhoras;
	}
	
	public Horario(@NotEmpty Time horainicio, @NotEmpty Time horafinal, @NotEmpty Time cantidadhoras) {
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.cantidadhoras = cantidadhoras;
	}
	
	//Getters && Setters

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public Time getCantidadhoras() {
		return cantidadhoras;
	}

	public void setCantidadhoras(Time cantidadhoras) {
		this.cantidadhoras = cantidadhoras;
	}
	
}
