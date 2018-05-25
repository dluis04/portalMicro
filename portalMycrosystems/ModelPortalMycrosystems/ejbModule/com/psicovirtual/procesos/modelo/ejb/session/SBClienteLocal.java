package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;
import javax.ejb.Local;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;

@Local
public interface SBClienteLocal {

	public Cliente crearCliente(Cliente nuevo) throws Exception;

	public Cliente actualizarClienet(Cliente update) throws Exception;

	public Cliente consultarCliente(int id) throws Exception;

	public List<Cliente> consultarClientes() throws Exception;

}
