/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Colas.Colas;
import ConsultaDAO.Consultas;
import Fachada.conexionDB;
import VOS.ValoresDeInversionistas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GLORIA AZUCENA
 */
public class ServletConsultasIt4 extends  HttpServlet{
    
    
    private ResultSet paginado;
    
		protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
	      
			 String estilo = request.getParameter( "id" );
                
                  //atributos de consultar valores 2 
                       
                         String nitConsultarValores2 = request.getParameter( "nitConsultarValores2" );
                          String tipoValorConsultarValores2 = request.getParameter( "tipoValorConsultarValores2" );
                          
                          
                  // atributos consultar portafolios
                          
                          String tipoValorConsultarPortafolios = request.getParameter( "tipoValorConsultarPortafolios" );
                            String valorConsultarPortafolios = request.getParameter( "valorConsultarPortafolios" );
                         
                         
                         
                  //atributos consultar movimientos de valores 1
                            
                            
                         String fechaInferiorMovimiento1 = request.getParameter( "fechaInferiorMovimiento1" );
                            String fechaSuperiorMovimiento1 = request.getParameter( "fechaSuperiorMovimiento1" );
                             String tipoRentabilidadMovimiento1 = request.getParameter( "tipoRentabilidadMovimiento1" );
                            String tipoValorMovimiento1 = request.getParameter( "tipoValorMovimiento1" );
                               String ValorMovimiento1 = request.getParameter( "valorMovimientos1" );
                                String emailMovimiento1 = request.getParameter( "emailMovimientos1" );
                            
                            
                  //atributos consultar movimientos de valores 2
                            
                            
                            String fechaInferiorMovimiento2 = request.getParameter( "fechaInferiorMovimiento2" );
                            String fechaSuperiorMovimiento2 = request.getParameter( "fechaSuperiorMovimiento2" );
                            String tipoRentabilidadMovimiento2 = request.getParameter( "tipoRentabilidadMovimiento2" );
                            String tipoValorMovimiento2 = request.getParameter( "tipoValorMovimiento2" );
                              String ValorMovimiento2 = request.getParameter( "valorMovimientos2" );
                              String emailMovimiento2 = request.getParameter( "emailMovimientos2" );
                         
                         
                //atributos consultar movimientos dinamicos 
                              
                           String fechaInferiorDinamico = request.getParameter( "fechaInferiorDinamicos" );
                            String fechaSuperiorDinamico = request.getParameter( "fechaSuperiorDinamicos" );
                            
                            
                            // atributos recomponer portafolios
                            
                            String emailRecomponerPortafolio = request.getParameter("emailRecomponer");
                            String nitRecomponerPortafolios = request.getParameter("nitRecomponerPortafolios");
                            String nombreValor = request.getParameter("valorRecomponer");
                            String portafolio = request.getParameter("portafolioRecomponer");
                             String nitNuevoRecomponer = request.getParameter("nitRecomponerPortafoliosNuevo");
                               String valorNuevoRecomponer = request.getParameter("valorRecomponerNuevo");
                            
               
                              
                              // atributos  retirar intermediario
                            
                            String emailRetirar = request.getParameter("emailRetirar");
                            
                            //atributos Movimientos
                            
                            String nomValorMovimientos = request.getParameter("valorMovimientos");
                            
                            String rentabilidadMovimientos = request.getParameter("rentabilidadMovimientos");
                            
                            String emailMovimientos = request.getParameter("emailMovimientos");
                            
                            String fechaInferiorMovimientos = request.getParameter("fechaInferiorMovimientos");
                            
                            String fechaSuperiorMovimientos = request.getParameter("fechaSuperiorMovimientos");
                              
                    
                  //metodos   
                            
                            
                              PrintWriter respuesta = response.getWriter() ;
                            conexionDB x = new conexionDB();
                            
                            
                            if(estilo!=null)
                            {
                                paginadoConsultarValores2(x, respuesta);
                            }
                            
                         
                            else   if(valorConsultarPortafolios !=null && tipoValorConsultarPortafolios!=null){
                             try {
                                 if( Consultas.darGuardado()!=null)
                                 Consultas.darGuardado().close();
                                 consultarPortafolios(x,respuesta,tipoValorConsultarPortafolios,valorConsultarPortafolios);
                             } catch (SQLException ex) {
                                 Logger.getLogger(ServletConsultasIt4.class.getName()).log(Level.SEVERE, null, ex);
                             }
                      }   
                      
                      else  if(nitConsultarValores2 !=null && tipoValorConsultarValores2!=null){
                          
                             try {
                                 if( Consultas.darGuardado()!=null)
                                 Consultas.darGuardado().close();
                             } catch (SQLException ex) {
                                 Logger.getLogger(ServletConsultasIt4.class.getName()).log(Level.SEVERE, null, ex);
                             }
                          consultarValores2(x,respuesta,tipoValorConsultarValores2 , nitConsultarValores2);
                      } 
                      
                     else if(fechaInferiorMovimiento1 != null && fechaSuperiorMovimiento1!=null){
                             try {
                                 if( Consultas.darGuardado()!=null)
                                 Consultas.darGuardado().close();
                             } catch (SQLException ex) {
                                 Logger.getLogger(ServletConsultasIt4.class.getName()).log(Level.SEVERE, null, ex);
                             }
                          imprimirhtmlConsultarMovimientosDeValores1(x,respuesta,fechaInferiorMovimiento1,fechaSuperiorMovimiento1 , tipoValorMovimiento1,ValorMovimiento1,tipoRentabilidadMovimiento1,emailMovimiento1);
                      } 
                      
                    else if(fechaSuperiorMovimiento2!=null && fechaInferiorMovimiento2!=null){
                             try { 
                                 if( Consultas.darGuardado()!=null)
                                 Consultas.darGuardado().close();
                             } catch (SQLException ex) {
                                 Logger.getLogger(ServletConsultasIt4.class.getName()).log(Level.SEVERE, null, ex);
                             }
                        imprimirhtmlConsultarMovimientosDeValores2(x,respuesta,fechaInferiorMovimiento2,fechaSuperiorMovimiento2 , tipoValorMovimiento2,ValorMovimiento2,tipoRentabilidadMovimiento2,emailMovimiento2);
                      }
                    
                    else if(fechaInferiorDinamico!=null && fechaSuperiorDinamico!=null){
                             try { 
                                 if( Consultas.darGuardado()!=null)
                                 Consultas.darGuardado().close();
                             } catch (SQLException ex) {
                                 Logger.getLogger(ServletConsultasIt4.class.getName()).log(Level.SEVERE, null, ex);
                             }
                        imprimirHtmlDinamico(x,respuesta,fechaInferiorDinamico,fechaSuperiorDinamico);
                      }  
                    
                    else if(fechaInferiorDinamico!=null && fechaSuperiorDinamico!=null)
                    {
                        imprimirHtmlDinamico(x, respuesta, fechaInferiorDinamico, fechaSuperiorDinamico);
                        
                    }
                    
                    else if (emailRetirar!=null)
                    {
                        imprimirhtmlEliminarIntermediario(x, respuesta, emailRetirar);
                    }
                    
                    else if (fechaInferiorMovimientos!=null && fechaSuperiorMovimientos!=null)
                    {
                        imprimirHtmlMovimientos(x, respuesta, nomValorMovimientos,rentabilidadMovimientos, emailMovimientos, fechaSuperiorMovimientos, fechaInferiorMovimientos);
                    }
                        
                    
                         
                    else{
                             try {
                                 if( Consultas.darGuardado()!=null)
                                 Consultas.darGuardado().close();
                                 imprimirError(respuesta);
                             } catch (SQLException ex) {
                                 Logger.getLogger(ServletConsultasIt4.class.getName()).log(Level.SEVERE, null, ex);
                             }
                    }
            
	    }
		/**
	     * Maneja un pedido POST de un cliente
	     * @param request Pedido del cliente
	     * @param response Respuesta
	     */
	    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
                
                 
	    	
	    }
            
            
            
            private void imprimirHtmlMovimientos(conexionDB x , PrintWriter respuesta , String nomValor , String rentabilidad , String emailComprador,String fechaSuperior , String fechaInferior)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Valores Mas Dinamicos</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );


 Colas cola = Colas.darInstancia() ; 
              
            ArrayList lista =   cola.consultarMovimiento(nomValor, Integer.parseInt(rentabilidad), emailComprador, fechaInferior, fechaSuperior);
            
            for(int i = 0 ; i<lista.size() ; i++)
            {
                ValoresDeInversionistas actual = (ValoresDeInversionistas) lista.get(i);
                
                respuesta.write(actual.getEmail());
                
                
                respuesta.write(actual.getNitValor());
                
                
            }



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
            
         public void imprimirhtmlEliminarIntermediario(conexionDB x , PrintWriter respuesta , String correoELiminar)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Valores Mas Dinamicos</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );


  Colas  estilo = Colas.darInstancia() ; 
            
           respuesta.write( estilo.retirarIntermediario(correoELiminar));

            



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
            
            
             private void imprimirhtmlConsultarMovimientosDeValores1(conexionDB x ,PrintWriter respuesta ,String fecha1,String fecha2 , String nomValor,String precioUnidad,String TipoRentabilidad, String email)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li ><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Movimiento de Valores 1</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );
respuesta.write( "            <table class=\"table table-striped\">\r\n" );
respuesta.write( "              <thead>\r\n" );
respuesta.write( "                <tr>\r\n" );
respuesta.write( "                  <th>Numero</th>\r\n" );
respuesta.write( "                  <th>Intermediario</th>\r\n" );
respuesta.write( "                  <th>Valor</th>\r\n" );
respuesta.write( "                  <th>Tipo de Valor</th>\r\n" );
respuesta.write( "                  <th>Tipo de Rentabilidad</th>\r\n" );
respuesta.write( "                  <th>Fecha</th>\r\n" );



try {
               ResultSet rta1 = Consultas.consultarMovimientosDeValores1(x, fecha1, fecha2, nomValor, precioUnidad, TipoRentabilidad, email);
              
               int numero =0 ;
               
                        while(numero<30 && rta1.next())
                        {
                          respuesta.write( "                <tr>\r\n" );
                         
                                     respuesta.write( "                  <td>"+rta1.getRow()+"</td>\r\n" );
                                        respuesta.write( "                  <td>"+rta1.getString("EMAIL_INTER_COM")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("PRECIO_UNIDAD")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta1.getString("NOM_VALOR")+"</td>\r\n" );
                                    String portafolio  =rta1.getString("TIPO_RENTABILIDAD");
                                    if(portafolio.equals("1")){respuesta.write( "                     <td> Renta fija termino fijo</td>\r\n" );}
                                    else if (portafolio.equals("2")){respuesta.write( "                     <td> Renta fija termino indefinido</td>\r\n" );}
                                      else if (portafolio.equals("3")){respuesta.write( "                     <td> Renta variable termino fijo </td>\r\n" );}
                                        else if (portafolio.equals("4")){respuesta.write( "                     <td> Renta variable  termino indefinido</td>\r\n" );}
                                      else if(portafolio.equals("")){respuesta.write( "                     <td> Ninguno </td>\r\n" );}
                                     respuesta.write( "                    <td>"+rta1.getString("FECHA")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                                    
                                     numero++ ;
                        }
                       if(numero>28)
                            {
                                 respuesta.write(" <form role=\"form\" action=\"ServletConsultasIt4.htm\" method=\"get\">");
                                  respuesta.write("<input type=\"hidden\" value=estilo name=\"id\"/>");
                                    Consultas.cambiarguardado(rta1);
                           respuesta.write( "                    <button type=\"submit\" class=\"btn btn-default\">Siguiente Pag</button>   " );
                            respuesta.write("</form>");
                            }
                        else{
                             rta1.close();
                        }
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
              private void imprimirhtmlConsultarMovimientosDeValores2(conexionDB x ,PrintWriter respuesta  ,String fecha1,String fecha2 , String nomValor,String precioUnidad,String TipoRentabilidad, String email)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li ><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Movomiento de valores 2</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );
respuesta.write( "            <table class=\"table table-striped\">\r\n" );
respuesta.write( "              <thead>\r\n" );
respuesta.write( "                <tr>\r\n" );
respuesta.write( "                  <th>Numero</th>\r\n" );
respuesta.write( "                  <th>Intermediario</th>\r\n" );
respuesta.write( "                  <th>Valor</th>\r\n" );
respuesta.write( "                  <th>Tipo de Valor</th>\r\n" );
respuesta.write( "                  <th>Tipo de Rentabilidad</th>\r\n" );
respuesta.write( "                  <th>Fecha</th>\r\n" );




 
try {
               ResultSet rta1 = Consultas.consultarMovimientosDeValores2(x, fecha1, fecha2, nomValor, precioUnidad, TipoRentabilidad, email);
              
               int numero =0 ;
               
                        while(numero<30 && rta1.next())
                        {
                          respuesta.write( "                <tr>\r\n" );
                                     respuesta.write( "                  <td>"+rta1.getRow()+"</td>\r\n" );
                                        respuesta.write( "                  <td>"+rta1.getString("EMAIL_INTER_COM")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("PRECIO_UNIDAD")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta1.getString("NOM_VALOR")+"</td>\r\n" );
                                    String portafolio  =rta1.getString("TIPO_RENTABILIDAD");
                                    if(portafolio.equals("1")){respuesta.write( "                     <td> Renta fija termino fijo</td>\r\n" );}
                                    else if (portafolio.equals("2")){respuesta.write( "                     <td> Renta fija termino indefinido</td>\r\n" );}
                                      else if (portafolio.equals("3")){respuesta.write( "                     <td> Renta variable termino fijo </td>\r\n" );}
                                        else if (portafolio.equals("4")){respuesta.write( "                     <td> Renta variable  termino indefinido</td>\r\n" );}
                                      else if(portafolio.equals("")){respuesta.write( "                     <td> Ninguno </td>\r\n" );}
                                     respuesta.write( "                    <td>"+rta1.getString("FECHA")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                                    
                                     numero++ ;
                        }
                       
                         if(numero>28)
                            {
                                 respuesta.write(" <form role=\"form\" action=\"ServletConsultasIt4.htm\" method=\"get\">");
                                  respuesta.write("<input type=\"hidden\" value=estilo name=\"id\"/>");
                                    Consultas.cambiarguardado(rta1);
                           respuesta.write( "                    <button type=\"submit\" class=\"btn btn-default\">Siguiente Pag</button>   " );
                            respuesta.write("</form>");
                            }
                        else{
                             rta1.close();
                        }
                        
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
               private void consultarPortafolios(conexionDB x ,PrintWriter respuesta ,String nomValor,String precio )
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Portafolio</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );
respuesta.write( "            <table class=\"table table-striped\">\r\n" );
respuesta.write( "              <thead>\r\n" );
respuesta.write( "                <tr>\r\n" );
respuesta.write( "                  <th>Numero</th>\r\n" );
respuesta.write( "                  <th>Email</th>\r\n" );
respuesta.write( "                  <th>Valor</th>\r\n" );
respuesta.write( "                  <th>Tipo de Valor</th>\r\n" );
respuesta.write( "                  <th>Portafolio</th>\r\n" );




try {
               ResultSet rta1 = Consultas.consultaPortafolios(x, nomValor, precio);
              
               int numero =0 ;
               
                        while(numero<30 && rta1.next())
                        {
                          respuesta.write( "                <tr>\r\n" );
                          respuesta.write( "                  <td>"+rta1.getRow()+"</td>\r\n" );
                                        respuesta.write( "                  <td>"+rta1.getString("EMAIL_COM")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("PRECIO_UNIDAD")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta1.getString("NOM_VALOR")+"</td>\r\n" );
                                    String portafolio  =rta1.getString("PORTAFOLIO");
                                    if(portafolio.equals("1")){respuesta.write( "                     <td> Alto</td>\r\n" );}
                                    else if (portafolio.equals("2")){respuesta.write( "                     <td> Medio </td>\r\n" );}
                                      else if (portafolio.equals("3")){respuesta.write( "                     <td> Bajo  </td>\r\n" );}
                                      else if(portafolio.equals("")){respuesta.write( "                     <td> Ninguno </td>\r\n" );}
                                    
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                                    
                                     numero++ ;
                        }
                       
                        
                          if(numero>28)
                            {
                                 respuesta.write(" <form role=\"form\" action=\"ServletConsultasIt4.htm\" method=\"get\">");
                                  respuesta.write("<input type=\"hidden\" value=estilo name=\"id\"/>");
                                    Consultas.cambiarguardado(rta1);
                           respuesta.write( "                    <button type=\"submit\" class=\"btn btn-default\">Siguiente Pag</button>   " );
                            respuesta.write("</form>");
                            }
                        else{
                             rta1.close();
                        }
                        
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
                private void consultarValores2(conexionDB x ,PrintWriter respuesta,String nomValor , String nit_valor )
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Valores 2</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );
respuesta.write( "            <table class=\"table table-striped\">\r\n" );
respuesta.write( "              <thead>\r\n" );
respuesta.write( "                <tr>\r\n" );
respuesta.write( "                  <th>Numero</th>\r\n" );
respuesta.write( "                  <th>Email</th>\r\n" );
respuesta.write( "                  <th>Nit</th>\r\n" );
respuesta.write( "                  <th>Tipo de Valor</th>\r\n" );
respuesta.write( "                  <th>Cantidad</th>\r\n" );
respuesta.write( "                  <th>Portafolio</th>\r\n" );


  try {
               ResultSet rta1 = Consultas.consultarValores2(x, nomValor, nit_valor);
              
               int numero =0 ;
               
                        while(numero<30 && rta1.next()  )
                        {
                            respuesta.write( "                <tr>\r\n" );
                                respuesta.write( "                  <td>"+rta1.getRow()+"</td>\r\n" );
                                        respuesta.write( "                  <td>"+rta1.getString("EMAIL_COM")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("NIT_VALOR")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta1.getString("NOM_VALOR")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta1.getString("CANTIDAD")+"</td>\r\n" );
                                              respuesta.write( "                     <td>"+rta1.getString("PORTAFOLIO")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                                    
                                     numero++ ;
                                     
                        }
                        
                       
                        
                        
                        if(numero>28)
                            {
                                 respuesta.write(" <form role=\"form\" action=\"ServletConsultasIt4.htm\" method=\"get\">");
                                  respuesta.write("<input type=\"hidden\" value=estilo name=\"id\"/>");
                                    Consultas.cambiarguardado(rta1);
                           respuesta.write( "                    <button type=\"submit\" class=\"btn btn-default\">Siguiente Pag</button>   " );
                            respuesta.write("</form>");
                            }
                        else{
                             rta1.close();
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
  
  
 


respuesta.write( "                </tr>\r\n" );

respuesta.write( "               \r\n" );
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
    
    
                private void imprimirError(PrintWriter respuesta)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Error No ingresaste los datos necesarios</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );

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
    
                
                
                 private void paginadoConsultarValores2(conexionDB x ,PrintWriter respuesta)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Valores 2</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );
respuesta.write( "            <table class=\"table table-striped\">\r\n" );
respuesta.write( "              <thead>\r\n" );
respuesta.write( "                <tr>\r\n" );
respuesta.write( "                  <th>Numero</th>\r\n" );
respuesta.write( "                  <th>Email</th>\r\n" );
respuesta.write( "                  <th>Nit</th>\r\n" );
respuesta.write( "                  <th>Tipo de Valor</th>\r\n" );
respuesta.write( "                  <th>Cantidad</th>\r\n" );
respuesta.write( "                  <th>Portafolio</th>\r\n" );


  try {
               ResultSet rta1 = Consultas.darGuardado() ;
              
               int numero =0 ;
               
                        while(rta1.next() && numero<30)
                        {
                          
                              respuesta.write( "                <tr>\r\n" );
                                     respuesta.write( "                  <td>"+rta1.getRow()+"</td>\r\n" );
                                        respuesta.write( "                  <td>"+rta1.getString("EMAIL_COM")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("NIT_VALOR")+"</td>\r\n" );
                                    respuesta.write( "                    <td>"+rta1.getString("NOM_VALOR")+"</td>\r\n" );
                                    respuesta.write( "                     <td>"+rta1.getString("CANTIDAD")+"</td>\r\n" );
                                              respuesta.write( "                     <td>"+rta1.getString("PORTAFOLIO")+"</td>\r\n" );
                                    respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                                    
                                     numero++ ;
                        }
                       
                        
                        
                        if(numero>28)
                            {
                                 respuesta.write(" <form role=\"form\" action=\"ServletConsultasIt4.htm\" method=\"get\">");
                                  respuesta.write("<input type=\"hidden\" value=estilo name=\"id\"/>");
                                      Consultas.cambiarguardado(rta1);
                           respuesta.write( "                    <button type=\"submit\" class=\"btn btn-default\">Siguiente Pag</button>   " );
                             respuesta.write("</form>");
                            }
                        else{
                             rta1.close();
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
  
  
 


respuesta.write( "                </tr>\r\n" );

respuesta.write( "               \r\n" );
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
    
                 private void imprimirHtmlDinamico(conexionDB x ,PrintWriter respuesta , String fechaInferir , String fechaSuperior)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Valores Mas Dinamicos</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );
respuesta.write( "            <table class=\"table table-striped\">\r\n" );
respuesta.write( "              <thead>\r\n" );
respuesta.write( "                <tr>\r\n" );
respuesta.write( "                  <th>Puesto</th>\r\n" );
respuesta.write( "                  <th>Cantidad de Operaicones</th>\r\n" );
respuesta.write( "                  <th>Nit</th>\r\n" );
respuesta.write( "                  <th>Valor</th>\r\n" );


  try {
      
      
       
      
      
      
               ResultSet rta1 = Consultas.darValoresDinamicos(x, fechaInferir, fechaSuperior);
              
               int numero =1 ;
               
                        while(numero<11 && rta1.next()  )
                        {
                            respuesta.write( "                <tr>\r\n" );
                                respuesta.write( "                  <td>"+rta1.getRow()+"</td>\r\n" );
                                        respuesta.write( "                  <td>"+rta1.getString("COUNT(*)")+"</td>\r\n" );
                                    respuesta.write( "                   <td>"+rta1.getString("NIT_VALOR")+"</td>\r\n" );
                                             respuesta.write( "                   <td>"+rta1.getString("NOM_VALOR")+"</td>\r\n" );
                                     respuesta.write( "                </tr>\r\n" );
                                    respuesta.write( "                \r\n" );
                                    
                                     numero++ ;
                                     
                        }
                        
                       
                        
                        
                        if(numero>30)
                            {
                                 respuesta.write(" <form role=\"form\" action=\"ServletConsultasIt4.htm\" method=\"get\">");
                                  respuesta.write("<input type=\"hidden\" value=estilo name=\"id\"/>");
                                    Consultas.cambiarguardado(rta1);
                           respuesta.write( "                    <button type=\"submit\" class=\"btn btn-default\">Siguiente Pag</button>   " );
                            respuesta.write("</form>");
                            }
                        else{
                             rta1.close();
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletConsultaIT3.class.getName()).log(Level.SEVERE, null, ex);
                    }
  
  
 


respuesta.write( "                </tr>\r\n" );

respuesta.write( "               \r\n" );
respuesta.write( "              </tbody>\r\n" );
respuesta.write( "            </table>\r\n" );

    
                    Colas  style =  Colas.darInstancia() ; 
                    
                  ArrayList lista =   style.valoresMasDinamicos(fechaInferir, fechaSuperior);

                    
                 
                      for(int i = 0 ; i<lista.size() ; i++)
            {
                ValoresDeInversionistas actual = (ValoresDeInversionistas) lista.get(i);
                
                respuesta.write(actual.getEmail());
                
                
                respuesta.write(actual.getNitValor());
                
                
            }


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
    
     
                 
                   
                            
                            public void imprimirMovimientos(conexionDB x , PrintWriter respuesta , String emailRecomponer , String nitRecomponerPortafolio, String valorRecomponer, String portafolioRecomponer , String nitRecomponerPortafolioNuevo , String valorRecomponerNuevo)
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
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./ordenarOperacion.htm\">Ordenar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./cancelarOperacion.htm\">Cancelar operación bursátil</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./registrarOperacion.htm\">Registrar operación bursátil</a></li>\r\n" );
respuesta.write( "           \r\n" );
respuesta.write( "          </ul>\r\n" );
respuesta.write( "          <ul class=\"nav nav-sidebar\">\r\n" );
respuesta.write( "            <li><a href=\"./consultarExistencia.htm\">Consultar existencia de valores</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarOperacion.htm\">Consultar operaciones de un usuario</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarValores.htm\">Consultar valores con mayor movimiento</a></li>\r\n" );
respuesta.write( "            <li><a href=\"./consultarIntermediario.htm\">Consultar intermedario mas activo</a></li>\r\n" );
respuesta.write( "            <li  class=\"active\"><a href=\"./consultasIt4.htm\">ConsultasIT 4</a></li>\r\n" );

respuesta.write( "          </ul>\r\n" );
respuesta.write( "          \r\n" );
respuesta.write( "        </div>\r\n" );
respuesta.write( "        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n" );
respuesta.write( "          <h1 class=\"page-header\">Consultar Valores Mas Dinamicos</h1>\r\n" );
respuesta.write( "          <div class=\"row placeholders\">\r\n" );
respuesta.write( "         \r\n" );
respuesta.write( "          </div>\r\n" );
respuesta.write( "          <h3 class=\"sub-header\">Operaciones</h3>\r\n" );
respuesta.write( "          <div class=\"table-responsive\">\r\n" );


 Colas cola = Colas.darInstancia() ; 
 
 ArrayList<ValoresDeInversionistas> listaa = new ArrayList();
 
 ValoresDeInversionistas nuevo = new ValoresDeInversionistas();
 nuevo.setNitValor(nitRecomponerPortafolioNuevo);
 nuevo.setNomValor(valorRecomponerNuevo);
 listaa.add(nuevo);
 
 
              String rta =    cola.recomponerPortafolio(valorRecomponer, Integer.parseInt(portafolioRecomponer), listaa);
 
              
           respuesta.write(rta);
            


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
