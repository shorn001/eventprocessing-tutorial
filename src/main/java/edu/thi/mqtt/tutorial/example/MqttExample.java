package edu.thi.mqtt.tutorial.example;

import org.eclipse.paho.client.mqttv3.MqttException;

import edu.thi.mqtt.tutorial.client.Client;
import edu.thi.mqtt.tutorial.client.MqttListener;

public class MqttExample {

    public static void main(String[] args) {
        MqttListener listener1 = new MqttListener();
        MqttListener listener2 = new MqttListener();
        MqttListener listener3 = new MqttListener();
        MqttListener listener4 = new MqttListener();
        String broker = "tcp://localhost:1883";
        
        try {
            Client publishClient1 = new Client("Anlage1", broker, listener1, 2);
            Client publishClient2 = new Client("Anlage2", broker, listener2, 1);
            Client subscribeClient1 = new Client("Subscriber1", broker, listener3, 2);
            Client subscribeClient2 = new Client("Subscriber2", broker, listener4, 2);
            
            //You need to insert Code here.

            System.exit(1);
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  
    public static int getTemperature(){
        return (int)(Math.random() * 100);
    }
    
    public static int getDrehzahl(){
        return (int)(Math.random() * 10000);
    }
}
