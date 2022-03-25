package cikupang;
import java.util.Random;
public class CiKuPangGame implements CiKuPangController{

	private GameOption userChoice = GameOption.EMPTY;

    @Override
    public String welcomeMessage() {

        return "	Welcome to CI KU PANG Game\n"+
        		"Choose between: Ci,KuPang\n\n"+
        		 "For attacking side, if your hand matches the defensive one, you will HIT, otherwise MISS\n"+
        		 "For defending, if your hand does not match the offensive one, you BLOCK the attack, otherwise you get HIT\n\n"+
        		"Each player gets two HP, whoever runs out of HP first lose.\n\n"+
        		"\r\n"+
        		"ENJOY!";
    }

    @Override
    public String pleaseEnterOptionMessage(){
        return  "Please enter:\n"+
                "1. CI\n"+
                "2. KU\n"+
                "3. PANG\n\n";
    }

    @Override
    public void selectUserChoice(GameOption userOption) {
        this.userChoice = userOption;
    }
    

	
}
