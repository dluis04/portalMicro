package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;

/**
 * Session Bean implementation class SBAfiliado
 */
@Stateless
@LocalBean
public class SBAfiliado implements SBAfiliadoLocal {

    /**
     * Default constructor. 
     */
	
	
	@EJB
	SBFacadeProcesosLocal sbFacade;
    public SBAfiliado() {
        // TODO Auto-generated constructor stub
    }
    
    
    
	@Override
	public Cliente crearAfiliado(Cliente param) throws Exception {
		Cliente entity = (Cliente) sbFacade.insertEntity(param);
		return entity;
	}

	
	
	
	@Override
	public Cliente buscarAfiliado(Object param) throws Exception {

		Cliente entity = (Cliente) sbFacade.findByPrimaryKey(
				Cliente.class, param);
		return entity;
	}
	
	
	
	
	
	
	
	@Override
	public Cliente modificarAfiliado(Cliente param) throws Exception {
		Cliente entity = (Cliente) sbFacade.updateEntity(param);
		return entity;
	}
	
	
	@Override
	public List<Cliente> listaAfiliado() throws Exception {
		String query = "select o from Cliente o ";
		List<Cliente> lista = sbFacade.executeQuery(query, null);
		return lista;

	}
	
	

}
