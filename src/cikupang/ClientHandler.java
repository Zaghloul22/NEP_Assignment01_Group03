package cikupang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
	
	Socket socket;
	DataInputStream fromClient;
	DataOutputStream toClient;
	
	public ClientHandler (Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			fromClient = new DataInputStream(socket.getInputStream()); 
			toClient = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				double length = fromClient.readDouble();
				double breadth = fromClient.readDouble();
				
				System.out.println("Length" + length);
				System.out.println("breadth" + breadth);
				
				double area = length * breadth;
				
				toClient.writeDouble(area);
				
				boolean wantContinue = fromClient.readBoolean();
				if(!wantContinue) {
					break;
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(socket !=null) {
					socket.close();
				}
				if(toClient != null) {
					toClient.close();
				}
				if(fromClient != null) {
					fromClient.close();
				}
			}catch (IOException e) {
			e.printStackTrace();
				} 
			}

	}

}
