package edu.thi.esper.tutorial.subscriber;

import java.util.Map;

//Monitor: Eine Zusammenfassung (Durchschnittstemperatur) alle 5 Sekunden
public class MonitorSubscriber {
    //Adapted form https://github.com/adrianmilne/esper-demo-nuclear/blob/master/src/main/java/com/cor/cep/subscriber/MonitorEventSubscriber.java
    public String getStatement() {
    	//Hier wird das EPL Query für den jeweiligen Subscriber als String erzeugt
    	return "select...";
    }

    /**
     * Listener method called when Esper has detected a pattern match.
     */
    public void update(Map<String, Double> eventMap) {
    	//Hier wird der Code für den Callback platziert.
    }
}
