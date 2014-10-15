/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Fachada.conexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author estudiante
 */
public class ServletHTMLConsultasIT3  extends  HttpServlet{
    
    
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
	      
			
       
                  //BORRA UNO SECUNDARIO
                       
                         
                         
                         
                            PrintWriter respuesta = response.getWriter() ;         
                    imprimirhtmlConsultasIT3(respuesta,request,response);
                    
	    	
	        
	    }
		/**
	     * Maneja un pedido POST de un cliente
	     * @param request Pedido del cliente
	     * @param response Respuesta
	     */
	    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
                
                  PrintWriter respuesta = response.getWriter() ;
                    imprimirhtmlConsultasIT3(respuesta,request,response);
	    	
	    }
            
         
    
    
    
      
    public  void imprimirhtmlConsultasIT3(PrintWriter respuesta,HttpServletRequest request, HttpServletResponse response)
    {
        
        String sentenciaInversionistas="select * from inversionista;";
         String sentenciaOferentes="select * from oferente;";
          String sentenciasIntermediarios="select * from intermediario;";
        
        

                        conexionDB x = new conexionDB();
                         ResultSet sepuedeEliminar= x.consultar(sentenciaInversionistas);
        
        
        
        
    }   
           
    
    
    
    
    
    
    
}
