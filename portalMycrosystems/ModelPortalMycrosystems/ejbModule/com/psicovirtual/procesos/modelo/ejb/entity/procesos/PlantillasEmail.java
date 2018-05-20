package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plantillas_email database table.
 * 
 */
@Entity
@Table(name="plantillas_email")
@NamedQuery(name="PlantillasEmail.findAll", query="SELECT p FROM PlantillasEmail p")
public class PlantillasEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PLANTILLA")
	private int idPlantilla;

	private String descripcion;

	//bi-directional many-to-one association to EstadoCargue
	@OneToMany(mappedBy="plantillasEmail")
	private List<EstadoCargue> estadoCargues;

	//bi-directional many-to-one association to EstadoUsuario
	@OneToMany(mappedBy="plantillasEmail")
	private List<EstadoUsuario> estadoUsuarios;

	public PlantillasEmail() {
	}

	public int getIdPlantilla() {
		return this.idPlantilla;
	}

	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EstadoCargue> getEstadoCargues() {
		return this.estadoCargues;
	}

	public void setEstadoCargues(List<EstadoCargue> estadoCargues) {
		this.estadoCargues = estadoCargues;
	}

	public EstadoCargue addEstadoCargue(EstadoCargue estadoCargue) {
		getEstadoCargues().add(estadoCargue);
		estadoCargue.setPlantillasEmail(this);

		return estadoCargue;
	}

	public EstadoCargue removeEstadoCargue(EstadoCargue estadoCargue) {
		getEstadoCargues().remove(estadoCargue);
		estadoCargue.setPlantillasEmail(null);

		return estadoCargue;
	}

	public List<EstadoUsuario> getEstadoUsuarios() {
		return this.estadoUsuarios;
	}

	public void setEstadoUsuarios(List<EstadoUsuario> estadoUsuarios) {
		this.estadoUsuarios = estadoUsuarios;
	}

	public EstadoUsuario addEstadoUsuario(EstadoUsuario estadoUsuario) {
		getEstadoUsuarios().add(estadoUsuario);
		estadoUsuario.setPlantillasEmail(this);

		return estadoUsuario;
	}

	public EstadoUsuario removeEstadoUsuario(EstadoUsuario estadoUsuario) {
		getEstadoUsuarios().remove(estadoUsuario);
		estadoUsuario.setPlantillasEmail(null);

		return estadoUsuario;
	}

}