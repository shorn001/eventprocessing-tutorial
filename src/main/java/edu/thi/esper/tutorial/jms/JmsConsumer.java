package edu.thi.esper.tutorial.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Adapted from Example "TopicAsyncConsumer" of the JMS Tutorial by Prof. Dr. Volker Stiehl
 */

public class JmsConsumer {
	//Hier wird unser eigener MessageListener gespeichert
	private MessageListener listener;

	public JmsConsumer(MessageListener listener) {
		this.listener = listener;
	}

	public void init() {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		Queue queue;
		Connection connection = null;

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
		try {
			//Anpassung für Tutorial: 
			//Security blockt normalerweise alle unbekannten Klassen einer Object Message
			//Dieser Befehl schaltet dieses Verhalten ab
			connectionFactory.setTrustAllPackages(true);
			connection = connectionFactory.createConnection();
			connection.start();
			Session subSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			queue = subSession.createQueue("TestEventQueue");

			MessageConsumer subscriber = subSession.createConsumer(queue);
			subscriber.setMessageListener(listener);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
