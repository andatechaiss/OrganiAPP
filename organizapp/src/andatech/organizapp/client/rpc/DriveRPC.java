package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.drive.File;

@RemoteServiceRelativePath("drive")
public interface DriveRPC extends RemoteService{
	
	List<File> getAllFiles(String token);
	File getFile(String token,String file);
}
