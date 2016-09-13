package andatech.organizapp.client.resources.utils;

import com.google.gwt.core.client.Callback;

public abstract class CallbackVoid implements Callback<Void, Throwable>
{
	public void onFailure(Throwable reason) {
	}
}
