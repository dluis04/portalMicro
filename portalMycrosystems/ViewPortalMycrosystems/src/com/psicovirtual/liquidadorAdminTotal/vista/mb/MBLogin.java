package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNSesionActiva;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.SesionesActiva;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBLogin")
@SessionScoped
public class MBLogin implements Serializable{

	MBMensajes mensajes = new MBMensajes();
	DNUsuario dnUsuarios;
	DNSesionActiva dNSesionActiva;

	private Usuario usuario;
	private SesionesActiva sesion;

	public MBLogin() {
		usuario = new Usuario();
		sesion = new SesionesActiva();
	}

	public void navegarControl() {

		try {

			inicializarDelegados();

			if (dnUsuarios.consultarUsuarioInicio(usuario) == 1) {

				System.out.println("Hola Papi hermoso!! ;)");
				Usuario logueado= dnUsuarios.consultarDetalleUsuario(usuario.getCedula());
				Date fecha = new Date();
				sesion.setUsuario(logueado);
				sesion.setFechaIngreso(fecha);
				sesion.setFechaUltimaAct(fecha);

				dNSesionActiva.registroSesionActiva(sesion);
				
				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext extContext = context.getExternalContext();
				
				HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
				session.setAttribute("id", usuario.getCedula());
				
				String url2 = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,
						"/view/gestion/bienvenido.xhtml"));
				extContext.redirect(url2);
			}else {
				mensajes.mostrarMensajeAlerta("Identificacion o correo invalidos");
			
			}

		} catch (Exception exception) {
			// TODO: Add catch code
			exception.printStackTrace();
		}
	}

	public void cerrarSesion() {

		try {
			inicializarDelegados();
			if (dNSesionActiva.cerrarSesionActivaByUsuario(usuario) == 0) {

				
				FacesContext context = FacesContext.getCurrentInstance();

				ExternalContext externalContext = context.getExternalContext();

				Object session = externalContext.getSession(false);

				HttpSession httpSession = (HttpSession) session;

				httpSession.invalidate();

				String url2 = externalContext.encodeActionURL(
						context.getApplication().getViewHandler().getActionURL(context, "/view/index.xhtml"));
				externalContext.redirect(url2);
			}
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
		}

	}

	public void tabIsClosed() {

		System.out.println("Cerrando sesion por browser");

		FacesContext context = FacesContext.getCurrentInstance();

		ExternalContext externalContext = context.getExternalContext();

		Object session = externalContext.getSession(false);

		HttpSession httpSession = (HttpSession) session;

		httpSession.invalidate();
	}

	private void inicializarDelegados() throws Exception {
		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuario();
		}

		if (dNSesionActiva == null) {
			dNSesionActiva = new DNSesionActiva();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public SesionesActiva getSesion() {
		return sesion;
	}

	public void setSesion(SesionesActiva sesion) {
		this.sesion = sesion;
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

}
