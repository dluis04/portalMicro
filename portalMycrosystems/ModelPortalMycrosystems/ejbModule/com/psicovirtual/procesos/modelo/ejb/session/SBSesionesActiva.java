package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.SesionesActiva;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBSesionesActiva
 */
@Stateless
@LocalBean
public class SBSesionesActiva implements SBSesionesActivaLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBSesionesActiva() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SesionesActiva registroSesionActiva(SesionesActiva sesion) throws Exception {
		sesion.setActivo(1);
		SesionesActiva entity = (SesionesActiva) sbFacade.insertEntity(sesion);
		return entity;
	}

	@Override
	public SesionesActiva consultarSesionActivaByUsuario(Usuario usuario) throws Exception {

		String query = "SELECT u FROM SesionesActiva u where u.usuario.cedula='" + usuario.getCedula() + "' "
				+ "and u.activo='1' ";

		SesionesActiva temp = null;

		List<SesionesActiva> listSesion = sbFacade.executeQuery(query, null);

		for (SesionesActiva list : listSesion) {
			temp = list;
		}

		return temp;
	}

	@Override
	public int cerrarSesionActivaByUsuario(Usuario usuario) throws Exception {

		SesionesActiva sesionTemp = consultarSesionActivaByUsuario(usuario);
		sesionTemp.setActivo(0);
		SesionesActiva x = (SesionesActiva) sbFacade.updateEntity(sesionTemp);
		return x.getActivo();
	}

}
