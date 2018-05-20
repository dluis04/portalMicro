package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_cargue database table.
 * 
 */
@Entity
@Table(name="estado_cargue")
@NamedQuery(name="EstadoCargue.findAll", query="SELECT e FROM EstadoCargue e")
public class EstadoCargue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ESTADO_CARGUE")
	private int idEstadoCargue;

	private int activa;

	private String descripcion;

	private int dias;

	private int orden;

	//bi-directional many-to-one association to PlantillasEmail
	@ManyToOne
	@JoinColumn(name="ID_PLANTILLA")
	private PlantillasEmail plantillasEmail;

	//bi-directional many-to-one association to EstadoNotificacionCargue
	@OneToMany(mappedBy="estadoCargue")
	private List<EstadoNotificacionCargue> estadoNotificacionCargues;

	public EstadoCargue() {
	}

	public int getIdEstadoCargue() {
		return this.idEstadoCargue;
	}

	public void setIdEstadoCargue(int idEstadoCargue) {
		this.idEstadoCargue = idEstadoCargue;
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

	public PlantillasEmail getPlantillasEmail() {
		return this.plantillasEmail;
	}

	public void setPlantillasEmail(PlantillasEmail plantillasEmail) {
		this.plantillasEmail = plantillasEmail;
	}

	public List<EstadoNotificacionCargue> getEstadoNotificacionCargues() {
		return this.estadoNotificacionCargues;
	}

	public void setEstadoNotificacionCargues(List<EstadoNotificacionCargue> estadoNotificacionCargues) {
		this.estadoNotificacionCargues = estadoNotificacionCargues;
	}

	public EstadoNotificacionCargue addEstadoNotificacionCargue(EstadoNotificacionCargue estadoNotificacionCargue) {
		getEstadoNotificacionCargues().add(estadoNotificacionCargue);
		estadoNotificacionCargue.setEstadoCargue(this);

		return estadoNotificacionCargue;
	}

	public EstadoNotificacionCargue removeEstadoNotificacionCargue(EstadoNotificacionCargue estadoNotificacionCargue) {
		getEstadoNotificacionCargues().remove(estadoNotificacionCargue);
		estadoNotificacionCargue.setEstadoCargue(null);

		return estadoNotificacionCargue;
	}

}