package emailWithPDF;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmailPdf extends Remote {
	public String emailAttachment(String clientemailid) throws RemoteException;
}
