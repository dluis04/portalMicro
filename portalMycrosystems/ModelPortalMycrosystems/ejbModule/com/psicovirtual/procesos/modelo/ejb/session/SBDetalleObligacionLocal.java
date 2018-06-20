package com.psicovirtual.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleObligacion;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Obligacion;

@Local
public interface SBDetalleObligacionLocal {

	public DetalleObligacion registrarDetalleObligacion(DetalleObligacion nuevo) throws Exception;

	public List<DetalleObligacion> consultarDetalleObliacionByObli(Obligacion nuevo) throws Exception;

}
