package SpadesProject;

import java.util.Random;

public class Deck {
    Random random = new Random();
     private String [] suits = {"Diamonds", "Clubs", "Spades", "Hearts"};
     private String [] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

private final int totalCards =52 ;
private LinkedList cardsInDeck =new LinkedList();


     //constructor of the deck ----> where the cards created(with using nested for loop) and place cards into the deck
     public Deck(){
         Card tmp=null;
         Card newCard =null;

           for(int i=0;i<suits.length;i++){
                for(int j=0;j<values.length;j++){
                    if(i==2){
                        newCard =new Card(suits[i],values[j],j+15);
                    }else {
                        newCard = new Card(suits[i], values[j], j + 2);
                    }
                          cardsInDeck.insertLast(newCard);
                         if(j>0) {
                             tmp.setNextCard(newCard);
                         }
                             tmp = newCard;

                }
           }
     }

     public LinkedList getDeckLinkedList(){
         return cardsInDeck;
     }

     //shuffles deck with a for loop (using Random )
     public void shuffleDeck() {

         Card tmp;
         Card tmp2;
         int index;
         for (int i = 1; i < totalCards-1; i++) {
             index = random.nextInt(50) + 1;
             while (i == index) {
                 index = random.nextInt(50) + 1;
             }
             tmp = cardsInDeck.getNthCard(i);
             tmp2 = cardsInDeck.getNthCard(index);

             /*if(i==0){
                 cardsInDeck.deleteFirst();
                 cardsInDeck.insertFirst(new Card(tmp2.getCardSuit(),tmp2.getCardValue()));
                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                 cardsInDeck.insertMiddle(new Card(tmp.getCardSuit(),tmp.getCardValue()), cardsInDeck.getNthCard(index - 1));

             }*/

                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(i));
                 cardsInDeck.insertMiddle(new Card(tmp2.getCardSuit(),tmp2.getCardValue(),tmp.getIntValue()), cardsInDeck.getNthCard(index - 1));
                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                 cardsInDeck.insertMiddle(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()), cardsInDeck.getNthCard(index - 1));

             /*if (i == 51) {
                 cardsInDeck.deleteLast();
                 cardsInDeck.insertLast(new Card(tmp2.getCardSuit(),tmp2.getCardValue()));
                 cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                 cardsInDeck.insertMiddle(new Card(tmp.getCardSuit(),tmp.getCardValue()), cardsInDeck.getNthCard(index - 1));
             }*/

         }
     }



}
