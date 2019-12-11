package com.proyeto.escuelamanejo.entidades;
/**/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	@Column(name="Nombre")
	private String nombre;
	@NotNull
	@Column(name="Cantidad_Horas")
	private int cantidadhoras;
	@NotNull
	@Column(name="Horas_Practicas")
	private int horaspracticas;
	@NotNull
	@Column(name="Horas_Teoricas")
	private int horasteoricas;
	@NotNull
	@Column(name="Numero_Clases")
	private int clases;
	@NotNull
	@Column(name="Precio_Servicio")
	private double precio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVehiculo")
		private Vehiculo vehiculo;
	@NotNull
	@Column(name="Estado_Servicio")
	private int estado;
	
	//Builders
	
	public Servicio() {}

	public Servicio(int id,@NotEmpty String nombre, @NotEmpty int cantidadhoras, @NotEmpty int horaspracticas, @NotEmpty int horasteoricas,
			@NotEmpty int clases, @NotEmpty double precio, Vehiculo vehiculo, @NotEmpty int estado) {
		this.id = id;
		this.nombre = nombre;
		this.cantidadhoras = cantidadhoras;
		this.horaspracticas = horaspracticas;
		this.horasteoricas = horasteoricas;
		this.clases = clases;
		this.precio = precio;
		this.vehiculo = vehiculo;
		this.estado = estado;
	}
	
	public Servicio(@NotEmpty String nombre, @NotEmpty int cantidadhoras, @NotEmpty int horaspracticas, @NotEmpty int horasteoricas,
			@NotEmpty int clases, @NotEmpty double precio, Vehiculo vehiculo, @NotEmpty int estado) {
		this.nombre = nombre;
		this.cantidadhoras = cantidadhoras;
		this.horaspracticas = horaspracticas;
		this.horasteoricas = horasteoricas;
		this.clases = clases;
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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getClases() {
		return clases;
	}

	public void setClases(int clases) {
		this.clases = clases;
	}
	
}
