package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;
import com.psicovirtual.procesos.modelo.ejb.session.SBAccionesPaginaLocal;

@ManagedBean(value = "DNAccionPagina")
@ApplicationScoped
public class DNAccionPagina {

	SBAccionesPaginaLocal sBAccionesPaginaLocal;

	public DNAccionPagina() throws Exception {
		sBAccionesPaginaLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBAccionesPagina" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBAccionesPaginaLocal",
				SBAccionesPaginaLocal.class);
	}

	public AccionesPagina crearAccionPagina(AccionesPagina nuevo) throws Exception {
		return sBAccionesPaginaLocal.crearAccionPagina(nuevo);
	}

	public AccionesPagina actualizarAccionPagina(AccionesPagina update) throws Exception {
		return sBAccionesPaginaLocal.actualizarAccionPagina(update);
	}

	public List<AccionesPagina> consultarAccionesPagina(Pagina pagina) throws Exception {
		return sBAccionesPaginaLocal.consultarAccionesPagina(pagina);
	}

	public List<AccionesPagina> consultarTodasAccionesPaginas() throws Exception {
		return sBAccionesPaginaLocal.consultarTodasAccionesPaginas();
	}
}
