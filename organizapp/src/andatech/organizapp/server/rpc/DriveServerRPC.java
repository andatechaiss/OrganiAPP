package andatech.organizapp.server.rpc;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import andatech.organizapp.client.rpc.DriveRPC;
import andatech.organizapp.server.resources.drive.DriveFileResource;
import andatech.organizapp.shared.domain.drive.File;

@SuppressWarnings("serial")
public class DriveServerRPC extends RemoteServiceServlet implements DriveRPC {

	@Override
	public List<File> getAllFiles(String token) {
		return DriveFileResource.getAllFiles(token);
	}

	@Override
	public File getFile(String token, String file) {
		return DriveFileResource.getFile(token,file);

	}

}
