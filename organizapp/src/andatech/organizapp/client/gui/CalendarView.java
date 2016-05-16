package andatech.organizapp.client.gui;

import java.util.Map;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import andatech.organizapp.client.rpc.ClientRPC;
import andatech.organizapp.client.rpc.ClientRPCAsync;

public class CalendarView extends Composite implements View {
	final ClientRPCAsync rpc = GWT.create(ClientRPC.class);
	final HorizontalPanel mainPanel = new HorizontalPanel();
	
	@Override
	public void show(Map<String, String> param) {
		Button creaEvento = new Button("Crear evento");
		mainPanel.add(creaEvento);
		creaEvento.addClickHandler(new ClickHandler() {
			 public void onClick(ClickEvent event) {
				 
			 }
		});
		
		
	}

	@Override
	public void update(Map<String, String> param) {
		
		
	}

}
