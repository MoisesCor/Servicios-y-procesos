package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteUDP {

	public static void main(String[] args) {
		try {
			DatagramSocket socketUDP=new DatagramSocket();
			Scanner sc=new Scanner(
System.in
);
			System.out.println("Manda un mensaje");
			String 
mensaje=sc.next
();
			byte[] mensajeBytes=mensaje.getBytes();
			InetSocketAddress address
				=new InetSocketAddress("localhost",10000);
			DatagramPacket datagram=new DatagramPacket(
					mensajeBytes,mensajeBytes.length,
					address);
			socketUDP.send(datagram);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
} 