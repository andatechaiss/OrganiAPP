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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;

import andatech.organizapp.client.Autenticacion;
import andatech.organizapp.client.CallerRPC;
import andatech.organizapp.client.Client;
import andatech.organizapp.client.resources.utils.CallbackVoid;
import andatech.organizapp.shared.resources.ProyectoResource;

public class ProyectosView extends Composite implements View {

	public static List<ProyectoResource> proyectos = new LinkedList<ProyectoResource>();

	@Override
	public void show(Map<String, String> param) {

		/** Guardar espacio de cabecera **/

		RootPanel root = RootPanel.get();
		HorizontalPanel p = new HorizontalPanel();
		p.setWidth("100%");
		p.setHeight("80px");
		p.setBorderWidth(0);
		root.add(p);

		/** Texto "MIS PROYECTOS" **/

		HorizontalPanel p1 = new HorizontalPanel();
		p1.setWidth("100%");
		p1.setHeight("30px");
		// p1.setBorderWidth(0);
		Label l = new Label("	MIS PROYECTOS ");
		p1.add(l);

		/** Botón CREAR UN ProyectoResource **/
		Button b1 = new Button("CREAR PROYECTO");
		b1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//FlowController.go("NuevoProyecto", null);
				FlowController.go("NuevaTarjeta", null);
			}

		});
		p1.add(b1);
		root.add(p1);

		// Espacio entre texto y tabla
		HorizontalPanel barra = new HorizontalPanel();
		barra.setWidth("100%");
		barra.setHeight("30px");
		barra.setBorderWidth(0);
		root.add(barra);

		/** Tabla con los ProyectoResources **/

		final CellTable<ProyectoResource> tabla = new CellTable<ProyectoResource>();
		tabla.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		ButtonCell buttonCell = new ButtonCell();

		Column<ProyectoResource, String> columnaNombre = new Column<ProyectoResource, String>(buttonCell) {
			@Override
			public String getValue(ProyectoResource object) {
				// The value to display in the button.
				return object.getNombre();
			}
		};

		columnaNombre.setSortable(true);
		tabla.addColumn(columnaNombre, "Nombre");

		columnaNombre.setFieldUpdater(new FieldUpdater<ProyectoResource, String>() {
			public void update(int index, ProyectoResource object, String value) {
				Client.get().setProyecto(object);
				Client.get().sincronizar(new CallbackVoid(){
					public void onSuccess(Void result) {
						Client.get().onLoadProject(new CallbackVoid(){
							public void onSuccess(Void result) {
								FlowController.go("Proyecto", null);
							}
						});
					}
				});
			}
		});

		// Se crea la columna descripcion y se aniade a la tabla
		TextColumn<ProyectoResource> columnaDescripcion = new TextColumn<ProyectoResource>() {
			@Override
			public String getValue(ProyectoResource ProyectoResource) {

				return ProyectoResource.getDescripcion();
			}
		};

		tabla.addColumn(columnaDescripcion, "Descripcion");

		// Se crea la columna eliminar y se aniade a la tabla
		ButtonCell buttonEliminar = new ButtonCell();

		Column<ProyectoResource, String> columnaEliminar = new Column<ProyectoResource, String>(buttonEliminar) {
			@Override
			public String getValue(ProyectoResource object) {

				return "X";
			}
		};

		tabla.addColumn(columnaEliminar, "");

		// Se meten los datos de la lista ProyectoResources en la tabla
		final ListDataProvider<ProyectoResource> dataProvider = new ListDataProvider<ProyectoResource>();

		// Se conecta nuetra tabla con dataProvider
		dataProvider.addDataDisplay(tabla);

		// Se aniaden los datos al data provider, el cual automáticamente los
		// coloca en
		// widget.
		List<ProyectoResource> list = dataProvider.getList();
		for (ProyectoResource proy : proyectos) {
			list.add(proy);
		}

		// Add a ColumnSortEvent.ListHandler to connect sorting to the
		// java.util.List.

		// Ordenar tabla por NOMBRE
		ListHandler<ProyectoResource> columnNombreSortHandler = new ListHandler<ProyectoResource>(list);
		columnNombreSortHandler.setComparator(columnaNombre, new Comparator<ProyectoResource>() {
			public int compare(ProyectoResource o1, ProyectoResource o2) {
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

		// We know that the data is sorted alphabetically by default.
		tabla.getColumnSortList().push(columnaNombre);

		// Eliminar proyecto
		columnaEliminar.setFieldUpdater(new FieldUpdater<ProyectoResource, String>() {
			public void update(int index, ProyectoResource object, String value) {
				// Value is the button value. Object is the row object.
				dataProvider.getList().remove(object);
				dataProvider.refresh();
				tabla.redraw();
				CallerRPC.oa.deleteProject(Autenticacion.trelloToken(), object, new AsyncCallback<Void>(){
					public void onFailure(Throwable caught) {}
					public void onSuccess(Void result) {}
				});
			}
		});

		tabla.setWidth("70%");

		// Se aniade la tabla al panel raíz
		root.add(tabla);

		HorizontalPanel fin = new HorizontalPanel();
		fin.setHeight("50px");
		fin.setWidth("100%");
		root.add(fin);
	}

	@Override
	public void update(Map<String, String> param) {

	}
	
	public static void aniadeProyectoResource(String id, String nombre, String descripcion){
		ProyectoResource p = new ProyectoResource(id, nombre, descripcion);
		proyectos.add(p);
	}
	
	public static void eliminaProyectoResource(String id){
		for(ProyectoResource pr : proyectos){
			if(pr.getId().equals(id)){
				proyectos.remove(pr);
			}
		}
	}
	
	public static void eliminaProyectoResource(ProyectoResource p){
		proyectos.remove(p);
		}

}
