package com.proyeto.escuelamanejo.entidades;

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
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name="Cantidad_Horas")
	private int cantidadhoras;
	@NotEmpty
	@Column(name="Horas_Practicas")
	private int horaspracticas;
	@NotEmpty
	@Column(name="Horas_Teoricas")
	private int horasteoricas;
	@NotEmpty
	@Column(name="Precio_Servicio")
	private double precio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVehiculo")
		private Vehiculo vehiculo;
	@Column(name="Estado_Servicio")
	private int estado;
	
	//Builders
	
	public Servicio() {}

	public Servicio(int id, @NotEmpty int cantidadhoras, @NotEmpty int horaspracticas, @NotEmpty int horasteoricas,
			@NotEmpty double precio, Vehiculo vehiculo, @NotEmpty int estado) {
		this.id = id;
		this.cantidadhoras = cantidadhoras;
		this.horaspracticas = horaspracticas;
		this.horasteoricas = horasteoricas;
		this.precio = precio;
		this.vehiculo = vehiculo;
		this.estado = estado;
	}
	
	public Servicio(@NotEmpty int cantidadhoras, @NotEmpty int horaspracticas, @NotEmpty int horasteoricas,
			@NotEmpty double precio, Vehiculo vehiculo, @NotEmpty int estado) {
		this.cantidadhoras = cantidadhoras;
		this.horaspracticas = horaspracticas;
		this.horasteoricas = horasteoricas;
		this.precio = precio;
		this.vehiculo = vehiculo;
		this.estado = estado;
	}
	
	//Getters && Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadhoras() {
		return cantidadhoras;
	}

	public void setCantidadhoras(int cantidadhoras) {
		this.cantidadhoras = cantidadhoras;
	}

	public int getHoraspracticas() {
		return horaspracticas;
	}

	public void setHoraspracticas(int horaspracticas) {
		this.horaspracticas = horaspracticas;
	}

	public int getHorasteoricas() {
		return horasteoricas;
	}

	public void setHorasteoricas(int horasteoricas) {
		this.horasteoricas = horasteoricas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
