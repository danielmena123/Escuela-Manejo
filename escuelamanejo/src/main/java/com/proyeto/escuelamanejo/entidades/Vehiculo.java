package com.proyeto.escuelamanejo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name="Especifiacion_Vehiculo")
	private String especifiacion;
	@NotEmpty
	@Column(name="Tipo_Vehiculo")
	private int tipovehiculo;
	@NotEmpty
	@Column(name="Transmicion_Vehiculo")
	private int transmicion;
	@Column(name="Estado_Vehiculo")
	private int estado;
	
	
	//Builders
	
	public Vehiculo() {}

	public Vehiculo(int id, @NotEmpty String especifiacion, @NotEmpty int tipovehiculo, @NotEmpty int transmicion, @NotEmpty int estado) {
		this.id = id;
		this.especifiacion = especifiacion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
		this.estado = estado;
	}
	
	public Vehiculo(@NotEmpty String especifiacion, @NotEmpty int tipovehiculo, @NotEmpty int transmicion, @NotEmpty int estado) {
		this.especifiacion = especifiacion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
		this.estado = estado;
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecifiacion() {
		return especifiacion;
	}

	public void setEspecifiacion(String especifiacion) {
		this.especifiacion = especifiacion;
	}

	public int getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(int tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public int getTransmicion() {
		return transmicion;
	}

	public void setTransmicion(int transmicion) {
		this.transmicion = transmicion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
