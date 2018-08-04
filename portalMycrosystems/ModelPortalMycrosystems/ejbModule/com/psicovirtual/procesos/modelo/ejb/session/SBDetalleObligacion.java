package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleObligacion;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Obligacion;

/**
 * Session Bean implementation class SBDetalleObligacion
 */
@Stateless
public class SBDetalleObligacion implements SBDetalleObligacionLocal {

	/**
	 * Default constructor.
	 */
	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBDetalleObligacion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DetalleObligacion registrarDetalleObligacion(DetalleObligacion nuevo) throws Exception {
		DetalleObligacion entity = (DetalleObligacion) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public List<DetalleObligacion> consultarDetalleObliacionByObli(Obligacion obligacion) throws Exception {
		String query = "SELECT u FROM DetalleObligacion u where u.obligacion.idObligacion='"
				+ obligacion.getIdObligacion() + "'" + " and u.estado='ACTIVO' ";

		List<DetalleObligacion> listDetalleObligacion = sbFacade.executeQuery(query, null);

		return listDetalleObligacion;
	}

}
