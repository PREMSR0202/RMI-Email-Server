package emailWithoutAttachment;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NormalEmailImpl extends UnicastRemoteObject implements NormalEmail {

	public NormalEmailImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String normalEmail(String clientemail) throws RemoteException {
		NormalEmails email = new NormalEmails();
		String reply = null;
		try {
			reply = email.sendEmail(clientemail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}

}

class NormalEmails {

	private final static String username = "";
	private final static String password = "";
	private final static String fromEmail = "srprem2000@gmail.com";
	private final static String text = "Email without Attachment";

	public String sendEmail(String clientmailid) throws Exception {
		String toEmail = "srprem2000@gmail.com";

		Properties properties = new Properties();
		properties.load(new FileInputStream("Email.properties"));

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		message.setSubject("Testing Email Server");
		message.setText(text);
		Transport.send(message);
		return "Mail Send Sucessfully";
	}

}