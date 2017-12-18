package edu.thi.esper.tutorial.examples;

import java.util.Random;


import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import edu.thi.esper.tutorial.events.Temperature;
import edu.thi.esper.tutorial.listener.MySimpleListener;

public class BasicExample {

    private EPServiceProvider _engine;

    public static void main(String[] args){
    	//Erzeugen einer Instanz der Anwendung
        BasicExample example = new BasicExample();
        
        //Initialisieren des Eventprocesings
        example.configure();
        
        //Starten der Eventverarbeitung
        example.run();
    }
    
    public  void configure(){
    	//Hier wird die Engine bei Programmstart koniguriert
    }
    
    public void run() {
    	//Für dieses Beispiel wird kein externer Event Channel (Mqtt,JMS) angebunden.
    	//um das Eventprocessing zu testen werden hier Events erzeugt und an die Engine gesendet
        
    }
    
}
