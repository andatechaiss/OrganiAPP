package andatech.organizapp.client;

import com.google.gwt.core.client.GWT;

import andatech.organizapp.client.rpc.OrganizappRPC;
import andatech.organizapp.client.rpc.TrelloRPC;
import andatech.organizapp.client.rpc.TrelloRPCAsync;

public class CallerRPC 
{
	public static TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
	public static TrelloRPCAsync oa = GWT.create(OrganizappRPC.class);
}
