package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Pagina;

@Local
public interface SBPaginaLocal {

	public Pagina crearPagina(Pagina nueva) throws Exception;

	public Pagina actualizarPagina(Pagina update) throws Exception;

	public List<Pagina> consultarPaginas() throws Exception;

	public Pagina consultarPaginasRuta(String pagina) throws Exception;

}
