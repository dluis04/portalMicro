package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_obligacion database table.
 * 
 */
@Entity
@Table(name="detalle_obligacion")
@NamedQuery(name="DetalleObligacion.findAll", query="SELECT d FROM DetalleObligacion d")
public class DetalleObligacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DETALLE_OBLI")
	private int idDetalleObli;

	private int cuota;

	@Column(name="DIAS_MORA")
	private int diasMora;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ELABORACION")
	private Date fechaElaboracion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;

	private int valor;

	//bi-directional many-to-one association to Obligacion
	@ManyToOne
	@JoinColumn(name="ID_OBLIGACION")
	private Obligacion obligacion;

	public DetalleObligacion() {
	}

	public int getIdDetalleObli() {
		return this.idDetalleObli;
	}

	public void setIdDetalleObli(int idDetalleObli) {
		this.idDetalleObli = idDetalleObli;
	}

	public int getCuota() {
		return this.cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}

	public int getDiasMora() {
		return this.diasMora;
	}

	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaElaboracion() {
		return this.fechaElaboracion;
	}

	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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