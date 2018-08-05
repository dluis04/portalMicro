package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the negociaciones database table.
 * 
 */
@Entity
@Table(name="negociaciones")
@NamedQuery(name="Negociacione.findAll", query="SELECT n FROM Negociacione n")
public class Negociacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NEGOCIACION")
	private int idNegociacion;

	private int capital;

	@Column(name="GASTO_COBRANZO")
	private int gastoCobranzo;

	@Column(name="INTERES_MORA")
	private BigDecimal interesMora;

	private String nombre;

	@Column(name="RANGO_DIAS_FIN")
	private int rangoDiasFin;

	@Column(name="RANGO_DIAS_INI")
	private int rangoDiasIni;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	public Negociacione() {
	}

	public int getIdNegociacion() {
		return this.idNegociacion;
	}

	public void setIdNegociacion(int idNegociacion) {
		this.idNegociacion = idNegociacion;
	}

	public int getCapital() {
		return this.capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public int getGastoCobranzo() {
		return this.gastoCobranzo;
	}

	public void setGastoCobranzo(int gastoCobranzo) {
		this.gastoCobranzo = gastoCobranzo;
	}

	public BigDecimal getInteresMora() {
		return this.interesMora;
	}

	public void setInteresMora(BigDecimal interesMora) {
		this.interesMora = interesMora;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRangoDiasFin() {
		return this.rangoDiasFin;
	}

	public void setRangoDiasFin(int rangoDiasFin) {
		this.rangoDiasFin = rangoDiasFin;
	}

	public int getRangoDiasIni() {
		return this.rangoDiasIni;
	}

	public void setRangoDiasIni(int rangoDiasIni) {
		this.rangoDiasIni = rangoDiasIni;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}