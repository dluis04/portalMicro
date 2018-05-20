package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_usuario database table.
 * 
 */
@Entity
@Table(name="estado_usuario")
@NamedQuery(name="EstadoUsuario.findAll", query="SELECT e FROM EstadoUsuario e")
public class EstadoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ESTADO_USUARIO")
	private int idEstadoUsuario;

	private int activa;

	private String descripcion;

	private int dias;

	private int orden;

	//bi-directional many-to-one association to EstadoNotificacionUsuario
	@OneToMany(mappedBy="estadoUsuario")
	private List<EstadoNotificacionUsuario> estadoNotificacionUsuarios;

	//bi-directional many-to-one association to PlantillasEmail
	@ManyToOne
	@JoinColumn(name="ID_PLANTILLA")
	private PlantillasEmail plantillasEmail;

	public EstadoUsuario() {
	}

	public int getIdEstadoUsuario() {
		return this.idEstadoUsuario;
	}

	public void setIdEstadoUsuario(int idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
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

	public List<EstadoNotificacionUsuario> getEstadoNotificacionUsuarios() {
		return this.estadoNotificacionUsuarios;
	}

	public void setEstadoNotificacionUsuarios(List<EstadoNotificacionUsuario> estadoNotificacionUsuarios) {
		this.estadoNotificacionUsuarios = estadoNotificacionUsuarios;
	}

	public EstadoNotificacionUsuario addEstadoNotificacionUsuario(EstadoNotificacionUsuario estadoNotificacionUsuario) {
		getEstadoNotificacionUsuarios().add(estadoNotificacionUsuario);
		estadoNotificacionUsuario.setEstadoUsuario(this);

		return estadoNotificacionUsuario;
	}

	public EstadoNotificacionUsuario removeEstadoNotificacionUsuario(EstadoNotificacionUsuario estadoNotificacionUsuario) {
		getEstadoNotificacionUsuarios().remove(estadoNotificacionUsuario);
		estadoNotificacionUsuario.setEstadoUsuario(null);

		return estadoNotificacionUsuario;
	}

	public PlantillasEmail getPlantillasEmail() {
		return this.plantillasEmail;
	}

	public void setPlantillasEmail(PlantillasEmail plantillasEmail) {
		this.plantillasEmail = plantillasEmail;
	}

}