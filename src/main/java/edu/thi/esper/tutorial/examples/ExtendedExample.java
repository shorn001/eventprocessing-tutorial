package edu.thi.esper.tutorial.examples;

import java.util.Random;

import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import edu.thi.esper.tutorial.events.Temperature;
import edu.thi.esper.tutorial.subscriber.CriticalSubscriber;
import edu.thi.esper.tutorial.subscriber.MonitorSubscriber;
import edu.thi.esper.tutorial.subscriber.WarningSubscriber;


//Dieses Beispiel soll die Temperaturüberwachung in einem Atomkraftwert zeigen
//Im Rahmen des EventProcessings werde folgende Events abgeleitet
//Monitor: Eine Zusammenfassung (Durchschnittstemperatur) alle 5 Sekunden
//Warning: zwei Temperaturen in Folge über dem Grenzwert (400 Grad)
//Critical: 4 aufeinander folgende Events jeweils steigend und 
//über einem Grenzwert von 100 Grad die letzte Temperatur ist 1,5 Fach über der Anfangstemperatur
//Dieses Beispiel wurde adaptiert von http://www.adrianmilne.com/complex-event-processing-made-easy/

public class ExtendedExample {
    private EPServiceProvider _engine;

    public static void main(String[] args) throws InterruptedException {
    	//Erzeugen einer Instanz der Anwendung
        ExtendedExample example = new ExtendedExample();
        
        //Initialisieren des Eventprocesings
        example.configure();
        
        //Starten der Eventverarbeitung
        example.run();
     
        
    }

    public void configure() {
    	//Hier wird die Engine bei Programmstart koniguriert

    }

    public void run() throws InterruptedException {
    	//Für dieses Beispiel wird kein externer Event Channel (Mqtt,JMS) angebunden.
    	//um das Eventprocessing zu testen werden hier Events erzeugt und an die Engine gesendet

    }
}
