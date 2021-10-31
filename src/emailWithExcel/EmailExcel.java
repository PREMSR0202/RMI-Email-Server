package emailWithExcel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmailExcel extends Remote {
	public String emailAttachment(String clientemailid) throws RemoteException;
}
