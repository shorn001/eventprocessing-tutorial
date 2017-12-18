package edu.thi.esper.tutorial.subscriber;

import java.util.Map;

import edu.thi.esper.tutorial.events.Temperature;

//Critical: 4 aufeinander folgende Events jeweils steigend und 
//über einem Grenzwert von 100 Grad die letzte Temperatur ist 1,5 Fach über der Anfangstemperatur
public class CriticalSubscriber {
    // Adapted from https://github.com/adrianmilne/esper-demo-nuclear/blob/master/src/main/java/com/cor/cep/subscriber/CriticalEventSubscriber.java
    /** Used as the minimum starting threshold for a critical event. */
    private static final String CRITICAL_EVENT_THRESHOLD = "100";
    
    
    /**
     * If the last event in a critical sequence is this much greater than the first - issue a
     * critical alert.
     */
    private static final String CRITICAL_EVENT_MULTIPLIER = "1.5";
    

    public String getStatement() {
        //Hier wird das EPL Query für den jeweiligen Subscriber als String erzeugt
    	return "select...";
    }
    
    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, Temperature> eventMap) {
    	//Hier wird der Code für den Callback platziert.
    }
}
