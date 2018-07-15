package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNPagina;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBPagina")
@SessionScoped
public class MBPagina implements Serializable {

	MBMensajes mensajes = new MBMensajes();
	DNUsuario dnUsuarios;
	DNPagina dnPagina;
	private Pagina pagina;
	private Pagina paginaSeleccionada;
	private Usuario usuario;
	private List<Pagina> listPaginas;

	public MBPagina() throws Exception {
		usuario = new Usuario();
		pagina = new Pagina();
		paginaSeleccionada = new Pagina();
		consultarPaginas();
	}

	public void registrarPagina() throws Exception {
		
		inicializarDelegados();

		if (pagina.getPagina().equals("") || pagina.getDescripcion().equals("")) {
			mensajes.mostrarMensaje("Ingrese los datos solicitados para el registro de la pagina", 3);
		} else {
			pagina.setActiva(1); // valor 1 = activo, valor 0 = desactivado
			if (dnPagina.crearPagina(pagina) != null) {
				mensajes.mostrarMensaje("Pagina Registrada correctamente", 1);
				pagina = null;
				listPaginas = dnPagina.consultarPaginas();
			} else {
				mensajes.mostrarMensaje("La pagina no se pudo crear, verifique con el administrador", 3);
			}
		}
	}

	public void consultarPaginas() throws Exception {
		inicializarDelegados();
		listPaginas = dnPagina.consultarPaginas();
	}

	public void modificarPagina() throws Exception {
		inicializarDelegados();
		try {
			if (paginaSeleccionada.getIdPagina() != 0) {

				if (paginaSeleccionada.getPagina().equals("") || paginaSeleccionada.getDescripcion().equals("")) {
					mensajes.mostrarMensaje("Para la modificacion no debe dejar campos vacios", 3);
					limpiar();
					listPaginas = dnPagina.consultarPaginas();
				} else {

					if (dnPagina.actualizarPagina(paginaSeleccionada) != null) {
						mensajes.mostrarMensaje("Pagina fue modificada correctamente", 1);
						listPaginas = dnPagina.consultarPaginas();
					} else {
						mensajes.mostrarMensaje("La pagina no se pudo modificar, verifique con el administrador", 2);
					}
				}
			}
		} catch (Exception e) {
			mensajes.mostrarMensaje("Debe seleccionar una opcion de pagina a modificar", 3);
		}

	}

	public void limpiar() {
		pagina = null;
		pagina = new Pagina();

		paginaSeleccionada = null;
		paginaSeleccionada = new Pagina();

	}

	private void inicializarDelegados() throws Exception {
		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuario();
		}

		if (dnPagina == null) {
			dnPagina = new DNPagina();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Pagina getPaginaSeleccionada() {
		if (paginaSeleccionada == null) {
			paginaSeleccionada = new Pagina();
		}
		return paginaSeleccionada;
	}

	public void setPaginaSeleccionada(Pagina paginaSeleccionada) {
		this.paginaSeleccionada = paginaSeleccionada;
	}

	public List<Pagina> getListPaginas() {
		return listPaginas;
	}

	public void setListPaginas(List<Pagina> listPaginas) {
		this.listPaginas = listPaginas;
	}

}
