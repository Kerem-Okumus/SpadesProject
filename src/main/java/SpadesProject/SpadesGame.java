package SpadesProject;

import SpadesProject.Hand;
import java.util.Random;
import java.util.Scanner;

public class SpadesGame {

    public static void main(String[] args) {
        Random random=new Random();

        BotPlayer p1=new BotPlayer(new Hand(),1);
        BotPlayer p2=new BotPlayer(new Hand(),2);
        BotPlayer p3=new BotPlayer(new Hand(),3);
        HumanPlayer p4=new HumanPlayer(new Hand(),4);
        Deck deck=new Deck();
        Table table=new Table();

        setGame(p1,p2,p3,p4,deck,table);
        playRound(p1,p2,p3,p4,deck,table);


      /*  System.out.println("-------------------- P1 HAND --------------------");
        System.out.println(p1.getPlayerHand().getCardsInHand().toString());
        System.out.println("-------------------- P2 HAND --------------------");
        System.out.println(p2.getPlayerHand().getCardsInHand().toString());
        System.out.println("-------------------- P3 HAND --------------------");
        System.out.println(p3.getPlayerHand().getCardsInHand().toString());
        System.out.println();*/





       /* System.out.println();
        System.out.println("--------- CARDS ON TABLE ---------");
        System.out.println(table.getCardsOnTable().toString());
        System.out.println();*/


        //System.out.println(p1.getPlayerHand().getCardsInHand().toString());
        //System.out.println(p2.getPlayerHand().getCardsInHand().toString());
        //System.out.println(p3.getPlayerHand().getCardsInHand().toString());



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
    public static void setGame(Player p1,Player p2,Player p3,HumanPlayer p4,Deck deck,Table table) {
Scanner input=new Scanner(System.in);
        deck.shuffleDeck();
        dealCards(deck,p1,p2,p3,p4);

        System.out.println("The deck has been created...");
        System.out.println("The deck has been shuffled...");
        System.out.println("Cards have been dealt...");
        System.out.println("----------GAME STARTED----------\n");

        System.out.println("-----Your Hand-----\n"+p4.getPlayerHand().getCardsInHand().toString());

        setBids(p1,p2,p3,p4);

    }

    /**
     * // method that shows current hand as provided in the output template
     *
     * @param player
     */
    public void displayHand(Player player) {
       System.out.println(player.getPlayerHand().getCardsInHand().toString());
    }

    /**
     * method that gets bids from players
     */
    public static void setBids(Player p1,Player p2,Player p3,HumanPlayer p4) {
        Random random=new Random();
        Scanner input=new Scanner(System.in);

        int bid1 = random.nextInt(3)+1;
        p1.setBid(bid1);
        int bid2 = random.nextInt(3)+1;
        p2.setBid(bid2);
        int bid3 = random.nextInt(3)+1;
        p3.setBid(bid3);

        System.out.print("Please enter your bid here:");
        int bid=input.nextInt();
        p4.setBid(bid);

        System.out.println("Bids have set, p1:"+p1.getBid()+" ,p2:"+p2.getBid()+" ,p3:"+p3.getBid()+" ,you:"+p4.getBid()+"\n");

    }

    /**
     * method that simulates 1 round
     */
    public static void playRound(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4,Deck deck,Table table) {
        for(int i=1;i<14;i++) {
            System.out.println("------------------------------ROUND "+i+"------------------------------\n");

            p1.botPlay(table);
            p2.botPlay(table);
            p3.botPlay(table);
            p4.humanPlay(table);
            determineRoundWinner(p1,p2, p3, p4, table);
                for(int j=3;j>=0;j--){
                    Card tmp=table.getCardsOnTable().getNthCard(j);
                    table.getCardsOnTable().deleteLast();

                    deck.getDeckLinkedList().insertLast(new Card(tmp.getCardValue(),tmp.getCardSuit(),tmp.getIntValue()));
                }
                table.getCardsOnTable().deleteFirst();

        }
    }

    public static void determineRoundWinner(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4,Table table ){
        Card winnerCard=table.getCardsOnTable().getTail();

        if(p1.selectedCard.getCardSuit()==p2.selectedCard.getCardSuit() && p2.selectedCard.getCardSuit()==p3.selectedCard.getCardSuit() && p3.selectedCard.getCardSuit()==p4.selectedCard.getCardSuit()){
            System.out.println(table.getCardsOnTable().toString());
            System.out.println(p4.getSelectedCard().toString());
            for(int i=0;i<3;i++){
                Card tmp= table.getCardsOnTable().getNthCard(i);

                if(tmp.getIntValue() > winnerCard.getIntValue()){
                    winnerCard=tmp;
                    System.out.println("test2 "+winnerCard.toString());
                }
            }
            if(winnerCard.toString().equals(p1.selectedCard.toString())){p1.increaseTrickCount();System.out.println("-Player 1 won the round ");}
            else if(winnerCard.toString().equals(p2.selectedCard.toString())){p2.increaseTrickCount();System.out.println("-Player 2 won the round ");}
            else if(winnerCard.toString().equals(p3.selectedCard.toString())){p3.increaseTrickCount();System.out.println("-Player 3 won the round ");}
            else if(winnerCard.toString().equals(p4.selectedCard.toString())){p4.increaseTrickCount();System.out.println("-You won the round ");}
            System.out.println(" Trick points are --> p1 : "+p1.getTrickCount()+" ,p2 : "+p2.getTrickCount()+" ,p3 : "+p3.getTrickCount()+" ,YOU : "+p4.getTrickCount());
        }



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









    /**
     * //adds a card to hand from deck
     * @param deck
     * @param player
     */
    public static void addCard(Deck deck, Player player){
        Card tmp =deck.getDeckLinkedList().getTail();
        deck.getDeckLinkedList().deleteLast();
        player.getPlayerHand().getCardsInHand().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()));
    }

    /**
     * method that deals all cards
     * @param deck
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public static void dealCards(Deck deck,Player p1,Player p2,Player p3,Player p4){
        for(int i=0;i<13;i++){
            addCard(deck,p1);
        }
        for(int i=0;i<13;i++){
            addCard(deck,p2);
        }
        for(int i=0;i<13;i++){
            addCard(deck,p3);
        }
        for(int i=0;i<13;i++){
            addCard(deck,p4);
        }
        deck.getDeckLinkedList().deleteFirst();

    }
}