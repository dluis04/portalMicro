package com.psicovirtual.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBUsuarioLocal {

	public Usuario crearUsuario(Usuario nuevo) throws Exception;

	public Usuario actualizarUsuario(Usuario update) throws Exception;

	public Usuario consultarDetalleUsuario(int id) throws Exception;

	public int consultarUsuarioInicio(Usuario user) throws Exception;

	public boolean enviarCorreoTokenRecuperacion(Usuario user) throws Exception;

}
