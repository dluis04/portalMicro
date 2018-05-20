package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBAfiliadoLocal {

	
	public Cliente crearAfiliado(Cliente param) throws Exception;
	
	
	public List<Cliente> listaAfiliado() throws Exception ;

	public Cliente modificarAfiliado(Cliente param) throws Exception;
	public Cliente buscarAfiliado(Object param) throws Exception;
	
	
}
