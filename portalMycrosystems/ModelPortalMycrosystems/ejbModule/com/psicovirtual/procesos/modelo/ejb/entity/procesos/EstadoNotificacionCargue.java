package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the estado_notificacion_cargue database table.
 * 
 */
@Entity
@Table(name="estado_notificacion_cargue")
@NamedQuery(name="EstadoNotificacionCargue.findAll", query="SELECT e FROM EstadoNotificacionCargue e")
public class EstadoNotificacionCargue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ESTADO_NOT_CARG")
	private int idEstadoNotCarg;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to FlujoNotificacion
	@ManyToOne
	@JoinColumn(name="ID_FLUJO_NOTI")
	private FlujoNotificacion flujoNotificacion;

	//bi-directional many-to-one association to CargueArchivo
	@ManyToOne
	@JoinColumn(name="ID_CARGUE")
	private CargueArchivo cargueArchivo;

	public EstadoNotificacionCargue() {
	}

	public int getIdEstadoNotCarg() {
		return this.idEstadoNotCarg;
	}

	public void setIdEstadoNotCarg(int idEstadoNotCarg) {
		this.idEstadoNotCarg = idEstadoNotCarg;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public FlujoNotificacion getFlujoNotificacion() {
		return this.flujoNotificacion;
	}

	public void setFlujoNotificacion(FlujoNotificacion flujoNotificacion) {
		this.flujoNotificacion = flujoNotificacion;
	}

	public CargueArchivo getCargueArchivo() {
		return this.cargueArchivo;
	}

	public void setCargueArchivo(CargueArchivo cargueArchivo) {
		this.cargueArchivo = cargueArchivo;
	}

}