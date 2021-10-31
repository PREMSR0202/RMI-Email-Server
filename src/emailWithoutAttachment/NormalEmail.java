package emailWithoutAttachment;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NormalEmail extends Remote {
	public String normalEmail(String clientemail) throws RemoteException;
}
