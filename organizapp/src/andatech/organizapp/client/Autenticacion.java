package andatech.organizapp.client;

import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;

import andatech.organizapp.client.resources.utils.CallbackVoid;
import andatech.organizapp.shared.GoogleCommon;

public class Autenticacion 
{
	private static String google_token = null;
	
	
	public static void authorizeGoogle(final CallbackVoid call)
	{
		AuthRequest google = new AuthRequest(GoogleCommon.AUTH_URL, GoogleCommon.CLIENT_ID)
								.withScopes(GoogleCommon.SCOPES);
		
		Auth.get().login(google, new Callback<String, Throwable>() {

			@Override
			public void onFailure(Throwable reason) {
			}

			@Override
			public void onSuccess(String result) {
				google_token = result;
				call.onSuccess(null);
			}
		});
	}
	
	public static void authorizeTrello()
	{
		try
		{
			trelloJNSI();
		}
		catch(Exception e)
		{
			Window.alert(e.getMessage());
		}
	}
	
	
	
	public static void desAuthorize()
	{
		Auth.get().clearAllTokens();
	}
	
	
	public static String trelloToken()
	{
		String res = DOM.getElementById("trello_token").getAttribute("value");
		return res.equals("none") ? null : res;
	}
	
	public static String googleToken()
	{
		return google_token;
	}
	
	

	//JSNI para usar la libreria nativa de autentificacion de trello
	public static native void trelloJNSI() /*-{
	  $wnd.trelloAuth();
	}-*/;
	
}
