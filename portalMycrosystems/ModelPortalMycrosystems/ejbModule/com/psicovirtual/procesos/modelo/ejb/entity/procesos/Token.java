package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the token database table.
 * 
 */
@Entity
@NamedQuery(name="Token.findAll", query="SELECT t FROM Token t")
public class Token implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TOKEN")
	private int idToken;

	private int activo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_FIN")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	private String token;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Token() {
	}

	public int getIdToken() {
		return this.idToken;
	}

	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}