package andatech.organizapp.client.gui;

import java.util.Map;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class MainView extends Composite implements View {

	public void show(Map<String, String> param) {
		RootPanel.get().clear();
		HorizontalPanel panel = new HorizontalPanel();
		final Button OauthButton = new Button("Autenticate");
		final Button MapsButton = new Button("Maps");
		final Button CalendarButton = new Button("Calendar");
		final Button TrelloButton = new Button("Trello");
		panel.add(OauthButton);
		panel.add(MapsButton);
		panel.add(CalendarButton);
		panel.add(TrelloButton);
	}

	public void update(Map<String, String> param) {
		// TODO Auto-generated method stub

	}

}
