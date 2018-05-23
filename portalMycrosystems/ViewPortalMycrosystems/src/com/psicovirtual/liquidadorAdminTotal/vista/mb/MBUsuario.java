package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.estandar.vista.utilidades.TokenSeguridad;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNSesionActiva;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.SesionesActiva;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Token;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBUsuario")
@SessionScoped
public class MBUsuario implements Serializable {

	MBMensajes mensajes = new MBMensajes();
	DNUsuario dnUsuarios;
	DNSesionActiva dNSesionActiva;
	private Usuario usuario;
	private SesionesActiva sesion;
	private TokenSeguridad tokenSeguridad;
	private Token token;

	public MBUsuario() {
		usuario = new Usuario();
		sesion = new SesionesActiva();
		tokenSeguridad = new TokenSeguridad();
		token = new Token();
	}

	public void generarUsuarios() {
		try {
			inicializarDelegados();

			token.setToken(tokenSeguridad.generarToken());
			token.setActivo(1);

			System.out.println("Token generado :D -->> " + tokenSeguridad.generarToken());
		} catch (Exception e) {
			System.out.println("Error en el metodo generarUsuario -->> " + e);
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

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
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
