package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBAccionesPagina
 */
@Stateless
@LocalBean
public class SBAccionesPagina implements SBAccionesPaginaLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBAccionesPagina() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AccionesPagina crearAccionPagina(AccionesPagina nuevo) throws Exception {
		AccionesPagina entity = (AccionesPagina) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public AccionesPagina actualizarAccionPagina(AccionesPagina update) throws Exception {
		AccionesPagina entity = (AccionesPagina) sbFacade.updateEntity(update);
		return entity;
	}

	@Override
	public List<AccionesPagina> consultarAccionesPagina(Pagina pagina) throws Exception {
		String query = "SELECT u FROM AccionesPagina u where u.pagina.idPagina='" + pagina.getIdPagina()
				+ "' and u.activa='1' ";

		List<AccionesPagina> listAcciones = sbFacade.executeQuery(query, null);

		return listAcciones;
	}

}
