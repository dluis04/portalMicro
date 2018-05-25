package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBClienteUsuarioLocal {

	public ClienteUsuario crearClienteUsuario(ClienteUsuario nuevo) throws Exception;

	public ClienteUsuario actualizarClieneUsuario(ClienteUsuario update) throws Exception;

	public List<ClienteUsuario> consultarClienteUsuario(Usuario usuario) throws Exception;

	public List<ClienteUsuario> consultarUsuariosByCliente(Cliente cliente) throws Exception;

}
