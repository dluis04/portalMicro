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

	private String correo;

	private int nit;

	private String nombre;

	//bi-directional many-to-one association to CargueArchivo
	@OneToMany(mappedBy="cliente")
	private List<CargueArchivo> cargueArchivos;

	//bi-directional many-to-one association to ClienteUsuario
	@OneToMany(mappedBy="cliente")
	private List<ClienteUsuario> clienteUsuarios;

	
	
	@Transient
	private String nombreAfil;
	
	
	@Transient
	private String cantidadRegistros;
	
	
	
	public String getNombreAfil() {
		return nombreAfil;
	}

	public void setNombreAfil(String nombreAfil) {
		this.nombreAfil = nombreAfil;
	}

	public String getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(String cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

}