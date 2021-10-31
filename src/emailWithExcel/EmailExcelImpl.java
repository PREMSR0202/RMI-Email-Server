package emailWithExcel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EmailExcelImpl extends UnicastRemoteObject implements EmailExcel {

	private static ExcelCreation excel;
	private static EmailCreation email;

	public EmailExcelImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String emailAttachment(String clientemailid) throws RemoteException {

		try {
			excel = new ExcelCreation();
			excel.create();
			email = new EmailCreation();
			email.emailWithAttachment(clientemailid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Email Sent with Attachment Excel";
	}
}
