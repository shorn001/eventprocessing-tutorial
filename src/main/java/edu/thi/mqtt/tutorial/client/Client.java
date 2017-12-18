/**
 * 
 */
package edu.thi.mqtt.tutorial.client;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author lars
 * A small sample class for a MQTT client.
 * There are some default settings, which are made in this class.
 * Some settings can not be set with this client. If you need them you'll need to extend the client class.
 *
 */
public class Client {
    
    private String clientId;
    private String broker;
    private int qos;
    private MqttClient client;
    private MqttConnectOptions options;
    private MemoryPersistence persistence;
    private MqttListener listener;
    

    public Client(String clientId, String broker, MqttListener listener, int qos) throws MqttException {
        super();
        this.clientId = clientId;
        this.broker = broker;
        this.qos = qos;
        this.persistence = new MemoryPersistence();
        this.listener = listener;
        this.listener.setClientId(clientId);
        this.client = new MqttClient(broker, clientId, persistence);
        this.options = new MqttConnectOptions();
        this.options.setCleanSession(true);
        this.options.setWill("ClientInfo/" + clientId, ("Bye" + clientId).getBytes(), qos, false);
        
        this.client.setCallback(this.listener);
        this.client.connect(this.options);
        System.out.println(clientId + " connected to broker: " + broker);
    }
    
    public void disconnect() throws MqttException{
        client.disconnect();
    }
    
    public void publish(String subtopic, String content) throws MqttPersistenceException, MqttException{
        //This needs to be implemented
    }
    
    public void subscribe(String topic) throws MqttException{
        //This needs to be implemented
    }
    

}
