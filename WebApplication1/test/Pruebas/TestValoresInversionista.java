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
public class TestValoresInversionista {
    
    public TestValoresInversionista() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }

    
    @Test
    public void testInversionista()    {
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
            String emailOferente = "lweb@clickbank.net";
            String emailIntermediario = "hchavez6@bbc.co.uk";
            String nomValor = "Accion";
            long nitValor = Long.parseLong("8656441914");
            double precioUnidad = 123;
            int cantidad = 321;
            Integer idSolicitud=null;
        assertTrue(OperacionEsperaPrim.insertarOperacion(id, emailOferente, emailIntermediario, nitValor, nomValor, precioUnidad, cantidad, idSolicitud));
        assertFalse(OperacionEsperaPrim.insertarOperacion(id, emailOferente, emailIntermediario, nitValor, nomValor, precioUnidad, cantidad, idSolicitud));
        assertFalse(OperacionEsperaPrim.eliminarOperacion(id));
    }
   
    
    
    
    
        
    
}
