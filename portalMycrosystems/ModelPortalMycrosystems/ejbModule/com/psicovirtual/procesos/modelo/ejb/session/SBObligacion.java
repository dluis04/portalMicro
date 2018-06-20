package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Obligacion;

/**
 * Session Bean implementation class SBObligacion
 */
@Stateless
public class SBObligacion implements SBObligacionLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBObligacion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Obligacion registrarObligacion(Obligacion nueva) throws Exception {
		Obligacion entity = (Obligacion) sbFacade.insertEntity(nueva);
		return entity;
	}

	@Override
	public Obligacion consultarObligacionByNumeroTitu(String numeroTitular) throws Exception {
		String query = "SELECT u FROM Obligacion u where u.numeroTitular='" + numeroTitular + "'"
				+ " and u.estado='ACTIVO' ";

		List<Obligacion> listObligacion = sbFacade.executeQuery(query, null);
		Obligacion temp = null;
		for (Obligacion tempObligacion : listObligacion) {
			temp = tempObligacion;
		}

		return temp;
	}

	@Override
	public Obligacion consultarObligacionByClienteUsuario(ClienteUsuario clienteUsu) throws Exception {
		String query = "SELECT u FROM Obligacion u where u.clienteUsuario.idClienteUsuario='"
				+ clienteUsu.getIdClienteUsuario() + "'" + " and u.estado='ACTIVO' ";

		List<Obligacion> listObligacion = sbFacade.executeQuery(query, null);

		Obligacion temp = null;

		for (Obligacion tempObligacion : listObligacion) {
			temp = tempObligacion;
		}

		return temp;
	}

}