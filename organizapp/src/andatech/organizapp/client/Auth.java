package andatech.organizapp.client;

import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;

import andatech.organizapp.shared.GoogleCommon;

public class Auth 
{
	public static void authorize()
	{
		AuthRequest google = new AuthRequest(GoogleCommon.AUTH_URL, GoogleCommon.CLIENT_ID)
								.withScopes(GoogleCommon.SCOPES);
		
		com.google.api.gwt.oauth2.client.Auth.get().login(google, new Callback<String, Throwable>() {

			@Override
			public void onFailure(Throwable reason) {
			}

			@Override
			public void onSuccess(String result) {
			}
		});
	}
	
	
	public static void desAuthorize()
	{
		com.google.api.gwt.oauth2.client.Auth.get().clearAllTokens();
	}
	
	
	
	
}
