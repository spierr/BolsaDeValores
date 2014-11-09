/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaDAO;

import Fachada.conexionDB;
import VOS.OperacionEsperaSec;
import VOS.SolicitudCompra;
import VOS.ValoresDeInversionistas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.taglibs.standard.lang.jstl.Coercions;

/**
 *
 * @author Cristian
 */
public class Consultas {
    
    public static ArrayList consultarSolicitudesPrimasriasPorIntermediario(conexionDB x, String email) throws SQLException         
    {
        ResultSet r= x.consultar("SELECT * FROM SOLICITUDES_COMPRA_PRIM WHERE EMAIL_INT_VEN ='"+email+"'");
        ArrayList res= new ArrayList();
        
        while (r.next())
        {
           res.add(new SolicitudCompra(Integer.parseInt(r.getString("ID")),
                   Long.parseLong(r.getString("NIT_VALOR")), r.getString("NOM_VALOR"),
                   Double.parseDouble(r.getString("PRECIO_UNITARIO")), Integer.parseInt(r.getString("CANTIDAD")),
                   r.getString("FECHA"), 
                   r.getString("EMAIL_VEN"),  r.getString("EMAIL_COM"),  r.getString("EMAIL_INT_VEN"),  r.getString("EMAIL_INT_COM")));
        }
        r.close();
        x.close();
        return res;
    }
    
    public static ArrayList consultarSolicitudesSecundarioasPorIntermediario(conexionDB x, String email)   throws SQLException      
    {
       ResultSet r= x.consultar("SELECT * FROM SOLICITUDES_COMPRA_SEC WHERE EMAIL_INT_VEN ='"+email+"'");
        ArrayList res= new ArrayList();
        
        while (r.next())
        {
           res.add(new SolicitudCompra(Integer.parseInt(r.getString("ID")),
                   Long.parseLong(r.getString("NIT_VALOR")), r.getString("NOM_VALOR"),
                   Double.parseDouble(r.getString("PRECIO_UNITARIO")), Integer.parseInt(r.getString("CANTIDAD")),
                   r.getString("FECHA"), 
                   r.getString("EMAIL_VEN"),  r.getString("EMAIL_COM"),  r.getString("EMAIL_INT_VEN"),  r.getString("EMAIL_INT_COM")));
        }
        
        r.close();
        x.close();
        return res;
    }
    
    
    
    
    public static ArrayList consultarValoresConNitDado(conexionDB conexion , String nit) throws SQLException
    {
       
        ArrayList  lista = new ArrayList() ;
        
        String sentencia = "select * from VALORES_DE_INVERSIONISTAS where nit_valor="+nit;
      ResultSet rta =  conexion.consultar(sentencia) ;
       
       while(rta.next())
       {
          ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
           lista.add(nuevo);
       }
         rta.close();
        conexion.close();
        
        
        return lista ;
    }
    
    
     public static ArrayList  buscarValoresPorTipoDeVaor(String tipoDeValor , conexionDB conexion) throws SQLException
    {
        ArrayList lista = new ArrayList() ;
        
        if(tipoDeValor.equalsIgnoreCase("Accion")||tipoDeValor.equalsIgnoreCase("BonoPriv")||tipoDeValor.equalsIgnoreCase("BonoPub")||tipoDeValor.equalsIgnoreCase("Certificado")||tipoDeValor.equalsIgnoreCase("Titulo"))
        {
        
           String sentencia = "select * from VALORES_DE_INVERSIONISTAS where nom_valor='"+tipoDeValor+"'";
      ResultSet rta =  conexion.consultar(sentencia) ;
       
       while(rta.next())
       {
          ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
           lista.add(nuevo);
       }
         rta.close();
         conexion.close();
        
        }
        
        return lista ;
    }
    
     
     public static ArrayList valoresNegociados(String negociados ,conexionDB conexion ) throws SQLException
     {
         ArrayList lista = new ArrayList();
        
         if(negociados.equalsIgnoreCase("si"))
         {
                        String sentencia = "select * from OPERACIONES_EN_ESPERA_PRIM where  solicitud is not null";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL_OFERENTE"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                 
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_SEC where  solicitud is  not null and TIPO_OPERACION='VENTA'";
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta2.getString("EMAIL_INVER"), rta2.getString("NIT_VALOR"), rta2.getString("NOM_VALOR"),Integer.parseInt( rta2.getString("CANTIDAD")));
                     lista.add(nuevo);
                 }
                  rta2.close();
                  conexion.close();
         }
         if(negociados.equalsIgnoreCase("no"))
         {
             
                  String sentencia = "select * from OPERACIONES_EN_ESPERA_PRIM where  solicitud is  null";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL_OFERENTE"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
                      lista.add(nuevo);
                  }
                 rta.close();
                  
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_SEC where  solicitud is null and TIPO_OPERACION='VENTA'";
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta2.getString("EMAIL_INVER"), rta2.getString("NIT_VALOR"), rta2.getString("NOM_VALOR"),Integer.parseInt( rta2.getString("CANTIDAD")));
                     lista.add(nuevo);
                 }
                  rta2.close();
                  conexion.close();

             
         }
         
         
         
         
         
         
         
         return lista ;
     }
     
     
     
     public static ArrayList  valoresDadoUnOferente(String emailOferente , conexionDB conexion) throws SQLException
     {
         ArrayList lista = new ArrayList();
         
         
          String sentencia = "select * from OPERACIONES_EN_ESPERA_prim where  EMAIL_OFERENTE='"+emailOferente+"'";
      ResultSet rta =  conexion.consultar(sentencia) ;
       
       while(rta.next())
       {
          ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL_OFERENTE"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
           lista.add(nuevo);
       }
         rta.close();
        
         conexion.close();
         return lista ; 
         
     }
     
     
     public static ArrayList  valoresDadoUnInversionita(String emailInv , conexionDB conexion) throws SQLException
     {
         ArrayList lista = new ArrayList();
         
         
          String sentencia = "select * from OPERACIONES_EN_ESPERA_SEC where  TIPO_OPERACION='VENTA' AND  EMAIL_INVER='"+emailInv+"'";
      ResultSet rta =  conexion.consultar(sentencia) ;
       
       while(rta.next())
       {
          ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL_INVER"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
           lista.add(nuevo);
       }
         rta.close();
        conexion.close();
         
         return lista ; 
         
     }
     
     
     
      public static ArrayList valoresDadoUnIntermediario(String emailIntermediario ,conexionDB conexion ) throws SQLException
     {
         ArrayList lista = new ArrayList();
        
         
  
                        String sentencia = "select * from OPERACIONES_EN_ESPERA_PRIM where  EMAIL_INTERMEDIARIO='"+emailIntermediario+"'";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta.getString("EMAIL_INTERMEDIARIO"), rta.getString("NIT_VALOR"), rta.getString("NOM_VALOR"),Integer.parseInt( rta.getString("CANTIDAD")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_SEC where  TIPO_OPERACION='VENTA' and EMAIL_INTER='"+emailIntermediario+"'";
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    ValoresDeInversionistas nuevo = new ValoresDeInversionistas(rta2.getString("EMAIL_INTER"), rta2.getString("NIT_VALOR"), rta2.getString("NOM_VALOR"),Integer.parseInt( rta2.getString("CANTIDAD")));
                     lista.add(nuevo);
                 }
                  rta2.close();
       
         
         
         
         conexion.close();
         
         
         
         
         return lista ;
     }
      
      
      public static  ArrayList operacionesDadoTipoDeUsuario(String tipoUsuario , conexionDB conexion) throws SQLException
      {
          ArrayList lista = new ArrayList() ;
          
          
          if(tipoUsuario.equalsIgnoreCase("Inversionita"))
          {
               String sentencia = "select  ID , EMAIL_INVER , nom_valor ,NIT_VALOR, TIPO_OPERACION, NVL(PRECIO_UNIDAD,0) , NVL(CANTIDAD,0) , FECHA , EMAIL_INTER , NVL(PRECIO,0) from OPERACIONES_EN_ESPERA_SEC";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("NVL(PRECIO_UNIDAD,0)")),Integer.parseInt( rta.getString("NVL(CANTIDAD,0)")), rta.getString("FECHA"), rta.getString("TIPO_OPERACION"),Double.parseDouble( rta.getString("NVL(PRECIO,0)")));
                      lista.add(nuevo);
                  }
                 rta.close();
          }
          
           if(tipoUsuario.equalsIgnoreCase("Oferente"))
          {
              String sentencia = "select * from OPERACIONES_EN_ESPERA_PRIM";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                    OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("PRECIO_UNIDAD")),Integer.parseInt( rta.getString("CANTIDAD")), rta.getString("FECHA"), "VENTA",Double.parseDouble("0"));
                      lista.add(nuevo);
                  }
                 rta.close();
          }
           
            if(tipoUsuario.equalsIgnoreCase("Intermediario"))
          {
             
                        String sentencia = "select  ID , EMAIL_INVER , nom_valor ,NIT_VALOR, TIPO_OPERACION, NVL(PRECIO_UNIDAD,0) , NVL(CANTIDAD,0) , FECHA , EMAIL_INTER , NVL(PRECIO,0) from OPERACIONES_EN_ESPERA_SEC";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("NVL(PRECIO_UNIDAD,0)")),Integer.parseInt( rta.getString("NVL(CANTIDAD,0)")), rta.getString("FECHA"), rta.getString("TIPO_OPERACION"),Double.parseDouble( rta.getString("NVL(PRECIO,0)")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_PRIM";
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta2.getString("NIT_VALOR")), rta2.getString("NOM_VALOR"),Double.parseDouble( rta2.getString("PRECIO_UNIDAD")),Integer.parseInt( rta2.getString("CANTIDAD")), rta2.getString("FECHA"), "VENTA",Double.parseDouble("0"));
                      lista.add(nuevo);
                 }
                  rta2.close();
       
          }
          
          
          
          
          
          return lista ;
      }
      
      
      public static ArrayList operacionesDadoTipoDeOperacion(String tipoOperacion , conexionDB conexion) throws SQLException
      {
          
          ArrayList lista = new ArrayList();
          
          
          
          
                if(tipoOperacion.equalsIgnoreCase("compra"))
          {
             
                        String sentencia = "select  ID , EMAIL_INVER , nom_valor ,NIT_VALOR, TIPO_OPERACION, NVL(PRECIO_UNIDAD,0) , NVL(CANTIDAD,0) , FECHA , EMAIL_INTER , NVL(PRECIO,0) from OPERACIONES_EN_ESPERA_SEC where tipo_operacion='COMPRA'";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("NVL(PRECIO_UNIDAD,0)")),Integer.parseInt( rta.getString("NVL(CANTIDAD,0)")), rta.getString("FECHA"), rta.getString("TIPO_OPERACION"),Double.parseDouble( rta.getString("NVL(PRECIO,0)")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                  
                        
          }
          
          
          if(tipoOperacion.equalsIgnoreCase("VENTA"))
          {
             
                        String sentencia = "select  ID , EMAIL_INVER , nom_valor ,NIT_VALOR, TIPO_OPERACION, NVL(PRECIO_UNIDAD,0) , NVL(CANTIDAD,0) , FECHA , EMAIL_INTER , NVL(PRECIO,0) from OPERACIONES_EN_ESPERA_SEC WHERE TIPO_OPERACION='VENTA'";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("NVL(PRECIO_UNIDAD,0)")),Integer.parseInt( rta.getString("NVL(CANTIDAD,0)")), rta.getString("FECHA"), rta.getString("TIPO_OPERACION"),Double.parseDouble( rta.getString("NVL(PRECIO,0)")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_PRIM";
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta2.getString("NIT_VALOR")), rta2.getString("NOM_VALOR"),Double.parseDouble( rta2.getString("PRECIO_UNIDAD")),Integer.parseInt( rta2.getString("CANTIDAD")), rta2.getString("FECHA"), "VENTA",Double.parseDouble("0"));
                      lista.add(nuevo);
                 }
                  rta2.close();
       
          }
          
          
          
          
          return lista;
      }
              
      
     public static ArrayList filtrarOperacionDadoPrecio(String precio , conexionDB conexion) throws SQLException
             {
                 
                 ArrayList lista = new ArrayList();
                 
                 
                 
                        String sentencia = "select  ID , EMAIL_INVER , nom_valor ,NIT_VALOR, TIPO_OPERACION, NVL(PRECIO_UNIDAD,0) , NVL(CANTIDAD,0) , FECHA , EMAIL_INTER , NVL(PRECIO,0) from OPERACIONES_EN_ESPERA_SEC where nvl(precio,0)="+precio+" or nvl(precio_unidad,0)="+precio;
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("NVL(PRECIO_UNIDAD,0)")),Integer.parseInt( rta.getString("NVL(CANTIDAD,0)")), rta.getString("FECHA"), rta.getString("TIPO_OPERACION"),Double.parseDouble( rta.getString("NVL(PRECIO,0)")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_PRIM where PRECIO_UNIDAD ="+precio;
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta2.getString("NIT_VALOR")), rta2.getString("NOM_VALOR"),Double.parseDouble( rta2.getString("PRECIO_UNIDAD")),Integer.parseInt( rta2.getString("CANTIDAD")), rta2.getString("FECHA"), "VENTA",Double.parseDouble("0"));
                      lista.add(nuevo);
                 }
                  rta2.close();
                 
                 
                 
                 
                 return lista;
             }
     
     
     
     public static ArrayList consultarOperacionesEnEsperaPorSolucitud(conexionDB x, String email)   throws SQLException      
    {
       ResultSet r= x.consultar("SELECT * FROM SOLICITUDES_COMPRA_SEC WHERE EMAIL_INT_VEN ='"+email+"'");
        ArrayList res= new ArrayList();
        
        while (r.next())
        {
           res.add(new SolicitudCompra(Integer.parseInt(r.getString("ID")),
                   Long.parseLong(r.getString("NIT_VALOR")), r.getString("NOM_VALOR"),
                   Double.parseDouble(r.getString("PRECIO_UNITARIO")), Integer.parseInt(r.getString("CANTIDAD")),
                   r.getString("FECHA"), 
                   r.getString("EMAIL_VEN"),  r.getString("EMAIL_COM"),  r.getString("EMAIL_INT_VEN"),  r.getString("EMAIL_INT_COM")));
        }
        r.close();
        x.close();
        return res;
    }

   public static ResultSet buscarValoresDeInversionistas(conexionDB x,String inversionista) {
              ResultSet r = x.consultar("select * from VALORES_DE_INVERSIONISTAS , PORTAFOLIOS where PORTAFOLIOS.ID=VALORES_DE_INVERSIONISTAS.ID_PORTAFOLIO AND VALORES_DE_INVERSIONISTAS.EMAIL='"+inversionista+"'" );
              
              
              return r;
               
    }

    public static ResultSet buscarVentasCompatiblesPrecioNullPrim(conexionDB x,OperacionEsperaSec o) {
              ResultSet r = x.consultar("SELECT * \n" +
                "FROM OPERACIONES_EN_ESPERA_PRIM \n" +
                "WHERE \n" +
                "SOLICITUD IS NULL AND CANTIDAD>= "+o.getCantidad()+ " AND NOM_VALOR= '"+o.getNomValor()+ "' AND NIT_VALOR=  "+o.getNitValor() );
              
              
              return r;
               
    }

    public static ResultSet buscarVentasCompatiblesPrecioNullSec(conexionDB x,OperacionEsperaSec o) {
    ResultSet r =  x.consultar("SELECT * \n" +
                "FROM OPERACIONES_EN_ESPERA_SEC \n" +
                "WHERE \n" +
                "SOLICITUD IS NULL AND CANTIDAD>= "+o.getCantidad()+ " AND NOM_VALOR= '"+o.getNomValor()+ "' AND NIT_VALOR= "+o.getNitValor()+" AND TIPO_OPERACION= 'VENTA'");
    
              return r;
    }

    public static ResultSet buscarVentasCompatiblesCantidadNullPrim(conexionDB x,OperacionEsperaSec o) {
         ResultSet r = x.consultar("SELECT * \n" +
                "FROM OPERACIONES_EN_ESPERA_PRIM \n" +
                "WHERE \n" +
                "SOLICITUD IS NULL AND (CANTIDAD*PRECIO_UNIDAD)>= "+o.getPrecio()+" AND NOM_VALOR= '"+o.getNomValor()+"' AND NIT_VALOR= "+o.getNitValor());
    
              return r;
    }
    
    
    

    public static ResultSet buscarVentasCompatiblesCantidadNullSec(conexionDB x,OperacionEsperaSec o) {
          ResultSet r =  x.consultar("SELECT * \n" +
                "FROM OPERACIONES_EN_ESPERA_SEC \n" +
                "WHERE \n" +
                "SOLICITUD IS NULL AND (CANTIDAD*PRECIO_UNIDAD)>= "+o.getPrecio()+" AND NOM_VALOR= '"+o.getNomValor()+"' AND NIT_VALOR= "+o.getNitValor()+" AND TIPO_OPERACION= 'VENTA'");
    
              return r;
    }
  
     public static ResultSet buscarIntermediariosPortafolio(conexionDB x,String tipoPortafolio , String emailIntermediario) {
          ResultSet r =  x.consultar("select EMAIL_INTERMEDIARIO AS MAIL,OPERACIONES_EN_ESPERA_PRIM.NOM_VALOR AS VALOR,NIT_VALOR AS NIT,PORTAFOLIOS.TIPO_PORTAFOLIO AS PORTA from OPERACIONES_EN_ESPERA_PRIM,PORTAFOLIOS where OPERACIONES_EN_ESPERA_PRIM.PORTAFOLIO=PORTAFOLIOS.id and TIPO_PORTAFOLIO='"+tipoPortafolio+"' AND  EMAIL_INTERMEDIARIO='"+emailIntermediario+"' UNION ALL\n" +
"(SELECT EMAIL_INTER AS MAIL , OPERACIONES_EN_ESPERA_SEC.NOM_VALOR AS VALOR ,NIT_VALOR AS NIT , TIPO_PORTAFOLIO AS PORTA FROM  OPERACIONES_EN_ESPERA_SEC,PORTAFOLIOS where OPERACIONES_EN_ESPERA_SEC.PORTAFOLIO=PORTAFOLIOS.id and TIPO_PORTAFOLIO='"+tipoPortafolio+"' AND  EMAIL_INTER='"+emailIntermediario+"')");
              return r;
    }
    
     
      public static ResultSet buscarIntermediariosValoresEnNegociasion(conexionDB x, String emailIntermediario) {
          ResultSet r =  x.consultar("select *  from SOLICITUDES_COMPRA_PRIM where( EMAIL_INT_COM='"+emailIntermediario+"' or EMAIL_INT_VEN='"+emailIntermediario+"' ) union all\n" +
"(select *  from SOLICITUDES_COMPRA_SEC where( EMAIL_INT_COM='"+emailIntermediario+"' or EMAIL_INT_VEN='"+emailIntermediario+"' ))");
              return r;
    }
     
      
      public static ResultSet buscarInversionistasDeIntermediario(conexionDB x,String emailIntermediario) {
         ResultSet r = x.consultar("SELECT VECES , NOMBRE , NACIONALIDAD FROM (SELECT VECES  FROM (SELECT EMAIL_INVER AS VECES FROM OPERACIONES_EN_ESPERA_SEC WHERE EMAIL_INTER='"+emailIntermediario+"' ) GROUP BY VECES), USUARIO WHERE EMAIL=VECES");
    
              return r;
    }
    
      public static ResultSet consultarMovimientosDeValores1(conexionDB x,String fecha1,String fecha2 , String nomValor,String precioUnidad,String TipoRentabilidad, String email ) {
         ResultSet r = x.consultar("select * from OPERACIONES_REGISTRADAS_SEC \n" +
"where fecha  between  to_date('"+fecha1+"','yyyy-mm-dd') and to_date('"+fecha2+"','yyyy-mm-dd') \n" +
"and (NOM_VALOR='"+nomValor+"' or precio_unidad="+precioUnidad+" or TIPO_RENTABILIDAD="+TipoRentabilidad+" or email_com='"+email+"')");
    
              return r;
    }
      public static ResultSet consultarValores2(conexionDB x,String nomValor , String nit_valor) {
         ResultSet r = x.consultar("select * from OPERACIONES_REGISTRADAS_SEC WHERE NOM_VALOR='"+nomValor+"' AND NIT_VALOR="+nit_valor ) ;
    
              return r;
    }
      public static ResultSet consultaPortafolios(conexionDB x,String nomValor,String precio) {
         ResultSet r = x.consultar("select * from OPERACIONES_REGISTRADAS_SEC WHERE NOM_VALOR='"+nomValor+"' AND PRECIO_UNIDAD>"+precio);
    
              return r;
              
    }
      public static ResultSet consultarMovimientosDeValores2(conexionDB x,String fecha1,String fecha2 , String nomValor,String precioUnidad,String TipoRentabilidad, String email) {
         ResultSet r = x.consultar("select * from OPERACIONES_REGISTRADAS_SEC \n" +
"where fecha  between  to_date('"+fecha1+"','yyyy-mm-dd') and to_date('"+fecha2+"','yyyy-mm-dd') \n" +
"and (NOM_VALOR='"+nomValor+"' or precio_unidad="+precioUnidad+" or TIPO_RENTABILIDAD="+TipoRentabilidad+" or email_com='"+email+"')");
    
              return r;
    }
      
      
    public static ResultSet darValoresOFerentes(conexionDB x,String email)
    {
        
        ResultSet rta = x.consultar("select * from OPERACIONES_EN_ESPERA_PRIM where EMAIL_OFERENTE='"+email+"'");
        
        return rta;
        
        
    }
    
    
     public static ArrayList operacionRangoFecha(String fechaInferior , String fechaSuperior , conexionDB conexion) throws SQLException
     {
         ArrayList lista= new ArrayList();
         
         
                 String sentencia = "select  ID , EMAIL_INVER , nom_valor ,NIT_VALOR, TIPO_OPERACION, NVL(PRECIO_UNIDAD,0) , NVL(CANTIDAD,0) , FECHA , EMAIL_INTER , NVL(PRECIO,0) from OPERACIONES_EN_ESPERA_SEC where FECHA  between  to_date('"+fechaInferior+"','yyyy-mm-dd') and to_date('"+fechaSuperior+"','yyyy-mm-dd')";
                 ResultSet rta =  conexion.consultar(sentencia) ;

                  while(rta.next())
                  {
                     OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta.getString("NIT_VALOR")), rta.getString("NOM_VALOR"),Double.parseDouble( rta.getString("NVL(PRECIO_UNIDAD,0)")),Integer.parseInt( rta.getString("NVL(CANTIDAD,0)")), rta.getString("FECHA"), rta.getString("TIPO_OPERACION"),Double.parseDouble( rta.getString("NVL(PRECIO,0)")));
                      lista.add(nuevo);
                  }
                 rta.close();
                 
                  
                          String sentencia2 = "select * from OPERACIONES_EN_ESPERA_PRIM where FECHA  between  to_date('"+fechaInferior+"','yyyy-mm-dd') and to_date('"+fechaSuperior+"','yyyy-mm-dd') ";
                ResultSet rta2 =  conexion.consultar(sentencia2) ;

                 while(rta2.next())
                 {
                    OperacionEsperaSec nuevo = new OperacionEsperaSec(0, " ", " ", Long.parseLong(rta2.getString("NIT_VALOR")), rta2.getString("NOM_VALOR"),Double.parseDouble( rta2.getString("PRECIO_UNIDAD")),Integer.parseInt( rta2.getString("CANTIDAD")), rta2.getString("FECHA"), "VENTA",Double.parseDouble("0"));
                      lista.add(nuevo);
                 }
                  rta2.close();
         
         
         
         
         
         
         return lista;
     }
     
     public static String darNombreDeEmpresa(String nit)
     {
         String resp= null;
        try {
            conexionDB x = new conexionDB();
            ResultSet r = x.consultar("SELECT NOMBRE FROM EMPRESA WHERE NIT = "+ nit);
            
            r.next();
            resp =r.getString("NOMBRE");
            r.close();
            x.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
         return resp;
     }
     
      public static ResultSet bono(conexionDB x)
    {
         ResultSet r =  x.consultar("SELECT NIT_VALOR , NOM_VALOR , veces\n" +
"FROM(\n" +
"select nit_valor , nom_valor, count(*) as veces\n" +
"from(\n" +
"select nit_valor , NOM_VALOR \n" +
"from OPERACIONES_EN_ESPERA_PRIM \n" +
"union all (\n" +
"select nit_valor , nom_valor\n" +
"from OPERACIONES_EN_ESPERA_SEC )\n" +
"union all(\n" +
"select nit_valor , nom_valor\n" +
"from OPERACIONES_REGISTRADAS_PRIM\n" +
"\n" +
")\n" +
"union all(\n" +
"select nit_valor , nom_valor\n" +
"from OPERACIONES_REGISTRADAS_SEC\n" +
"\n" +
")\n" +
")\n" +
"group by (nit_valor,nom_valor)\n" +
")\n" +
"\n" +
"WHERE VECES=(\n" +
"SELECT MAX(VECES)FROM(\n" +
"select nit_valor , nom_valor, count(*) as veces\n" +
"from(\n" +
"select nit_valor , NOM_VALOR \n" +
"from OPERACIONES_EN_ESPERA_PRIM \n" +
"union all (\n" +
"select nit_valor , nom_valor\n" +
"from OPERACIONES_EN_ESPERA_SEC )\n" +
"union all(\n" +
"select nit_valor , nom_valor\n" +
"from OPERACIONES_REGISTRADAS_PRIM\n" +
"\n" +
")\n" +
"union all(\n" +
"select nit_valor , nom_valor\n" +
"from OPERACIONES_REGISTRADAS_SEC\n" +
"\n" +
")\n" +
")\n" +
"group by (nit_valor,nom_valor)\n" +
")\n" +
")");
              return r;
    }



}
