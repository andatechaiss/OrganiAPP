package andatech.organizapp.client.resources.utils;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class CallbackVoid implements AsyncCallback<Void>
{
	private CallbackObject obj;
	private Object param;
	
	
	public CallbackVoid()
	{
		obj = null;
	}
	
	public CallbackVoid(CallbackObject obj, Object param)
	{
		this.obj = obj;
		this.param = param;
	}
	

	@Override
	public void onFailure(Throwable caught) {
	}

	@Override
	public void onSuccess(Void result) {
		if(obj != null)
			obj.run(param);
	}

}
