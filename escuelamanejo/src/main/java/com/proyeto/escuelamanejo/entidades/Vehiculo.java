package com.proyeto.escuelamanejo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	@Column(name="N_Placa")
	private String placa;
	
	@Column(name="Especifiacion_Vehiculo")
	private String descripcion;
	@NotNull
	@Column(name="Tipo_Vehiculo")
	private int tipovehiculo;
	@NotNull
	@Column(name="Transmicion_Vehiculo")
	private int transmicion;
	@Column(name="Estado_Vehiculo")
	private int estado;
	
	
	//Buil ders
	
	public Vehiculo() {}

	public Vehiculo(int id, @NotEmpty String placa, String descripcion, @NotNull int tipovehiculo, @NotNull int transmicion, @NotNull int estado) {
		this.id = id;
		this.placa = placa;
		this.descripcion = descripcion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
		this.estado = estado;
	}
	
	public Vehiculo(@NotEmpty String placa, String descripcion, @NotNull int tipovehiculo, @NotNull int transmicion, @NotNull int estado) {
		this.placa = placa;
		this.descripcion = descripcion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
		this.estado = estado;
	}
	
	//Getters &&  Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
