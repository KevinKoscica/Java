//Written by Kevin Koscica
//The purpose of this program is the client side of the TCP calculator server

import java.net.*;
import java.io.*;
import java.util.*;
public class TcpClient
{
	public static void main(String[] args) throws IOException {
	InetAddress ip = InetAddress.getLocalHost();
        int port = 4444;
        Scanner sc = new Scanner(System.in);
 
        // This opens the socket connection.
        Socket so = new Socket(ip, port);
 
        //Gets the input and output stream
        DataInputStream in = new DataInputStream(so.getInputStream());
        DataOutputStream out = new DataOutputStream(so.getOutputStream());
 	String ans;
        while (true)
        {
            
            System.out.print("Enter an equation(or bye to exit):");
 
            String input = sc.nextLine();
 
            if (input.equals("bye")){
		System.out.println("disconnecting...");
		
                break;
		}
		else{
 
            // send the equation to server
            out.writeUTF(input);
 
            // wait till request is processed and sent back to client
           
            System.out.println("Answer=" + );
		}
        }
    }
}
