package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP {

	public static void main(String[] args) {
		
		
		try {
			DatagramSocket socketUDP=new DatagramSocket(10000);
			byte[] buffer=new byte[1024];
			DatagramPacket mensaje=new DatagramPacket(buffer,1024);
			System.out.println("Esperando petición ....");
			socketUDP.receive(mensaje);
			socketUDP.close();
			
			System.out.println(new String(buffer));
				
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 