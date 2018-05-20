package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.session.SBAfiliadoLocal;


@ManagedBean(value = "DNUsuarios")
@ApplicationScoped
public class DNAfiliado {

	SBAfiliadoLocal sBAfiliadoLocal;

	public DNAfiliado() throws Exception {
		sBAfiliadoLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBAfiliado" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBAfiliadoLocal",
				SBAfiliadoLocal.class);
	}

	
	
	

	public Cliente crearAfiliado(Cliente param) throws Exception {
		return sBAfiliadoLocal.crearAfiliado(param);
	}





	public Cliente buscarAfiliado(Object param) throws Exception {
		return sBAfiliadoLocal.buscarAfiliado(param);
	}





	public Cliente modificarAfiliado(Cliente param) throws Exception {
		return sBAfiliadoLocal.modificarAfiliado(param);
	}





	public List<Cliente> listaAfiliado() throws Exception {
		return sBAfiliadoLocal.listaAfiliado();
	}

	

	
	
}
