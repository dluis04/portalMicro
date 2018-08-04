package com.psicovirtual.procesos.modelo.ejb.session;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.estandar.modelo.utilidades.Email;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Token;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBUsuario
 */
@Stateless
@LocalBean
public class SBUsuario implements SBUsuarioLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;
	@EJB
	SBClienteUsuarioLocal sBclienteUsuarioLocal;
	@EJB
	SBTokenLocal sBTokenLocal;

	protected SecureRandom random;

	public SBUsuario() {
		// TODO Auto-generated constructor stub
		random = new SecureRandom();
	}

	@Override
	public Usuario crearUsuario(Usuario nuevo) throws Exception {
		Usuario entity = (Usuario) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public int consultarUsuarioInicio(Usuario user) throws Exception {

		int retorna = 0;

		String query = "SELECT u.cedula FROM Usuario u where u.cedula='" + user.getCedula() + "' "
				+ "and u.contrasena='" + user.getContrasena() + "' and u.estado='A' ";

		List listUsuario = sbFacade.executeQuery(query, null);
		retorna = listUsuario.size();

		return retorna;
	}

	@Override
	public Usuario actualizarUsuario(Usuario update) throws Exception {
		Usuario x = (Usuario) sbFacade.updateEntity(update);
		return x;
	}

	@Override
	public Usuario consultarDetalleUsuario(int id) throws Exception {
		String query = "SELECT u FROM Usuario u where u.cedula='" + id + "' and u.estado='A' ";

		List<Usuario> listUsuario = sbFacade.executeQuery(query, null);
		Usuario temp = null;

		for (int i = 0; i < listUsuario.size(); i++) {
			temp = listUsuario.get(i);
		}
		return temp;
	}

	@Override
	public boolean enviarCorreoTokenRecuperacion(Usuario user) throws Exception {

		Email x = new Email();
		boolean isEnvio = false;

		List<ClienteUsuario> listClienteUsuario = sBclienteUsuarioLocal.consultarUsuariosByIdUsuario(user);
		String token = null;

		for (ClienteUsuario list : listClienteUsuario) {

			token = generarTokenUsuario(list.getUsuario(), list.getCorreo());

			if (token != null) {
				x.sendMailSimples(list.getCorreo(), "Recuperacion de contraseña",
						"Cordial Saludo, " + " \n El codigo de recuperacion de contraseña es: " + token
								+ " \n Ingresar en un tiempo de 2 horas sino el codigo se vencera."
								+ " \n Atentamente la administracion");

				token = null;
				isEnvio = true;
			} else {
				System.out.println("El token no fue generado!");
			}

		}

		return isEnvio;
	}

	public String generarTokenUsuario(Usuario usuario, String correo) {

		String tokenGenerado = "";
		try {

			// Se crea la fecha y hora Inicial
			Calendar calendar = Calendar.getInstance();
			Date fechaIniFin = new Date();
			Token token = new Token();

			token.setFechaInicio(fechaIniFin);

			// Se configura fecha y hora Fin
			calendar.setTime(fechaIniFin);
			calendar.add(Calendar.MINUTE, 0); // Colocar en configuracion
			calendar.add(Calendar.HOUR, 3); // Colocar en configuracion
			fechaIniFin = calendar.getTime();

			token.setUsuario(usuario);
			token.setFechaFin(fechaIniFin);

			tokenGenerado = generarToken();
			token.setToken(tokenGenerado);
			token.setActivo(1);

			if (sBTokenLocal.registrarToken(token) != null) {
				usuario.setContrasena(tokenGenerado);
				actualizarUsuario(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error en el metodo generarTokenUsuario -->> " + e);
		}
		return tokenGenerado;
	}

	public String generarToken() {
		long longToken = Math.abs(random.nextLong());
		String random = Long.toString(longToken, 17).substring(0, 8);
		return random;
	}

	@Override
	public List<Usuario> consultarAllUsuariosActivos() throws Exception {
		
		String query = "SELECT u FROM Usuario u where u.estado='A' ";
		List<Usuario> listUsuario = sbFacade.executeQuery(query, null);
		return listUsuario;
	}

}
