//Written by Kevin Koscica
//The purpose of this program is the client side of the udp server to calculate simple equations
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
 
public class UdpClient
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
 
        //Creates data socket  
        DatagramSocket ds = new DatagramSocket();
 
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
 
        // continues prompt till bye is entered.
        while (true)
        {
            System.out.print("Enter an equation: ");
            String input = sc.nextLine();
            buf = new byte[65535];
 
            // convert String input into a byte array.
            buf = input.getBytes();
 
            //create datagram for sending data
            DatagramPacket DpSend =
                      new DatagramPacket(buf, buf.length, ip, 1234);
 
            //sends the data
            ds.send(DpSend);
 
            // ends the while loop when bye is entered
            if (input.equals("bye"))
                break;
 
            buf = new byte[65535];
            DatagramPacket DpReceive =
                                 new DatagramPacket(buf, buf.length);
            ds.receive(DpReceive);
 
            System.out.println("The answer = " +
                                new String(buf,0,buf.length));
        }
    }
}
