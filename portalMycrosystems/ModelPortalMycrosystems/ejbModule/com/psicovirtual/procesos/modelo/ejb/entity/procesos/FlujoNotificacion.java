package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the flujo_notificacion database table.
 * 
 */
@Entity
@Table(name="flujo_notificacion")
@NamedQuery(name="FlujoNotificacion.findAll", query="SELECT f FROM FlujoNotificacion f")
public class FlujoNotificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FLUJO_NOTI")
	private int idFlujoNoti;

	private int activa;

	private String descripcion;

	private int dias;

	private int orden;

	//bi-directional many-to-one association to EstadoNotificacionCargue
	@OneToMany(mappedBy="flujoNotificacion")
	private List<EstadoNotificacionCargue> estadoNotificacionCargues;

	//bi-directional many-to-one association to EstadoNotificacionUsuario
	@OneToMany(mappedBy="flujoNotificacion")
	private List<EstadoNotificacionUsuario> estadoNotificacionUsuarios;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to TipoNotificiacon
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private TipoNotificiacon tipoNotificiacon;

	public FlujoNotificacion() {
	}

	public int getIdFlujoNoti() {
		return this.idFlujoNoti;
	}

	public void setIdFlujoNoti(int idFlujoNoti) {
		this.idFlujoNoti = idFlujoNoti;
	}

	public int getActiva() {
		return this.activa;
	}

	public void setActiva(int activa) {
		this.activa = activa;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDias() {
		return this.dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public List<EstadoNotificacionCargue> getEstadoNotificacionCargues() {
		return this.estadoNotificacionCargues;
	}

	public void setEstadoNotificacionCargues(List<EstadoNotificacionCargue> estadoNotificacionCargues) {
		this.estadoNotificacionCargues = estadoNotificacionCargues;
	}

	public EstadoNotificacionCargue addEstadoNotificacionCargue(EstadoNotificacionCargue estadoNotificacionCargue) {
		getEstadoNotificacionCargues().add(estadoNotificacionCargue);
		estadoNotificacionCargue.setFlujoNotificacion(this);

		return estadoNotificacionCargue;
	}

	public EstadoNotificacionCargue removeEstadoNotificacionCargue(EstadoNotificacionCargue estadoNotificacionCargue) {
		getEstadoNotificacionCargues().remove(estadoNotificacionCargue);
		estadoNotificacionCargue.setFlujoNotificacion(null);

		return estadoNotificacionCargue;
	}

	public List<EstadoNotificacionUsuario> getEstadoNotificacionUsuarios() {
		return this.estadoNotificacionUsuarios;
	}

	public void setEstadoNotificacionUsuarios(List<EstadoNotificacionUsuario> estadoNotificacionUsuarios) {
		this.estadoNotificacionUsuarios = estadoNotificacionUsuarios;
	}

	public EstadoNotificacionUsuario addEstadoNotificacionUsuario(EstadoNotificacionUsuario estadoNotificacionUsuario) {
		getEstadoNotificacionUsuarios().add(estadoNotificacionUsuario);
		estadoNotificacionUsuario.setFlujoNotificacion(this);

		return estadoNotificacionUsuario;
	}

	public EstadoNotificacionUsuario removeEstadoNotificacionUsuario(EstadoNotificacionUsuario estadoNotificacionUsuario) {
		getEstadoNotificacionUsuarios().remove(estadoNotificacionUsuario);
		estadoNotificacionUsuario.setFlujoNotificacion(null);

		return estadoNotificacionUsuario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoNotificiacon getTipoNotificiacon() {
		return this.tipoNotificiacon;
	}

	public void setTipoNotificiacon(TipoNotificiacon tipoNotificiacon) {
		this.tipoNotificiacon = tipoNotificiacon;
	}

}