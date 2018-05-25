package com.psicovirtual.procesos.modelo.ejb.session;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.psicovirtual.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.psicovirtual.estandar.modelo.utilidades.Email;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.CargueArchivo;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.ClienteUsuario;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCargue;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCarguePK;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Token;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBAfiliado
 */
@Stateless
@LocalBean
public class SBCargueArchivos implements SBCargueArchivosLocal {

	/**
	 * Default constructor.
	 */

	@EJB
	SBFacadeProcesosLocal sbFacade;
	@EJB
	SBAfiliadoLocal sBAfiliadoLocal;
	@EJB
	SBUsuarioLocal sBUsuarioLocal;
	@EJB
	SBClienteLocal sBClienteLocal;
	@EJB
	SBClienteUsuarioLocal sBClienteUsuarioLocal;
	@EJB
	SBTokenLocal sBTokenLocal;

	protected SecureRandom random;

	public SBCargueArchivos() {
		// TODO Auto-generated constructor stub
		random = new SecureRandom();
	}

	@Override
	public void guardarInformacionCargue(List<Vector> registros, int cargueCreado) throws Exception {
		// Afiliado entity = (Afiliado) sbFacade.insertEntity(param);
		for (int i = 0; i < registros.size(); i++) {
			DetalleCarguePK pk = new DetalleCarguePK();

			CargueArchivo entity = (CargueArchivo) sbFacade.findByPrimaryKey(CargueArchivo.class, cargueCreado);

			int cedula = 0, tipoDocumento = 0, valor = 0, diasMora = 0;
			String primerNombre = "", segundoNombre = "", primerApellido = "", segundoApellido = "", direccion = "";
			String ciudad = "", departamento = "", telefono1 = "", telefono2 = "", telefono3 = "", celular = null,
					correo = null;

			pk.setIdCargue(entity.getIdCargue());
			cedula = Integer.parseInt(registros.get(i).get(7).toString().trim());
			pk.setCedula(cedula);

			pk.setNumeroTituloValor(registros.get(i).get(0).toString().trim());
			if (registros.get(i).get(1) != null) {
				pk.setCuota(Integer.parseInt(registros.get(i).get(1).toString().trim()));
			}

			DetalleCargue dt = new DetalleCargue();

			dt.setId(pk);

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaElaboracion = (formateador.parse(registros.get(i).get(2).toString().trim()));
			valor = Integer.parseInt(registros.get(i).get(3).toString().trim());
			Date fechaVencimiento = (formateador.parse(registros.get(i).get(4).toString().trim()));
			diasMora = Integer.parseInt(registros.get(i).get(5).toString().trim());
			tipoDocumento = Integer.parseInt(registros.get(i).get(6).toString().trim());
			primerNombre = registros.get(i).get(8).toString().trim();
			segundoNombre = registros.get(i).get(9).toString().trim();
			primerApellido = registros.get(i).get(10).toString().trim();
			segundoApellido = registros.get(i).get(11).toString().trim();
			direccion = registros.get(i).get(12).toString().trim();
			ciudad = registros.get(i).get(13).toString().trim();
			departamento = registros.get(i).get(14).toString().trim();
			telefono1 = registros.get(i).get(15).toString().trim();
			telefono2 = registros.get(i).get(16).toString().trim();
			telefono3 = registros.get(i).get(17).toString().trim();
			celular = registros.get(i).get(18).toString().trim();
			correo = registros.get(i).get(19).toString().trim();

			dt.setFechaElaboracion(fechaElaboracion);
			dt.setValor(valor);
			dt.setFechaVencimiento(fechaVencimiento);
			dt.setDiasMora(diasMora);
			dt.setTipoDoc(tipoDocumento);
			dt.setPrimerNombre(primerNombre);
			dt.setSegundoNombre(segundoNombre);
			dt.setPrimerApellido(primerApellido);
			dt.setSegundoApellido(segundoApellido);
			dt.setDireccion(direccion);

			if (registros.get(i).get(13) != null) {
				dt.setCiudad(ciudad);
			}

			if (registros.get(i).get(14) != null) {
				dt.setDepartamento(departamento);
			}

			if (registros.get(i).get(15) != null) {
				dt.setTelefono1(telefono1);
			}

			if (registros.get(i).get(16) != null) {
				dt.setTeledono2(telefono2);
			}

			if (registros.get(i).get(17) != null) {
				dt.setTelefono3(telefono3);
			}

			if (registros.get(i).get(18) != null) {
				dt.setCelular(celular);
			}

			if (registros.get(i).get(19) != null) {
				dt.setCorreo(correo);
			}

			dt.setCargueArchivo(entity);

			DetalleCargue tempCargue = (DetalleCargue) sbFacade.insertEntity(dt);

			if (tempCargue != null) {
				Date fechaActualizacion = new Date();
				Usuario tempUsuario = new Usuario();

				tempUsuario.setCedula(cedula);
				tempUsuario.setTipoDoc(tipoDocumento);
				tempUsuario.setTipoUsuario("Usuario"); // Definir tipoUsuario
				tempUsuario.setFechaCreacion(fechaActualizacion);
				tempUsuario.setEstado("Activo");
				
				Usuario usuarioExiste = sBUsuarioLocal.consultarDetalleUsuario(cedula);

				if (usuarioExiste != null) {
					System.out.println("Actualizar clienteUsuario");
					sBUsuarioLocal.actualizarUsuario(tempUsuario);
				} else {
					System.out.println("Registro clienteUsuario Nuevo");
					if (sBUsuarioLocal.crearUsuario(tempUsuario) != null) {

						// Se prepara los datos para el registro del ClienteUsuario
						ClienteUsuario clienteUsuario = new ClienteUsuario();
						tempUsuario = sBUsuarioLocal.consultarDetalleUsuario(cedula);

						Cliente clienteTemp = new Cliente();
						clienteTemp.setIdCliente(2);
						clienteTemp.setNit(1144168383);
						clienteTemp.setNombre("DIEGO");
						clienteUsuario.setUsuario(tempUsuario);
						clienteUsuario.setCliente(clienteTemp);
						clienteUsuario.setTipoDoc(tipoDocumento);
						clienteUsuario.setCedula(cedula);
						clienteUsuario.setPrimerNombre(primerNombre);
						clienteUsuario.setSegundoNombre(segundoNombre);
						clienteUsuario.setPrimerApellido(primerApellido);
						clienteUsuario.setSegundoApellido(segundoApellido);
						clienteUsuario.setDepartamento(departamento);
						clienteUsuario.setCiudad(ciudad);
						clienteUsuario.setCorreo(correo);
						clienteUsuario.setDireccion(direccion);
						clienteUsuario.setCelular(celular);
						clienteUsuario.setTelefono1(telefono1);
						clienteUsuario.setTelefono2(telefono2);
						clienteUsuario.setTelefono3(telefono3);
						clienteUsuario.setFechaActualizacion(fechaActualizacion);
						clienteUsuario.setEstado("ACTIVO");

						// Se genera el token al usuario nuevo
						generarTokenUsuario(tempUsuario, correo, celular);

						// Se valida que el clienteUsuario exista antes de realizar el registro
						ClienteUsuario clienteUsuExiste = sBClienteUsuarioLocal
								.consultarClienteUsuarioEmpresa(tempUsuario, clienteTemp);

						
						if (clienteUsuExiste != null) {
							actualizarClienteUsuario(clienteUsuExiste);
						} else {

							if (sBClienteUsuarioLocal.crearClienteUsuario(clienteUsuario) != null) {
								System.out.println("Registro exitoso");
							}

						}
					}
				}

			}

		}

	}

	public void actualizarClienteUsuario(ClienteUsuario clienteUsu) {
		try {
			sBClienteUsuarioLocal.actualizarClieneUsuario(clienteUsu);
		} catch (Exception e) {
			System.out.println("Se encuentra problemas en el metodo actualizarClienteUsuario -->> " + e);
		}
	}

	public void generarTokenUsuario(Usuario usuario, String correo, String celular) {

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
			token.setToken(generarToken());
			token.setActivo(1);

			if (sBTokenLocal.registrarToken(token) != null) {
				usuario.setContrasena(generarToken());
				sBUsuarioLocal.actualizarUsuario(usuario);
				System.out.println("Registro el token");

				if (correo != null) {
					enviarCorreoConToken(token.getToken(), correo);
				} else {
					if (celular != null) {
						enviarMensajeTexto(token.getToken(), celular);
					} else {
						System.out.println("Notificar a la empresa");
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error en el metodo generarTokenUsuario -->> " + e);
		}
	}

	private void enviarCorreoConToken(String token, String correo) {

		try {
			Email x = new Email();

			System.out.println("Correo -->> " + correo);
			System.out.println("Token -->> " + token);

			correo = "diegoluis1993@gmail.com";

			x.sendMailSimples(correo, "Codigo de Acceso",
					"Cordial Saludo, " + " \n El codigo de acceso a la plataforma MicroSystem es: " + token
							+ " \n Ingresar en un tiempo de 2 horas sino el codigo se vencera."
							+ " \n Atentamente la administración");
		} catch (Exception e) {
			System.out.println("Error en el metodo enviarCorreoConToken -->> " + e);
		}

	}

	private void enviarMensajeTexto(String token, String celular) {
		System.out.println("EnviarMensaje de texto al numero -->> " + celular);
	}

	public String generarToken() {
		long longToken = Math.abs(random.nextLong());
		String random = Long.toString(longToken, 17).substring(0, 8);
		return random;
	}

	@Override
	public CargueArchivo crearCargueArchivo(CargueArchivo param) throws Exception {
		CargueArchivo entity = (CargueArchivo) sbFacade.insertEntity(param);
		return entity;
	}

	@Override
	public int maximoIdCargue() throws Exception {

		String query = "SELECT max(ID_CARGUE) FROM CARGUE_ARCHIVOS";
		HashMap parametros = new HashMap();

		List registrosList = sbFacade.executeNativeQuery(query, parametros);
		int vo = 0;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = Integer.parseInt(registrosList.get(i) + "");

		}

		return vo;
	}

	@Override
	public CargueArchivo buscarCargueArchivo(Object param) throws Exception {

		CargueArchivo entity = (CargueArchivo) sbFacade.findByPrimaryKey(Cliente.class, param);
		return entity;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<CargueArchivo> listaCargues() throws Exception {

		List<CargueArchivo> lista = new ArrayList<CargueArchivo>();

		String query = "SELECT ID_CARGUE, NIT AS AFILIADO,NOMBRE_ARCHIVO, FECHA_CARGUE, (SELECT COUNT(*) "
				+ " FROM DETALLE_CARGUE WHERE ID_CARGUE=CARGUE_ARCHIVOS.ID_CARGUE) AS REGISTROS FROM CARGUE_ARCHIVOS";

		HashMap parametros = new HashMap();

		System.out.println("query " + query + "\n" + "parametros: ");
		List<Object[]> registrosList = sbFacade.executeNativeQuery(query, parametros);
		CargueArchivo vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new CargueArchivo();

			vo.setIdCargue(Integer.parseInt(registrosList.get(i)[0].toString()));

			System.out.println("nit = " + registrosList.get(i)[1].toString());
			Cliente tempAfil = sBAfiliadoLocal.buscarAfiliado(Integer.parseInt(registrosList.get(i)[1].toString()));
			vo.setCliente(tempAfil);

			vo.setNombreAfil(tempAfil.getNombre());

			vo.setNombreArchivo(registrosList.get(i)[2].toString());

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			vo.setFechaCargue(formatter.parse(registrosList.get(i)[3].toString()));

			vo.setCantidadRegistros(registrosList.get(i)[4].toString());
			lista.add(vo);

		}

		return lista;

	}

	@Override
	public List<DetalleCargue> listaDetalleCargue(String idCargue) throws Exception {
		String query = "select o from DetalleCargue o where o.id.idCargue ='" + idCargue + "'";
		List<DetalleCargue> lista = sbFacade.executeQuery(query, null);
		return lista;

	}

}
