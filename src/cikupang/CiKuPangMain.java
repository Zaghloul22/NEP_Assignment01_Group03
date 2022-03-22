package cikupang;
import java.util.Scanner; 
public class CiKuPangMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CiKuPangController gameController = new CiKuPangGame();

		Scanner scanner = new Scanner(System.in);
        String userWantsToExit;

        System.out.print(gameController.welcomeMessage());
       for(int i = 2,j= 2 ; i>0;  ) {
//       		do {
    	   		//attacking side
       			System.out.println("Machine's lifespan is " + i);
       			System.out.println("User's lifespan is " + j);
                System.out.println("Attacking Side");
    	        System.out.println(gameController.pleaseEnterOptionMessage());
    	            
    	            
    	            int userOptionRaw = scanner.nextInt();
    	
    	            GameOption userOption = GameOption.valueOf(userOptionRaw);
    	
    	            gameController.selectUserChoice(userOption);
    	
    	            GameOption machineChoice = gameController.randomMachineChoice();
    	
    	            CiKuPangResult winner = gameController.calculateResultAtt();
    	
    	            CiKuPangScore score = gameController.getResults();
    	
    	            System.out.printf("You played: %s and the machine played: %s \n", userOption.name(), machineChoice.name());
    	            if (CiKuPangResult.USER.equals(winner)) {
    	                System.out.println("You won!!");
    	                i--;
    	            }
    	            if(CiKuPangResult.TIE.equals(winner)){
    	                System.out.println("Tie!!");
    	            }
    	            System.out.printf("You won %d games out of %d \n", score.getGamesWonByUser(), score.totalNumberOfGames());
    	            
 //defending side
           			System.out.println("Machine's lifespan is " + i);
           			System.out.println("User's lifespan is " + j);
                    System.out.println("Defending side");
        	        System.out.println(gameController.pleaseEnterOptionMessage());
        	            
        	            
        	            int userOptionRaw2 = scanner.nextInt();
        	
        	            GameOption userOption2 = GameOption.valueOf(userOptionRaw2);
        	
        	            gameController.selectUserChoice(userOption2);
        	
        	            GameOption machineChoice2 = gameController.randomMachineChoice();
        	            CiKuPangResult winner2 = gameController.calculateResultDef();
        	
        	            
        	
        	            System.out.printf("You played: %s and the machine played: %s \n", userOption2.name(), machineChoice2.name());
        	            if (CiKuPangResult.USER.equals(winner2)) {
        	                System.out.println("You lost!!");
        	                j--;
        	            }
        	            if(CiKuPangResult.TIE.equals(winner2)){
        	                System.out.println("Tie!!");
        	            }
        	            System.out.printf("You won %d games out of %d \n", score.getGamesWonByUser(), score.totalNumberOfGames());


            	
//            	System.out.println("Continue playing(Y=Yes, N=No)?");
//                userWantsToExit = scanner.next();
//            }while(userWantsToExit.toUpperCase().equals("Y"));
    	   	 if(i == 0) {
    	   		System.out.println("you win the game");
    	   		break;
    	   	}else if(j == 0) {
    	   		System.out.println("You lost the game");
    	   		break;
    	   	}
        
       }//end for loop

	}
		
	}


