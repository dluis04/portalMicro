package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;
import com.psicovirtual.procesos.modelo.ejb.session.SBPaginaLocal;

@ManagedBean(value = "DNPagina")
@ApplicationScoped
public class DNPagina {

	SBPaginaLocal sBPaginaLocal;

	public DNPagina() throws Exception {
		sBPaginaLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBPagina" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPaginaLocal",
				SBPaginaLocal.class);
	}

	public Pagina crearPagina(Pagina nueva) throws Exception {
		return sBPaginaLocal.crearPagina(nueva);
	}

	public Pagina actualizarPagina(Pagina update) throws Exception {
		return sBPaginaLocal.actualizarPagina(update);
	}

	public List<Pagina> consultarPaginas() throws Exception {
		return sBPaginaLocal.consultarPaginas();
	}

	public Pagina consultarPaginasRuta(String pagina) throws Exception{
		return sBPaginaLocal.consultarPaginasRuta(pagina);
	}

}
