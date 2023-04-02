package SpadesProject;

import SpadesProject.Hand;

public class SpadesGame {

    public static void main(String[] args) {


        Player p1=new BotPlayer(new Hand(),1);
        Player p2=new BotPlayer(new Hand(),2);
        Player p3=new BotPlayer(new Hand(),3);
        Player p4=new HumanPlayer(new Hand(),4);

        Deck deck = new Deck();
        deck.shuffleDeck();
        dealCards(deck,p1,p2,p3,p4);



        System.out.println(deck.getDeckLinkedList().toString1());
        System.out.println(p1.getPlayerHand().getCardsInHand().toString1());
        System.out.println(p2.getPlayerHand().getCardsInHand().toString1());
        System.out.println(p3.getPlayerHand().getCardsInHand().toString1());
        System.out.println(p4.getPlayerHand().getCardsInHand().toString1());


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
        player.getPlayerHand().getCardsInHand();
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

    //adds a card to hand from deck
    public static void addCard(Deck d, Player p){
        Card tmp =d.getDeckLinkedList().getTail();
        d.getDeckLinkedList().deleteLast();
        p.getPlayerHand().getCardsInHand().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
    }

    /**
     * method that deals all cards
     * @param d
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public static void dealCards(Deck d,Player p1,Player p2,Player p3,Player p4){
        for(int i=0;i<13;i++){
            addCard(d,p1);
        }
        for(int i=0;i<13;i++){
            addCard(d,p2);
        }
        for(int i=0;i<13;i++){
            addCard(d,p3);
        }
        for(int i=0;i<13;i++){
            addCard(d,p4);
        }

    }
}