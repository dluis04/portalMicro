package com.psicovirtual.liquidadorAdminTotal.vista.servicios;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.psicovirtual.liquidadorAdminTotal.vista.delegado.DNCargueArchivos;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Trackingurl;
import com.psicovirtual.procesos.modelo.ejb.entity.procesos.Usuario;


/**
 *
 * @author jpantoja
 */
@Stateless
@Path("Rest")
public class UsuarioFacadeREST  {

  

	DNCargueArchivos dNCargueArchivos;
    
    @POST
    @Path("saveEmailTracking")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveEmailTracking(Trackingurl entity) throws Exception {
      
    	if (dNCargueArchivos==null) {
    		dNCargueArchivos= new DNCargueArchivos();
		}
    	Trackingurl guarda=	dNCargueArchivos.guardarTRackingUrl(entity); 	
    	
        System.out.println("Se Guarda "+guarda.getId() );
         
        
    }

    
    

    

}

