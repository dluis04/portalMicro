package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cargue_archivos database table.
 * 
 */
@Entity
@Table(name="cargue_archivos")
@NamedQuery(name="CargueArchivo.findAll", query="SELECT c FROM CargueArchivo c")
public class CargueArchivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CARGUE")
	private int idCargue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_CARGUE")
	private Date fechaCargue;

	@Column(name="NOMBRE_ARCHIVO")
	private String nombreArchivo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to DetalleCargue
	@OneToMany(mappedBy="cargueArchivo")
	private List<DetalleCargue> detalleCargues;

	//bi-directional many-to-one association to EstadoNotificacionCargue
	@OneToMany(mappedBy="cargueArchivo")
	private List<EstadoNotificacionCargue> estadoNotificacionCargues;
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
	public CargueArchivo() {
	}

	public int getIdCargue() {
		return this.idCargue;
	}

	public void setIdCargue(int idCargue) {
		this.idCargue = idCargue;
	}

	public Date getFechaCargue() {
		return this.fechaCargue;
	}

	public void setFechaCargue(Date fechaCargue) {
		this.fechaCargue = fechaCargue;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleCargue> getDetalleCargues() {
		return this.detalleCargues;
	}

	public void setDetalleCargues(List<DetalleCargue> detalleCargues) {
		this.detalleCargues = detalleCargues;
	}

	public DetalleCargue addDetalleCargue(DetalleCargue detalleCargue) {
		getDetalleCargues().add(detalleCargue);
		detalleCargue.setCargueArchivo(this);

		return detalleCargue;
	}

	public DetalleCargue removeDetalleCargue(DetalleCargue detalleCargue) {
		getDetalleCargues().remove(detalleCargue);
		detalleCargue.setCargueArchivo(null);

		return detalleCargue;
	}

	public List<EstadoNotificacionCargue> getEstadoNotificacionCargues() {
		return this.estadoNotificacionCargues;
	}

	public void setEstadoNotificacionCargues(List<EstadoNotificacionCargue> estadoNotificacionCargues) {
		this.estadoNotificacionCargues = estadoNotificacionCargues;
	}

	public EstadoNotificacionCargue addEstadoNotificacionCargue(EstadoNotificacionCargue estadoNotificacionCargue) {
		getEstadoNotificacionCargues().add(estadoNotificacionCargue);
		estadoNotificacionCargue.setCargueArchivo(this);

		return estadoNotificacionCargue;
	}

	public EstadoNotificacionCargue removeEstadoNotificacionCargue(EstadoNotificacionCargue estadoNotificacionCargue) {
		getEstadoNotificacionCargues().remove(estadoNotificacionCargue);
		estadoNotificacionCargue.setCargueArchivo(null);

		return estadoNotificacionCargue;
	}

}