package edu.thi.esper.tutorial.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

//Ein Listener Implementiert das Interface UpdateListener
public class MySimpleListener implements UpdateListener {

	// Implementierung der Methode Update. Diese wird als Callback von Esper
	// aufgerufen,
	// wenn ein neues Ergebnis aus dem Eventprocessing vorliegt
	public void update(EventBean[] newData, EventBean[] oldData) {
		

	}

}