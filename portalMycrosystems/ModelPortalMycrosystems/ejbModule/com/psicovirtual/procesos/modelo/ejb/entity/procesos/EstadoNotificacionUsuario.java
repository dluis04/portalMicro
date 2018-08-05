package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the estado_notificacion_usuario database table.
 * 
 */
@Entity
@Table(name="estado_notificacion_usuario")
@NamedQuery(name="EstadoNotificacionUsuario.findAll", query="SELECT e FROM EstadoNotificacionUsuario e")
public class EstadoNotificacionUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ESTADO_NOT_CARG")
	private int idEstadoNotCarg;

	@Column(name="ESTADO_NOTIFICACION")
	private String estadoNotificacion;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="RESPUESTA_SERVICIO")
	private String respuestaServicio;

	//bi-directional many-to-one association to ClienteUsuario
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE_USUARIO")
	private ClienteUsuario clienteUsuario;

	//bi-directional many-to-one association to FlujoNotificacion
	@ManyToOne
	@JoinColumn(name="ID_FLUJO_NOTI")
	private FlujoNotificacion flujoNotificacion;

	public EstadoNotificacionUsuario() {
	}

	public int getIdEstadoNotCarg() {
		return this.idEstadoNotCarg;
	}

	public void setIdEstadoNotCarg(int idEstadoNotCarg) {
		this.idEstadoNotCarg = idEstadoNotCarg;
	}

	public String getEstadoNotificacion() {
		return this.estadoNotificacion;
	}

	public void setEstadoNotificacion(String estadoNotificacion) {
		this.estadoNotificacion = estadoNotificacion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getRespuestaServicio() {
		return this.respuestaServicio;
	}

	public void setRespuestaServicio(String respuestaServicio) {
		this.respuestaServicio = respuestaServicio;
	}

	public ClienteUsuario getClienteUsuario() {
		return this.clienteUsuario;
	}

	public void setClienteUsuario(ClienteUsuario clienteUsuario) {
		this.clienteUsuario = clienteUsuario;
	}

	public FlujoNotificacion getFlujoNotificacion() {
		return this.flujoNotificacion;
	}

	public void setFlujoNotificacion(FlujoNotificacion flujoNotificacion) {
		this.flujoNotificacion = flujoNotificacion;
	}

}