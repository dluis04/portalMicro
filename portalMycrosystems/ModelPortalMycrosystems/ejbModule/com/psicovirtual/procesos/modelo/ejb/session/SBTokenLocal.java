package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Token;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBTokenLocal {

	public Token registrarToken(Token nuevo) throws Exception;

	public Token consultarTokenByUsuario(Usuario usuario) throws Exception;

	public Token consultarTokenBy(int idToken) throws Exception;

	public void consultaDesactivarToken(Date fecha) throws Exception;

	public Token desactivarToken(Token token) throws Exception;

}
