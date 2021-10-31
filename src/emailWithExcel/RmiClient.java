package emailWithExcel;

import java.rmi.Naming;
import java.util.Scanner;

public class RmiClient {
	public static void main(String[] args) throws Exception {
		EmailExcel email = (EmailExcel) Naming.lookup("rmi://localhost:1099/email");
		System.out.print("Enter Client Mail ID: ");
		Scanner s = new Scanner(System.in);
		String clientemailid = s.nextLine();
		System.out.println(email.emailAttachment(clientemailid));
	}
}
