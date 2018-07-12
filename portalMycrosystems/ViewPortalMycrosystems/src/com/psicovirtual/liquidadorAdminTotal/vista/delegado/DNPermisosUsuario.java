package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.PermisosUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;
import com.psicovirtual.procesos.modelo.ejb.session.SBPermisosUsuarioLocal;

@ManagedBean(value = "DNPermisosUsuario")
@ApplicationScoped
public class DNPermisosUsuario {

	SBPermisosUsuarioLocal sBPermisosUsuarioLocal;

	public DNPermisosUsuario() throws Exception {
		sBPermisosUsuarioLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBPermisosUsuario" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPermisosUsuarioLocal",
				SBPermisosUsuarioLocal.class);
	}

	public PermisosUsuario crearPermiso(PermisosUsuario nuevo) throws Exception {
		return sBPermisosUsuarioLocal.crearPermiso(nuevo);
	}

	public PermisosUsuario actualizarPermiso(PermisosUsuario update) throws Exception {
		return sBPermisosUsuarioLocal.actualizarPermiso(update);
	}

	public PermisosUsuario consultarPermisosByUsuarioAccion(Usuario usuario, AccionesPagina accion) throws Exception {
		return sBPermisosUsuarioLocal.consultarPermisosByUsuarioAccion(usuario, accion);
	}

}
