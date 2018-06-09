package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Obligacion;

/**
 * Session Bean implementation class SBObligacion
 */
@Stateless
public class SBObligacion implements SBObligacionLocal {

    /**
     * Default constructor.
     */

    @EJB
    SBFacadeProcesosLocal sbFacade;

    public SBObligacion() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Obligacion registrarObligacion(Obligacion nueva) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public Obligacion consultarObligacionByNumeroTitu(String numeroTitular) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Obligacion> consultarObligacionByClienteUsuario(ClienteUsuario clienteUsu) throws Exception {
		// TODO Auto-generated method stub
return null;
	}

}
