package cikupang;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


import java.net.InetAddress;

public class ClientApp {
	
	public static void main(String[] args) throws Exception{
		DataOutputStream toServer = null;
        Scanner scanner = new Scanner(System.in);
		
	try {
		//Open connection towards clients 
        System.out.println("Attempting socket connection to localhost:1337");
        InetAddress address = InetAddress.getByName("localhost");

        //Open a new socket belonging to one client towards a server at a specific address and port
        Socket client = new Socket("localhost", 1337);
        System.out.println("Client ready.\n");

        //Create classes to access outputs from the clients and write
		toServer = new DataOutputStream(client.getOutputStream());
		 
       //Ask the user to type 
	       while(true) {
	    	   for(int i = 2,j= 2 ; i>0;  ) {
	    	     CiKuPangController gameController = new CiKuPangGame();
	      	   		//Player 1 attack
	               System.out.println("Player 1 attack");
	   	        System.out.println(gameController.pleaseEnterOptionMessage());
	   	            
	   	            int userOptionRaw = scanner.nextInt();
	    	            GameOption userOption = GameOption.valueOf(userOptionRaw);
	    	            gameController.selectUserChoice(userOption);
	    	            
	    	            System.out.println("You chose :" + userOption+"\n");
	    	            
	    	            
	   	            //Player 2 Attack
	    	            
	                   System.out.println("Player 2 attack");
	       	        System.out.println(gameController.pleaseEnterOptionMessage());
	       	        
	       	  int  userOptionRaw2 = scanner.nextInt();
	       	    GameOption userOption2 = GameOption.valueOf(userOptionRaw2);
  	            gameController.selectUserChoice(userOption2);
  	            
  	            System.out.println("You chose:"+userOption2+"\n");
  	            
	            toServer.writeInt(userOptionRaw);
	            toServer.writeInt(userOptionRaw2);

  	          //Sends the user's choice off to the server
  	          //This method forces any buffered output bytes to be written out
  	          toServer.flush();
  	            
	    	   }// end for loop
   }



        //Exceptions are handled if no connections are present or program times out  
	}  catch (IOException e) {
	System.out.println(e);
		}
	}

}
