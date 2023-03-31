package SpadesProject;

import SpadesProject.Hand;

public class SpadesGame {

    public static void main(String[] args) {

        Player p1=new HumanPlayer(new Hand());
        Player p2=new BotPlayer(new Hand());
        Player p3=new BotPlayer(new Hand());
        Player p4=new BotPlayer(new Hand());

        Deck deck = new Deck();
        deck.shuffleDeck();

System.out.println(deck.getDeckLinkedList().toString());


/*   output template:

(at the beginning)
-deck has been created
-deck has been shuffled
-cards have been dealt
-game has started
-your hand = 1-(2ofDiamonds) ,2-(queenOfHearts) ... etc.
-what is your bid?
-bits have set : player(3) ,bot1(4) ,bot2(2) ,bot3(2)

(each turn)
-your current hand: 1-(2ofDiamonds) ,2-(queenOfHearts) ... etc.
-please select a card to play (enter the index of it)
-you played .... , bot1 played .... ,bot2 played ..... and bot3 played ....
-..... won the round (n)
-score table :player(1) ,bot1(0 ... etc.


(at the end of the game)
player won the game with bid: ... and score: ...
 */


    }

    /**
     * // the method that creates deck and the players , shuffles the deck and deals the cards
     */
    public void setGame() {
    }

    /**
     * // method that shows current hand as provided in the output template
     *
     * @param player
     */
    public void displayHand(Player player) {
        player.getPlayerHand(player).getCardsInHand();
    }

    /**
     * method that gets bids from players
     */
    public void setBids() {
    }

    /**
     * method that determines the winner of the round and gives 1 point to the winner of the round
     */
    public void endRound() {
    }

    /**
     * method that checks whether a player won the game or not
     */
    public void isGameOver() {
    }

    /**
     * method that sets first suit so that game will be continue according to the first card
     */
    public void determineSuitOfRound() {
    }

    /**
     * method that gives points to players according to the rules
     */
    public void givePoints() {
    }


    public void isValidPlay() {

    }
}