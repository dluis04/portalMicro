package com.psicovirtual.liquidadorAdminTotal.vista.mb;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlForm;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import co.bmsoft.components.readfiles.ReadFilesComp;
import co.bmsoft.components.readfiles.parameters.ReadFilesParams;
import co.bmsoft.components.readfiles.parameters.ReadFilesParams.FileType;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.psicovirtual.estandar.modelo.utilidades.Parametros;
import com.psicovirtual.estandar.modelo.utilidades.UtilidadesModel;
import com.psicovirtual.estandar.vista.mb.MBMensajes;
import com.psicovirtual.estandar.vista.utilidades.AccesoPropiedadesVista;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNAfiliado;
import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNCargueArchivos;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.CargueArchivo;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.DetalleCargue;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Inconsistencias;
import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer.Param;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Byte;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.naming.InitialContext;
import javax.sql.DataSource;

@ManagedBean(name = "MBCarguesRealizados")
@SessionScoped
public class MBCarguesRealizados {
	MBMensajes mensajes = new MBMensajes();

	DNAfiliado dnAfiliado;

	DNCargueArchivos dNCargueArchivos;
	List<CargueArchivo> listaCargues;
	CargueArchivo cargueSeleccionado;
	public MBCarguesRealizados() {
		try {
			if (validarSession()) {
				consultarCargue();
			}
		} catch (Exception e) {
			System.out.println("error en cargue ");
		}
	}


	
	List<DetalleCargue> listaDetalleCargue;

	public void consultarDetalle() throws Exception {
		if (dNCargueArchivos == null) {
			dNCargueArchivos = new DNCargueArchivos();
		}
		System.out.println("consulta detalle ");
		listaDetalleCargue = dNCargueArchivos.listaDetalleCargue(cargueSeleccionado.getIdCargue() + "");
		navegarDetalle();

	}



	public void navegarDetalle() throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url2 = extContext.encodeActionURL(
				context.getApplication().getViewHandler().getActionURL(context, "/view/gestion/detalleCargue.xhtml"));
		extContext.redirect(url2);

	}

	public void regresarCargues() throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url2 = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,
				"/view/gestion/carguesRealizados.xhtml"));
		extContext.redirect(url2);

	}

	public String ponerPuntos(String numeroconpuntos) {
		int cont = 0;
		String cadenanueva = "";
		String cadenanueva2 = "";
		String cadenanueva3 = "";

		for (int x = numeroconpuntos.length() - 1; x >= 0; x--) {
			char b = numeroconpuntos.charAt(x);
			cont++;
			cadenanueva += numeroconpuntos.charAt(x);
			if (cont == 3) {
				cadenanueva += ".";
				cont = 0;
			}
		}

		for (int x = cadenanueva.length() - 1; x >= 0; x--) {
			char b = cadenanueva.charAt(x);
			cadenanueva2 += cadenanueva.charAt(x);
		}

		for (int i = 0; i < cadenanueva2.length(); i++) {
			char b = cadenanueva2.charAt(i);
			if (i == 0) {
				if (b == '.') {
					cadenanueva3 = quitarpuntoinicion(cadenanueva2);
					break;
				} else {
					cadenanueva3 = cadenanueva2;
					break;
				}
			} else {
				cadenanueva3 = cadenanueva2;
				break;
			}
		}
		return cadenanueva3;
	}

	public String quitarpuntoinicion(String dato) {
		String dato2 = "";
		for (int i = 0; i < dato.length(); i++) {
			char b = dato.charAt(i);
			if (i == 0) {
				if (b == '.') {
				}
			} else {
				dato2 += dato.charAt(i);
			}
		}
		return dato2;
	}

	
	
	public Boolean validarSession() throws IOException {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		Boolean isSession = false;

		if (session.getAttribute("id") != null) {
			isSession = true;
		} else {
			ExternalContext extContext = context.getExternalContext();
			Object session2 = extContext.getSession(false);
			HttpSession httpSession = (HttpSession) session2;
			httpSession.invalidate();
			String url2 = extContext.encodeActionURL(
					context.getApplication().getViewHandler().getActionURL(context, "/view/index.xhtml"));
			extContext.redirect(url2);
		}

		return isSession;
	}

	public void consultarCargue() throws Exception {
		if (dNCargueArchivos == null) {
			dNCargueArchivos = new DNCargueArchivos();
		}
		listaCargues = dNCargueArchivos.listaCargues();

	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public DNAfiliado getDnAfiliado() {
		return dnAfiliado;
	}

	public void setDnAfiliado(DNAfiliado dnAfiliado) {
		this.dnAfiliado = dnAfiliado;
	}

	public DNCargueArchivos getdNCargueArchivos() {
		return dNCargueArchivos;
	}

	public void setdNCargueArchivos(DNCargueArchivos dNCargueArchivos) {
		this.dNCargueArchivos = dNCargueArchivos;
	}

	public List<CargueArchivo> getListaCargues() {
		return listaCargues;
	}

	public void setListaCargues(List<CargueArchivo> listaCargues) {
		this.listaCargues = listaCargues;
	}



	public CargueArchivo getCargueSeleccionado() {
		return cargueSeleccionado;
	}



	public void setCargueSeleccionado(CargueArchivo cargueSeleccionado) {
		this.cargueSeleccionado = cargueSeleccionado;
	}



	public List<DetalleCargue> getListaDetalleCargue() {
		return listaDetalleCargue;
	}



	public void setListaDetalleCargue(List<DetalleCargue> listaDetalleCargue) {
		this.listaDetalleCargue = listaDetalleCargue;
	}
	
	
	

}
