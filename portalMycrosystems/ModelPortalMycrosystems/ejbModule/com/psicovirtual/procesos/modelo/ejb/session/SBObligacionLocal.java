package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Obligacion;

@Local
public interface SBObligacionLocal {

    public Obligacion registrarObligacion(Obligacion nueva) throws Exception;

    public Obligacion consultarObligacionByNumeroTitu(String numeroTitular) throws Exception;

    public Obligacion consultarObligacionByClienteUsuario(ClienteUsuario clienteUsu) throws Exception;

}
