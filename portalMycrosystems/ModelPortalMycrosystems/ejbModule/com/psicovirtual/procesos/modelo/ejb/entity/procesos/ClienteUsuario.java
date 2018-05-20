package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente_usuario database table.
 * 
 */
@Entity
@Table(name="cliente_usuario")
@NamedQuery(name="ClienteUsuario.findAll", query="SELECT c FROM ClienteUsuario c")
public class ClienteUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLIENTE_USUARIO")
	private int idClienteUsuario;

	private int cedula;

	private String celular;

	private String ciudad;

	private String correo;

	private String departamento;

	private String direccion;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name="SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;

	@Column(name="TELEFONO_1")
	private String telefono1;

	@Column(name="TELEFONO_2")
	private String telefono2;

	@Column(name="TELEFONO_3")
	private String telefono3;

	@Column(name="TIPO_DOC")
	private int tipoDoc;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to EstadoNotificacionUsuario
	@OneToMany(mappedBy="clienteUsuario")
	private List<EstadoNotificacionUsuario> estadoNotificacionUsuarios;

	//bi-directional many-to-one association to Obligacion
	@OneToMany(mappedBy="clienteUsuario")
	private List<Obligacion> obligacions;

	public ClienteUsuario() {
	}

	public int getIdClienteUsuario() {
		return this.idClienteUsuario;
	}

	public void setIdClienteUsuario(int idClienteUsuario) {
		this.idClienteUsuario = idClienteUsuario;
	}

	public int getCedula() {
		return this.cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono3() {
		return this.telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public int getTipoDoc() {
		return this.tipoDoc;
	}

	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<EstadoNotificacionUsuario> getEstadoNotificacionUsuarios() {
		return this.estadoNotificacionUsuarios;
	}

	public void setEstadoNotificacionUsuarios(List<EstadoNotificacionUsuario> estadoNotificacionUsuarios) {
		this.estadoNotificacionUsuarios = estadoNotificacionUsuarios;
	}

	public EstadoNotificacionUsuario addEstadoNotificacionUsuario(EstadoNotificacionUsuario estadoNotificacionUsuario) {
		getEstadoNotificacionUsuarios().add(estadoNotificacionUsuario);
		estadoNotificacionUsuario.setClienteUsuario(this);

		return estadoNotificacionUsuario;
	}

	public EstadoNotificacionUsuario removeEstadoNotificacionUsuario(EstadoNotificacionUsuario estadoNotificacionUsuario) {
		getEstadoNotificacionUsuarios().remove(estadoNotificacionUsuario);
		estadoNotificacionUsuario.setClienteUsuario(null);

		return estadoNotificacionUsuario;
	}

	public List<Obligacion> getObligacions() {
		return this.obligacions;
	}

	public void setObligacions(List<Obligacion> obligacions) {
		this.obligacions = obligacions;
	}

	public Obligacion addObligacion(Obligacion obligacion) {
		getObligacions().add(obligacion);
		obligacion.setClienteUsuario(this);

		return obligacion;
	}

	public Obligacion removeObligacion(Obligacion obligacion) {
		getObligacions().remove(obligacion);
		obligacion.setClienteUsuario(null);

		return obligacion;
	}

}