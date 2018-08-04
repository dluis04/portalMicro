package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_cargue database table.
 * 
 */
@Entity
@Table(name="detalle_cargue")
@NamedQuery(name="DetalleCargue.findAll", query="SELECT d FROM DetalleCargue d")
public class DetalleCargue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleCarguePK id;

	private String celular;

	private String ciudad;

	private String correo;

	private String departamento;

	@Column(name="DIAS_MORA")
	private int diasMora;

	private String direccion;

	@Column(name="ERROR_CARGUE")
	private String errorCargue;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ELABORACION")
	private Date fechaElaboracion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;

	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name="SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;

	@Column(name="TELEDONO_2")
	private String teledono2;

	@Column(name="TELEFONO_1")
	private String telefono1;

	@Column(name="TELEFONO_3")
	private String telefono3;

	@Column(name="TIPO_DOC")
	private int tipoDoc;

	private int valor;

	//bi-directional many-to-one association to CargueArchivo
	@ManyToOne
	@JoinColumn(name="ID_CARGUE")
	private CargueArchivo cargueArchivo;

	public DetalleCargue() {
	}

	public DetalleCarguePK getId() {
		return this.id;
	}

	public void setId(DetalleCarguePK id) {
		this.id = id;
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

	public int getDiasMora() {
		return this.diasMora;
	}

	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getErrorCargue() {
		return this.errorCargue;
	}

	public void setErrorCargue(String errorCargue) {
		this.errorCargue = errorCargue;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaElaboracion() {
		return this.fechaElaboracion;
	}

	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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

	public String getTeledono2() {
		return this.teledono2;
	}

	public void setTeledono2(String teledono2) {
		this.teledono2 = teledono2;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
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

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public CargueArchivo getCargueArchivo() {
		return this.cargueArchivo;
	}

	public void setCargueArchivo(CargueArchivo cargueArchivo) {
		this.cargueArchivo = cargueArchivo;
	}

}