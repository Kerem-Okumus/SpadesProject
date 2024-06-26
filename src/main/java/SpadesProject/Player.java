package SpadesProject;

public class Player {

    private int bid;
    private int TrickCount;
    private Hand hand;
    private final int playerIndex;
    private int totalScore;

    /**
     *constructor of the Player
     * @param hand
     */
    public Player(Hand hand, int playerIndex){
         this.hand=hand;
         TrickCount =0;
         this.playerIndex=playerIndex;
         totalScore=0;
}

     public void setBid(int i){
        bid=i;
     }

    public int getBid() {
        return bid;
    }

    public void increaseTrickCount(){
        TrickCount++;
    }

    /**
     *
     * @return
     */
    public int getTrickCount(){
        return TrickCount;
    }

    /**
     *
     * @return
     */
    public Hand getPlayerHand(){
         return hand;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isValidBid(int bid){
        if(bid<0 || bid >13){
            System.out.println("please enter a valid bid !");
            return false;
        }
        return true;
    }

}


