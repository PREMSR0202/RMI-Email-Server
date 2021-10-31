package emailWithPDF;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EmailPdfImpl extends UnicastRemoteObject implements EmailPdf {

	public EmailPdfImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	private static PDFCreation pdf;

	private static EmailCreation email;

	@Override
	public String emailAttachment(String clientemailid) throws RemoteException {
		try {

			pdf = new PDFCreation();
			pdf.create();

			email = new EmailCreation();
			email.emailWithAttachment(clientemailid);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Email Sent with Attachment PDF";
	}
}
