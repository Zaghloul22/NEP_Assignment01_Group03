package cikupang;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
//		System.out.println("length");
//		double length = Double.parseDouble(scanner.nextLine());
//		
//		System.out.println("breadth");
//		double breath = Double.parseDouble(scanner.nextLine());
//		
//		toServer.writeDouble(length);
//		toServer.writeDouble(breath);
//		
//		double area = fromServer.readDouble();
//		System.out.println("area="+ area);
		
			CiKuPangController gameController = new CiKuPangGame();



//			System.out.print(gameController.welcomeMessage());
	       for(int i = 2,j= 2 ; i>0;  ) {

	    	   		//attacking side
	       			System.out.println("Machine's lifespan is " + i);
	       			System.out.println("User's lifespan is " + j);
	                System.out.println("Attacking Side");
	    	        System.out.println(gameController.pleaseEnterOptionMessage());
	    	            
	    	            
	    	            int userOptionRaw = scanner.nextInt();
	    	            GameOption userOption = GameOption.valueOf(userOptionRaw);
	    	            gameController.selectUserChoice(userOption);
//	    	            GameOption machineChoice = gameController.randomMachineChoice();
//	    	            CiKuPangResult winner = gameController.calculateResultAtt();
//	    	            CiKuPangScore score = gameController.getResults();
	    	
//	    	            System.out.printf("You played: %s and the machine played: %s \n", userOption.name(), machineChoice.name());
//	    	            if (CiKuPangResult.USER.equals(winner)) {
//	    	                System.out.println("You won!!");
//	    	                i--;
//	    	            }
//	    	            if(CiKuPangResult.TIE.equals(winner)){
//	    	                System.out.println("Tie!!");
//	    	            }
//	    	            System.out.printf("You won %d games out of %d \n", score.getGamesWonByUser(), score.totalNumberOfGames());
	    	            
	 //defending side
	           			System.out.println("Machine's lifespan is " + i);
	           			System.out.println("User's lifespan is " + j);
	                    System.out.println("Defending side");
	        	        System.out.println(gameController.pleaseEnterOptionMessage());
	        	            
	        	            
	        	            int userOptionRaw2 = scanner.nextInt();
	        	
	        	            GameOption userOption2 = GameOption.valueOf(userOptionRaw2);
	        	
	        	            gameController.selectUserChoice(userOption2);
	        	
//	        	            GameOption machineChoice2 = gameController.randomMachineChoice();
//	        	            CiKuPangResult winner2 = gameController.calculateResultDef();
	        	
	        	            toServer.writeInt(userOptionRaw);
	        	            toServer.writeInt(userOptionRaw2);
	        	            
	        	
//	        	            System.out.printf("You played: %s and the machine played: %s \n", userOption2.name(), machineChoice2.name());
//	        	            if (CiKuPangResult.USER.equals(winner2)) {
//	        	                System.out.println("You lost!!");
//	        	                j--;
//	        	            }
//	        	            if(CiKuPangResult.TIE.equals(winner2)){
//	        	                System.out.println("Tie!!");
//	        	            }
//	        	            System.out.printf("You won %d games out of %d \n", score.getGamesWonByUser(), score.totalNumberOfGames());

	    	   	 if(i == 0) {
	    	   		System.out.println("you win the game");
	    	   		break;
	    	   	}else if(j == 0) {
	    	   		System.out.println("You lost the game");
	    	   		break;
	    	   	}
	        
	       }//end for loop

			
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
