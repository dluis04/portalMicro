package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;

@Local
public interface SBAccionesPaginaLocal {

	public AccionesPagina crearAccionPagina(AccionesPagina nuevo) throws Exception;

	public AccionesPagina actualizarAccionPagina(AccionesPagina update) throws Exception;

	public List<AccionesPagina> consultarAccionesPagina(Pagina pagina) throws Exception;

}
