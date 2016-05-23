package andatech.organizapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import andatech.organizapp.client.rpc.CalendarRPC;
import andatech.organizapp.client.rpc.CalendarRPCAsync;

public class Organizapp implements EntryPoint {
	
	  public void onModuleLoad() {

		
		Button bt = new Button("Clica!");
		bt.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				Autenticacion.authorize();
			}
		});
		Button bt2 = new Button("Fueraaaa!");
		bt2.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				//Auth.desAuthorize();
				final CalendarRPCAsync contactService = GWT.create(CalendarRPC.class);
				contactService.deleteCalendarEvent(Autenticacion.token_google, "primary",
						"qfjt88j9157ai20v6c8i56v6ec", new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable e) {
						Window.alert("Error loading contacts: " + e.getMessage());
						
					}

					@Override
					public void onSuccess(Boolean result) {
						Window.alert(result.toString());
						
					}
				});
			}
		});
//		Button bt1 = new Button("Clica!");
//		Element elem = bt1.getElement();
//		elem.setAttribute("onclick", "trelloAuth();");
//	
		RootPanel.get().add(bt);
//		RootPanel.get().add(bt1);
		RootPanel.get().add(bt2);	
		
		
	}
	  
}
		