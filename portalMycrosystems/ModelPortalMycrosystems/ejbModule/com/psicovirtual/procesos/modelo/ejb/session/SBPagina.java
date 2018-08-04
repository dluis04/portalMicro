package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;

/**
 * Session Bean implementation class SBPagina
 */
@Stateless
@LocalBean
public class SBPagina implements SBPaginaLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPagina() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pagina crearPagina(Pagina nueva) throws Exception {
		Pagina entity = (Pagina) sbFacade.insertEntity(nueva);
		return entity;
	}

	@Override
	public Pagina actualizarPagina(Pagina update) throws Exception {
		Pagina x = (Pagina) sbFacade.updateEntity(update);
		return x;
	}

	@Override
	public List<Pagina> consultarPaginas() throws Exception {
		String query = "SELECT u FROM Pagina u ";

		List<Pagina> listPagina = sbFacade.executeQuery(query, null);
		return listPagina;
	}

	@Override
	public Pagina consultarPaginasRuta(String pagina) throws Exception {
		String query = "SELECT u FROM Pagina u where u.pagina='" + pagina + "' ";

		List<Pagina> listPagina = sbFacade.executeQuery(query, null);
		Pagina temp = null;

		for (int i = 0; i < listPagina.size(); i++) {
			temp = listPagina.get(i);
		}

		return temp;
	}

}
