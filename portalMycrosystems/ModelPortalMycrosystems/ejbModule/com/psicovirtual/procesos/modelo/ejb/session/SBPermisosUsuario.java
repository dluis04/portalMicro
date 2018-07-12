package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.PermisosUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBPermisosUsuario
 */
@Stateless
@LocalBean
public class SBPermisosUsuario implements SBPermisosUsuarioLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPermisosUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PermisosUsuario crearPermiso(PermisosUsuario nuevo) throws Exception {
		PermisosUsuario entity = (PermisosUsuario) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public PermisosUsuario actualizarPermiso(PermisosUsuario update) throws Exception {
		PermisosUsuario entity = (PermisosUsuario) sbFacade.updateEntity(update);
		return entity;
	}

	@Override
	public PermisosUsuario consultarPermisosByUsuarioAccion(Usuario usuario, AccionesPagina accion) throws Exception {
		String query = "SELECT u FROM PermisosUsuario u where u.usuario.idUsuario='" + usuario.getIdUsuario()
				+ "' and  u.accionesPagina.idAccion='" + accion.getIdAccion() + "' and u.activo='1' ";

		List<PermisosUsuario> listAccion = sbFacade.executeQuery(query, null);
		PermisosUsuario temp = null;

		for (int i = 0; i < listAccion.size(); i++) {
			temp = listAccion.get(i);
		}
		return temp;
	}

}
