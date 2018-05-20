package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sesiones_activas database table.
 * 
 */
@Entity
@Table(name="sesiones_activas")
@NamedQuery(name="SesionesActiva.findAll", query="SELECT s FROM SesionesActiva s")
public class SesionesActiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SESION")
	private int idSesion;

	private int activo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INGRESO")
	private Date fechaIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_ULTIMA_ACT")
	private Date fechaUltimaAct;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public SesionesActiva() {
	}

	public int getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaUltimaAct() {
		return this.fechaUltimaAct;
	}

	public void setFechaUltimaAct(Date fechaUltimaAct) {
		this.fechaUltimaAct = fechaUltimaAct;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}