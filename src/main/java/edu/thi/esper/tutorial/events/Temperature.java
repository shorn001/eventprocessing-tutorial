package edu.thi.esper.tutorial.events;

import java.io.Serializable;


//Die Klasse Temperature ermöglicht eine Repräsentation des Temperaturevents als Java Objekt
//Dafür weist die Klasse sämtliche Informationen des Events auf.
//In diesem Beispiel gibt es lediglich ein Attribut: Temperatur (als Integerwert)
public class Temperature implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2133982642468789248L;

    public Temperature(int temperature) {
        super();
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    //Speichert die gemessene Temperatur
    private int temperature;
}
