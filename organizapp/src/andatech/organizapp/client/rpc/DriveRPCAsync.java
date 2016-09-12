package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.drive.File;

public interface DriveRPCAsync {

	void getAllFiles(String token,AsyncCallback<List<File>> callback);

	void getFile(String token, String file, AsyncCallback<File> callback);

}
