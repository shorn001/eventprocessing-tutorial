package edu.thi.esper.tutorial.mqtt;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import com.espertech.esper.client.EPServiceProvider;

public class MyMqttClient extends MqttClient {
    
    MqttCallback listener;
    
    public MyMqttClient(MqttCallback listener,String serverUri) throws MqttException
    {
       super(serverUri,"Esper");   
       this.listener = listener;
       this.init();
  
    }
    
    public void init() {
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        
        try {
      
            this.connect(connOpts);
       
            this.setCallback(listener);
            //Der Mqtt Client muss sich hier auf das Temperatur Event subscriben
            
        } catch (MqttSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
