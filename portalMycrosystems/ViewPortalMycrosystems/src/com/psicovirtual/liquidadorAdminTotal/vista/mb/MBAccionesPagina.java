package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNAccionPagina;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNPagina;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBAccionesPagina")
@SessionScoped
public class MBAccionesPagina implements Serializable {

	MBMensajes mensajes = new MBMensajes();

	DNUsuario dnUsuarios;
	DNPagina dnPagina;
	DNAccionPagina dNAccionPagina;

	private AccionesPagina accionesPagina;

	private AccionesPagina accionesPaginaSeleccionada;
	private Pagina paginaSeleccionada;
	private Pagina paginaSeleccionadaModificar;
	private Usuario usuario;
	private List<Pagina> listPaginas;
	private List<AccionesPagina> listAccionesPaginas;

	public MBAccionesPagina() throws Exception {
		usuario = new Usuario();
		accionesPagina = new AccionesPagina();
		paginaSeleccionadaModificar = new Pagina();
		accionesPaginaSeleccionada = new AccionesPagina();
		paginaSeleccionada = new Pagina();
		inicializarDelegados();
		consultarPaginas();
		consultarAccionesPaginas();
	}

	public void registrarAccionesPagina() throws Exception {
		inicializarDelegados();

		if (accionesPagina.getAccion().equals("") || accionesPagina.getDescripcion().equals("")) {
			mensajes.mostrarMensaje("Debe ingresar los datos solicitados para el registro de la acción pagina.", 3);
		} else {

			if (accionesPagina != null) {
				try {

					if (paginaSeleccionada.getIdPagina() != 0) {

						accionesPagina.setActiva(1); // valor 1 = activo, valor 0 = desactivado
						accionesPagina.setPagina(paginaSeleccionada);

						if (dNAccionPagina.crearAccionPagina(accionesPagina) != null) {
							mensajes.mostrarMensaje("Acción Registrada correctamente", 1);
							accionesPagina = null;
							paginaSeleccionada = null;
							paginaSeleccionada = new Pagina();

							consultarAccionesPaginas();
						} else {
							mensajes.mostrarMensaje("La acción no se pudo crear, verifique con el administrador", 2);
						}
					}
				} catch (Exception e) {
					mensajes.mostrarMensaje("Debe seleccionar una pagina para relacionar la acción", 3);
				}
			}
		}

	}

	public void consultarPaginas() throws Exception {
		listPaginas = dnPagina.consultarPaginas();
	}

	public void consultarAccionesPaginas() throws Exception {
		listAccionesPaginas = dNAccionPagina.consultarTodasAccionesPaginas();
	}

	public void modificarAccionPagina() throws Exception {
		inicializarDelegados();
		try {
			if (accionesPaginaSeleccionada.getIdAccion() != 0) {

				if (accionesPaginaSeleccionada.getAccion().equals("")
						|| accionesPaginaSeleccionada.getDescripcion().equals("")) {
					mensajes.mostrarMensaje(
							"Debe ingresar los datos solicitados para la modificacion de la acción pagina.", 3);

					limpiar();
					consultarAccionesPaginas();

				} else {

					if (dNAccionPagina.actualizarAccionPagina(accionesPaginaSeleccionada) != null) {
						mensajes.mostrarMensaje("Accion fue modificada correctamente", 1);
						consultarAccionesPaginas();
					} else {
						mensajes.mostrarMensaje("La acción no se pudo modificar, verifique con el administrador", 2);
					}
				}

			}
		} catch (Exception e) {
			mensajes.mostrarMensaje("Debe seleccionar la acción pagina para realiazar la modificación", 3);
		}

	}

	public void limpiar() {

		accionesPagina = null;
		accionesPagina = new AccionesPagina();

		paginaSeleccionada = null;
		paginaSeleccionada = new Pagina();

		accionesPaginaSeleccionada = null;
		accionesPaginaSeleccionada = new AccionesPagina();
	}
	private void inicializarDelegados() throws Exception {
		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuario();
		}

		if (dnPagina == null) {
			dnPagina = new DNPagina();
		}

		if (dNAccionPagina == null) {
			dNAccionPagina = new DNAccionPagina();
		}
	}


	public Pagina getPaginaSeleccionadaModificar() {

		if (paginaSeleccionadaModificar == null) {
			paginaSeleccionadaModificar = new Pagina();
		}

		return paginaSeleccionadaModificar;
	}

	public void setPaginaSeleccionadaModificar(Pagina paginaSeleccionadaModificar) {
		this.paginaSeleccionadaModificar = paginaSeleccionadaModificar;
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

	public AccionesPagina getAccionesPagina() {
		return accionesPagina;
	}

	public void setAccionesPagina(AccionesPagina accionesPagina) {
		this.accionesPagina = accionesPagina;
	}

	public AccionesPagina getAccionesPaginaSeleccionada() {

		if (accionesPaginaSeleccionada == null) {
			accionesPaginaSeleccionada = new AccionesPagina();
		}
		return accionesPaginaSeleccionada;
	}

	public void setAccionesPaginaSeleccionada(AccionesPagina accionesPaginaSeleccionada) {
		this.accionesPaginaSeleccionada = accionesPaginaSeleccionada;
	}

	public List<AccionesPagina> getListAccionesPaginas() {
		return listAccionesPaginas;
	}

	public void setListAccionesPaginas(List<AccionesPagina> listAccionesPaginas) {
		this.listAccionesPaginas = listAccionesPaginas;
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
