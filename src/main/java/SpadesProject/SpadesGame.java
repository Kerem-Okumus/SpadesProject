package SpadesProject;

import java.util.Random;
import java.util.Scanner;

public class SpadesGame {

    public static void main(String[] args) {

        BotPlayer p1=new BotPlayer(new Hand(),1);
        BotPlayer p2=new BotPlayer(new Hand(),2);
        BotPlayer p3=new BotPlayer(new Hand(),3);
        HumanPlayer p4=new HumanPlayer(new Hand(),4);

        Deck deck=new Deck();
        Table table=new Table();

        playGame(p1,p2,p3,p4,deck,table);

    }

    /**
     * Method that continues the game if no one reaches the target score
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @param deck
     * @param table
     */
    public static void playGame(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4,Deck deck,Table table){
        System.out.println("The deck has been created...");
        while(isGameOver(p1,p2,p3,p4)==false) {
            setGame(p1, p2, p3, p4, deck, table);
            System.out.println("----------GAME STARTED----------\n");

            playRound(p1, p2, p3, p4, deck, table);
            System.out.println("---------------------------------------------");
            System.out.println("13 Rounds are over, no one have reached the target score , continuing the game");
            System.out.println("---------------------------------------------");
        }
        System.out.println(" GAME OVER ");
    }

    /**
     * // the method that creates deck and the players , shuffles the deck and deals the cards
     */
    public static void setGame(Player p1,Player p2,Player p3,HumanPlayer p4,Deck deck,Table table) {

        deck.shuffleDeck();
        deck.shuffleDeck();
        deck.shuffleDeck();
        dealCards(deck,p1,p2,p3,p4);


        System.out.println("The deck has been shuffled...");
        System.out.println("Cards have been dealt...");


        System.out.println("-----Your Hand-----\n"+p4.getPlayerHand().getCardsInHand().handToString());

        setBids(p1,p2,p3,p4);
    }

    /**
     * // method that shows current hand as provided in the output template
     *
     * @param player
     */
    public static void displayHand(Player player) {
        System.out.println(player.getPlayerHand().getCardsInHand().handToString());
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

        int bid = input.nextInt();

        while(p4.isValidBid(bid)==false){
            System.out.print("Please enter a valid bid (0-13) :");
            bid=input.nextInt();
        }
            p4.setBid(bid);

        System.out.println("Bids have set, p1:"+p1.getBid()+" ,p2:"+p2.getBid()+" ,p3:"+p3.getBid()+" ,you:"+p4.getBid()+"\n");

    }

    /**
     * method that simulates 13 rounds
     * @param p1,p2,p3,p4,deck,table
     */
    public static void playRound(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4,Deck deck,Table table) {

        for(int i=1;i<14;i++) {
            System.out.println("------------------------------ROUND "+i+"------------------------------\n");

            p1.botPlay(table);
            p2.botPlay(table);
            p3.botPlay(table);
            p4.humanPlay(table);
            System.out.println("------CARDS ON TABLE------");
            System.out.println(table.getCardsOnTable().toString());
            determineRoundWinner(p1,p2, p3, p4, table);
                for(int j=3;j>=0;j--){
                    Card tmp=table.getCardsOnTable().getNthCard(j);
                    table.getCardsOnTable().deleteLast();

                    deck.getDeckLinkedList().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()));
                }
                table.getCardsOnTable().deleteFirst();

        }
        givePoints(p1);
        givePoints(p2);
        givePoints(p3);
        givePoints(p4);

        displayScores(p1,p2,p3,p4);

        p1.setRemainingCards(13);
        p2.setRemainingCards(13);
        p3.setRemainingCards(13);
        p4.setRemainingCards(13);
    }

    public static void displayScores(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4){
        System.out.println("Total Scores ----->  P1 : "+p1.getTotalScore()+" ,P2 : "+p2.getTotalScore()+" ,P3 : "+p3.getTotalScore()+" YOU : "+p4.getTotalScore());
    }

    /**
     * method that determines the winner of the round and prints the current points
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @param table
     */
    public static void determineRoundWinner(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4,Table table ){
        Card winnerCard=table.getCardsOnTable().getTail();

        if(p1.selectedCard.getCardSuit()==p2.selectedCard.getCardSuit() && p2.selectedCard.getCardSuit()==p3.selectedCard.getCardSuit() && p3.selectedCard.getCardSuit()==p4.selectedCard.getCardSuit()){
            for(int i=0;i<3;i++){
                Card tmp= table.getCardsOnTable().getNthCard(i);

                if(tmp.getIntValue() > winnerCard.getIntValue()){
                    winnerCard=tmp;
                }
            }

        }else {
            if(p1.getSelectedCard().getCardSuit() != "Spades" && p2.getSelectedCard().getCardSuit() != "Spades" && p3.getSelectedCard().getCardSuit() != "Spades" && p4.getSelectedCard().getCardSuit() != "Spades"){
                winnerCard=p1.getSelectedCard();
            }
            else{
                for(int i=0;i<3;i++){
                    Card tmp=table.getCardsOnTable().getNthCard(i);
                        if(tmp.getCardSuit()=="Spades" && tmp.getIntValue()>winnerCard.getIntValue()){
                            winnerCard=tmp;
                        }
                }
            }

        }

        if(winnerCard.toString().equals(p1.selectedCard.toString())){p1.increaseTrickCount();System.out.println("-Player 1 won the round ");}
        else if(winnerCard.toString().equals(p2.selectedCard.toString())){p2.increaseTrickCount();System.out.println("-Player 2 won the round ");}
        else if(winnerCard.toString().equals(p3.selectedCard.toString())){p3.increaseTrickCount();System.out.println("-Player 3 won the round ");}
        else if(winnerCard.toString().equals(p4.selectedCard.toString())){p4.increaseTrickCount();System.out.println("-You won the round ");}
        System.out.println(" Trick points are --> p1 : "+p1.getTrickCount()+" ,p2 : "+p2.getTrickCount()+" ,p3 : "+p3.getTrickCount()+" ,YOU : "+p4.getTrickCount());
    }

    /**
     * method that checks whether a player won the game or not
     */
    public static boolean isGameOver(BotPlayer p1,BotPlayer p2,BotPlayer p3,HumanPlayer p4) {
        int winningScore=500;
        if(p1.getTotalScore() >= winningScore){System.out.println("****** P1 WON THE GAME ******");return true;}
        if(p2.getTotalScore() >= winningScore){System.out.println("****** P2 WON THE GAME ******");return true;}
        if(p3.getTotalScore() >= winningScore){System.out.println("****** P3 WON THE GAME ******");return true;}
        if(p4.getTotalScore() >= winningScore){System.out.println("****** YOU WON THE GAME ******");return true;}
        return false;
    }

    /**
     * method that gives points to players according to the rules
     */
    public static void givePoints(Player player) {
        int bid=player.getBid();
        if(bid ==0 && player.getTrickCount()>0){
            player.setTotalScore((player.getTotalScore())-100);
        }
        if(bid ==0 && player.getTrickCount() < 0){
            player.setTotalScore((player.getTotalScore())+100);
        }
        else if(bid !=0 && bid <= player.getTrickCount()){
            player.setTotalScore(player.getTotalScore()+bid*10 +(player.getTrickCount()-bid));
        }
        else if(player.getTrickCount() < player.getBid()){
            player.setTotalScore(player.getTotalScore()-bid*10);
        }

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