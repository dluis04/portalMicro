package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compromiso database table.
 * 
 */
@Entity
@NamedQuery(name="Compromiso.findAll", query="SELECT c FROM Compromiso c")
public class Compromiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMPROMISO")
	private int idCompromiso;

	private String estado;

	@Column(name="FECHA_COMPROMISO")
	private String fechaCompromiso;

	private String interes;

	private int orden;

	private int valor;

	//bi-directional many-to-one association to Obligacion
	@ManyToOne
	@JoinColumn(name="ID_OBLIGACION")
	private Obligacion obligacion;

	public Compromiso() {
	}

	public int getIdCompromiso() {
		return this.idCompromiso;
	}

	public void setIdCompromiso(int idCompromiso) {
		this.idCompromiso = idCompromiso;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaCompromiso() {
		return this.fechaCompromiso;
	}

	public void setFechaCompromiso(String fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public String getInteres() {
		return this.interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Obligacion getObligacion() {
		return this.obligacion;
	}

	public void setObligacion(Obligacion obligacion) {
		this.obligacion = obligacion;
	}

}