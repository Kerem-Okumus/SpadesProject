package SpadesProject;

import java.util.Random;

public class Deck {
    Random random = new Random();

private final int totalCards =52 ;
private LinkedList cardsInDeck =new LinkedList();

    /**
     * //constructor of the deck ----> where the cards created(with using nested for loop) and place cards into the deck
     */
     public Deck(){
         String suit =null;
         String value=null;
         Card tmp=null;
         Card newCard=null;
     for( int i=1;i<5;i++){
         switch(i){
             case 1 : suit ="Diamonds";
                 break;
             case 2 : suit= "Clubs";
                 break;
             case 3 : suit= "Spades";
                 break;
             case 4 : suit ="Hearts";
                 break;
     }
     for(int j=0;j<13;j++){
         if(j<9) {
             value = Integer.toString(j + 2);
         }
     switch(j) {
         case 9:
             value = "Jack";
                 break;
         case 10:
             value = "Queen";
                 break;
         case 11:
             value = "King";
                 break;
         case 12:
             value = "Ace";
                 break;
         }
     if(i==3){
         newCard =new Card(suit,value,j+15);
     }
     else{
         newCard =new Card(suit,value,j+2);
     }
         cardsInDeck.insertLast(newCard);
     if(j>0){
         tmp.setNextCard(newCard);
     }
     tmp=newCard;
     }
     }
}

     public LinkedList getDeckLinkedList(){
         return cardsInDeck;
     }


    /**
     * //shuffles deck with a for loop
     */
    public void shuffleDeck() {
         Card tmp;
         Card tmp2;
         int index;
         for (int i = 0; i <= totalCards-1; i++) {
             index = random.nextInt(50) + 1;
             while (i == index) {
                 index = random.nextInt(50) + 1;
             }
             tmp = cardsInDeck.getNthCard(i);
             tmp2 = cardsInDeck.getNthCard(index);

             if(i==0){
                 cardsInDeck.deleteFirst();
                 cardsInDeck.insertFirst(new Card(tmp2.getCardSuit(),tmp2.getCardValue(),tmp2.getIntValue()));
                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                 cardsInDeck.insertMiddle(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()), cardsInDeck.getNthCard(index-1 ));

             }
             else if(i !=totalCards-1) {
                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(i));
                 cardsInDeck.insertMiddle(new Card(tmp2.getCardSuit(),tmp2.getCardValue(),tmp2.getIntValue()), cardsInDeck.getNthCard(index -1));

                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                 cardsInDeck.insertMiddle(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()), cardsInDeck.getNthCard(index -1));
             }

             else if (i == 51) {
                 cardsInDeck.deleteLast();
                 cardsInDeck.insertLast(new Card(tmp2.getCardSuit(),tmp2.getCardValue(),tmp2.getIntValue()));
                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                 cardsInDeck.insertMiddle(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()), cardsInDeck.getNthCard(index-1 ));
             }

         }
     }

}
