/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import ConsultaDAO.Consultas;
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
	      
			
       
                         String intermediario = request.getParameter( "Intermediario" );
                          String oferente = request.getParameter( "Oferente" );
                          String inversionista = request.getParameter( "Inversionista" );

                      
                         PrintWriter respuesta = response.getWriter() ;
                         conexionDB x = new conexionDB();
                         
           
                         
                         
                         
                         if(intermediario!=null)
                         {
                             
                             imprimirhtmlIntermediario(respuesta,x , intermediario);
                             
                         }
                    
                         
                         
                         
                         
                         
                         if(oferente!=null)
                         {
                             
                             
                             imprimirhtmlOferente(respuesta,x , oferente);
                             
                             
                             
                             
                         }
                         
                         
                         
                         
                         
                         if(inversionista!=null)
                         {
                             
                             
                             imprimirhtmlInversionista(respuesta,x,inversionista);
                             
                             
                             
                         }
                
                
	        
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
                             
                             imprimirhtmlIntermediario(respuesta,x , intermediario);
                             
                         }
                    
                         
                         
                         
                         
                         
                         if(oferente!=null)
                         {
                             
                             
                             imprimirhtmlOferente(respuesta,x , oferente);
                             
                             
                             
                             
                         }
                         
                         
                         
                         
                         
                         if(inversionista!=null)
                         {
                             
                             
                             imprimirhtmlInversionista(respuesta,x,inversionista);
                             
                             
                             
                         }
                    x.close();
	    	
	    	
	    }
            
         
    
    
    
    
    public  void imprimirhtmlIntermediario(PrintWriter respuesta , conexionDB x , String intermediario)
    {
        
        
        respuesta.write( "<!DOCTYPE html>\r\n" );
        respuesta.write( "<!-- saved from url=(0044)http://getbootstrap.com/examples/dashboard/? -->\r\n" );
        respuesta.write( "<html lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" );
        respuesta.write( "    <meta charset=\"utf-8\">\r\n" );
        respuesta.write( "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" );
        respuesta.write( "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" );
        respuesta.write( "    <meta name=\"description\" content=\"\">\r\n" );
        respuesta.write( "    <meta name=\"author\" content=\"\">\r\n" );
        respuesta.write( "    <link rel=\"icon\" href=\"http://getbootstrap.com/favicon.ico\">\r\n" );
        respuesta.write( "    <title>ValorAndes</title>\r\n" );
        respuesta.write( "    <!-- Bootstrap core CSS -->\r\n" );
        respuesta.write( "    <link href=\"http://getbootstrap.com/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" );
        respuesta.write( "    <!-- Custom styles for this template -->\r\n" );
        respuesta.write( "    <link href=\"http://getbootstrap.com/examples/dashboard/dashboard.css\" rel=\"stylesheet\">\r\n" );
        respuesta.write( "    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\r\n" );
        respuesta.write( "    <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js\"></script>\r\n" );
        respuesta.write( "    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n" );
        respuesta.write( "    <!--[if lt IE 9]>\r\n" );
        respuesta.write( "      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n" );
        respuesta.write( "      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n" );
        respuesta.write( "    <![endif]-->\r\n" );
        respuesta.write( "  <style id=\"holderjs-style\" type=\"text/css\"></style><style type=\"text/css\"></style></head>\r\n" );
        respuesta.write( "  <body>\r\n" );
        respuesta.write( "    <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n" );
        respuesta.write( "      <div class=\"container-fluid\">\r\n" );
        respuesta.write( "        <div class=\"navbar-header\">\r\n" );
        respuesta.write( "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n" );
        respuesta.write( "            <span class=\"sr-only\">Toggle navigation</span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "          </button>\r\n" );
        respuesta.write( "          <a class=\"navbar-brand\" href=\"http://getbootstrap.com/examples/dashboard/?#\">ValorAndes</a>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "        <div class=\"navbar-collapse collapse\">\r\n" );
        respuesta.write( "          <ul class=\"nav navbar-nav navbar-right\">\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 1</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 2</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 3</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 4</a></li>\r\n" );
        respuesta.write( "<li class=\"dropdown\">\r\n" );
        respuesta.write( "        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opción 5 <b class=\"caret\"></b></a>\r\n" );
        respuesta.write( "        <ul class=\"dropdown-menu\">\r\n" );
        respuesta.write( "          <li><a href=\"#\">Action</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Another action</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Something else here</a></li>\r\n" );
        respuesta.write( "          <li class=\"divider\"></li>\r\n" );
        respuesta.write( "          <li class=\"dropdown-header\">Dropdown header</li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Separated link</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">One more separated link</a></li>\r\n" );
        respuesta.write( "        </ul>\r\n" );
        respuesta.write( "      </li>\r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          <form class=\"navbar-form navbar-right\">\r\n" );
        respuesta.write( "            <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\r\n" );
        respuesta.write( "          </form>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "      </div>\r\n" );
        respuesta.write( "    </div>\r\n" );
        respuesta.write( "    <div class=\"container-fluid\">\r\n" );
        respuesta.write( "      <div class=\"row\">\r\n" );
        respuesta.write( "        <div class=\"col-sm-3 col-md-2 sidebar\">\r\n" );
        respuesta.write( "         <ul class=\"nav nav-sidebar\">\r\n" );
        respuesta.write( "              <li ><a href=\"./ordenarOperacionPrim.htm\">Ordenar operación primaria</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./ordenarOperacionSec.htm\">Ordenar operación secundaria</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación </a></li>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
        respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./portafolios.htm\">Portafolios</a></li>\r\n" );
        respuesta.write( "            <li ><a href=\"./eliminarInversionista.htm\">Eliminar Intermediario</a></li>\r\n" );
        respuesta.write( "              <li class=\"active\"><a href=\"./consultasIte3.htm\">Consultas</a></li>\r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
        respuesta.write( "          <h1 class=\"page-header\">Intermedario</h1>\r\n" );
        respuesta.write( "          <div class=\"row placeholders\">\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
        

        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );

    
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
     
     
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
   
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "          <h2 class=\"sub-header\">Portafolios</h2>\r\n" );
        respuesta.write( "          <div class=\"table-responsive\">\r\n" );
        respuesta.write( "              <br>\r\n" );
        respuesta.write( "              <h3> Conservador </h3>\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        respuesta.write( "                  <th>email intermediario</th>\r\n" );
        respuesta.write( "                   <th>valor</th>\r\n" );
   
        respuesta.write( "                     <th>nit</th>\r\n" );
             respuesta.write( "                    <th>tipo portafolio</th>\r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        
           ResultSet rta = Consultas.buscarIntermediariosPortafolio(x,"BAJO",intermediario);
        
          try {
                        while(rta.next())
                        {
                          
                                    respuesta.write( "                  <td>"+rta.getString("MAIL")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta.getString("VALOR")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta.getString("NIT")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta.getString("PORTA")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                        }
                        rta.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        
   
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "     \r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "              <br>\r\n" );
        respuesta.write( "              <h3> Agresivo </h3>\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        respuesta.write( "                  <th>email intermediario</th>\r\n" );
        respuesta.write( "                   <th>valor</th>\r\n" );
       
        respuesta.write( "                     <th>nit</th>\r\n" );
         respuesta.write( "                    <th>tipo portafolio</th>\r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
        respuesta.write( "                <tr>\r\n" );
         
          
        
          try {
               ResultSet rta1 = Consultas.buscarIntermediariosPortafolio(x,"ALTO",intermediario);
              
                        while(rta1.next())
                        {
                          
                                        respuesta.write( "                  <td>"+rta1.getString("MAIL")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("VALOR")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta1.getString("NIT")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta1.getString("PORTA")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                        }
                        rta1.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "     \r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "              <br>\r\n" );
        respuesta.write( "              <h3> Moderado </h3>\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        respuesta.write( "                  <th>email intermediario</th>\r\n" );
        respuesta.write( "                   <th>valor</th>\r\n" );
       
        respuesta.write( "                     <th>nit</th>\r\n" );
         respuesta.write( "                    <th>tipo portafolio</th>\r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
        respuesta.write( "                <tr>\r\n" );
      
          
        
          try {
               ResultSet rta2 = Consultas.buscarIntermediariosPortafolio(x,"MEDIO",intermediario);
              
                        while(rta2.next())
                        {
                          
                                       respuesta.write( "                  <td>"+rta2.getString("MAIL")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta2.getString("VALOR")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta2.getString("NIT")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta2.getString("PORTA")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                        }
                        rta2.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        ;
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "     \r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "          <br>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          <br>\r\n" );
        respuesta.write( "          <h2 class=\"sub-header\">Valores en Negociacion</h2>\r\n" );
        respuesta.write( "          <div class=\"table-responsive\">\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        respuesta.write( "                  <th>Email Intermediario Comprador</th>\r\n" );
        respuesta.write( "                  <th>Email Intermediario Vendedor</th>\r\n" );
        respuesta.write( "                  <th>Nit</th>\r\n" );
         respuesta.write( "                  <th>Valor</th>\r\n" );
        respuesta.write( "                  <th>Cantidad</th>\r\n" );
        respuesta.write( "                  <th>Precio Unitario</th>\r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
        respuesta.write( "                <tr>\r\n" );
     try {
               ResultSet rta4 = Consultas.buscarIntermediariosValoresEnNegociasion(x, intermediario);
              
                        while(rta4.next())
                        {
                          
                                       respuesta.write( "                  <td>"+rta4.getString("EMAIL_INT_COM")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta4.getString("EMAIL_INT_VEN")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta4.getString("NIT_VALOR")+"</td>\r\n" );
                                     respuesta.write( "                    <td>"+rta4.getString("NOM_VALOR")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta4.getString("CANTIDAD")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta4.getString("PRECIO_UNITARIO")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                        }
                        rta4.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "          <br>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          <br>\r\n" );
        respuesta.write( "          <h2 class=\"sub-header\">Inversionistas</h2>\r\n" );
        respuesta.write( "          <div class=\"table-responsive\">\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        respuesta.write( "                  <th>Email Intermediario</th>\r\n" );
        respuesta.write( "                  <th>Nombre Inversionista</th>\r\n" );
        respuesta.write( "                  <th>Email Inversionista</th>\r\n" );
        respuesta.write( "                  <th>Nacionalidad</th>              \r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
        respuesta.write( "                <tr>\r\n" );
       try {
               ResultSet rta4 = Consultas.buscarInversionistasDeIntermediario(x, intermediario);
              
                        while(rta4.next())
                        {
                          
                                       respuesta.write( "                  <td>"+intermediario+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta4.getString("NOMBRE")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta4.getString("VECES")+"</td>\r\n" );
                                     respuesta.write( "                    <td>"+rta4.getString("NACIONALIDAD")+"</td>\r\n" );
                                 
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                        }
                        rta4.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "      </div>\r\n" );
        respuesta.write( "    </div>\r\n" );
        respuesta.write( "    <!-- Bootstrap core JavaScript\r\n" );
        respuesta.write( "    ================================================== -->\r\n" );
        respuesta.write( "    <!-- Placed at the end of the document so the pages load faster -->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/jquery.min.js\"></script>\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/bootstrap.min.js\"></script>\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/docs.min.js\"></script>\r\n" );
        respuesta.write( "    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js\"></script>\r\n" );
        respuesta.write( "  \r\n" );
        respuesta.write( "<div id=\"global-zeroclipboard-html-bridge\" class=\"global-zeroclipboard-container\" style=\"position: absolute; left: 0px; top: -9999px; width: 15px; height: 15px; z-index: 999999999;\" title=\"\" data-original-title=\"Copy to clipboard\">      <object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" id=\"global-zeroclipboard-flash-bridge\" width=\"100%\" height=\"100%\">         <param name=\"movie\" value=\"/assets/flash/ZeroClipboard.swf?noCache=1410465793904\">         <param name=\"allowScriptAccess\" value=\"sameDomain\">         <param name=\"scale\" value=\"exactfit\">         <param name=\"loop\" value=\"false\">         <param name=\"menu\" value=\"false\">         <param name=\"quality\" value=\"best\">         <param name=\"bgcolor\" value=\"#ffffff\">         <param name=\"wmode\" value=\"transparent\">         <param name=\"flashvars\" value=\"trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com\">         <embed src=\"/assets/flash/ZeroClipboard.swf?noCache=1410465793904\" loop=\"false\" menu=\"false\" quality=\"best\" bgcolor=\"#ffffff\" width=\"100%\" height=\"100%\" name=\"global-zeroclipboard-flash-bridge\" allowscriptaccess=\"sameDomain\" allowfullscreen=\"false\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" flashvars=\"trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com\" scale=\"exactfit\">                </object></div></body></html>\r\n" );


        
    }   
    
    
    
     public  void imprimirhtmlOferente(PrintWriter respuesta , conexionDB x , String oferente)
    {
        
        
        
        
        
        respuesta.write( "<!DOCTYPE html>\r\n" );
        respuesta.write( "<!-- saved from url=(0044)http://getbootstrap.com/examples/dashboard/? -->\r\n" );
        respuesta.write( "<html lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" );
        respuesta.write( "    <meta charset=\"utf-8\">\r\n" );
        respuesta.write( "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" );
        respuesta.write( "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" );
        respuesta.write( "    <meta name=\"description\" content=\"\">\r\n" );
        respuesta.write( "    <meta name=\"author\" content=\"\">\r\n" );
        respuesta.write( "    <link rel=\"icon\" href=\"http://getbootstrap.com/favicon.ico\">\r\n" );
        respuesta.write( "    <title>ValorAndes</title>\r\n" );
        respuesta.write( "    <!-- Bootstrap core CSS -->\r\n" );
        respuesta.write( "    <link href=\"http://getbootstrap.com/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" );
        respuesta.write( "    <!-- Custom styles for this template -->\r\n" );
        respuesta.write( "    <link href=\"http://getbootstrap.com/examples/dashboard/dashboard.css\" rel=\"stylesheet\">\r\n" );
        respuesta.write( "    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\r\n" );
        respuesta.write( "    <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js\"></script>\r\n" );
        respuesta.write( "    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n" );
        respuesta.write( "    <!--[if lt IE 9]>\r\n" );
        respuesta.write( "      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n" );
        respuesta.write( "      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n" );
        respuesta.write( "    <![endif]-->\r\n" );
        respuesta.write( "  <style id=\"holderjs-style\" type=\"text/css\"></style><style type=\"text/css\"></style></head>\r\n" );
        respuesta.write( "  <body>\r\n" );
        respuesta.write( "    <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n" );
        respuesta.write( "      <div class=\"container-fluid\">\r\n" );
        respuesta.write( "        <div class=\"navbar-header\">\r\n" );
        respuesta.write( "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n" );
        respuesta.write( "            <span class=\"sr-only\">Toggle navigation</span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "          </button>\r\n" );
        respuesta.write( "          <a class=\"navbar-brand\" href=\"http://getbootstrap.com/examples/dashboard/?#\">ValorAndes</a>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "        <div class=\"navbar-collapse collapse\">\r\n" );
        respuesta.write( "          <ul class=\"nav navbar-nav navbar-right\">\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 1</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 2</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 3</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 4</a></li>\r\n" );
        respuesta.write( "<li class=\"dropdown\">\r\n" );
        respuesta.write( "        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opción 5 <b class=\"caret\"></b></a>\r\n" );
        respuesta.write( "        <ul class=\"dropdown-menu\">\r\n" );
        respuesta.write( "          <li><a href=\"#\">Action</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Another action</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Something else here</a></li>\r\n" );
        respuesta.write( "          <li class=\"divider\"></li>\r\n" );
        respuesta.write( "          <li class=\"dropdown-header\">Dropdown header</li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Separated link</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">One more separated link</a></li>\r\n" );
        respuesta.write( "        </ul>\r\n" );
        respuesta.write( "      </li>\r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          <form class=\"navbar-form navbar-right\">\r\n" );
        respuesta.write( "            <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\r\n" );
        respuesta.write( "          </form>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "      </div>\r\n" );
        respuesta.write( "    </div>\r\n" );
        respuesta.write( "    <div class=\"container-fluid\">\r\n" );
        respuesta.write( "      <div class=\"row\">\r\n" );
        respuesta.write( "        <div class=\"col-sm-3 col-md-2 sidebar\">\r\n" );
        respuesta.write( "         <ul class=\"nav nav-sidebar\">\r\n" );
        respuesta.write( "              <li ><a href=\"./ordenarOperacionPrim.htm\">Ordenar operación primaria</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./ordenarOperacionSec.htm\">Ordenar operación secundaria</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación </a></li>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
        respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./portafolios.htm\">Portafolios</a></li>\r\n" );
        respuesta.write( "            <li ><a href=\"./eliminarInversionista.htm\">Eliminar Intermediario</a></li>\r\n" );
        respuesta.write( "              <li class=\"active\"><a href=\"./consultasIte3.htm\">Consultas</a></li>\r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
        respuesta.write( "          <h1 class=\"page-header\">Oferente</h1>\r\n" );
        respuesta.write( "          <div class=\"row placeholders\">\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );   
        
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "          </div>\r\n" );
   
        respuesta.write( "          <h2 class=\"sub-header\">Valores  </h2>\r\n" );
            respuesta.write( "          <br>\r\n" );
        respuesta.write( "          <div class=\"table-responsive\">\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );       
        respuesta.write( "                  <th>Email Oferente</th>\r\n" );
        respuesta.write( "                  <th>Email Intermediario</th>\r\n" );
        respuesta.write( "                  <th>Nit</th>\r\n" );
        respuesta.write( "                  <th>Cantidad</th>\r\n" );
        respuesta.write( "                  <th>Precio por accion</th>\r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        
        
        ResultSet rta = Consultas.darValoresOFerentes(x, oferente);
        
                    try {
                        while(rta.next())
                        {
                          
                                respuesta.write( "                  <td>"+rta.getString("EMAIL_OFERENTE")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("EMAIL_INTERMEDIARIO")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("NIT_VALOR")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("CANTIDAD")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("PRECIO_UNIDAD")+"</td>\r\n" );
                                 respuesta.write( "                </tr>\r\n" );
                                 respuesta.write( "                \r\n" );
                        }
                        rta.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        
        
        
        
        
        
        
        
        
        
        
     
    
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "          <br>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "       \r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "      </div>\r\n" );
        respuesta.write( "    </div>\r\n" );
        respuesta.write( "    <!-- Bootstrap core JavaScript\r\n" );
        respuesta.write( "    ================================================== -->\r\n" );
        respuesta.write( "    <!-- Placed at the end of the document so the pages load faster -->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/jquery.min.js\"></script>\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/bootstrap.min.js\"></script>\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/docs.min.js\"></script>\r\n" );
        respuesta.write( "    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js\"></script>\r\n" );
        respuesta.write( "  \r\n" );
        respuesta.write( "<div id=\"global-zeroclipboard-html-bridge\" class=\"global-zeroclipboard-container\" style=\"position: absolute; left: 0px; top: -9999px; width: 15px; height: 15px; z-index: 999999999;\" title=\"\" data-original-title=\"Copy to clipboard\">      <object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" id=\"global-zeroclipboard-flash-bridge\" width=\"100%\" height=\"100%\">         <param name=\"movie\" value=\"/assets/flash/ZeroClipboard.swf?noCache=1410465793904\">         <param name=\"allowScriptAccess\" value=\"sameDomain\">         <param name=\"scale\" value=\"exactfit\">         <param name=\"loop\" value=\"false\">         <param name=\"menu\" value=\"false\">         <param name=\"quality\" value=\"best\">         <param name=\"bgcolor\" value=\"#ffffff\">         <param name=\"wmode\" value=\"transparent\">         <param name=\"flashvars\" value=\"trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com\">         <embed src=\"/assets/flash/ZeroClipboard.swf?noCache=1410465793904\" loop=\"false\" menu=\"false\" quality=\"best\" bgcolor=\"#ffffff\" width=\"100%\" height=\"100%\" name=\"global-zeroclipboard-flash-bridge\" allowscriptaccess=\"sameDomain\" allowfullscreen=\"false\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" flashvars=\"trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com\" scale=\"exactfit\">                </object></div></body></html>\r\n" );



    
        
    }   
     
     
     
     
      public  void imprimirhtmlInversionista(PrintWriter respuesta , conexionDB x , String inversionista)
    {
        
    
        
        
        
        respuesta.write( "<!DOCTYPE html>\r\n" );
        respuesta.write( "<!-- saved from url=(0044)http://getbootstrap.com/examples/dashboard/? -->\r\n" );
        respuesta.write( "<html lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" );
        respuesta.write( "    <meta charset=\"utf-8\">\r\n" );
        respuesta.write( "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" );
        respuesta.write( "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" );
        respuesta.write( "    <meta name=\"description\" content=\"\">\r\n" );
        respuesta.write( "    <meta name=\"author\" content=\"\">\r\n" );
        respuesta.write( "    <link rel=\"icon\" href=\"http://getbootstrap.com/favicon.ico\">\r\n" );
        respuesta.write( "    <title>ValorAndes</title>\r\n" );
        respuesta.write( "    <!-- Bootstrap core CSS -->\r\n" );
        respuesta.write( "    <link href=\"http://getbootstrap.com/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" );
        respuesta.write( "    <!-- Custom styles for this template -->\r\n" );
        respuesta.write( "    <link href=\"http://getbootstrap.com/examples/dashboard/dashboard.css\" rel=\"stylesheet\">\r\n" );
        respuesta.write( "    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\r\n" );
        respuesta.write( "    <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js\"></script>\r\n" );
        respuesta.write( "    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n" );
        respuesta.write( "    <!--[if lt IE 9]>\r\n" );
        respuesta.write( "      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n" );
        respuesta.write( "      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n" );
        respuesta.write( "    <![endif]-->\r\n" );
        respuesta.write( "  <style id=\"holderjs-style\" type=\"text/css\"></style><style type=\"text/css\"></style></head>\r\n" );
        respuesta.write( "  <body>\r\n" );
        respuesta.write( "    <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n" );
        respuesta.write( "      <div class=\"container-fluid\">\r\n" );
        respuesta.write( "        <div class=\"navbar-header\">\r\n" );
        respuesta.write( "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n" );
        respuesta.write( "            <span class=\"sr-only\">Toggle navigation</span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "            <span class=\"icon-bar\"></span>\r\n" );
        respuesta.write( "          </button>\r\n" );
        respuesta.write( "          <a class=\"navbar-brand\" href=\"http://getbootstrap.com/examples/dashboard/?#\">ValorAndes</a>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "        <div class=\"navbar-collapse collapse\">\r\n" );
        respuesta.write( "          <ul class=\"nav navbar-nav navbar-right\">\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 1</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 2</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 3</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"http://getbootstrap.com/examples/dashboard/?#\">Opción 4</a></li>\r\n" );
        respuesta.write( "<li class=\"dropdown\">\r\n" );
        respuesta.write( "        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opción 5 <b class=\"caret\"></b></a>\r\n" );
        respuesta.write( "        <ul class=\"dropdown-menu\">\r\n" );
        respuesta.write( "          <li><a href=\"#\">Action</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Another action</a></li>\r\n" );
     
        respuesta.write( "          <li class=\"divider\"></li>\r\n" );
        respuesta.write( "          <li class=\"dropdown-header\">Dropdown header</li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">Separated link</a></li>\r\n" );
        respuesta.write( "          <li><a href=\"#\">One more separated link</a></li>\r\n" );
        respuesta.write( "        </ul>\r\n" );
        respuesta.write( "      </li>\r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          <form class=\"navbar-form navbar-right\">\r\n" );
        respuesta.write( "            <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\r\n" );
        respuesta.write( "          </form>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "      </div>\r\n" );
        respuesta.write( "    </div>\r\n" );
        respuesta.write( "    <div class=\"container-fluid\">\r\n" );
        respuesta.write( "      <div class=\"row\">\r\n" );
        respuesta.write( "        <div class=\"col-sm-3 col-md-2 sidebar\">\r\n" );
        respuesta.write( "         <ul class=\"nav nav-sidebar\">\r\n" );
        respuesta.write( "              <li ><a href=\"./ordenarOperacionPrim.htm\">Ordenar operación primaria</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./ordenarOperacionSec.htm\">Ordenar operación secundaria</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación </a></li>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
        respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
        respuesta.write( "            <li><a href=\"./portafolios.htm\">Portafolios</a></li>\r\n" );
        respuesta.write( "            <li ><a href=\"./eliminarInversionista.htm\">Eliminar Intermediario</a></li>\r\n" );
        respuesta.write( "              <li class=\"active\"><a href=\"./consultasIte3.htm\">Consultas</a></li>\r\n" );
        respuesta.write( "          </ul>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
        respuesta.write( "          <h1 class=\"page-header\">Inversionista</h1>\r\n" );
        respuesta.write( "          <div class=\"row placeholders\">\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
      
     ;
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
      
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
      
       
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "            <div class=\"col-xs-6 col-sm-3 placeholder\">\r\n" );
     
        respuesta.write( "            </div>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "          \r\n" );
        respuesta.write( "          \r\n" );
       
       
        respuesta.write( "          <h2 class=\"sub-header\">Valores</h2>\r\n" );
        respuesta.write( "          <div class=\"table-responsive\">\r\n" );
        respuesta.write( "            <table class=\"table table-striped\">\r\n" );
        respuesta.write( "              <thead>\r\n" );
        respuesta.write( "                <tr>\r\n" );
        respuesta.write( "                  <th>Email Inversionista</th>\r\n" );
        respuesta.write( "                  <th>Nit</th>\r\n" );
        respuesta.write( "                  <th>Nombre de Valor</th>\r\n" );
        respuesta.write( "                  <th>Cantidad</th> \r\n" );
        respuesta.write( "                  <th>Portafolio</th>\r\n" );
        respuesta.write( "                </tr>\r\n" );
        respuesta.write( "              </thead>\r\n" );
        respuesta.write( "              <tbody>\r\n" );
         respuesta.write( "                <tr>\r\n" );
        
        
          ResultSet rta = Consultas.buscarValoresDeInversionistas(x, inversionista);
        
                    try {
                        while(rta.next())
                        {
                          
                                respuesta.write( "                  <td>"+rta.getString("EMAIL")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("NIT_VALOR")+"</td>\r\n" );
                                  respuesta.write( "                  <td>"+rta.getString("NOM_VALOR")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("CANTIDAD")+"</td>\r\n" );
                                respuesta.write( "                  <td>"+rta.getString("TIPO_PORTAFOLIO")+"</td>\r\n" );
                                 respuesta.write( "                </tr>\r\n" );
                                 respuesta.write( "                \r\n" );
                        }
                        rta.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        respuesta.write( "              </tbody>\r\n" );
        respuesta.write( "            </table>\r\n" );
        respuesta.write( "          </div>\r\n" );
        respuesta.write( "        </div>\r\n" );
        respuesta.write( "      </div>\r\n" );
        respuesta.write( "    </div>\r\n" );
        respuesta.write( "    <!-- Bootstrap core JavaScript\r\n" );
        respuesta.write( "    ================================================== -->\r\n" );
        respuesta.write( "    <!-- Placed at the end of the document so the pages load faster -->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/jquery.min.js\"></script>\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/bootstrap.min.js\"></script>\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/docs.min.js\"></script>\r\n" );
        respuesta.write( "    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n" );
        respuesta.write( "    <script src=\"./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js\"></script>\r\n" );
        respuesta.write( "  \r\n" );
        respuesta.write( "<div id=\"global-zeroclipboard-html-bridge\" class=\"global-zeroclipboard-container\" style=\"position: absolute; left: 0px; top: -9999px; width: 15px; height: 15px; z-index: 999999999;\" title=\"\" data-original-title=\"Copy to clipboard\">      <object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" id=\"global-zeroclipboard-flash-bridge\" width=\"100%\" height=\"100%\">         <param name=\"movie\" value=\"/assets/flash/ZeroClipboard.swf?noCache=1410465793904\">         <param name=\"allowScriptAccess\" value=\"sameDomain\">         <param name=\"scale\" value=\"exactfit\">         <param name=\"loop\" value=\"false\">         <param name=\"menu\" value=\"false\">         <param name=\"quality\" value=\"best\">         <param name=\"bgcolor\" value=\"#ffffff\">         <param name=\"wmode\" value=\"transparent\">         <param name=\"flashvars\" value=\"trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com\">         <embed src=\"/assets/flash/ZeroClipboard.swf?noCache=1410465793904\" loop=\"false\" menu=\"false\" quality=\"best\" bgcolor=\"#ffffff\" width=\"100%\" height=\"100%\" name=\"global-zeroclipboard-flash-bridge\" allowscriptaccess=\"sameDomain\" allowfullscreen=\"false\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" flashvars=\"trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com\" scale=\"exactfit\">                </object></div></body></html>\r\n" );

        
        
        
        
        
        
    }   
           
         
    
    
    
    
}
