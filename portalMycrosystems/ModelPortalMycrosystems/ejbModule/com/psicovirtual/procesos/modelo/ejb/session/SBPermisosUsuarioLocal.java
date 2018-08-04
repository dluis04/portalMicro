package com.psicovirtual.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.AccionesPagina;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.PermisosUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBPermisosUsuarioLocal {

	public PermisosUsuario crearPermiso(PermisosUsuario nuevo) throws Exception;

	public PermisosUsuario actualizarPermiso(PermisosUsuario update) throws Exception;

	public PermisosUsuario consultarPermisosByUsuarioAccion(Usuario usuario, AccionesPagina accion) throws Exception;

}
