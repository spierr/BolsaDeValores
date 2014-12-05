/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;
import ConsultaDAO.Consultas;
import Fachada.conexionDB;
import VOS.ValoresDeInversionistas;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class Colas extends Thread{
    private final static String IP = "localhost";
    private static Colas cola;
    
    protected Colas()
    { 
         
    }
    public static   Colas darInstancia(){
    if(cola==null)
    {
        cola = new Colas();
    }
       return cola;
    }
      

    private void pregunta1(String resp) {
         conexionDB x= new conexionDB();
        x.setAutoCommit(false);
        String[] parametros = resp.split(":");
        String emailInver= parametros[0]; 
        String idPortafolio= parametros[1];
        String tipoValor= parametros[2];
        String[] valores= parametros[3].split("|");
        ResultSet r = x.consultar("SELECT * FROM VALORES_DE_INVERSIONISTAS WHERE EMAIL = '"+emailInver+"' AND "
                + "ID_PORTAFOLIO = "+idPortafolio+" AND NOM_VALOR = '"+tipoValor+"'");
        ResultSet max = x.consultar("SELECT MAX(ID) FROM OPERACIONES_EN_ESPERA_SEC ");
        
        
        try {
            max.next();
            int count=max.getInt("MAX(ID)");
            while (r.next()) {
                count++;
                x.actualizarCrear("INSERT INTO OPERACIONES_EN_ESPERA_SEC (ID, EMAIL_INVER, PORTAFOLIO, SOLICITUD, NOM_VALOR, NIT_VALOR)\n" +
                        "VALUES ("+count+",'"+emailInver+"', "+idPortafolio+", 'Venta', '"+r.getString("NOM_VALOR")+"','"+r.getString("NIT_VALOR")+"' );");
            }
            for (int i = 0; i < valores.length; i++) {
                count++;
                String[] actual= valores[i].split(",");
                String nit= actual[1];
                String nom= actual[0];
                 x.actualizarCrear("INSERT INTO OPERACIONES_EN_ESPERA_SEC (ID, EMAIL_INVER, PORTAFOLIO, SOLICITUD, NOM_VALOR, NIT_VALOR)\n" +
                        "VALUES ("+count+",'"+emailInver+"', "+idPortafolio+", 'Compra', '"+nom+"','"+nit+"' );");
            
                sender("R1;true,"+count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Colas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
   }

    private void pregunta2(String resp) {
         conexionDB x = new conexionDB();
            x.setAutoCommit(false);
            String correoEliminar= resp;
                       
                    try {
                    x.actualizarCrear("UPDATE INTERMEDIARIO SET ESTA_ACTIVO = 'No' WHERE EMAIL = '"+correoEliminar+"'");
                    ResultSet n = x.consultar("SELECT * FROM INTERMEDIARIO WHERE ESTA_ACTIVO='Si'");
                    String correoNuevo= n.getNString("EMAIL");
                    x.actualizarCrear("UPDATE OPERACIONES_EN_ESPERA_PRIM SET EMAIL_INTERMEDIARIO = '"+correoNuevo+"' WHERE EMAIL_INTERMEDIARIO = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE OPERACIONES_EN_ESPERA_SEC SET EMAIL_INTER = '"+correoNuevo+"' WHERE EMAIL_INTER = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE SOLICITUDES_COMPRA_PRIM SET EMAIL_INT_COM  = '"+correoNuevo+"' WHERE EMAIL_INT_COM = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE SOLICITUDES_COMPRA_PRIM SET EMAIL_INT_VEN = '"+correoNuevo+"' WHERE EMAIL_INT_VEN = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE SOLICITUDES_COMPRA_SEC SET EMAIL_INT_COM = '"+correoNuevo+"' WHERE EMAIL_INT_COM = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE SOLICITUDES_COMPRA_SEC SET EMAIL_INT_VEN = '"+correoNuevo+"' WHERE EMAIL_INT_VEN = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE INVERSIONISTA SET EMAIL_INTE = '"+correoNuevo+"' WHERE EMAIL_INTE = '"+correoEliminar+"'");
                    x.actualizarCrear("UPDATE OFERENTE SET EMAIL_INTE = '"+correoNuevo+"' WHERE EMAIL_INTE = '"+correoEliminar+"'");
                    x.commit();
                    sender("R2;"+correoNuevo);
                    
        } catch (Exception e) {
            sender("R2;false");
             System.out.println("Error eliminando ");
             e.printStackTrace();
        }
    
    }

    private void pregunta3(String resp) {
        try {
            String r[]= resp.split(resp);
            for (int i = 0; i < r.length; i++) {
                if (r[i]=="null")
                    r[i]=null;
            }
            conexionDB x = new conexionDB();
            ResultSet respuesta= Consultas.consultarMovimientosDeValores1(x, r[3],r[4], r[0], null, r[1], r[2]);
            String enviar = "R3;";
            int i = 0;
            while (respuesta.next()) {
                if(i!=0){
                    enviar+="|";
                }
               enviar+=respuesta.getString("NOM_VALOR")+","+respuesta.getString("NIT_VALOR");
                
            }
            sender(enviar);
        } catch (SQLException ex) {
            Logger.getLogger(Colas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void pregunta4(String resp) {
       try {
            String r[]= resp.split(resp);
            for (int i = 0; i < r.length; i++) {
                if (r[i]=="null")
                    r[i]=null;
            }
            conexionDB x = new conexionDB();
            ResultSet respuesta= Consultas.darValoresDinamicos(x, resp.split(":")[1], resp.split(":")[0]);
         String enviar = "R3;";
            int i = 0;
            while (respuesta.next()) {
                if(i!=0){
                    enviar+="|";
                }
               enviar+=respuesta.getString("NOM_VALOR")+","+respuesta.getString("NIT_VALOR");
                
            }
            sender(enviar);
        } catch (SQLException ex) {
            Logger.getLogger(Colas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //este es el metodo indio del split del boolean y el numero
    public String recomponerPortafolio(String EMAILINVER, int IDPORTAFOLIO, ArrayList<ValoresDeInversionistas> valores) {
        String pregunta= "Q1;"+EMAILINVER+":"+IDPORTAFOLIO+":";
        for (int i = 0; i < valores.size(); i++) {
            if(i!=0){
                pregunta+="|";
            }
            pregunta+=valores.get(i).getNomValor()+","+valores.get(i).getNitValor();
        }
        
        return reciver(pregunta).split(";")[1];
    }

    public String retirarIntermediario(String emailIntermediario) {
         
         return reciver("Q2;"+emailIntermediario).split(";")[1];
    }

    public ArrayList<ValoresDeInversionistas> consultarMovimiento(String NOMVALOR, int RENTABILIDAD, String EMAILCOMPRADOR, String FECHA1, String FECHA2) {
        
        String resp[]= reciver("Q3;"+NOMVALOR+":"+RENTABILIDAD+":"+EMAILCOMPRADOR+":"+FECHA1+":"+FECHA2).split(";")[1].split("|");
        ArrayList<ValoresDeInversionistas> r= new ArrayList<>();
        for (int i = 0; i < resp.length; i++) {
            String temp[] = resp[i].split(",");
            ValoresDeInversionistas v= new ValoresDeInversionistas();
            v.setNitValor(temp[1]);
            v.setNomValor(temp[0]);
            r.add(v);
        }
        
       return r;
    }

    public ArrayList<ValoresDeInversionistas> valoresMasDinamicos(String FECHA1, String FECHA2) {
       String resp[]= reciver("Q4;"+FECHA1+":"+FECHA2).split(";")[1].split("|");
        ArrayList<ValoresDeInversionistas> r= new ArrayList<>();
        for (int i = 0; i < resp.length; i++) {
            String temp[] = resp[i].split(",");
            ValoresDeInversionistas v= new ValoresDeInversionistas();
            v.setNitValor(temp[1]);
            v.setNomValor(temp[0]);
            r.add(v);
        }
        
       return r;
    }
    
  
    private String reciver(String enviar){
         try {
             ConnectionFactory factory = new ConnectionFactory();
                factory.setHost(IP);
		factory.setPort(5672);
		factory.setUsername("valencia");
		factory.setPassword("admin123");
		
		Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	   
	    channel.queueDeclare("SC", false, false, false, null);
		
	    channel.basicPublish("", "SC", null, enviar.getBytes());
	    System.out.println(" [x] Sent '" + enviar + "'");
	    channel.close();
    	connection.close();
        } catch (Exception e) {
             System.out.println("Error enviando ");
             e.printStackTrace();
        }
         try {
            ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("guest");
		factory.setPassword("admin123");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("CF", false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("CF", true, consumer);
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
                        return message;
                        
		}
        } catch (Exception e) {
             System.out.println("Error reciviendo ");
             e.printStackTrace();
        }
        return "Error";
         
    }

    private void sender(String string) {
    try {
             ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("valencia");
		factory.setPassword("admin123");
		
		Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	   
	    channel.queueDeclare("SC", false, false, false, null);
		
	    channel.basicPublish("", "SC", null, string.getBytes());
	    System.out.println(" [x] Sent '" + string + "'");
	    channel.close();
    	connection.close();
        } catch (Exception e) {
             System.out.println("Error enviando ");
             e.printStackTrace();
        } 
    }
    
     @Override
    public void run()
    {
         try {
            ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("guest");
		factory.setPassword("admin123");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("CF", false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("CF", true, consumer);
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
                        String[] resp= message.split(";");
                        String p=resp[0];
                        if(p.equals("Q1"))
                        {
                           pregunta1(resp[1]); 
                        }
                        if(p.equals("Q2"))
                        {
                            pregunta2(resp[1]); 
                        }
                        if(p.equals("Q3"))
                        {
                            pregunta3(resp[1]); 
                        }
                        if(p.equals("Q4"))
                        {
                            pregunta4(resp[1]); 
                        }
                        
		}
        } catch (Exception e) {
             System.out.println("Error reciviendo ");
             e.printStackTrace();
        }
    }    
    
    
}
