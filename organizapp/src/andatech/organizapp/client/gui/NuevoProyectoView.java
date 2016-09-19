package andatech.organizapp.client.gui;

import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import andatech.organizapp.client.Autenticacion;
import andatech.organizapp.client.CallerRPC;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;

public class NuevoProyectoView extends Composite implements View {

	public List<TareaResource> nuevasTareas;

	@Override
	public void show(Map<String, String> param) {

		/** PÁGINA DE CREACIÓN DE PROYECTO **/

		final RootPanel root = RootPanel.get();
		HorizontalPanel p = new HorizontalPanel();
		p.setWidth("100%");
		p.setHeight("80px");
		p.setBorderWidth(0);
		root.add(p);

		/** Texto nuevo proyecto **/

		HorizontalPanel p1 = new HorizontalPanel();
		p1.setWidth("30%");
		p1.setHeight("30px");
		p1.setBorderWidth(0);

		// Texto NUEVO PROYECTO
		Label l = new Label("NUEVO PROYECTO");
		p1.add(l);
		root.add(p1);

		HorizontalPanel p2 = new HorizontalPanel();
		p2.setWidth("30%");
		p2.setHeight("30px");
		p2.setBorderWidth(0);
		root.add(p2);

		// NOMBRE
		Label nombre = new Label("Nombre: ");
		root.add(nombre);
		final TextBox tb = new TextBox();
		root.add(tb);

		HorizontalPanel p3 = new HorizontalPanel();
		p3.setWidth("30%");
		p3.setHeight("30px");
		p3.setBorderWidth(0);
		root.add(p3);

		// DESCRIPCION
		Label descripcion = new Label("Descripcion: ");
		root.add(descripcion);
		final RichTextArea rta = new RichTextArea();
		root.add(rta);

		HorizontalPanel p4 = new HorizontalPanel();
		p4.setWidth("30%");
		p4.setHeight("50px");
		p4.setBorderWidth(0);
		root.add(p4);

		HorizontalPanel crear = new HorizontalPanel();

		Button crearProyecto = new Button("CREAR PROYECTO");
		crearProyecto.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) 
			{
				CallerRPC.oa.createProject(Autenticacion.googleToken(), Autenticacion.trelloToken(), tb.getValue(), rta.getText(), new AsyncCallback<ProyectoResource>(){
					public void onFailure(Throwable caught) {}
					public void onSuccess(ProyectoResource result) {
						ProyectosView.aniadeProyectoResource(result.getId(), result.getNombre(), result.getDescripcion());
						if(FlowController.getActiva().equals("Proyectos"))
							FlowController.go("Proyectos", null);
						//TODO
					}
				});
			}
		});
		crear.add(crearProyecto);

		/** Añadir el BACK TO PROYECTOS **/
		Anchor anchor = new Anchor(".                  Volver a Proyectos");
		anchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				FlowController.go("Proyectos", null);
			}
		});

		crear.add(anchor);
		root.add(crear);

		HorizontalPanel fin = new HorizontalPanel();
		fin.setHeight("50px");
		fin.setWidth("100%");
		root.add(fin);

	}

	@Override
	public void update(Map<String, String> param) {

	}

}

