package SpadesProject;

public class Player {

    private int bid;
    private int playerScore;
    private Hand hand;
    private final int playerIndex;

    /**
     *
     * @param hand
     */
    public Player(Hand hand, int playerIndex){
         this.hand=hand;
         playerScore=0;
         this.playerIndex=playerIndex;
}




     public void setBid(int i){
        bid=i;
     }

    public void increasePlayerScore(){
        playerScore++;
    }

    /**
     *
     * @return
     */
    public int getPlayerScore(){
        return playerScore;
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



}


