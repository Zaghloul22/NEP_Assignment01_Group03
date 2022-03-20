package cikupang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream fromClient = null;
		DataOutputStream toClient = null;
		try {
			serverSocket = new ServerSocket (9101);
			System.out.println("Server has started.");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("Client has connected");
				
				new Thread(new ClientHandler(socket)).start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
				if(socket !=null) {
					socket.close();
				}
				if(fromClient != null) {
					fromClient.close();
				}
				if(toClient != null) {
					toClient.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
