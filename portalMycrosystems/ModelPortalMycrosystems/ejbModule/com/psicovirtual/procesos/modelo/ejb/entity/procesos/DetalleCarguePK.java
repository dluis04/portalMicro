package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_cargue database table.
 * 
 */
@Embeddable
public class DetalleCarguePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_CARGUE", insertable=false, updatable=false)
	private int idCargue;

	@Column(name="NUMERO_TITULO_VALOR")
	private String numeroTituloValor;

	private int cuota;

	private int cedula;

	public DetalleCarguePK() {
	}
	public int getIdCargue() {
		return this.idCargue;
	}
	public void setIdCargue(int idCargue) {
		this.idCargue = idCargue;
	}
	public String getNumeroTituloValor() {
		return this.numeroTituloValor;
	}
	public void setNumeroTituloValor(String numeroTituloValor) {
		this.numeroTituloValor = numeroTituloValor;
	}
	public int getCuota() {
		return this.cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public int getCedula() {
		return this.cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleCarguePK)) {
			return false;
		}
		DetalleCarguePK castOther = (DetalleCarguePK)other;
		return 
			(this.idCargue == castOther.idCargue)
			&& this.numeroTituloValor.equals(castOther.numeroTituloValor)
			&& (this.cuota == castOther.cuota)
			&& (this.cedula == castOther.cedula);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCargue;
		hash = hash * prime + this.numeroTituloValor.hashCode();
		hash = hash * prime + this.cuota;
		hash = hash * prime + this.cedula;
		
		return hash;
	}
}