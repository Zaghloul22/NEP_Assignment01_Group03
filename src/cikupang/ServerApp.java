package cikupang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ServerApp {
	private static CiKuPangScore score = new CiKuPangScore();

	public static void main(String[] args) throws Exception{
        //Runs method runSocket on port 1337
        runSocket(1337);
	}
	
	//This method opens and runs a socket 
    public static void runSocket(int port) {
    	
        //Exceptions handling
        try {

            //New class that implements the socket
            ServerSocket Services = new ServerSocket(port);

            //Listening time set to 30 seconds
            Services.setSoTimeout(30000);
            System.out.println("Game is about to start");

            //Virtually infinite loop
            while (true) {

//                Waits and thus accepts (if present) a connection for clients
                Socket connectionSocket1 = Services.accept();
                Socket connectionSocket2 = Services.accept();

                //Prepares buffered object to reads from and writes to a client's socket
                DataInputStream player1atk = new DataInputStream(connectionSocket1.getInputStream());
                DataInputStream player2def = new DataInputStream(connectionSocket2.getInputStream());
                DataInputStream player1def = new DataInputStream(connectionSocket1.getInputStream());
                DataInputStream player2atk = new DataInputStream(connectionSocket2.getInputStream());
                DataOutputStream outToClient1 = new DataOutputStream(connectionSocket1.getOutputStream());
                DataOutputStream outToClient2 = new DataOutputStream(connectionSocket2.getOutputStream());

                //Read all the lines from the client, in this case one being one character only 
                String declaration = null;
                String declaration2 = null;
                
				CiKuPangController gameController = new CiKuPangGame();

				System.out.print(gameController.welcomeMessage());
				for(int i = 2,j= 2 ; i>0;  ) {
					
					// Player 1 attack
					score.incrementTotalNumberGames();
					GameOption userOption = GameOption.valueOf(player1atk.readInt());
		            gameController.selectUserChoice(userOption);
					GameOption userOptionp2d = GameOption.valueOf(player2def.readInt());
		            gameController.selectUserChoice(userOptionp2d);
			    	
			    	System.out.println("Player 1's lifespan is " + j);
			    	System.out.println("Player 2's lifespan is " + i + "\n");
			    	System.out.printf("P1: Player 1 played: %s and the Player 2 played: %s \n", userOption.name(), userOptionp2d.name());
			    		if (userOption.equals(userOptionp2d)) {
			    			System.out.println("\n Player 1 hit \n");
				    	    i--;
				    	   }
			    		else{
				    	    System.out.println("\nPlayer 1 missed \n");
				    	    score.incrementGamesWonByUser1();
				    	   }
			    	            
					   	if(i == 0) {
						   declaration= "win";
						   declaration2= "lose";
						   break;
						   }
			    	            
					   	//Player 2 Attack
					   	score.incrementTotalNumberGames();
		        	            GameOption userOption2 = GameOption.valueOf(player1def.readInt());
		        	            gameController.selectUserChoice(userOption2);
		        	            GameOption userOptionp2a = GameOption.valueOf(player2atk.readInt());
		        	            gameController.selectUserChoice(userOptionp2a);

		        	            System.out.println("Player 1's lifespan is " + j);
			        	    	System.out.println("Player 2's lifespan is " + i+"\n");
			        	    	System.out.printf("P2: Player 1 played: %s and the Player 2 played: %s \n", userOption2.name(), userOptionp2a.name());
				        	    	if (userOption2.equals(userOptionp2a)) {
				        	    		System.out.println("\nPlayer 2 hit\n");
				        	            j--;
				        	            }
				        	       else{
				        	                System.out.println("\nPlayer 2 missed\n");
				        	                score.incrementGamesWonByUser2();
				        	            }

			        	            if(j == 0) {
			    	   		declaration= "lose";
			    	   		declaration2= "win";
			    	   		break;
			    	   	}
				}// end for loop
	                //Sends out output to each client
		                outToClient1.writeUTF(declaration);;
		                outToClient2.writeUTF(declaration2);
		                outToClient1.flush();
		                outToClient2.flush();
		                System.out.println("Player 1: " + declaration);
		                System.out.println("Player 2: " + declaration2);
		                System.out.printf("Player 1 blocked %d attacks out of %d turns\n", score.getGamesWonByUser1(), score.totalNumberOfGames());
		                System.out.printf("Player 2 blocked %d attacks out of %d turns\n", score.getGamesWonByUser2(), score.totalNumberOfGames());

		                //Closes the sockets
		                connectionSocket1.close();
		                connectionSocket2.close();
		       
            }
            //Exceptions are handled if no connections are present or programme times out       
        } catch (IOException e) {
            System.out.println("Error:");
            System.out.println(e);
        }

    }
}
