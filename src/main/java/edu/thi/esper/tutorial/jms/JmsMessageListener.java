package edu.thi.esper.tutorial.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.activemq.command.ActiveMQObjectMessage;

import com.espertech.esper.client.EPServiceProvider;

import edu.thi.esper.tutorial.events.Temperature;

/*
 * Adapted from Example "Topic Message Listener" of the JMS Tutorial by Prof. Dr. Volker Stiehl
 */

public class JmsMessageListener implements MessageListener {
    private EPServiceProvider _engine;
    
    

    public JmsMessageListener(EPServiceProvider _engine) {
        super();
        this._engine = _engine;
    }



    public EPServiceProvider get_engine() {
        return _engine;
    }




    public void onMessage(Message msg) {
    	//Methode, die JMS Object Messages entgegennimmt
    }
}
