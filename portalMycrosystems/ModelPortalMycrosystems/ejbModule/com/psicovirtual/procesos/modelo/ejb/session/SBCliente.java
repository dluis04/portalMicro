package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;

/**
 * Session Bean implementation class SBCliente
 */
@Stateless
public class SBCliente implements SBClienteLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBCliente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente crearCliente(Cliente nuevo) throws Exception {
		Cliente entity = (Cliente) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public Cliente actualizarClienet(Cliente update) throws Exception {
		Cliente x = (Cliente) sbFacade.updateEntity(update);
		return x;
	}

	@Override
	public Cliente consultarCliente(int id) throws Exception {
		String query = "SELECT u FROM Cliente u where u.nit='" + id + "' ";

		List<Cliente> listCliente = sbFacade.executeQuery(query, null);
		Cliente temp = new Cliente();

		for (Cliente list : listCliente) {
			temp = list;
		}
		return temp;
	}

	@Override
	public List<Cliente> consultarClientes() throws Exception {
		String query = "SELECT u FROM Cliente u ";

		List<Cliente> listCliente = sbFacade.executeQuery(query, null);

		return listCliente;
	}

}
