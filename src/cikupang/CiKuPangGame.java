package cikupang;
import java.util.Random;
public class CiKuPangGame implements CiKuPangController{

	private GameOption userChoice = GameOption.EMPTY;
    private GameOption machineChoice = GameOption.EMPTY;
    private CiKuPangScore totalCiKuPangScore = new CiKuPangScore();


    @Override
    public String welcomeMessage() {

        return "           Welcome to          \n"+
               "   CI KU PANG Game    \n"+
               "                               \n";
    }

    @Override
    public String pleaseEnterOptionMessage(){
        return  "         Please enter:         \n"+
                "            1. CI            \n"+
                "            2. KU           \n"+
                "            3. PANG        \n"+
                "                               \n";
    }

    @Override
    public void selectUserChoice(GameOption userOption) {
        this.userChoice = userOption;
    }

    @Override
    public GameOption randomMachineChoice() {
        int randomNumberBetween1to3 = new Random().nextInt(3)+1;
        GameOption machineOption = GameOption.valueOf(randomNumberBetween1to3);
        this.machineChoice = machineOption;
        return machineOption;
    }

    @Override
    public CiKuPangResult calculateResultAtt() {

        totalCiKuPangScore.incrementTotalNumberGames();

        if(machineChoice.equals(userChoice)){
        	totalCiKuPangScore.incrementGamesWonByUser();
            return CiKuPangResult.USER;
        }
        if(machineChoice.isWinBy(userChoice)){
            return CiKuPangResult.MACHINE;
        }
        return CiKuPangResult.MACHINE;
    }

    @Override
    public CiKuPangResult calculateResultDef() {

        totalCiKuPangScore.incrementTotalNumberGames();

        if(machineChoice.equals(userChoice)){
            return CiKuPangResult.USER;
        }
        if(machineChoice.isWinBy(userChoice)){
         
            return CiKuPangResult.MACHINE;
        }
        totalCiKuPangScore.incrementGamesWonByUser();
        return CiKuPangResult.MACHINE;
    }
    
    @Override
    public CiKuPangScore getResults() {
        return totalCiKuPangScore;
    }
	
}
