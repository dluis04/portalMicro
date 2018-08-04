package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNAccionPagina;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNPermisosUsuario;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.PermisosUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBPermisosUsuario")
@SessionScoped
public class MBPermisosUsuario implements Serializable {

	MBMensajes mensajes = new MBMensajes();
	DNUsuario dnUsuarios;
	DNAccionPagina dNAccionPagina;
	DNPermisosUsuario dNPermisosUsuario;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

	private List<Usuario> listUsuario;
	private List<AccionesPagina> listAccionPagina;
	private Usuario usuarioSeleccionado;
	private AccionesPagina accionSeleccionada;
	private PermisosUsuario nuevo;
	private PermisosUsuario permisoModificar;

	public MBPermisosUsuario() throws Exception {
		inicializarDelegados();
		listUsuario = dnUsuarios.consultarAllUsuariosActivos();
		listAccionPagina = dNAccionPagina.consultarTodasAccionesPaginas();
		usuarioSeleccionado = new Usuario();
		accionSeleccionada = new AccionesPagina();
	}

	public void registrarPermisoUsuario() throws Exception {
		inicializarDelegados();

		if (usuarioSeleccionado.getIdUsuario() != 0 && accionSeleccionada.getIdAccion() != 0) {
			Date fecha = new Date();
			nuevo.setFechaAsignacion(fecha);
			nuevo.setActivo(1);
			nuevo.setUsuAsignacion(Integer.parseInt((String) session.getAttribute("id")));
			nuevo.setUsuario(usuarioSeleccionado);
			nuevo.setAccionesPagina(accionSeleccionada);

			dNPermisosUsuario.crearPermiso(nuevo);
		} else {
			mensajes.mostrarMensaje("Debe seleccionar un usuario y la acciòn a realizar", 1);
		}
	}

	public void modificarPermisoUsuario() throws Exception {
		inicializarDelegados();

		if (usuarioSeleccionado.getIdUsuario() != 0 && accionSeleccionada.getIdAccion() != 0) {
			Date fecha = new Date();
			permisoModificar.setFechaAsignacion(fecha);
			permisoModificar.setActivo(1);
			permisoModificar.setUsuAsignacion(Integer.parseInt((String) session.getAttribute("id")));
			permisoModificar.setUsuario(usuarioSeleccionado);
			permisoModificar.setAccionesPagina(accionSeleccionada);

			dNPermisosUsuario.actualizarPermiso(permisoModificar);
		} else {
			mensajes.mostrarMensaje("Debe seleccionar un usuario y la acción a realizar para hacer la modificación", 1);
		}
	}

	private void inicializarDelegados() throws Exception {
		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuario();
		}

		if (dNAccionPagina == null) {
			dNAccionPagina = new DNAccionPagina();
		}

		if (dNPermisosUsuario == null) {
			dNPermisosUsuario = new DNPermisosUsuario();
		}
	}

	public PermisosUsuario getPermisoModificar() {
		return permisoModificar;
	}

	public void setPermisoModificar(PermisosUsuario permisoModificar) {
		this.permisoModificar = permisoModificar;
	}

	public PermisosUsuario getNuevo() {
		return nuevo;
	}

	public void setNuevo(PermisosUsuario nuevo) {
		this.nuevo = nuevo;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public AccionesPagina getAccionSeleccionada() {
		return accionSeleccionada;
	}

	public void setAccionSeleccionada(AccionesPagina accionSeleccionada) {
		this.accionSeleccionada = accionSeleccionada;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public List<AccionesPagina> getListAccionPagina() {
		return listAccionPagina;
	}

	public void setListAccionPagina(List<AccionesPagina> listAccionPagina) {
		this.listAccionPagina = listAccionPagina;
	}

}
