package edu.thi.esper.tutorial.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.espertech.esper.client.EPServiceProvider;

import edu.thi.esper.tutorial.events.Temperature;

//Adapted from https://github.com/aksakalli/EsperIoT/blob/master/src/main/java/org/esperiot/service/EventListener.java
public class MyMqttListener implements MqttCallback {
    
    private EPServiceProvider _engine;
    
    
    
    public EPServiceProvider get_engine() {
        return _engine;
    }

    public void set_engine(EPServiceProvider _engine) {
        this._engine = _engine;
    }

    public void connectionLost(Throwable arg0) {
        System.out.println("Error: Connection to MQTT Broker lost");
        
    }

    public void deliveryComplete(IMqttDeliveryToken arg0) {
        // TODO Auto-generated method stub
        
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
       //Für jede Eingehende MQTT Nachricht wird diese Methode aufgerufen
        
    }

}
