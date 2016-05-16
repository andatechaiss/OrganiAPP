package andatech.organizapp.client.gui;

import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class MapsView extends Composite implements View {

	public MapsView() {
	}

	public void show(Map<String, String> param) {
		RootPanel.get().clear();
		HorizontalPanel panel = new HorizontalPanel();
		final Button sendButton = new Button("Mapa");
		panel.add(sendButton);

		class MyHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				getMapa();
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void getMapa() {
				new JsonpRequestBuilder().send("http://maps.googleapis.com/maps/api/js?sensor=false",
						new AsyncCallback<Void>() {

							public void onFailure(Throwable caught) {
								Window.alert("Error loading map: " + caught.getMessage());
							}

							public void onSuccess(Void result) {
							}
						});

			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
	}

	@Override
	public void update(Map<String, String> param) {

	}

}
