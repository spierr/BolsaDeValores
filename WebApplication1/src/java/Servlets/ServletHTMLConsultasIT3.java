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
        
  

        
        
        

                        conexionDB x = new conexionDB();
                      
        
        
        
                         
                         
                         
                         
                         
                         
                         
                         
                         respuesta.write( " <!DOCTYPE html> \r\n"); 
respuesta.write( " <!-- saved from url=(0044)http://getbootstrap.com/examples/dashboard/? --> \r\n"); 
respuesta.write( " <html lang=\" en\" ><head><meta http-equiv=\" Content-Type\"  content=\" text/html; charset=UTF-8\" > \r\n"); 
respuesta.write( "     <meta charset=\" utf-8\" > \r\n"); 
respuesta.write( "     <meta http-equiv=\" X-UA-Compatible\"  content=\" IE=edge\" > \r\n"); 
respuesta.write( "     <meta name=\" viewport\"  content=\" width=device-width, initial-scale=1\" > \r\n"); 
respuesta.write( "     <meta name=\" description\"  content=\" \" > \r\n"); 
respuesta.write( "     <meta name=\" author\"  content=\" \" > \r\n"); 
respuesta.write( "     <link rel=\" icon\"  href=\" http://getbootstrap.com/favicon.ico\" > \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <title>ValorAndes</title> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <!-- Bootstrap core CSS --> \r\n"); 
respuesta.write( "     <link href=\" http://getbootstrap.com/dist/css/bootstrap.min.css\"  rel=\" stylesheet\" > \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <!-- Custom styles for this template --> \r\n"); 
respuesta.write( "     <link href=\" http://getbootstrap.com/examples/dashboard/dashboard.css\"  rel=\" stylesheet\" > \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <!-- Just for debugging purposes. Don't actually copy these 2 lines! --> \r\n"); 
respuesta.write( "     <!--[if lt IE 9]><script src=\" ../../assets/js/ie8-responsive-file-warning.js\" ></script><![endif]--> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js\" ></script> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries --> \r\n"); 
respuesta.write( "     <!--[if lt IE 9]> \r\n"); 
respuesta.write( "       <script src=\" https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\" ></script> \r\n"); 
respuesta.write( "       <script src=\" https://oss.maxcdn.com/respond/1.4.2/respond.min.js\" ></script> \r\n"); 
respuesta.write( "     <![endif]--> \r\n"); 
respuesta.write( "   <style id=\" holderjs-style\"  type=\" text/css\" ></style><style type=\" text/css\" ></style></head> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "   <body> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <div class=\" navbar navbar-inverse navbar-fixed-top\"  role=\" navigation\" > \r\n"); 
respuesta.write( "       <div class=\" container-fluid\" > \r\n"); 
respuesta.write( "         <div class=\" navbar-header\" > \r\n"); 
respuesta.write( "           <button type=\" button\"  class=\" navbar-toggle collapsed\"  data-toggle=\" collapse\"  data-target=\" .navbar-collapse\" > \r\n"); 
respuesta.write( "             <span class=\" sr-only\" >Toggle navigation</span> \r\n"); 
respuesta.write( "             <span class=\" icon-bar\" ></span> \r\n"); 
respuesta.write( "             <span class=\" icon-bar\" ></span> \r\n"); 
respuesta.write( "             <span class=\" icon-bar\" ></span> \r\n"); 
respuesta.write( "           </button> \r\n"); 
respuesta.write( "           <a class=\" navbar-brand\"  href=\" http://getbootstrap.com/examples/dashboard/?#\" >ValorAndes</a> \r\n"); 
respuesta.write( "         </div> \r\n"); 
respuesta.write( "         <div class=\" navbar-collapse collapse\" > \r\n"); 
respuesta.write( "           <ul class=\" nav navbar-nav navbar-right\" > \r\n"); 
respuesta.write( "             <li><a href=\" http://getbootstrap.com/examples/dashboard/?#\" >Opción 1</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" http://getbootstrap.com/examples/dashboard/?#\" >Opción 2</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" http://getbootstrap.com/examples/dashboard/?#\" >Opción 3</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" http://getbootstrap.com/examples/dashboard/?#\" >Opción 4</a></li> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( " <li class=\" dropdown\" > \r\n"); 
respuesta.write( "         <a href=\" #\"  class=\" dropdown-toggle\"  data-toggle=\" dropdown\" >Opción 5 <b class=\" caret\" ></b></a> \r\n"); 
respuesta.write( "         <ul class=\" dropdown-menu\" > \r\n"); 
respuesta.write( "           <li><a href=\" #\" >Action</a></li> \r\n"); 
respuesta.write( "           <li><a href=\" #\" >Another action</a></li> \r\n"); 
respuesta.write( "           <li><a href=\" #\" >Something else here</a></li> \r\n"); 
respuesta.write( "           <li class=\" divider\" ></li> \r\n"); 
respuesta.write( "           <li class=\" dropdown-header\" >Dropdown header</li> \r\n"); 
respuesta.write( "           <li><a href=\" #\" >Separated link</a></li> \r\n"); 
respuesta.write( "           <li><a href=\" #\" >One more separated link</a></li> \r\n"); 
respuesta.write( "         </ul> \r\n"); 
respuesta.write( "       </li> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "           </ul> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "            \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "           <form class=\" navbar-form navbar-right\" > \r\n"); 
respuesta.write( "             <input type=\" text\"  class=\" form-control\"  placeholder=\" Search...\" > \r\n"); 
respuesta.write( "           </form> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "         </div> \r\n"); 
respuesta.write( "       </div> \r\n"); 
respuesta.write( "     </div> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <div class=\" container-fluid\" > \r\n"); 
respuesta.write( "       <div class=\" row\" > \r\n"); 
respuesta.write( "         <div class=\" col-sm-3 col-md-2 sidebar\" > \r\n"); 
respuesta.write( "         <ul class=\" nav nav-sidebar\" > \r\n"); 
respuesta.write( "               <li ><a href=\" ./ordenarOperacionPrim.htm\" >Ordenar operación primaria</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" ./ordenarOperacionSec.htm\" >Ordenar operación secundaria</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" ./cancelarOperacion.htm\" >Cancelar operación bursátil</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" ./registrarOperacion.htm\" >Registrar operación </a></li> \r\n"); 
respuesta.write( "            \r\n"); 
respuesta.write( "           </ul> \r\n"); 
respuesta.write( "           <ul class=\" nav nav-sidebar\" > \r\n"); 
respuesta.write( "             <li><a href=\" ./consultarExistencia.htm\" >Consultar existencia de valores</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" ./consultarOperacion.htm\" >Consultar operaciones de un usuario</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" ./portafolios.htm\" >Portafolios</a></li> \r\n"); 
respuesta.write( "             <li><a href=\" ./eliminarInversionista.htm\" >Eliminar Intermediario</a></li> \r\n"); 
respuesta.write( "               <li class = \" active\" ><a href=\" ./consultasIte3.htm\" >Consultas</a></li> \r\n"); 
respuesta.write( "           </ul> \r\n"); 
respuesta.write( "            \r\n"); 
respuesta.write( "         </div> \r\n"); 
respuesta.write( "         <div class=\" col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\" > \r\n"); 
respuesta.write( "           <h1 class=\" page-header\" >Consultas</h1> \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "            \r\n"); 
respuesta.write( "  \r\n"); 
respuesta.write( "     <!-- Bootstrap core JavaScript \r\n"); 
respuesta.write( "     ================================================== --> \r\n"); 
respuesta.write( "     <!-- Placed at the end of the document so the pages load faster --> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/jquery.min.js\" ></script> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/bootstrap.min.js\" ></script> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/docs.min.js\" ></script> \r\n"); 
respuesta.write( "     <!-- IE10 viewport hack for Surface/desktop Windows 8 bug --> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js\" ></script> \r\n"); 
respuesta.write( "    \r\n");
respuesta.write( "      <form role=\" form\"  action=\" ServletConsultaIT3.htm\"  method=\" post\" > \r\n"); 
respuesta.write( "          <br> \r\n"); 
respuesta.write( "       <h2>Visualizar Intermediarios</h2> \r\n"); 
respuesta.write( "       <br> \r\n"); 
respuesta.write( "     <div class=\" form-group\" > \r\n"); 
respuesta.write( "     \r\n"); 
respuesta.write( "      </div> \r\n"); 
respuesta.write( "     <div class=\" form-group\" > \r\n"); 
respuesta.write( "     <label for=\" ejemplo_email_1\" >Intermediarios</label> \r\n"); 
respuesta.write( "     <select class=\" form-control\"  name=\"Intermediario\"  > \r\n"); 
respuesta.write( "            <option value=\" \"  disabled selected>Seleccione el tipo de operacion bursatil</option> \r\n"); 


try {
                               String sentenciasIntermediarios="select * from intermediario";
                              ResultSet rta = x.consultar(sentenciasIntermediarios);
                              
                              while(rta.next())
                              {
                                 

                                    respuesta.write( "          <option value=\""+rta.getString("EMAIL")+"\" >"+rta.getString("EMAIL")+"</option>\r\n" );
                                 
                                    respuesta.write( "       \r\n" );
                              }
                             
                              
                              
                              
                             
                              rta.close();
                          } catch (SQLException ex) {
                              Logger.getLogger(ServletCancelarOrdenOperacionBursatil.class.getName()).log(Level.SEVERE, null, ex);
                          }










respuesta.write( "           \r\n"); 
respuesta.write( "         </select> \r\n"); 
respuesta.write( "   </div>            \r\n"); 
respuesta.write( "    \r\n"); 
respuesta.write( "      <button type=\" submit\"  class=\" btn btn-default\" >Buscar</button> \r\n"); 
respuesta.write( "       \r\n"); 
respuesta.write( "     </form> \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      <form role=\" form\"  action=\" ServletConsultaIT3.htm\"  method=\" post\" > \r\n"); 
respuesta.write( "          <br> \r\n"); 
respuesta.write( "       <h2>Visualizar Oferentes</h2> \r\n"); 
respuesta.write( "       <br> \r\n"); 
respuesta.write( "     <div class=\" form-group\" > \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      </div> \r\n"); 
respuesta.write( "     <div class=\" form-group\" > \r\n"); 
respuesta.write( "     <label for=\" ejemplo_email_1\" >Oferentes</label> \r\n"); 
respuesta.write( "     <select class=\" form-control\"  name=\"Oferente\"  > \r\n"); 
respuesta.write( "            <option value=\" \"  disabled selected>Seleccione el tipo de operacion bursatil</option> \r\n"); 





try {
                      
             String sentenciaOferentes="select * from oferente";
                              ResultSet rta = x.consultar(sentenciaOferentes);
                              
                              while(rta.next())
                              {
                                 

                                    respuesta.write( "          <option value=\""+rta.getString("EMAIL")+"\" >"+rta.getString("EMAIL")+"</option>\r\n" );
                                 
                                    respuesta.write( "       \r\n" );
                              }
                             
                              
                              
                              
                             
                              rta.close();
                          } catch (SQLException ex) {
                              Logger.getLogger(ServletCancelarOrdenOperacionBursatil.class.getName()).log(Level.SEVERE, null, ex);
                          }





respuesta.write( "           \r\n"); 
respuesta.write( "         </select> \r\n"); 
respuesta.write( "   </div>            \r\n"); 
respuesta.write( "    \r\n"); 
respuesta.write( "      <button type=\" submit\"  class=\" btn btn-default\" >Buscar</button> \r\n"); 
respuesta.write( "       \r\n"); 
respuesta.write( "     </form> \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      <form role=\" form\"  action=\" ServletConsultaIT3.htm\"  method=\" post\" > \r\n"); 
respuesta.write( "          <br> \r\n"); 
respuesta.write( "       <h2>Visualizar Inversionistas</h2> \r\n"); 
respuesta.write( "       <br> \r\n"); 
respuesta.write( "     <div class=\" form-group\" > \r\n"); 
respuesta.write( "    \r\n"); 
respuesta.write( "      </div> \r\n"); 
respuesta.write( "     <div class=\" form-group\" > \r\n"); 
respuesta.write( "     <label for=\" ejemplo_email_1\" >Inversionistas</label> \r\n"); 
respuesta.write( "     <select class=\" form-control\"  name=\"Inversionista\"  > \r\n"); 
respuesta.write( "            <option value=\" \"  disabled selected>Seleccione el tipo de operacion bursatil</option> \r\n"); 
try {
                              String sentenciaInversionistas="select * from inversionista";
                              ResultSet rta = x.consultar(sentenciaInversionistas);
                              
                              while(rta.next())
                              {
                                 

                                    respuesta.write( "          <option value=\""+rta.getString("EMAIL")+"\" >"+rta.getString("EMAIL")+"</option>\r\n" );
                                 
                                    respuesta.write( "       \r\n" );
                              }
                             
                              
                              
                              
                             
                              rta.close();
                          } catch (SQLException ex) {
                              Logger.getLogger(ServletCancelarOrdenOperacionBursatil.class.getName()).log(Level.SEVERE, null, ex);
                          }
respuesta.write( "           \r\n"); 
respuesta.write( "         </select> \r\n"); 
respuesta.write( "   </div>            \r\n"); 
respuesta.write( "    \r\n"); 
respuesta.write( "      <button type=\" submit\"  class=\" btn btn-default\" >Buscar</button> \r\n"); 
respuesta.write( "       \r\n"); 
respuesta.write( "     </form> \r\n"); 
respuesta.write( "       \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "        <!-- Bootstrap core JavaScript \r\n"); 
respuesta.write( "     ================================================== --> \r\n"); 
respuesta.write( "     <!-- Placed at the end of the document so the pages load faster --> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/jquery.min.js\" ></script> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/bootstrap.min.js\" ></script> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/docs.min.js\" ></script> \r\n"); 
respuesta.write( "     <!-- IE10 viewport hack for Surface/desktop Windows 8 bug --> \r\n"); 
respuesta.write( "     <script src=\" ./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js\" ></script> \r\n"); 
respuesta.write( "       \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( "      \r\n"); 
respuesta.write( " <div id=\" global- \r\n"); 
                         
                         
                         
                         
                         
                         
        
    }   
           
    
    
    
    
    
    
    
}
