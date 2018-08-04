package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;
import java.util.Vector;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.CargueArchivo;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCargue;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Trackingurl;

@Local
public interface SBCargueArchivosLocal {

	public void guardarInformacionCargue(List<Vector> registros, int cargueCreado) throws Exception;

	public CargueArchivo crearCargueArchivo(CargueArchivo param) throws Exception;

	public CargueArchivo buscarCargueArchivo(Object param) throws Exception;

	public int maximoIdCargue() throws Exception;

	public List<CargueArchivo> listaCargues() throws Exception;

	public List<DetalleCargue> listaDetalleCargue(String idCargue) throws Exception;
	public Trackingurl guardarTRackingUrl(Trackingurl param) throws Exception;

}
