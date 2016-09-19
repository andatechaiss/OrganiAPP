package andatech.organizapp.client.gui;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import andatech.organizapp.client.Client;
import andatech.organizapp.shared.resources.EventoResource;
import andatech.organizapp.shared.resources.TareaResource;

public class ProyectoView extends Composite implements View {


	public static List<TareaResource> tareasU = new LinkedList<TareaResource>();
	public static List<TareaResource> tareasS = new LinkedList<TareaResource>();
	public static List<TareaResource> tareasF = new LinkedList<TareaResource>();
	public static MapPanel mapa = null;
	public static List<EventoResource> eventos;
	@Override
	public void show(Map<String, String> param) {
		
		RootPanel root = RootPanel.get();
		
		HorizontalPanel p = new HorizontalPanel();
		p.setWidth("100%");
		p.setHeight("80px");
		root.add(p);
		
		VerticalPanel verizq = new VerticalPanel();
		verizq.setWidth("100%");
		root.add(verizq);

		/** ------------------------ PARTE IZQUIERDA  -------------------------**/
		
		/** PAGINA DE UN PROYECTO **/

		/** Nombre del proyecto **/

		Label l = new Label(Client.get().getProyecto().getNombre());
		verizq.add(l);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setHeight("20px");
		hp2.setWidth("10%");
		hp2.setBorderWidth(0);
		verizq.add(hp2);

		/** Descripción del proyecto **/
		HorizontalPanel hp = new HorizontalPanel();
		hp.setWidth("80%");
		Label l1 = new Label(Client.get().getProyecto().getDescripcion());

		hp.add(l1);
		verizq.add(hp);

		HorizontalPanel hp3 = new HorizontalPanel();
		hp3.setHeight("30px");
		hp3.setWidth("100%");
		hp3.setBorderWidth(0);
		verizq.add(hp3);

		/** Tabla de tareas **/

		TabPanel tp = new TabPanel();
		tp.setWidth("90%");

		/** Tabla con las tareas **/

		// TAREAS SIN ASIGNAR

		final CellTable<TareaResource> tabla = new CellTable<TareaResource>();
		tabla.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Se crea la columna tarea y se añade a la tabla
		ButtonCell buttonCell = new ButtonCell();

		Column<TareaResource, String> columnaTarea = new Column<TareaResource, String>(buttonCell) {
			@Override
			public String getValue(TareaResource object) {
				// The value to display in the button.
				return object.getNombre();
			}
		};

		columnaTarea.setSortable(true);
		tabla.addColumn(columnaTarea, "Nombre");

		columnaTarea.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
			public void update(int index, TareaResource object, String value) {
				if(object.getTipo().equals("date")){
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n\n\n"
							+ "FECHA FIN: "/* + object.getFin() + "\n"*/);
				}
				else if(object.getTipo().equals("location")){
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n\n\n"/*
							+ "LOCALIZACION: \n" + "Latitud: " + object.getLatitud() + "\nLongitud: " + object.getLongitud() + "\n"*/);//TODO
				}
				else{
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n");
				}	
			}
		});

		// Se crea la columna tipo y se añade a la tabla
		TextColumn<TareaResource> columnaTipo = new TextColumn<TareaResource>() {
			@Override
			public String getValue(TareaResource tarea) {
				return tarea.getTipo().toString();
			}
		};

		tabla.addColumn(columnaTipo, "Tipo");
		columnaTipo.setSortable(true);

		// Se crea la columna para asignar y se añade a la tabla
		ButtonCell buttonAsign = new ButtonCell();

		Column<TareaResource, String> columnaAsign = new Column<TareaResource, String>(buttonAsign) {
			@Override
			public String getValue(TareaResource object) {
				// The value to display in the button.
				return ">";
			}
		};

		tabla.addColumn(columnaAsign, "");

		// Se meten los datos de la lista proyectos en la tabla
		final ListDataProvider<TareaResource> model = new ListDataProvider<TareaResource>();
		model.addDataDisplay(tabla);

		// Se añaden los datos al data provider, el cual automáticamente los
		// coloca en
		// widget.
		List<TareaResource> list = model.getList();
		for (TareaResource t : tareasU) {
			list.add(t);
		}

		// Add a ColumnSortEvent.ListHandler to connect sorting to the
		// java.util.List.

		// NOMBRE
		ListHandler<TareaResource> columnNombreSortHandler = new ListHandler<TareaResource>(list);
		columnNombreSortHandler.setComparator(columnaTarea, new Comparator<TareaResource>() {
			public int compare(TareaResource o1, TareaResource o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getNombre().compareTo(o2.getNombre()) : 1;
				}
				return -1;
			}
		});
		tabla.addColumnSortHandler(columnNombreSortHandler);

		// TIPO

		ListHandler<TareaResource> columnTipoSortHandler = new ListHandler<TareaResource>(list);
		columnTipoSortHandler.setComparator(columnaTipo, new Comparator<TareaResource>() {
			public int compare(TareaResource o1, TareaResource o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getTipo().compareTo(o2.getTipo()) : 1;
				}
				return -1;
			}
		});
		tabla.addColumnSortHandler(columnTipoSortHandler);
		tabla.getColumnSortList().push(columnaTarea);
		

		// TAREAS EN CURSO

		final CellTable<TareaResource> tabla1 = new CellTable<TareaResource>();
		tabla1.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Se crea la columna tarea y se añade a la tabla
		ButtonCell buttonCell1 = new ButtonCell();

		Column<TareaResource, String> columnaTarea1 = new Column<TareaResource, String>(buttonCell1) {
			@Override
			public String getValue(TareaResource object) {

				return object.getNombre();
			}
		};

		columnaTarea1.setSortable(true);
		tabla1.addColumn(columnaTarea1, "Nombre");

		columnaTarea1.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
			public void update(int index, TareaResource object, String value) {

				if(object.getTipo().equals("date")){
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n\n\n"/*
							+ "FECHA FIN: " + object.getFin() + "\n"*/);
				}
				else if(object.getTipo().equals("location")){
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n\n\n"/*
							+ "LOCALIZACION: \n" + "Latitud: " + object.getLatitud() + "\nLongitud: " + object.getLongitud() + "\n"*/);
				}
				else{
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n");

				}
			}
		});

		// Se crea la columna tipo y se añade a la tabla
		TextColumn<TareaResource> columnaTipo1 = new TextColumn<TareaResource>() {
			@Override
			public String getValue(TareaResource tarea) {
				return tarea.getTipo();
			}
		};

		tabla1.addColumn(columnaTipo1, "Tipo");
		columnaTipo1.setSortable(true);

		// Se crea la columna back y se añade a la tabla
		ButtonCell buttonBack1 = new ButtonCell();

		Column<TareaResource, String> columnaBack1 = new Column<TareaResource, String>(buttonBack1) {
			@Override
			public String getValue(TareaResource object) {
				// The value to display in the button.
				return "<";
			}
		};
		
		tabla1.addColumn(columnaBack1, "");
		
		//Se crea la columna finalizar y se añade a la tabla
		ButtonCell buttonFinalizar = new ButtonCell();
		Column<TareaResource, String> columnaFinalizar = new Column<TareaResource, String>(buttonFinalizar) {
			@Override
			public String getValue(TareaResource object) {
				// The value to display in the button.
				return ">";
			}
		};

		tabla1.addColumn(columnaFinalizar, "");

		// Se meten los datos de la lista proyectos en la tabla
		final ListDataProvider<TareaResource> model1 = new ListDataProvider<TareaResource>();
		model1.addDataDisplay(tabla1);
		
		List<TareaResource> list1 = model1.getList();
		for (TareaResource t : tareasS) {
			list1.add(t);
		}
		
		// Add a ColumnSortEvent.ListHandler to connect sorting to the
		// java.util.List.

		// NOMBRE
		ListHandler<TareaResource> columnNombre1SortHandler = new ListHandler<TareaResource>(model1.getList());
		columnNombre1SortHandler.setComparator(columnaTarea1, new Comparator<TareaResource>() {
			public int compare(TareaResource o1, TareaResource o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getNombre().compareTo(o2.getNombre()) : 1;
				}
				return -1;
			}
		});
		tabla1.addColumnSortHandler(columnNombre1SortHandler);

		// TIPO

		ListHandler<TareaResource> columnTipo1SortHandler = new ListHandler<TareaResource>(model1.getList());
		columnTipo1SortHandler.setComparator(columnaTipo1, new Comparator<TareaResource>() {
			public int compare(TareaResource o1, TareaResource o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getTipo().compareTo(o2.getTipo()) : 1;
				}
				return -1;
			}
		});
		tabla1.addColumnSortHandler(columnTipo1SortHandler);
		tabla1.getColumnSortList().push(columnaTarea1);
		//tabla1.setWidth("90%");
		
		
		
		// TAREAS FINALIZADAS

		final CellTable<TareaResource> tabla2 = new CellTable<TareaResource>();
		tabla2.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Se crea la columna tarea y se añade a la tabla
		ButtonCell buttonCell2 = new ButtonCell();

		Column<TareaResource, String> columnaTarea2 = new Column<TareaResource, String>(buttonCell2) {
			@Override
			public String getValue(TareaResource object) {

				return object.getNombre();
			}
		};

		columnaTarea2.setSortable(true);
		tabla2.addColumn(columnaTarea2, "Nombre");

		columnaTarea2.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
			public void update(int index, TareaResource object, String value) {
				if(object.getTipo().equals("date")){
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n\n\n"/*
							+ "FECHA FIN: " + object.getFin() + "\n"*/);
				}
				else if(object.getTipo().equals("location")){
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n\n\n"/*
							+ "LOCALIZACION: \n" + "Latitud: " + object.getLatitud() + "\nLongitud: " + object.getLongitud() + "\n"*/);//TODO
				}
				else{
					Window.alert("TAREA: " + object.getNombre() + "\n\n\nDESCRIPCION: " + object.getDescripcion() + "\n");
				}
			}
		});

		// Se crea la columna tipo y se añade a la tabla
		TextColumn<TareaResource> columnaTipo2 = new TextColumn<TareaResource>() {
			@Override
			public String getValue(TareaResource tarea) {
				return tarea.getTipo();
			}
		};

		tabla2.addColumn(columnaTipo2, "Tipo");
		columnaTipo2.setSortable(true);
		
		// Se crea la columna back y se añade a la tabla
		ButtonCell buttonBack = new ButtonCell();

		Column<TareaResource, String> columnaBack = new Column<TareaResource, String>(buttonBack) {
			@Override
			public String getValue(TareaResource object) {
				// The value to display in the button.
				return "<";
			}
		};
		
		tabla2.addColumn(columnaBack, "");


		// Se meten los datos de la lista proyectos en la tabla
		final ListDataProvider<TareaResource> model2 = new ListDataProvider<TareaResource>();
		model2.addDataDisplay(tabla2);
		
		List<TareaResource> list2 = model2.getList();
		for (TareaResource t : tareasF) {
			list2.add(t);
		}

		// Add a ColumnSortEvent.ListHandler to connect sorting to the
		// java.util.List.

		// NOMBRE
		ListHandler<TareaResource> columnNombre2SortHandler = new ListHandler<TareaResource>(model2.getList());
		columnNombre2SortHandler.setComparator(columnaTarea2, new Comparator<TareaResource>() {
			public int compare(TareaResource o1, TareaResource o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getNombre().compareTo(o2.getNombre()) : 1;
				}
				return -1;
			}
		});
		tabla2.addColumnSortHandler(columnNombre2SortHandler);
		tabla2.getColumnSortList().push(columnaTarea2);
		// TIPO

		ListHandler<TareaResource> columnTipo2SortHandler = new ListHandler<TareaResource>(model2.getList());
		columnTipo2SortHandler.setComparator(columnaTipo2, new Comparator<TareaResource>() {
			public int compare(TareaResource o1, TareaResource o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getTipo().compareTo(o2.getTipo()) : 1;
				}
				return -1;
			}
		});
		tabla2.addColumnSortHandler(columnTipo2SortHandler);
		tabla2.getColumnSortList().push(columnaTarea2);
		//tabla2.setWidth("90%");


		// Pasa tarea a "en curso"

		columnaAsign.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
			public void update(int index, TareaResource object, String value) {
				// Value is the button value. Object is the row object.
				model.getList().remove(object);
				model.refresh();
				tabla.redraw();
				model1.getList().add(object);
				model1.refresh();
				tabla1.redraw();
				tareasU.remove(object);
				tareasS.add(object);
				//TODO
			}
		});
		
		// Pasa tarea a "finalizada"

			columnaFinalizar.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
				public void update(int index, TareaResource object, String value) {
					// Value is the button value. Object is the row object.
					model1.getList().remove(object);
					model1.refresh();
					tabla1.redraw();
					model2.getList().add(object);
					model2.refresh();
					tabla2.redraw();
					tareasS.remove(object);
					tareasF.add(object);
				}
			});
			
		// Pasa tarea a "en curso" (back)

			columnaBack.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
				public void update(int index, TareaResource object, String value) {
					// Value is the button value. Object is the row object.
					model2.getList().remove(object);
					model2.refresh();
					tabla2.redraw();
					model1.getList().add(object);
					model1.refresh();
					tabla1.redraw();
					tareasS.add(object);
					tareasF.remove(object);
				}
			});
			
		// Pasa tarea a "sin asignar" (back)

			columnaBack1.setFieldUpdater(new FieldUpdater<TareaResource, String>() {
				public void update(int index, TareaResource object, String value) {
					// Value is the button value. Object is the row object.
					model1.getList().remove(object);
					model1.refresh();
					tabla1.redraw();
					model.getList().add(object);
					model.refresh();
					tabla.redraw();
					tareasU.add(object);
					tareasS.remove(object);
				}
			});

		tp.add(tabla, "Tareas sin asignar");
		tp.add(tabla1, "Tareas en curso");
		tp.add(tabla2, "Tareas finalizadas");
		tp.selectTab(0);
		ScrollPanel contenedor = new ScrollPanel(tp);
		contenedor.setHeight("200px");
		verizq.add(contenedor);
		
		
		/** ------------------------ BOTTOM  -------------------------**/
		
		HorizontalPanel hp6 = new HorizontalPanel();
		hp6.setBorderWidth(0);
		hp6.setWidth("50%");
		hp6.setHeight("30px");
		root.add(hp6);
		
		HorizontalPanel cont = new HorizontalPanel();
		cont.setWidth("100%");
		VerticalPanel bottom = new VerticalPanel();
		cont.add(bottom);
		bottom.setWidth("50%");
		mapa = new MapPanel(500, 500);
		bottom.add(mapa);
		
		HorizontalPanel hp5 = new HorizontalPanel();
		hp5.setBorderWidth(0);
		hp5.setWidth("100%");
		hp5.setHeight("40px");
		bottom.add(hp5);
		
		/** Añadir el BACK TO PROYECTOS **/
		Anchor anchor = new Anchor("Volver a Proyectos");
		anchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				FlowController.go("Proyectos", null);
			}
		});
		bottom.add(anchor);
		
		VerticalPanel bot = new VerticalPanel();
		cont.add(bot);
		bot.setWidth("50%");

		CellTable<EventoResource> calendario = new CellTable<EventoResource>();
		calendario.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		TextColumn<EventoResource> columnaFin = new TextColumn<EventoResource>() {
			@Override
			public String getValue(EventoResource evento) {

				return evento.getEndDia() + "/" + evento.getEndMes() + "/" + evento.getEndAnio();
			}
		};
		calendario.addColumn(columnaFin, "Fin");
		
		
		ListDataProvider<EventoResource> dataProvider = new ListDataProvider<EventoResource>();
		// Se conecta nuestra tabla con dataProvider
		dataProvider.addDataDisplay(calendario);

		// Se añaden los datos al data provider, el cual automáticamente los
		// coloca en
		// widget.
		List<EventoResource> list3 = dataProvider.getList();
		for (EventoResource ev : eventos) {
			list3.add(ev);
		}

		
		
		Button crearTarea = new Button("CREAR TAREA", new ClickHandler() {

		   @Override
		   public void onClick(ClickEvent event) {
		    FlowController.go("NuevaTarjeta", null);
		    
		   }
		   
		  });
		
		root.add(crearTarea);
		cont.add(bottom);
		cont.add(bot);
		root.add(cont);
		HorizontalPanel hp4 = new HorizontalPanel();
		hp4.setBorderWidth(0);
		hp4.setWidth("50%");
		hp4.setHeight("50px");
		root.add(hp4);
				
	}

	@Override
	public void update(Map<String, String> param) {

	}

}
