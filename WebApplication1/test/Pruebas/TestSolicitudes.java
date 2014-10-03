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
public class TestSolicitudes {
    
    public TestSolicitudes() {
    }
    
  
    @Test
    public void testSolicitudPrim()    {
            String emailIntCom = "";
            String emailCom = "";
            String emailIntVen = "";
            String emailVen = "";
            String nomValor = "";
            long nit = 764567456;
            double precioUnitario = 31231;
            int cantidad = 321;
            Integer id=null;
            String tipoDeValor= "VENTA";
        SolicitudCompra.insertarSolicitudPrimaria(id,nomValor, nit, cantidad, precioUnitario, emailIntCom, emailCom, emailIntVen, emailVen);
    }
    @Test
    public void testSolicitudSec()    {
         String emailIntCom = "";
            String emailCom = "";
            String emailIntVen = "";
            String emailVen = "";
            String nomValor = "";
            long nit = 764567456;
            double precioUnitario = 31231;
            int cantidad = 321;
            Integer id=null;
            String tipoDeValor= "VENTA";
            int numRes=SolicitudCompra.insertarSolicitudPrimaria(id,nomValor, nit, cantidad, precioUnitario, emailIntCom, emailCom, emailIntVen, emailVen);
    
            boolean r=false;
            if(numRes > -1)
                r=true;
        assertFalse(r);
    }
    

        
    
}
