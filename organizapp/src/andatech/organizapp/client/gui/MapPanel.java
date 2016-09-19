package andatech.organizapp.client.gui;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Element;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.Position.Coordinates;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.InfoWindow;
import com.google.maps.gwt.client.InfoWindowOptions;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.Marker;
import com.google.maps.gwt.client.Marker.ClickHandler;
import com.google.maps.gwt.client.MarkerOptions;
import com.google.maps.gwt.client.MouseEvent;

public class MapPanel extends Widget {
	
//	Ejemplo añadir un mapa
//	final MapPanel mapa =new MapPanel(500,500);
//	mapa.getMarcas().add(MapPanel.crearMarca(20., 50., "a", "j"));
//	RootPanel.get().add(mapa);

	private Element container;
	private GoogleMap map;
	private List<Marca> marcas;

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public MapPanel(Integer ancho, Integer alto) {
		
		marcas= new LinkedList<Marca>();

		container = DOM.createDiv();
		container.setAttribute("style", "width:" + ancho + "px;height:" + alto + "px");

		// this is required by the Widget API to define the underlying element
		setElement(container);
	}

	public static Marca crearMarca(Double latitud, Double longitud, String nombre, String descripcion) {
		return new Marca(latitud, longitud, nombre, descripcion);
	}
	
	public GoogleMap getMapa(){
		return map;
	}

	@Override
	protected void onLoad() {
		super.onLoad();

		new JsonpRequestBuilder().send("http://maps.googleapis.com/maps/api/js?sensor=false",
				new AsyncCallback<Void>() {
					public void onFailure(Throwable e) {
						Window.alert("Error loading map: " + e.getMessage());
					}

					public void onSuccess(Void result) {

						LatLng myLatLng = LatLng.create(39, 40);
						MapOptions myOptions = MapOptions.create();
						myOptions.setZoom(17);
						myOptions.setCenter(myLatLng);
						myOptions.setMapTypeId(MapTypeId.ROADMAP);
						map = GoogleMap.create(container, myOptions);

					}
				});

		if (Geolocation.isSupported()) {
			Geolocation.getIfSupported().getCurrentPosition(new Callback<Position, PositionError>() {

				public void onSuccess(Position result) {
					Coordinates coords = result.getCoordinates();
					LatLng location = LatLng.create(coords.getLatitude(), coords.getLongitude());
					map.setCenter(location);
					showMarks();

				}

				@Override
				public void onFailure(PositionError reason) {
					System.out.println(reason);

				}

			});
		} else {
			Window.alert("No Geolocation Support");
		}

	}

	private void showMarks() {

		for (Marca m : marcas) {

			InfoWindowOptions infowindowOpts = InfoWindowOptions.create();
			infowindowOpts.setContent("<b>" + m.getNombre() + "</b><br/>" + m.getDescripcion());
			final InfoWindow infowindow = InfoWindow.create(infowindowOpts);

			LatLng pos = LatLng.create(m.getLatitud(),m.getLongitud());
			MarkerOptions markerOpts = MarkerOptions.create();
			markerOpts.setPosition(pos);
			markerOpts.setMap(map);
			final Marker marker = Marker.create(markerOpts);
			marker.addClickListener(new ClickHandler() {
				public void handle(MouseEvent event) {
					infowindow.open(map, marker);
				}
			});

		}
	}

	private static class Marca {

		private Double latitud;
		private Double longitud;
		private String Nombre;
		private String Descripcion;

		public Marca(Double latitud, Double longitud, String nombre, String descripcion) {
			super();
			this.latitud = latitud;
			this.longitud = longitud;
			Nombre = nombre;
			Descripcion = descripcion;
		}

		public Double getLatitud() {
			return latitud;
		}


		public Double getLongitud() {
			return longitud;
		}


		public String getNombre() {
			return Nombre;
		}

		public String getDescripcion() {
			return Descripcion;
		}

	}
}
