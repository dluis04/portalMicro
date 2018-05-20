package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the obligacion database table.
 * 
 */
@Entity
@NamedQuery(name="Obligacion.findAll", query="SELECT o FROM Obligacion o")
public class Obligacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_OBLIGACION")
	private int idObligacion;

	private String estado;

	@Column(name="NUMERO_TITULAR")
	private String numeroTitular;

	//bi-directional many-to-one association to Compromiso
	@OneToMany(mappedBy="obligacion")
	private List<Compromiso> compromisos;

	//bi-directional many-to-one association to DetalleObligacion
	@OneToMany(mappedBy="obligacion")
	private List<DetalleObligacion> detalleObligacions;

	//bi-directional many-to-one association to ClienteUsuario
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE_USUARIO")
	private ClienteUsuario clienteUsuario;

	public Obligacion() {
	}

	public int getIdObligacion() {
		return this.idObligacion;
	}

	public void setIdObligacion(int idObligacion) {
		this.idObligacion = idObligacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroTitular() {
		return this.numeroTitular;
	}

	public void setNumeroTitular(String numeroTitular) {
		this.numeroTitular = numeroTitular;
	}

	public List<Compromiso> getCompromisos() {
		return this.compromisos;
	}

	public void setCompromisos(List<Compromiso> compromisos) {
		this.compromisos = compromisos;
	}

	public Compromiso addCompromiso(Compromiso compromiso) {
		getCompromisos().add(compromiso);
		compromiso.setObligacion(this);

		return compromiso;
	}

	public Compromiso removeCompromiso(Compromiso compromiso) {
		getCompromisos().remove(compromiso);
		compromiso.setObligacion(null);

		return compromiso;
	}

	public List<DetalleObligacion> getDetalleObligacions() {
		return this.detalleObligacions;
	}

	public void setDetalleObligacions(List<DetalleObligacion> detalleObligacions) {
		this.detalleObligacions = detalleObligacions;
	}

	public DetalleObligacion addDetalleObligacion(DetalleObligacion detalleObligacion) {
		getDetalleObligacions().add(detalleObligacion);
		detalleObligacion.setObligacion(this);

		return detalleObligacion;
	}

	public DetalleObligacion removeDetalleObligacion(DetalleObligacion detalleObligacion) {
		getDetalleObligacions().remove(detalleObligacion);
		detalleObligacion.setObligacion(null);

		return detalleObligacion;
	}

	public ClienteUsuario getClienteUsuario() {
		return this.clienteUsuario;
	}

	public void setClienteUsuario(ClienteUsuario clienteUsuario) {
		this.clienteUsuario = clienteUsuario;
	}

}