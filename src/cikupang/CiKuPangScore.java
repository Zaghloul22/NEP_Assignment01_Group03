package cikupang;

public class CiKuPangScore {

	private int gamesWonByUser1;
	private int gamesWonByUser2;
    private int totalNumberGames;

    public void incrementGamesWonByUser1(){
        gamesWonByUser1++;
    }
    
    public void incrementGamesWonByUser2(){
        gamesWonByUser2++;
    }

    public void incrementTotalNumberGames(){
        totalNumberGames++;
    }

    public int totalNumberOfGames(){
        return totalNumberGames;
    }

    public int getGamesWonByUser1(){
        return gamesWonByUser1;
    }
    
    public int getGamesWonByUser2(){
        return gamesWonByUser2;
    }
	
}
