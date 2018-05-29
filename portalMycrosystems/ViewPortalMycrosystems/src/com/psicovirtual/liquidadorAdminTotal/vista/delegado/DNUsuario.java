package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;
import com.psicovirtual.procesos.modelo.ejb.session.SBUsuarioLocal;

@ManagedBean(value = "DNUsuarios")
@ApplicationScoped
public class DNUsuario {

	SBUsuarioLocal sBUsuarioLocal;

	public DNUsuario() throws Exception {
		sBUsuarioLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBUsuario" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBUsuarioLocal",
				SBUsuarioLocal.class);
	}

	public Usuario crearUsuario(Usuario nuevo) throws Exception {
		return sBUsuarioLocal.crearUsuario(nuevo);
	}

	public Usuario actualizarUsuario(Usuario update) throws Exception {
		return sBUsuarioLocal.actualizarUsuario(update);
	}

	public Usuario consultarDetalleUsuario(int id) throws Exception {
		return sBUsuarioLocal.consultarDetalleUsuario(id);
	}

	public int consultarUsuarioInicio(Usuario user) throws Exception {
		return sBUsuarioLocal.consultarUsuarioInicio(user);
	}

	public boolean enviarTokenRecuperacionPass(Usuario user) throws Exception {
		return sBUsuarioLocal.enviarCorreoTokenRecuperacion(user);
	}

}
