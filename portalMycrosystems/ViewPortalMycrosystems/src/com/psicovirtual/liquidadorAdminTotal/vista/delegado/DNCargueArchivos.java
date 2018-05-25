package com.psicovirtual.liquidadorAdminTotal.vista.delegado;

import java.util.List;
import java.util.Vector;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.vista.utilidades.ServiceLocator;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.CargueArchivo;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCargue;
import com.psicovirtual.procesos.modelo.ejb.session.SBCargueArchivosLocal;

@ManagedBean(value = "DNCargueArchivos")
@ApplicationScoped
public class DNCargueArchivos {

	SBCargueArchivosLocal sBCargueArchivosLocal;

	public DNCargueArchivos() throws Exception {
		sBCargueArchivosLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBCargueArchivos" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBCargueArchivosLocal",
				SBCargueArchivosLocal.class);
	}

	public List<CargueArchivo> listaCargues() throws Exception {
		return sBCargueArchivosLocal.listaCargues();
	}

	public void guardarInformacionCargue(List<Vector> registros, int cargueCreado) throws Exception {
		sBCargueArchivosLocal.guardarInformacionCargue(registros, cargueCreado);
	}

	public CargueArchivo crearCargueArchivo(CargueArchivo param) throws Exception {
		return sBCargueArchivosLocal.crearCargueArchivo(param);
	}

	public CargueArchivo buscarCargueArchivo(Object param) throws Exception {
		return sBCargueArchivosLocal.buscarCargueArchivo(param);
	}

	public int maximoIdCargue() throws Exception {
		return sBCargueArchivosLocal.maximoIdCargue();
	}

	public List<DetalleCargue> listaDetalleCargue(String idCargue) throws Exception {
		return sBCargueArchivosLocal.listaDetalleCargue(idCargue);
	}

}
