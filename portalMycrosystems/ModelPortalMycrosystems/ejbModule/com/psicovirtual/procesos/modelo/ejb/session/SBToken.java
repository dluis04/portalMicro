package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Token;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBToken
 */
@Stateless
public class SBToken implements SBTokenLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;

	public SBToken() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Token registrarToken(Token nuevo) throws Exception {
		Token entity = (Token) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public Token consultarTokenByUsuario(Usuario usuario) throws Exception {
		String query = "SELECT u FROM Token u where u.usuario.cedula='" + usuario.getCedula() + "' "
				+ "and u.activo='1' ";

		List<Token> listToken = sbFacade.executeQuery(query, null);
		Token temp = null;

		for (Token list : listToken) {
			temp = list;
		}
		return temp;
	}

	@Override
	public Token consultarTokenBy(int idToken) throws Exception {
		String query = "SELECT u FROM Token u where u.idToken='" + idToken + "' ";

		List<Token> listToken = sbFacade.executeQuery(query, null);
		Token temp = null;

		for (Token list : listToken) {
			temp = list;
		}
		return temp;
	}

	@Override
	public void consultaDesactivarToken(Date fecha) throws Exception {

		java.sql.Timestamp sq = new java.sql.Timestamp(fecha.getTime());
		String query = "SELECT u FROM Token u where u.fechaFin<'" + sq + "' ";

		List<Token> listToken = sbFacade.executeQuery(query, null);

		for (Token tokenDesactivar : listToken) {
			desactivarToken(tokenDesactivar);
		}

	}

	@Override
	public Token desactivarToken(Token token) throws Exception {
		token.setActivo(0);
		Token x = (Token) sbFacade.updateEntity(token);
		return x;
	}

}
