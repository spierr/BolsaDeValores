/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;
import VOS.ValoresDeInversionistas;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
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
        
    }       
    public void escuchar(){
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
   }

    private void pregunta2(String resp) {
    }

    private void pregunta3(String resp) {
    }

    private void pregunta4(String resp) {
    }
    //este es el metodo indio del split del boolean y el numero
    public String recomponerPortafolio(String EMAILINVER, int IDPORTAFOLIO, ArrayList<ValoresDeInversionistas> valores) {
        return null;
    }

    public String retirarIntermediario(String emailIntermediario) {
        return null;
    }

    public ArrayList<ValoresDeInversionistas> consultarMovimiento(String NOMVALOR, int RENTABILIDAD, String EMAILCOMPRADOR, String FECHA1, String FECHA2) {
        return null;    
    }

    public ArrayList<ValoresDeInversionistas> valoresMasDinamicos(String FECHA1, String FECHA2) {
        return null;
    }
    
    
}
