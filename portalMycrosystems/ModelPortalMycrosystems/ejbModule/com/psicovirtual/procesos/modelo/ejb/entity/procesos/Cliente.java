package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLIENTE")
	private int idCliente;

	@Column(name="CONTRASENA_INFOBI")
	private String contrasenaInfobi;

	private String correo;

	@Column(name="DNS_CLIENTE")
	private String dnsCliente;

	@Column(name="ID_PLANTILLA")
	private int idPlantilla;

	private int nit;

	private String nombre;

	@Column(name="USUARIO_INFOBI")
	private String usuarioInfobi;

	//bi-directional many-to-one association to CargueArchivo
	@OneToMany(mappedBy="cliente")
	private List<CargueArchivo> cargueArchivos;

	//bi-directional many-to-one association to ClienteUsuario
	@OneToMany(mappedBy="cliente")
	private List<ClienteUsuario> clienteUsuarios;

	//bi-directional many-to-one association to FlujoNotificacion
	@OneToMany(mappedBy="cliente")
	private List<FlujoNotificacion> flujoNotificacions;

	//bi-directional many-to-one association to Negociacione
	@OneToMany(mappedBy="cliente")
	private List<Negociacione> negociaciones;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getContrasenaInfobi() {
		return this.contrasenaInfobi;
	}

	public void setContrasenaInfobi(String contrasenaInfobi) {
		this.contrasenaInfobi = contrasenaInfobi;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDnsCliente() {
		return this.dnsCliente;
	}

	public void setDnsCliente(String dnsCliente) {
		this.dnsCliente = dnsCliente;
	}

	public int getIdPlantilla() {
		return this.idPlantilla;
	}

	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public int getNit() {
		return this.nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuarioInfobi() {
		return this.usuarioInfobi;
	}

	public void setUsuarioInfobi(String usuarioInfobi) {
		this.usuarioInfobi = usuarioInfobi;
	}

	public List<CargueArchivo> getCargueArchivos() {
		return this.cargueArchivos;
	}

	public void setCargueArchivos(List<CargueArchivo> cargueArchivos) {
		this.cargueArchivos = cargueArchivos;
	}

	public CargueArchivo addCargueArchivo(CargueArchivo cargueArchivo) {
		getCargueArchivos().add(cargueArchivo);
		cargueArchivo.setCliente(this);

		return cargueArchivo;
	}

	public CargueArchivo removeCargueArchivo(CargueArchivo cargueArchivo) {
		getCargueArchivos().remove(cargueArchivo);
		cargueArchivo.setCliente(null);

		return cargueArchivo;
	}

	public List<ClienteUsuario> getClienteUsuarios() {
		return this.clienteUsuarios;
	}

	public void setClienteUsuarios(List<ClienteUsuario> clienteUsuarios) {
		this.clienteUsuarios = clienteUsuarios;
	}

	public ClienteUsuario addClienteUsuario(ClienteUsuario clienteUsuario) {
		getClienteUsuarios().add(clienteUsuario);
		clienteUsuario.setCliente(this);

		return clienteUsuario;
	}

	public ClienteUsuario removeClienteUsuario(ClienteUsuario clienteUsuario) {
		getClienteUsuarios().remove(clienteUsuario);
		clienteUsuario.setCliente(null);

		return clienteUsuario;
	}

	public List<FlujoNotificacion> getFlujoNotificacions() {
		return this.flujoNotificacions;
	}

	public void setFlujoNotificacions(List<FlujoNotificacion> flujoNotificacions) {
		this.flujoNotificacions = flujoNotificacions;
	}

	public FlujoNotificacion addFlujoNotificacion(FlujoNotificacion flujoNotificacion) {
		getFlujoNotificacions().add(flujoNotificacion);
		flujoNotificacion.setCliente(this);

		return flujoNotificacion;
	}

	public FlujoNotificacion removeFlujoNotificacion(FlujoNotificacion flujoNotificacion) {
		getFlujoNotificacions().remove(flujoNotificacion);
		flujoNotificacion.setCliente(null);

		return flujoNotificacion;
	}

	public List<Negociacione> getNegociaciones() {
		return this.negociaciones;
	}

	public void setNegociaciones(List<Negociacione> negociaciones) {
		this.negociaciones = negociaciones;
	}

	public Negociacione addNegociacione(Negociacione negociacione) {
		getNegociaciones().add(negociacione);
		negociacione.setCliente(this);

		return negociacione;
	}

	public Negociacione removeNegociacione(Negociacione negociacione) {
		getNegociaciones().remove(negociacione);
		negociacione.setCliente(null);

		return negociacione;
	}

}