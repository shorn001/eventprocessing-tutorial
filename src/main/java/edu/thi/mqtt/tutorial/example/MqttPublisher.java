package edu.thi.mqtt.tutorial.example;

import org.eclipse.paho.client.mqttv3.MqttException;

import edu.thi.mqtt.tutorial.client.Client;
import edu.thi.mqtt.tutorial.client.MqttListener;

public class MqttPublisher {

    public static void main(String[] args) throws MqttException {
        Client publishClient1 = null;
        Client publishClient2 = null;
        MqttListener listener1 = new MqttListener();
        MqttListener listener2 = new MqttListener();
        String broker = "tcp://localhost:1883";
        
        try {
            publishClient1 = new Client("Anlage1", broker, listener1, 2);
            publishClient2 = new Client("Anlage2", broker, listener2, 1);
            
            while(true){
                publishClient1.publish("Temperatur", String.valueOf(getTemperature()));
                publishClient2.publish("Temperatur", String.valueOf(getTemperature()));
                publishClient1.publish("Drehzahl", String.valueOf(getDrehzahl()));
                publishClient2.publish("Drehzahl", String.valueOf(getDrehzahl()));
                Thread.sleep(200);
            }
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (publishClient1 != null) {
                publishClient1.disconnect();
            }
            if (publishClient2 != null) {
                publishClient2.disconnect();
            }
        }

    }

    public static int getTemperature(){
        return (int)(Math.random() * 100);
    }
    
    public static int getDrehzahl(){
        return (int)(Math.random() * 10000);
    }
}
