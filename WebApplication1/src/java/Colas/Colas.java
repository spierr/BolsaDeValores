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
import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public class Colas extends Thread{
    private final static String QUEUE_NAME = "CF";
    private Colas cola;
    
    private Colas()
    {
         cola.start();
    }
    public Colas darInstancia(){
    if(cola==null)
    {
        cola = new Colas();
    }
       return cola;
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
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);
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

    private void pregunta1(String resp) {
         conexionDB x= new conexionDB();
        x.setAutoCommit(false);
        ResultSet r = x.consultar("");
        
        
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
             System.out.println("Error eliminando ");
             e.printStackTrace();
        }
    
    }

    private void pregunta3(String resp) {
    }

    private void pregunta4(String resp) {
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
        //Consultas.consultarSolicitudesPrimasriasPorIntermediario(null, FECHA2);  
        return null;
    }

    public ArrayList<ValoresDeInversionistas> valoresMasDinamicos(String FECHA1, String FECHA2) {
       String resp= reciver("");
       return null;
    }
    
  
    private String reciver(String enviar){
         try {
             ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("brochero");
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
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);
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
		factory.setUsername("brochero");
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
        } }
    
    
    
}
