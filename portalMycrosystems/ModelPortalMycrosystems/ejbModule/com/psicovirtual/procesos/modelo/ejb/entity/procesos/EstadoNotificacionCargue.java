package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	private int activo;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	//bi-directional many-to-one association to CargueArchivo
	@ManyToOne
	@JoinColumn(name="ID_CARGUE")
	private CargueArchivo cargueArchivo;

	//bi-directional many-to-one association to EstadoCargue
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_CARGUE")
	private EstadoCargue estadoCargue;

	public EstadoNotificacionCargue() {
	}

	public int getIdEstadoNotCarg() {
		return this.idEstadoNotCarg;
	}

	public void setIdEstadoNotCarg(int idEstadoNotCarg) {
		this.idEstadoNotCarg = idEstadoNotCarg;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public CargueArchivo getCargueArchivo() {
		return this.cargueArchivo;
	}

	public void setCargueArchivo(CargueArchivo cargueArchivo) {
		this.cargueArchivo = cargueArchivo;
	}

	public EstadoCargue getEstadoCargue() {
		return this.estadoCargue;
	}

	public void setEstadoCargue(EstadoCargue estadoCargue) {
		this.estadoCargue = estadoCargue;
	}

}