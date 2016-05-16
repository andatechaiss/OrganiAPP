package andatech.organizapp.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;


public class Organizapp implements EntryPoint {
	
	public void onModuleLoad() {
		/*final ClientRPCAsync contactService = GWT.create(ClientRPC.class);
		contactService.callRPC(new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable e) {
				Window.alert("Error loading contacts: " + e.getMessage());
				
			}

			@Override
			public void onSuccess(Void vo) {
				Window.alert("Manu gay!!");
			}
		});*/
		Button bt = new Button("Clica!");
		bt.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				Auth.authorize();
			}
		});
		Button bt2 = new Button("Fueraaaa!");
		bt.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				Auth.desAuthorize();
			}
		});
		Button bt1 = new Button("Clica!");
		Element elem = bt1.getElement();
		elem.setAttribute("onclick", "trelloAuth();");
		
		RootPanel.get().add(bt);
		RootPanel.get().add(bt1);
		RootPanel.get().add(bt2);
	}
}
