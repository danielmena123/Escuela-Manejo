package com.proyeto.escuelamanejo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;
/**/
@Entity
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	@Column(name="Nombre_Alumno")
	private String nombre;
	@NotEmpty
	@Column(name="Apellido_Alumno")
	private String apellido;
	@NotEmpty
	@Column(name="DUI_Alumno")
	private String dui;
	@NotEmpty
	@Column(name="Telefono_Alumno")
	private String telefono;
	@NotNull
	@Column(name="Edad_Alumno")
	private int edad;
	@NotEmpty
	@Column(name="Direccion_Alumno")
	private String direccion;
	@NotNull
	@Column(name="Estado_Alumno")
	private int estado;
	
	//Builde rs
	
	public Alumno() {}

	public Alumno(int id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String dui,
			@NotEmpty String telefono, @NotEmpty int edad, @NotEmpty String direccion, @NotEmpty int estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dui = dui;
		this.telefono = telefono;
		this.edad = edad;
		this.direccion = direccion;
		this.estado = estado;
	}
	
	public Alumno(@NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String dui,
			@NotEmpty String telefono, @NotEmpty int edad, @NotEmpty String direccion, @NotEmpty int estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dui = dui;
		this.telefono = telefono;
		this.edad = edad;
		this.direccion = direccion;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
