package edu.thi.esper.tutorial.jms;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;



import edu.thi.esper.tutorial.events.Temperature;

/*
 * Adapted from Example "QueueProducer" of the JMS Tutorial by Prof. Dr. Volker Stiehl
 */
public class JmsTestProducer {

    public static void main(String[] args) throws JMSException {
        int messages = 200;

        
        String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        Destination destination;
        Connection connection = null;
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
        
        //Anpassung für Tutorial: 
		//Security blockt normalerweise alle unbekannten Klassen einer Object Message
		//Dieser Befehl schaltet dieses Verhalten ab (siehe auch JmsConsumer)
        connectionFactory.setTrustAllPackages(true);
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);    // Transaction == false
        destination = session.createQueue("TestEventQueue");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);          // Nachrichten werden nicht persistiert --> Stürzt JMS-Provider ab,
                                                                        // sind sämtliche Nachrichten verloren --> QoS "At Most Once"
                                                                        // Alternative: PERSISTENT --> QoS "Exactly Once"
        
        //Gleiche Prozedur wie bei der Lokalen Eventerzeugung, allerdings wird hier das Event
        //als JMS Message verschickt
        Temperature temp;
        Random rnd = new Random();
        for( int i=1; i <= messages; i ++) {
               temp = new Temperature(rnd.nextInt(500));
               System.out.println("Input: Neue Temperatur wird generiert: "+ temp.getTemperature());
               
               //hier wird das Objekt als Object Message verschickt
               ObjectMessage msg = session.createObjectMessage(temp);
               producer.send(msg);
        }
        connection.close();
    }

}
