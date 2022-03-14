package cikupang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
	
	public static void main(String[] args) {
	Socket socket = null;
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	Scanner scanner = new Scanner(System.in);
	try {
		socket = new Socket ("localhost", 9101);
		
		toServer = new DataOutputStream(socket.getOutputStream());
		fromServer = new DataInputStream(socket.getInputStream());

		while(true) {
		System.out.println("length");
		double length = Double.parseDouble(scanner.nextLine());
		
		System.out.println("breadth");
		double breath = Double.parseDouble(scanner.nextLine());
		
		toServer.writeDouble(length);
		toServer.writeDouble(breath);
		
		double area = fromServer.readDouble();
		System.out.println("area="+ area);
		
		System.out.println("continue? y/n");
		String wantContinue = scanner.nextLine();
		if(wantContinue.equalsIgnoreCase("y")) {
			toServer.writeBoolean(true);
		}else {
			toServer.writeBoolean(false);
			break;
		}
		}
		
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally{
		try {
			if(socket !=null) {
				socket.close();
			}
			if(toServer != null) {
				toServer.close();
			}
			if(fromServer != null) {
				fromServer.close();
			}
		}catch (IOException e) {
		e.printStackTrace();
			} 
		}
	scanner.close();
	}
}
