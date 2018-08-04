package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_notificiacon database table.
 * 
 */
@Entity
@Table(name="tipo_notificiacon")
@NamedQuery(name="TipoNotificiacon.findAll", query="SELECT t FROM TipoNotificiacon t")
public class TipoNotificiacon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO")
	private int idTipo;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to FlujoNotificacion
	@OneToMany(mappedBy="tipoNotificiacon")
	private List<FlujoNotificacion> flujoNotificacions;

	public TipoNotificiacon() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<FlujoNotificacion> getFlujoNotificacions() {
		return this.flujoNotificacions;
	}

	public void setFlujoNotificacions(List<FlujoNotificacion> flujoNotificacions) {
		this.flujoNotificacions = flujoNotificacions;
	}

	public FlujoNotificacion addFlujoNotificacion(FlujoNotificacion flujoNotificacion) {
		getFlujoNotificacions().add(flujoNotificacion);
		flujoNotificacion.setTipoNotificiacon(this);

		return flujoNotificacion;
	}

	public FlujoNotificacion removeFlujoNotificacion(FlujoNotificacion flujoNotificacion) {
		getFlujoNotificacions().remove(flujoNotificacion);
		flujoNotificacion.setTipoNotificiacon(null);

		return flujoNotificacion;
	}

}