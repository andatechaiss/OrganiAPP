package andatech.organizapp.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import andatech.organizapp.api.resources.EventCardResource;
import andatech.organizapp.api.resources.ListCardResource;
import andatech.organizapp.api.resources.LocationCardResource;
import andatech.organizapp.api.resources.ProjectResource;
import andatech.organizapp.api.resources.TaskCardResource;

public class OrganizApp extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application so that they
	// can be found byRESTEasy.
	public OrganizApp() {
		singletons.add(new ProjectResource());
		singletons.add(new ListCardResource());
		singletons.add(new TaskCardResource());
		singletons.add(new LocationCardResource());
		singletons.add(new EventCardResource());
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

	public Set<Object> getSingletons() {
		return singletons;
	}

}