package com.psicovirtual.estandar.modelo.utilidades;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CargarArchivoPropiedades {
    public CargarArchivoPropiedades() {
    }

    public String getProperty(String fileName, 
                              String propertyName) throws Exception {
        Properties pro = null;
        String valor=null;
        try {
            if(fileName == null){
                fileName="parametros.properties";
            }
            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/psicovirtual/estandar/modelo/properties/" + 
                                                                                   fileName);
            pro.load(input);

            valor = pro.getProperty(propertyName);

            pro.clear();

            input.close();

            return valor;
        } catch (IOException ex) {
            System.out.println("Error leyendo propiedad por: " + 
                               ex.getMessage());
            throw ex;
        }
    }
    
   public String getError(String codigoError) throws Exception{
        return getProperty("errores.properties",codigoError);
   }
   
    public String getNotificacion(String codigoNotificacion) throws Exception{
         return getProperty("notificaciones.properties",codigoNotificacion);
    }

    public List getListProperty(String fileName, String propertyName, 
                                      String propertySeparator) throws Exception {
        Properties pro = null;
        List list;
        String[] d;

        try {
            if(fileName == null){
                fileName="parametros.properties";
            }
            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/psicovirtual/estandar/modelo/properties/" + 
                                                                                   fileName);
            pro.load(input);

            list = new ArrayList();
            d = pro.getProperty(propertyName).split(propertySeparator);

            for (int i = 0; i < d.length; i++){
                list.add( d[i] );
            }

            pro.clear();

            input.close();

            return list;

        } catch (IOException ex) {
            System.out.println("Error leyendo propiedad por: " + 
                               ex.getMessage());
            throw ex;
        }
    }

}