package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private int idUsuario;

	private int cedula;

	private String contrasena;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="TIPO_DOC")
	private int tipoDoc;

	@Column(name="TIPO_USUARIO")
	private String tipoUsuario;

	//bi-directional many-to-one association to ClienteUsuario
	@OneToMany(mappedBy="usuario")
	private List<ClienteUsuario> clienteUsuarios;

	//bi-directional many-to-one association to PermisosUsuario
	@OneToMany(mappedBy="usuario")
	private List<PermisosUsuario> permisosUsuarios;

	//bi-directional many-to-one association to SesionesActiva
	@OneToMany(mappedBy="usuario")
	private List<SesionesActiva> sesionesActivas;

	//bi-directional many-to-one association to Token
	@OneToMany(mappedBy="usuario")
	private List<Token> tokens;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getCedula() {
		return this.cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getTipoDoc() {
		return this.tipoDoc;
	}

	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<ClienteUsuario> getClienteUsuarios() {
		return this.clienteUsuarios;
	}

	public void setClienteUsuarios(List<ClienteUsuario> clienteUsuarios) {
		this.clienteUsuarios = clienteUsuarios;
	}

	public ClienteUsuario addClienteUsuario(ClienteUsuario clienteUsuario) {
		getClienteUsuarios().add(clienteUsuario);
		clienteUsuario.setUsuario(this);

		return clienteUsuario;
	}

	public ClienteUsuario removeClienteUsuario(ClienteUsuario clienteUsuario) {
		getClienteUsuarios().remove(clienteUsuario);
		clienteUsuario.setUsuario(null);

		return clienteUsuario;
	}

	public List<PermisosUsuario> getPermisosUsuarios() {
		return this.permisosUsuarios;
	}

	public void setPermisosUsuarios(List<PermisosUsuario> permisosUsuarios) {
		this.permisosUsuarios = permisosUsuarios;
	}

	public PermisosUsuario addPermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().add(permisosUsuario);
		permisosUsuario.setUsuario(this);

		return permisosUsuario;
	}

	public PermisosUsuario removePermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().remove(permisosUsuario);
		permisosUsuario.setUsuario(null);

		return permisosUsuario;
	}

	public List<SesionesActiva> getSesionesActivas() {
		return this.sesionesActivas;
	}

	public void setSesionesActivas(List<SesionesActiva> sesionesActivas) {
		this.sesionesActivas = sesionesActivas;
	}

	public SesionesActiva addSesionesActiva(SesionesActiva sesionesActiva) {
		getSesionesActivas().add(sesionesActiva);
		sesionesActiva.setUsuario(this);

		return sesionesActiva;
	}

	public SesionesActiva removeSesionesActiva(SesionesActiva sesionesActiva) {
		getSesionesActivas().remove(sesionesActiva);
		sesionesActiva.setUsuario(null);

		return sesionesActiva;
	}

	public List<Token> getTokens() {
		return this.tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Token addToken(Token token) {
		getTokens().add(token);
		token.setUsuario(this);

		return token;
	}

	public Token removeToken(Token token) {
		getTokens().remove(token);
		token.setUsuario(null);

		return token;
	}

}