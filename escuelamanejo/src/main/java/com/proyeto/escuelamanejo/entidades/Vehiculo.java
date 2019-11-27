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
	private int Id;
	@NotEmpty
	@Column(name="Especifiacion_Vehiculo")
	private String especifiacion;
	@NotEmpty
	@Column(name="Tipo_Vehiculo")
	private int tipovehiculo;
	@NotEmpty
	@Column(name="Transmicion_Vehiculo")
	private int transmicion;
	
	//Builders
	
	public Vehiculo() {}

	public Vehiculo(int id, @NotEmpty String especifiacion, @NotEmpty int tipovehiculo, @NotEmpty int transmicion) {
		Id = id;
		this.especifiacion = especifiacion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
	}
	
	public Vehiculo(@NotEmpty String especifiacion, @NotEmpty int tipovehiculo, @NotEmpty int transmicion) {
		this.especifiacion = especifiacion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
	}
	
	//Getters && Setters

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
	
}
