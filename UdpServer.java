//Written by Kevin Koscica
//The purpose of this program is use a udp server to calculate simple equations
import java.io.*;
import java.util.*;
import java.net.*;
public class UdpServer
{
    public static void main(String[] args) throws IOException
    {
        //Creates the socket at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] buf = null;
        DatagramPacket DpReceive = null;
        DatagramPacket DpSend = null;
        while (true)
        {
            buf = new byte[65535];
 
            //Creates a datagram packet to recieve
            DpReceive = new DatagramPacket(buf, buf.length);
 
            // receive the data in byte buffer.
            ds.receive(DpReceive);
 
            String input= new String(buf, 0, buf.length);
 
            //To remove extra spaces.
            input=input.trim();
            System.out.println("Equation Received: " + input);
 
            // Exit the server 
            if (input.equals("bye"))
            {
                System.out.println("Connection closed.");
                break;
            }
 
            int result;
 
           //split string into integers and symbols
		String[] split=input.split("(?<=[+-/*])|(?=[+-/*])");
		
		//The trim() method here is used to remove whitespace
		//In case an equation is entered in form "int + int" instead of "int+int"
		int num1=Integer.parseInt(split[0].trim());
		String op= split[1].trim();
		op.trim();
		System.out.println(op);
		int num2=Integer.parseInt(split[2].trim());
		
		

	
 		switch(op){
		case "+": result=num1+num2;break;
		case "-": result=num1-num2;break;
		case "*": result=num1*num2;break;
		case "/": result=num1/num2;break;
		default: throw new IllegalArgumentException("invalid entry try again");
		
		}
           
 
 
           
 
            System.out.println("Sending the result...");
            String res = Integer.toString(result);
 
            // Clears buffer after each message.
            buf = res.getBytes();
 
            // get the port of client.
            int port = DpReceive.getPort();
 
            DpSend = new DatagramPacket(buf, buf.length,
                          InetAddress.getLocalHost(), port);
            ds.send(DpSend);
        }
    }
}
