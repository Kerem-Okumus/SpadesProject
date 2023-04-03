package SpadesProject;

import SpadesProject.Hand;
import java.util.Random;
import java.util.Scanner;

public class SpadesGame {

    public static void main(String[] args) {
        Random random=new Random();

        Player p1=new BotPlayer(new Hand(),1);
        Player p2=new BotPlayer(new Hand(),2);
        Player p3=new BotPlayer(new Hand(),3);
        HumanPlayer p4=new HumanPlayer(new Hand(),4);
        Deck deck=new Deck();
        Table table=new Table();

        setGame(p1,p2,p3,p4,deck,table);
        playRound(p1,p2,p3,p4,table);


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
     * playing logic for bots
     * @param player
     * @param table
     */
    public static void botPlay(Player player,Table table){
        Card tmp;
        int initial=13;
        if(player.getPlayerIndex()==1){
            Random random=new Random();
            int indexOfCard = random.nextInt(initial);
            tmp = player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard);
            table.setOpeningCard(new Card(tmp.getCardSuit(),tmp.getCardValue()));

            if(indexOfCard==0){
                player.getPlayerHand().getCardsInHand().deleteFirst();
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
            }
            else if(indexOfCard !=initial-1){
                player.getPlayerHand().getCardsInHand().deleteMiddle(player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard));
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
            }
            else{
                player.getPlayerHand().getCardsInHand().deleteLast();
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
            }
            System.out.println("-player "+ player.getPlayerIndex()+" played "+tmp.getCardValue()+" of "+tmp.getCardSuit());
        }
        else{
            tmp=player.getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard());
            if(player.getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard())==null){
                Random random=new Random();
                int indexOfCard = random.nextInt(initial);
                tmp = player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard);

                if(indexOfCard==0){
                    player.getPlayerHand().getCardsInHand().deleteFirst();
                    table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));

                }
                else if(indexOfCard !=initial-1){
                    player.getPlayerHand().getCardsInHand().deleteMiddle(player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard));
                    table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));

                }
                else{
                    player.getPlayerHand().getCardsInHand().deleteLast();
                    table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));

                }
            } else {

                for(int i = 0;i<initial;i++){

                if (tmp == player.getPlayerHand().getCardsInHand().getNthCard(i)) {
                    if (i == 0) {
                        player.getPlayerHand().getCardsInHand().deleteFirst();
                        table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue()));

                    } else if (i != initial - 1) {
                        player.getPlayerHand().getCardsInHand().deleteMiddle(player.getPlayerHand().getCardsInHand().getNthCard(i));
                        table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue()));

                    } else {
                        player.getPlayerHand().getCardsInHand().deleteLast();
                        table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue()));

                    }
                }
                }
                System.out.println("-player "+ player.getPlayerIndex()+" played "+tmp.getCardValue()+" of "+tmp.getCardSuit());
            }
        }

    initial--;



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
        System.out.println("----------GAME STARTED----------\n\n\n");

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
     * method that determines the winner of the round and gives 1 trick point to the winner of the round
     */
    public static void playRound(Player p1,Player p2,Player p3,HumanPlayer p4,Table table) {
        for(int i=1;i<14;i++) {
            System.out.println("------------------------------ROUND "+i+"------------------------------");
            botPlay(p1, table);
            botPlay(p2, table);
            botPlay(p3, table);
            p4.humanPlay(table);
            System.out.println("Player x won the round "+i);
                for(int j=0;j<4;j++){
                    table.getCardsOnTable().deleteLast();
                }
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
        player.getPlayerHand().getCardsInHand().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
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

    }
}