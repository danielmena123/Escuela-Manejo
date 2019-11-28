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
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name="Fecha_Pago")
	private Date fechapago;
	@NotEmpty
	@Column(name="Abono_Contrato")
	private double abono;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdContrato")
		private Contrato contrato;
	
	//Builders
	
	public Pago() {}

	public Pago(int id, @NotEmpty Date fechapago, @NotEmpty double abono, Contrato contrato) {
		this.id = id;
		this.fechapago = fechapago;
		this.abono = abono;
		this.contrato = contrato;
	}
	
	public Pago(@NotEmpty Date fechapago, @NotEmpty double abono, Contrato contrato) {
		this.fechapago = fechapago;
		this.abono = abono;
		this.contrato = contrato;
	}
	
	//Getters && Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(Date fechapago) {
		this.fechapago = fechapago;
	}

	public double getAbono() {
		return abono;
	}

	public void setAbono(double abono) {
		this.abono = abono;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
}
