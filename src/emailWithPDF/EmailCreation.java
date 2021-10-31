package emailWithPDF;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailCreation {

	private final static String username = "srprem2000@gmail.com";
	private final static String password = "";
	private final static String fromEmail = "srprem2000@gmail.com";
	private final static String attachEmail = "PDFCreation.pdf";

	public void emailWithAttachment(String clientEmail) throws Exception {

		String toEmail = clientEmail;

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

		Multipart emailContent = new MimeMultipart();

		MimeBodyPart textBodyPart = new MimeBodyPart();
		textBodyPart.setText("Email with Attachment");

		MimeBodyPart pdfAttachment = new MimeBodyPart();
		pdfAttachment.attachFile(attachEmail);

		emailContent.addBodyPart(textBodyPart);
		emailContent.addBodyPart(pdfAttachment);

		message.setContent(emailContent);

		Transport.send(message);
		

	}
}