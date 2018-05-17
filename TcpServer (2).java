//Written by: Kevin Koscica
//This program was written for CSIT340 the purpose of it is 
//to demonstrate a simple tcp server that can compute the basic operations
import java.net.*;
import java.io.*;
import java.util.*;
public class TcpServer
{
	public static void main(String[] args)throws IOException  {
		 // Establishes the socket connection.
        ServerSocket sock = new ServerSocket(4444);
        Socket so = sock.accept();
 
        //processes the request
        DataInputStream in= new DataInputStream(so.getInputStream());
        DataOutputStream out = new DataOutputStream(so.getOutputStream());
 
        while (true)
        {
            // waiting for input
            String input = in.readUTF();
		input=input.trim();
		int result;
		 System.out.println("Equation Received: " + input);
		
 
            if(input.equals("bye")){
		System.out.println("connection closed");
		break;
		}
		//split string into integers and symbols
		String[] split=input.split("(?<=[+-/*])|(?=[+-/*])",3);
		
		//The trim() method here is used to remove whitespace
		//In case an equation is entered in form "int + int" instead of "int+int"
		int num1=Integer.parseInt(split[0].trim());
		String op= split[1].trim();
		System.out.println(op);
		int num2=Integer.parseInt(split[2].trim());
		
		

	
 		switch(op){
		case "+": result=num1+num2;break;
		case "-": result=num1-num2;break;
		case "*": result=num1*num2;break;
		case "/": result=num1/num2;break;
		default: throw new IllegalArgumentException("invalid entry try again");
		
		}
		
	
		
		
	
	
		System.out.println("The answer is : " +result);

		System.out.println("Relaying to client");
 
            // send the result back to the client.
            out.writeUTF(Integer.toString(result));
		
		 

}

}
}
           
		
 
           
