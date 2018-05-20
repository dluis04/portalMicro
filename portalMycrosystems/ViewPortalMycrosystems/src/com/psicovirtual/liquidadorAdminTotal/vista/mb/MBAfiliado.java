package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNAfiliado;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNSesionActiva;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;

@ManagedBean(name = "MBAfiliado")
@SessionScoped
public class MBAfiliado implements Serializable {

	MBMensajes mensajes = new MBMensajes();
	DNAfiliado dnAfiliado;
	Cliente afiliado;
	List<Cliente> listAfiliados;
	Cliente afiliadoSeleccionado;
	DNSesionActiva dNSesionActiva;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

	public MBAfiliado() {

		try {
			if (validarSession()) {
				afiliado = new Cliente();
				afiliadoSeleccionado = new Cliente();
				listarAfiliados();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Boolean validarSession() throws IOException {

		Boolean isSession = false;

		if (session.getAttribute("id") != null) {
			isSession = true;
		} else {

			ExternalContext extContext = context.getExternalContext();
			session.invalidate();

			String url2 = extContext.encodeActionURL(
					context.getApplication().getViewHandler().getActionURL(context, "/view/index.xhtml"));
			extContext.redirect(url2);
		}

		return isSession;
	}

	public void guardarAfiliado() throws Exception {
		if (dnAfiliado == null) {
			dnAfiliado = new DNAfiliado();
		}
		dnAfiliado.crearAfiliado(afiliado);

		mensajes.mostrarMensajeOk("Registro Exitoso.");

		listAfiliados = dnAfiliado.listaAfiliado();
	}

	public void modificarAfiliado() throws Exception {
		if (dnAfiliado == null) {
			dnAfiliado = new DNAfiliado();
		}

		// Afiliado afiliado = dnAfiliado.buscarAfiliado(afiliadoSeleccionado.getNit());
		// System.out.println("nom "+ afiliadoSeleccionado.getNombre());
		//
		// afiliado.setNombre(afiliadoSeleccionado.getNombre());
		//

		dnAfiliado.modificarAfiliado(afiliadoSeleccionado);

		mensajes.mostrarMensajeOk("Modificacion Exitosa.");

		listAfiliados = dnAfiliado.listaAfiliado();
	}

	public void listarAfiliados() throws Exception {

		if (dnAfiliado == null) {
			dnAfiliado = new DNAfiliado();
		}

		listAfiliados = dnAfiliado.listaAfiliado();
	}

	public void cargarModificar() {

		System.out.println("dato " + afiliadoSeleccionado.getNombre());

	}

	public void limpiar() {

		afiliado = new Cliente();

		afiliadoSeleccionado = new Cliente();
	}

	private void inicializarDelegados() throws Exception {

		if (dNSesionActiva == null) {
			dNSesionActiva = new DNSesionActiva();
		}
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public DNAfiliado getDnAfiliado() {
		return dnAfiliado;
	}

	public void setDnAfiliado(DNAfiliado dnAfiliado) {
		this.dnAfiliado = dnAfiliado;
	}

	public Cliente getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Cliente afiliado) {
		this.afiliado = afiliado;
	}

	public List<Cliente> getListAfiliados() {
		return listAfiliados;
	}

	public void setListAfiliados(List<Cliente> listAfiliados) {
		this.listAfiliados = listAfiliados;
	}

	public Cliente getAfiliadoSeleccionado() {
		return afiliadoSeleccionado;
	}

	public void setAfiliadoSeleccionado(Cliente afiliadoSeleccionado) {
		this.afiliadoSeleccionado = afiliadoSeleccionado;
	}

	public DNSesionActiva getdNSesionActiva() {
		return dNSesionActiva;
	}

	public void setdNSesionActiva(DNSesionActiva dNSesionActiva) {
		this.dNSesionActiva = dNSesionActiva;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	


}
