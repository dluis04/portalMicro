package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBClienteUsuario
 */
@Stateless
public class SBClienteUsuario implements SBClienteUsuarioLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBClienteUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClienteUsuario crearClienteUsuario(ClienteUsuario nuevo) throws Exception {
		ClienteUsuario entity = (ClienteUsuario) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public ClienteUsuario actualizarClieneUsuario(ClienteUsuario update) throws Exception {
		ClienteUsuario x = (ClienteUsuario) sbFacade.updateEntity(update);
		return x;
	}

	@Override
	public ClienteUsuario consultarClienteUsuarioEmpresa(Usuario usuario, Cliente cliente) throws Exception {
		String query = "SELECT u FROM ClienteUsuario u where u.usuario.cedula='" + usuario.getCedula() + "'"
				+ " and u.estado='ACTIVO' and u.cliente.nit='" + cliente.getNit() + "' ";

		List<ClienteUsuario> listClienteUsuario = sbFacade.executeQuery(query, null);
		ClienteUsuario temp = null;
		for (ClienteUsuario tempClienteUsu : listClienteUsuario) {
			temp = tempClienteUsu;
		}

		return temp;
	}

	@Override
	public List<ClienteUsuario> consultarUsuariosByCliente(Cliente cliente) throws Exception {
		String query = "SELECT u FROM ClienteUsuario u where u.cliente.nit='" + cliente.getNit() + "' ";

		List<ClienteUsuario> listClienteUsuario = sbFacade.executeQuery(query, null);

		return listClienteUsuario;
	}

}
