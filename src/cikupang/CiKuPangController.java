package cikupang;
import java.util.Random;
public interface CiKuPangController {

	 String welcomeMessage();

	    String pleaseEnterOptionMessage();

	    void selectUserChoice(GameOption userOption);

	    GameOption randomMachineChoice();

	    CiKuPangResult calculateResultAtt();
	    CiKuPangResult calculateResultDef();
	    
	    CiKuPangScore getResults();
	
}

    

