package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paginas database table.
 * 
 */
@Entity
@Table(name="paginas")
@NamedQuery(name="Pagina.findAll", query="SELECT p FROM Pagina p")
public class Pagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PAGINA")
	private int idPagina;

	private int activa;

	private String descripcion;

	private String pagina;

	//bi-directional many-to-one association to AccionesPagina
	@OneToMany(mappedBy="pagina")
	private List<AccionesPagina> accionesPaginas;

	public Pagina() {
	}

	public int getIdPagina() {
		return this.idPagina;
	}

	public void setIdPagina(int idPagina) {
		this.idPagina = idPagina;
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

	public String getPagina() {
		return this.pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public List<AccionesPagina> getAccionesPaginas() {
		return this.accionesPaginas;
	}

	public void setAccionesPaginas(List<AccionesPagina> accionesPaginas) {
		this.accionesPaginas = accionesPaginas;
	}

	public AccionesPagina addAccionesPagina(AccionesPagina accionesPagina) {
		getAccionesPaginas().add(accionesPagina);
		accionesPagina.setPagina(this);

		return accionesPagina;
	}

	public AccionesPagina removeAccionesPagina(AccionesPagina accionesPagina) {
		getAccionesPaginas().remove(accionesPagina);
		accionesPagina.setPagina(null);

		return accionesPagina;
	}

}