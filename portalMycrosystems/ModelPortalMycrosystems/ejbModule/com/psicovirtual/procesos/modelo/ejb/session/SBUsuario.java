package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBUsuario
 */
@Stateless
@LocalBean
public class SBUsuario implements SBUsuarioLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario crearUsuario(Usuario nuevo) throws Exception {
		Usuario entity = (Usuario) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public int consultarUsuarioInicio(Usuario user) throws Exception {

		int retorna = 0;

		String query = "SELECT u.cedula FROM Usuario u where u.cedula='" + user.getCedula() + "' "
				+ "and u.contrasena='" + user.getContrasena() + "' ";

		List listUsuario = sbFacade.executeQuery(query, null);
		retorna = listUsuario.size();

		if (retorna > 0) {
			return retorna;
		}
		return retorna;
	}


	@Override
	public Usuario actualizarUsuario(Usuario update) throws Exception {
		Usuario x = (Usuario) sbFacade.updateEntity(update);
		return x;
	}

	@Override
	public Usuario consultarDetalleUsuario(int id) throws Exception {
		String query = "SELECT u FROM Usuario u where u.cedula='" + id + "' ";

		List<Usuario> listUsuario = sbFacade.executeQuery(query, null);
		Usuario temp = new Usuario();

		for (int i = 0; i < listUsuario.size(); i++) {
			temp = listUsuario.get(i);
		}
		return temp;
	}



}
