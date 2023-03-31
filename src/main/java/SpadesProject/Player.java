package SpadesProject;

public class Player {

    private int bid;
    private int playerScore;
    private Hand hand;

    /**
     *
     * @param hand
     */
    public Player(Hand hand){
         this.hand=hand;
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
     * @param player
     * @return
     */
    public Hand getPlayerHand(Player player){
         return player.hand;
    }


}


