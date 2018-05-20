package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the permisos_usuarios database table.
 * 
 */
@Entity
@Table(name="permisos_usuarios")
@NamedQuery(name="PermisosUsuario.findAll", query="SELECT p FROM PermisosUsuario p")
public class PermisosUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERMISO")
	private int idPermiso;

	private int activo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_ASIGNACION")
	private Date fechaAsignacion;

	@Column(name="USU_ASIGNACION")
	private int usuAsignacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to AccionesPagina
	@ManyToOne
	@JoinColumn(name="ID_ACCION")
	private AccionesPagina accionesPagina;

	public PermisosUsuario() {
	}

	public int getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFechaAsignacion() {
		return this.fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public int getUsuAsignacion() {
		return this.usuAsignacion;
	}

	public void setUsuAsignacion(int usuAsignacion) {
		this.usuAsignacion = usuAsignacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AccionesPagina getAccionesPagina() {
		return this.accionesPagina;
	}

	public void setAccionesPagina(AccionesPagina accionesPagina) {
		this.accionesPagina = accionesPagina;
	}

}