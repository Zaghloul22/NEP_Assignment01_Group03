package cikupang;
import java.util.Random;
public class CiKuPangGame implements CiKuPangController{

	private GameOption userChoice = GameOption.EMPTY;

    @Override
    public String welcomeMessage() {

        return "           Welcome to          \n"+
               "   		CI KU PANG Game    \n"+
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
    

	
}
