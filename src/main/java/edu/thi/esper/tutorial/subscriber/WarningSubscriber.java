package edu.thi.esper.tutorial.subscriber;

import java.util.Map;
import edu.thi.esper.tutorial.events.Temperature;

//Warning: zwei Temperaturen in Folge über dem Grenzwert (400 Grad)
public class WarningSubscriber {
    
    //Code Adapted from Esper Nuclear Example
    //https://github.com/adrianmilne/esper-demo-nuclear/blob/master/src/main/java/com/cor/cep/subscriber/WarningEventSubscriber.java
    
    /** If 2 consecutive temperature events are greater than this - issue a warning */
    private static final String WARNING_EVENT_THRESHOLD = "200";

    
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
