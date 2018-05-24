package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Token;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;
import com.psicovirtual.procesos.modelo.ejb.session.SBTokenLocal;

@ManagedBean(value = "DNToken")
@ApplicationScoped
public class DNToken {

	SBTokenLocal sBTokenLocal;

	public DNToken() throws Exception {
		sBTokenLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBToken" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBTokenLocal",
				SBTokenLocal.class);
	}

	public Token registrarToken(Token nuevo) throws Exception {
		return sBTokenLocal.registrarToken(nuevo);
	}

	public Token consultarTokenByUsuario(Usuario usuario) throws Exception {
		return sBTokenLocal.consultarTokenByUsuario(usuario);
	}

	public Token consultarTokenBy(int idToken) throws Exception {
		return sBTokenLocal.consultarTokenBy(idToken);
	}

	public void consultaDesactivarToken(Date fecha) throws Exception {
		sBTokenLocal.consultaDesactivarToken(fecha);
	}

	public Token desactivarToken(Token token) throws Exception {
		return sBTokenLocal.desactivarToken(token);
	}

}
