package com.proyeto.escuelamanejo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**/
@Entity
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name="N_Placa")
	private String placa;
	@NotEmpty
	@Column(name="Especifiacion_Vehiculo")
	private String especificacion;
	@NotNull
	@Column(name="Tipo_Vehiculo")
	private int tipovehiculo;
	@NotNull
	@Column(name="Transmicion_Vehiculo")
	private int transmicion;
	@NotNull
	@Column(name="Estado_Vehiculo")
	private int estado;
	
	
	//Builders
	
	public Vehiculo() {}

	public Vehiculo(int id, @NotEmpty String placa, @NotEmpty String especificacion, @NotEmpty int tipovehiculo, @NotEmpty int transmicion, @NotEmpty int estado) {
		this.id = id;
		this.placa = placa;
		this.especificacion = especificacion;
		this.tipovehiculo = tipovehiculo;
		this.transmicion = transmicion;
		this.estado = estado;
	}
	
	public Vehiculo(@NotEmpty String placa, @NotEmpty String especificacion, @NotEmpty int tipovehiculo, @NotEmpty int transmicion, @NotEmpty int estado) {
		this.placa = placa;
		this.especificacion = especificacion;
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
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEspecificacion() {
		return especificacion;
	}

	public void setEspecifiacion(String especificacion) {
		this.especificacion = especificacion;
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
