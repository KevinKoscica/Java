/**
 * Client program requesting current date from server.
 *
 * Figure 3.22
 *
 * @author Silberschatz, Gagne and Galvin
 * Operating System Concepts  - Eighth Edition
 */ 

import java.net.*;
import java.io.*;

public class DateClient
{
	public static void main(String[] args) throws IOException {
		Socket sock=null;
		PrintWriter pout=null;
		BufferedReader in=null;
		
		try {
			// this could be changed to an IP name or address other than the localhost
			sock = new Socket("127.0.0.1",6013);
			pout=new PrintWriter(sock.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println("attempting to connect to server...");
			
				
			
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
			BufferedReader bin= new BufferedReader(new InputStreamReader(System.in));			
			String line;
			System.out.print ("input: ");
			while( (line = bin.readLine()) != null){
				pout.println(line);
				System.out.println("Echo: " + in.readLine());
				System.out.print("input: ");
}
		pout.close();
		in.close();
		bin.close();			
		sock.close();
	}
}
