package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acciones_pagina database table.
 * 
 */
@Entity
@Table(name="acciones_pagina")
@NamedQuery(name="AccionesPagina.findAll", query="SELECT a FROM AccionesPagina a")
public class AccionesPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACCION")
	private int idAccion;

	private String accion;

	private int activa;

	private String descripcion;

	//bi-directional many-to-one association to Pagina
	@ManyToOne
	@JoinColumn(name="ID_PAGINA")
	private Pagina pagina;

	//bi-directional many-to-one association to PermisosUsuario
	@OneToMany(mappedBy="accionesPagina")
	private List<PermisosUsuario> permisosUsuarios;

	public AccionesPagina() {
	}

	public int getIdAccion() {
		return this.idAccion;
	}

	public void setIdAccion(int idAccion) {
		this.idAccion = idAccion;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
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

	public Pagina getPagina() {
		return this.pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public List<PermisosUsuario> getPermisosUsuarios() {
		return this.permisosUsuarios;
	}

	public void setPermisosUsuarios(List<PermisosUsuario> permisosUsuarios) {
		this.permisosUsuarios = permisosUsuarios;
	}

	public PermisosUsuario addPermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().add(permisosUsuario);
		permisosUsuario.setAccionesPagina(this);

		return permisosUsuario;
	}

	public PermisosUsuario removePermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().remove(permisosUsuario);
		permisosUsuario.setAccionesPagina(null);

		return permisosUsuario;
	}

}