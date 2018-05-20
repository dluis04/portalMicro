package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	@Column(name="ID_ESTADO_NOT_USU")
	private int idEstadoNotUsu;

	private int activo;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	//bi-directional many-to-one association to ClienteUsuario
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE_USUARIO")
	private ClienteUsuario clienteUsuario;

	//bi-directional many-to-one association to EstadoUsuario
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_USUARIO")
	private EstadoUsuario estadoUsuario;

	public EstadoNotificacionUsuario() {
	}

	public int getIdEstadoNotUsu() {
		return this.idEstadoNotUsu;
	}

	public void setIdEstadoNotUsu(int idEstadoNotUsu) {
		this.idEstadoNotUsu = idEstadoNotUsu;
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

	public ClienteUsuario getClienteUsuario() {
		return this.clienteUsuario;
	}

	public void setClienteUsuario(ClienteUsuario clienteUsuario) {
		this.clienteUsuario = clienteUsuario;
	}

	public EstadoUsuario getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

}