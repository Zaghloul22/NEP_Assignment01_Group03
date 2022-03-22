package cikupang;

public enum GameOption {
    CI(1,1), KU(2,2), PANG(3,3),EMPTY(-1,-1);
    
    private int id;
    private int winBy;

    GameOption(int id, int winBy){

        this.id = id;
        this.winBy = winBy;
    }

    public static GameOption valueOf(int userEnteredOption){
        for(GameOption option: GameOption.values()){
            if(userEnteredOption ==option.id){
                return option;
            }
        }
        return EMPTY;
    }

    public boolean isWinBy(GameOption option){
        return this.winBy == option.id;
    }
}