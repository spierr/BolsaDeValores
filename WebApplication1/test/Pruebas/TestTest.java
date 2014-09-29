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
public class TestTest {
    
    public TestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    
    public void testOperacionesEnsperaPrim() {
        try {
            // TODO review the generated test code and remove the default call to fail.
            System.out.println("prueba1-1");
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
            Logger.getLogger(TestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void testOperacionesEnsperaSec() {
        try {
            // TODO review the generated test code and remove the default call to fail.
            System.out.println("prueba1-1");
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
            Logger.getLogger(TestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void testOperacionRegPrim()    {
         int id=0;
         try {
             conexionDB x = new conexionDB();
            ResultSet maximoid= x.consultar("SELECT MAX (ID) FROM  OPERACIONES_EN_ESPERA_PRIM ");
            maximoid.next();
                id = Integer.parseInt(maximoid.getString("MAX(ID)"))+1 ;
            maximoid.close();
            x.close();
        } catch (Exception e) {
        }
            assertNotSame("Error obtebiendo id", id, 0);
            String emailOferente = "";
            String emailIntermediario = "";
            String nomValor = "";
            long nitValor = 764567456;
            double precioUnidad = 31231;
            int cantidad = 321;
            Integer idSolicitud=null;
        assertTrue(OperacionEsperaPrim.insertarOperacion(id, emailOferente, emailIntermediario, nitValor, nomValor, precioUnidad, cantidad, idSolicitud));
        assertFalse(OperacionEsperaPrim.insertarOperacion(id, emailOferente, emailIntermediario, nitValor, nomValor, precioUnidad, cantidad, idSolicitud));
        assertTrue(OperacionEsperaPrim.eliminarOperacion(id));
    }
    public void testOperacionRegSec()    {
         int id=0;
         try {
             conexionDB x = new conexionDB();
            ResultSet maximoid= x.consultar("SELECT MAX (ID) FROM  OPERACIONES_EN_ESPERA_PRIM ");
            maximoid.next();
                id = Integer.parseInt(maximoid.getString("MAX(ID)"))+1 ;
            maximoid.close();
            x.close();
        } catch (Exception e) {
        }
            assertNotSame("Error obtebiendo id", id, 0);
            String emailOferente = "";
            String emailIntermediario = "";
            String nomValor = "";
            long nitValor = 764567456;
            double precioUnidad = 31231;
            int cantidad = 321;
            Integer idSolicitud=null;
            String tipoDeValor= "VENTA";
        assertTrue(OperacionEsperaSec.insertarOperacion(id, emailOferente, emailIntermediario, nitValor, nomValor, precioUnidad, cantidad, tipoDeValor, idSolicitud));
        assertFalse(OperacionEsperaPrim.insertarOperacion(id, emailOferente, emailIntermediario, nitValor, nomValor, precioUnidad, cantidad, idSolicitud));
        assertTrue(OperacionEsperaPrim.eliminarOperacion(id));
        
    }
    public void testSolicitudPrim()    {
        
    }
    public void testSolicitudSec()    {
        
    }
    public void testValoresDeInversionistas()    {
        
    }
    
    
    
    
        
    
}
