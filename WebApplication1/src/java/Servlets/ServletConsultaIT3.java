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
public class ServletConsultaIT3 extends HttpServlet{
    
    
    
    
		protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
	      
			
       
	        
	    }
		/**
	     * Maneja un pedido POST de un cliente
	     * @param request Pedido del cliente
	     * @param response Respuesta
	     */
	    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
                
                 
                  //BORRA UNO SECUNDARIO
                       
                         String intermediario = request.getParameter( "Intermediario" );
                          String oferente = request.getParameter( "Oferente" );
                          String inversionista = request.getParameter( "Inversionista" );

                      
                         PrintWriter respuesta = response.getWriter() ;
                         conexionDB x = new conexionDB();
                         
                         
                         
                         
                         
                         if(intermediario!=null)
                         {
                             
                             imprimirhtmlIntermediario(respuesta);
                             
                         }
                    
                         
                         
                         
                         
                         
                         if(oferente!=null)
                         {
                             
                             
                             imprimirhtmlOferente(respuesta);
                             
                             
                             
                             
                         }
                         
                         
                         
                         
                         
                         if(inversionista!=null)
                         {
                             
                             
                             imprimirhtmlInversionista(respuesta);
                             
                             
                             
                         }
                    
	    	
	    	
	    }
            
         
    
    
    
    
    public  void imprimirhtmlIntermediario(PrintWriter respuesta)
    {
        
    
        
    }   
    
    
    
     public  void imprimirhtmlOferente(PrintWriter respuesta)
    {
        
    
        
    }   
     
     
     
     
      public  void imprimirhtmlInversionista(PrintWriter respuesta)
    {
        
    
        
    }   
           
         
    
    
    
    
}
