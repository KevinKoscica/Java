
/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.21
 *
 * @author Silberschatz, Gagne, and Galvin. 
 * Operating System Concepts  - Ninth Edition
 * Copyright John Wiley & Sons - 2013.
 */
 
import java.net.*;
import java.io.*;

public class DateServer
{
	public static void main(String[] args)  {
		try {
			ServerSocket sock = new ServerSocket(6013);

			// now listen for connections
			while (true) {
				Socket client = sock.accept();
				// we have a connection
				System.out.println("connection Successful!");
				System.out.println("waiting on input....");
				
				BufferedReader in= new BufferedReader(new InputStreamReader		(client.getInputStream()));
				String inputLine;

			PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

					while((inputLine=in.readLine()) !=null){
						System.out.println("Server:" + inputLine);
						pout.println(inputLine);
						if (inputLine.equals("bye"))
							break;


						}

				// write the Date to the socket
				pout.println(new java.util.Date().toString());

				// close the socket and resume listening for more connections
				client.close();
				pout.close();
				in.close();
				sock.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
		


	}
}
