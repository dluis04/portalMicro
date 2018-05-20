package com.psicovirtual.procesos.modelo.ejb.session;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.CargueArchivo;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Cliente;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCargue;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCarguePK;

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
	

	public SBCargueArchivos() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarInformacionCargue(List<Vector> registros, int cargueCreado) throws Exception {
		// Afiliado entity = (Afiliado) sbFacade.insertEntity(param);
		for (int i = 0; i < registros.size(); i++) {
			DetalleCarguePK pk = new DetalleCarguePK();

			CargueArchivo entity = (CargueArchivo) sbFacade.findByPrimaryKey(CargueArchivo.class, cargueCreado);

			pk.setIdCargue(entity.getIdCargue());
			pk.setNumeroTituloValor(registros.get(i).get(0).toString().trim()	);
			if (registros.get(i).get(1) != null) {
				pk.setCuota(Integer.parseInt(registros.get(i).get(1).toString().trim()	));

			}
			pk.setCedula(Integer.parseInt(registros.get(i).get(7).toString().trim()	));

			DetalleCargue dt = new DetalleCargue();
			dt.setId(pk);

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

			dt.setFechaElaboracion(formateador.parse(registros.get(i).get(2).toString().trim()	));

			dt.setValor(Integer.parseInt(registros.get(i).get(3).toString().trim()	));

			dt.setFechaVencimiento(formateador.parse(registros.get(i).get(4).toString().trim()	));

			dt.setDiasMora(Integer.parseInt(registros.get(i).get(5).toString().trim()	));
			dt.setTipoDoc(Integer.parseInt(registros.get(i).get(6).toString().trim()	));
			dt.setPrimerNombre(registros.get(i).get(8).toString().trim()	);
			dt.setSegundoNombre(registros.get(i).get(9).toString().trim()	);
			dt.setPrimerApellido(registros.get(i).get(10).toString().trim()	);
			dt.setSegundoApellido(registros.get(i).get(11).toString().trim()	);
			dt.setDireccion(registros.get(i).get(12).toString().trim()	);

			if (registros.get(i).get(13) != null) {
				dt.setCiudad(registros.get(i).get(13).toString().trim()	);
			}

			if (registros.get(i).get(14) != null) {
				dt.setDepartamento(registros.get(i).get(14).toString().trim()	);
			}

			if (registros.get(i).get(15) != null) {
				dt.setTelefono1(registros.get(i).get(15).toString().trim()	);
			}

			if (registros.get(i).get(16) != null) {
				dt.setTeledono2(registros.get(i).get(16).toString().trim()	);
			}

			if (registros.get(i).get(17) != null) {
				dt.setTelefono3(registros.get(i).get(17).toString().trim()	);
			}

			if (registros.get(i).get(18) != null) {
				dt.setCelular(registros.get(i).get(18).toString().trim()	);
			}

			if (registros.get(i).get(19) != null) {
				dt.setCorreo(registros.get(i).get(19).toString().trim()	);
			}

			dt.setCargueArchivo(entity);

			sbFacade.insertEntity(dt);

		}

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
	
		System.out.println("query " + query + "\n" + "parametros: " );
		List<Object[]> registrosList = sbFacade.executeNativeQuery(query, parametros);
		CargueArchivo vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new CargueArchivo();

			vo.setIdCargue(Integer.parseInt(registrosList.get(i)[0].toString()) );		
			
			System.out.println("nit = "+registrosList.get(i)[1].toString());
			Cliente tempAfil=sBAfiliadoLocal.buscarAfiliado(Integer.parseInt(registrosList.get(i)[1].toString()));
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
		String query = "select o from DetalleCargue o where o.id.idCargue ='"+idCargue+"'";
		List<DetalleCargue> lista = sbFacade.executeQuery(query, null);
		return lista;

	}
	
	
	
	
	

}
