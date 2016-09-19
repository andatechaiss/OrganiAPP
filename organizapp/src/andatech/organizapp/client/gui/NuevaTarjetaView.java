package andatech.organizapp.client.gui;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import andatech.organizapp.client.Autenticacion;
import andatech.organizapp.client.CallerRPC;
import andatech.organizapp.client.Client;
import andatech.organizapp.shared.resources.EventoResource;
import andatech.organizapp.shared.resources.TareaResource;
import andatech.organizapp.shared.resources.UbicacionResource;

public class NuevaTarjetaView extends Composite implements View {

	public List<TareaResource> nuevasTareas;
	String tareaTabla = "";
	String descripcionTabla = "";
	String tipoTabla = "";

	@Override
	public void show(Map<String, String> param) {
		final RootPanel root = RootPanel.get();

		// TAREAS
		final TareaResource dateString = new TareaResource();
		dateString.setNombre("");
		Label tareas = new Label("TAREAS: ");
		root.add(tareas);
		
		
		HorizontalPanel p11 = new HorizontalPanel();
		p11.setWidth("30%");
		p11.setHeight("20px");
		p11.setBorderWidth(0);
		root.add(p11);

		Label tipo = new Label("Tipo: ");
		root.add(tipo);
		final ListBox lb = new ListBox();

		final VerticalPanel cont = new VerticalPanel();
		final TextBox lon = new TextBox();
		final TextBox lat = new TextBox();
		final TextArea ta = new TextArea();
		final TextBox textb = new TextBox();
		ChangeHandler ch = new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				cont.clear();
				if(lb.getItemText(0).equals(""))
					lb.removeItem(0);
				
				if (lb.getSelectedItemText().equals("Tarea")) {
					
					HorizontalPanel p12 = new HorizontalPanel();
					p12.setWidth("30%");
					p12.setHeight("15px");
					p12.setBorderWidth(0);
					cont.add(p12);
					
					Label tarea = new Label("Titulo: ");
					cont.add(tarea);
					cont.add(textb);

					HorizontalPanel p9 = new HorizontalPanel();
					p9.setWidth("30%");
					p9.setHeight("30px");
					p9.setBorderWidth(0);
					cont.add(p9);

					Label descrip = new Label("Descripcion: ");
					cont.add(descrip);
					cont.add(ta);
					
					//Actualización de variables para introducirlas en la tabla
					ChangeHandler cambioNombre = new ChangeHandler(){

						@Override
						public void onChange(ChangeEvent event) {
							tareaTabla = textb.getText();
						}
					};
					textb.addChangeHandler(cambioNombre);
					
					ChangeHandler cambioDescr = new ChangeHandler(){

						@Override
						public void onChange(ChangeEvent event) {
							descripcionTabla = ta.getText();
						}
					};
					ta.addChangeHandler(cambioDescr);

					tipoTabla = "Tarea";
				}
				
				else if(lb.getSelectedItemText().equals("Evento")){
					HorizontalPanel p12 = new HorizontalPanel();
					p12.setWidth("30%");
					p12.setHeight("15px");
					p12.setBorderWidth(0);
					cont.add(p12);
					
					Label tarea = new Label("Titulo: ");
					cont.add(tarea);
					cont.add(textb);

					HorizontalPanel p9 = new HorizontalPanel();
					p9.setWidth("30%");
					p9.setHeight("30px");
					p9.setBorderWidth(0);
					cont.add(p9);

					Label descrip = new Label("Descripcion: ");
					cont.add(descrip);
					cont.add(ta);

					HorizontalPanel p10 = new HorizontalPanel();
					p10.setWidth("30%");
					p10.setHeight("30px");
					p10.setBorderWidth(0);
					cont.add(p10);	
					
					Label fecha = new Label("Fecha:");
					cont.add(fecha);
					DatePicker datePicker = new DatePicker();
					datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
					      public void onValueChange(ValueChangeEvent<Date> event) {
					        Date date = event.getValue();
					        dateString.setNombre(DateTimeFormat.getFormat("dd-MM-yyyy").format(date));
					      }
					    });

					    // Set the default value
					    datePicker.setValue(new Date(), true);
					cont.add(datePicker);
					
					//Actualización de variables para introducirlas en la tabla
					tareaTabla = textb.getText();
					descripcionTabla = ta.getText();
					tipoTabla = "Evento";
					
				}
				
				else if(lb.getSelectedItemText().equals("Ubicacion")){
					HorizontalPanel p12 = new HorizontalPanel();
					p12.setWidth("30%");
					p12.setHeight("15px");
					p12.setBorderWidth(0);
					cont.add(p12);
					
					Label tarea = new Label("Titulo: ");
					cont.add(tarea);
					cont.add(textb);

					HorizontalPanel p9 = new HorizontalPanel();
					p9.setWidth("30%");
					p9.setHeight("30px");
					p9.setBorderWidth(0);
					cont.add(p9);

					Label descrip = new Label("Descripcion: ");
					cont.add(descrip);
					cont.add(ta);

					HorizontalPanel p10 = new HorizontalPanel();
					p10.setWidth("30%");
					p10.setHeight("30px");
					p10.setBorderWidth(0);
					cont.add(p10);	
					
					Label latitud = new Label("Latitud: ");
					cont.add(latitud);
					cont.add(lat);
					
					HorizontalPanel p11 = new HorizontalPanel();
					p11.setWidth("30%");
					p11.setHeight("30px");
					p11.setBorderWidth(0);
					cont.add(p11);
					
					Label longitud = new Label("Longitud: ");
					cont.add(longitud);
					cont.add(lon);
					
					//Actualización de variables para introducirlas en la tabla
					tareaTabla = textb.getText();
					descripcionTabla = ta.getText();
					tipoTabla = "Ubicacion";
				}
				else{
					
				}
			}

		};
		
		lb.addItem("");
		lb.addItem("Tarea");
		lb.addItem("Evento");
		lb.addItem("Ubicacion");
		root.add(lb);
		
//		lb.dateString
		
		
		lb.addChangeHandler(ch);
		root.add(cont);

		HorizontalPanel p5 = new HorizontalPanel();
		p5.setWidth("30%");
		p5.setHeight("30px");
		p5.setBorderWidth(0);
		root.add(p5);

		// Creador de tareas

		// --------

		HorizontalPanel p7 = new HorizontalPanel();
		p7.setWidth("30%");
		p7.setHeight("15px");
		p7.setBorderWidth(0);
		root.add(p7);

		 // Añadir una nueva tarea
		 Button nuevaTarea = new Button("Nueva tarjeta", new ClickHandler() {
		 public void onClick(ClickEvent event) {
			switch(lb.getSelectedItemText())
			{
				case "Tarea":
				TareaResource task = new TareaResource();
				task.setNombre(textb.getValue());
				task.setDescripcion(ta.getValue());
				task.setEstado("unassigned");
				CallerRPC.oa.insertTaskCard(Autenticacion.trelloToken(), Client.get().getProyecto(), task, new AsyncCallback<TareaResource>(){
						public void onFailure(Throwable caught) {}
						public void onSuccess(TareaResource result) {
							switch(result.getEstado())
							{
								case "unassigned":
									Client.get().getListaTareasSinAsignar().add(result);
									ProyectoView.tareasU.add(result);
									break;
								case "started":
									Client.get().getListaTareasEmpezadas().add(result);
									ProyectoView.tareasS.add(result);
									break;
								case "finished":
									Client.get().getListaTareasTerminadas().add(result);
									ProyectoView.tareasF.add(result);
									break;
							}
							FlowController.go("Proyecto", null);
						}
					});
					break;
					
				case "Evento":
				final EventoResource e = new EventoResource();
				CallerRPC.oa.insertEvent(Autenticacion.googleToken(), Autenticacion.trelloToken(), Client.get().getProyecto(), e, new AsyncCallback<String>(){
						public void onFailure(Throwable caught) {}
						public void onSuccess(String result) {
							String []arr = dateString.getNombre().split("-");
							e.setStartDia(arr[0]);
							e.setStartMes(arr[1]);
							e.setStartAnio(arr[2]);
							e.setEndDia(arr[0]);
							e.setEndMes(arr[1]);
							e.setEndAnio(arr[2]);
						}
					});
					FlowController.go("Proyecto", null);
					break;
					
				case "Ubicacion":
					final UbicacionResource u = new UbicacionResource();
					u.setNombre(textb.getValue());
					u.setDescripcion(ta.getValue());
					u.setLatitud(new Double(lat.getValue()));
					u.setLongitud(new Double(lon.getValue()));
					CallerRPC.oa.insertLocationCard( Autenticacion.trelloToken(), Client.get().getProyecto(), u, new AsyncCallback<String>(){
						public void onFailure(Throwable caught) {}
						public void onSuccess(String result) {
							u.setId(result);
							Client.get().getListaUbicaciones().add(u);
							ProyectoView.mapa.getMarcas().add(MapPanel.crearMarca(u.getLatitud(), u.getLongitud(), u.getNombre(), u.getDescripcion()));
							FlowController.go("Proyecto", null);
						}
					});
					break;
					
				default:
					Window.alert("Error");
					break;
			}
		 }
		 });
		
		 root.add(nuevaTarea);

		HorizontalPanel p6 = new HorizontalPanel();
		p6.setWidth("100%");
		p6.setHeight("30px");
		p6.setBorderWidth(0);
		root.add(p6);

		HorizontalPanel crear = new HorizontalPanel();

		/** Añadir el BACK TO PROYECTOS **/
		Anchor anchor = new Anchor(".                  Volver al Proyecto");
		anchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				FlowController.go("Proyecto", null);
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
		// TODO Auto-generated method stub

	}

}

