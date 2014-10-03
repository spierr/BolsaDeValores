/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Fachada.conexionDB;
import VOS.OperacionEsperaPrim;
import VOS.OperacionEsperaSec;
import VOS.OperacionRegPrim;
import VOS.SolicitudCompra;
import VOS.TipoDeValor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class TestOperacionesEspeara {
    
    public TestOperacionesEspeara() {
    }
    
   
    @Test
    public void testOperacionesEnsperaPrim() {
        System.out.println("prueba1-1");
        try {
            // TODO review the generated test code and remove the default call to fail.           
            conexionDB x = new conexionDB();          
            ResultSet maximoid= x.consultar("SELECT MAX (ID) FROM  OPERACIONES_EN_ESPERA_PRIM ");    
            int nuevoid=0;
            maximoid.next();
                nuevoid = Integer.parseInt(maximoid.getString("MAX(ID)"))+1 ;
            maximoid.close();
            
           
            String emailOferente = "";
            String emailIntermediario = "";
            String nombreValor = "";
            long nit = 764567456;
            double precio = 31231;
            int cantidad = 321;
            Integer idSolicitud=null;
            
            boolean rta=OperacionEsperaPrim.insertarOperacion(nuevoid, emailOferente, emailIntermediario, nit , nombreValor, precio, cantidad, idSolicitud);
            x.close();
            assertEquals(false, rta);
        } catch (SQLException ex) {
            //Logger.getLogger(TestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testOperacionesEnsperaSec() {
        try {
            // TODO review the generated test code and remove the default call to fail.
            conexionDB x = new conexionDB();
            
            ResultSet maximoid= x.consultar("SELECT MAX (ID) FROM  OPERACIONES_EN_ESPERA_SEC ");
            
            int nuevoid=0;
            maximoid.next();
                nuevoid = Integer.parseInt(maximoid.getString("MAX(ID)"))+1 ;
            maximoid.close();
            x.close();
           
            String emailInversor= "";
            String emailIntermediario = "";
            String nombreValor = "";
            long nit = 764567456;
            double precio = 31231;
            int cantidad = 321;
              Integer idSolicitud=null;
             String tipoOperacion= "CANTIDAD";
            
            boolean rta=OperacionEsperaSec.insertarOperacion(nuevoid, emailInversor, emailIntermediario, nit , nombreValor, precio, cantidad, tipoOperacion,idSolicitud );
            
            assertEquals(false, rta);
        } catch (SQLException ex) {
           // Logger.getLogger(TestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
