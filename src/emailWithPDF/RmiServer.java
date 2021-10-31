package emailWithPDF;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
	public static void main(String[] args) throws Exception {
		EmailPdfImpl email = new EmailPdfImpl();
		LocateRegistry.createRegistry(1099);
		Naming.bind("rmi://localhost:1099/email", email);
		System.out.println("Server Ready");
	}
}
