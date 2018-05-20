package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.SesionesActiva;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;
import com.psicovirtual.procesos.modelo.ejb.session.SBSesionesActivaLocal;

@ManagedBean(value = "DNSesionActiva")
@ApplicationScoped
public class DNSesionActiva {

	SBSesionesActivaLocal sBSesionesActivaLocal;

	public DNSesionActiva() throws Exception {
		sBSesionesActivaLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBSesionesActiva" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBSesionesActivaLocal",
				SBSesionesActivaLocal.class);
	}

	public SesionesActiva registroSesionActiva(SesionesActiva sesion) throws Exception {
		return sBSesionesActivaLocal.registroSesionActiva(sesion);
	}

	public SesionesActiva consultarSesionActivaByUsuario(Usuario usuario) throws Exception {
		return sBSesionesActivaLocal.consultarSesionActivaByUsuario(usuario);
	}

	public int cerrarSesionActivaByUsuario(Usuario usuario) throws Exception {
		return sBSesionesActivaLocal.cerrarSesionActivaByUsuario(usuario);
	}

}
