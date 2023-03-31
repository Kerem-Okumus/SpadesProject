package SpadesProject;

import java.util.Random;

public class Deck {

     private String [] suits = {"Diamonds", "Clubs", "Spades", "Hearts"};
     private String [] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

private static final int totalCards =52 ;
private LinkedList cardsInDeck =new LinkedList();


     //constructor of the deck ----> where the cards created(with using nested for loop) and place cards into the deck
     public Deck(){
         Card tmp=null;
         Card newCard =null;

           for(int i=0;i<suits.length;i++){
                for(int j=0;j<values.length;j++){
                    newCard =new Card(suits[i],values[j]);
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
     public void shuffleDeck(){
         Random random=new Random();
         Card tmp;
         Card tmp2;
         for(int i=0;i<totalCards;i++){
             int index=random.nextInt(totalCards);
                 while(index==i){
                     index=random.nextInt(totalCards);
                 }
             tmp= cardsInDeck.getNthCard(i);
             tmp2= cardsInDeck.getNthCard(index);

             if(i==0){
                 cardsInDeck.deleteFirst();
                 cardsInDeck.insertFirst(tmp2);
                 if(index !=52 && index!=0 ){
                     cardsInDeck.deleteMiddle(cardsInDeck.getNthCard(index));
                     cardsInDeck.insertMiddle(tmp,cardsInDeck.getNthCard(index-1));
                 }
             }

         }
}

     //the method that deals 13 cards to each hand
     public void dealCards(){

     }



}
