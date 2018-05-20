package com.psicovirtual.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.SesionesActiva;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;


@Local
public interface SBSesionesActivaLocal {

	public SesionesActiva registroSesionActiva(SesionesActiva sesion) throws Exception;

	public SesionesActiva consultarSesionActivaByUsuario(Usuario usuario) throws Exception;

	public int cerrarSesionActivaByUsuario(Usuario usuario) throws Exception;
	
}
