package SpadesProject;

import SpadesProject.Card;
import SpadesProject.Hand;

public class LinkedList {

     protected Card head;
     protected Card tail;

 public LinkedList(){
    head= null;
    tail=null;

 }

    public Card getPreviousCard(Card card){
     Card tmp=head;
     Card previousCard =null;
     while(tmp!= card){
         previousCard =tmp;
         tmp= tmp.getNextCard();
     }
     return previousCard;
    }


//will be used when creating the deck and hands
     public void insertLast(Card newCard) {
     if(head==null){
         head=newCard;
     }
     else{
         tail.setNextCard(newCard);
     }
     tail=newCard;
     }


//will be used to play card (removing from hand )
     public void deleteFirst(){
     head=head.getNextCard();
         if(head==null){
             tail=null;
         }
 }


//will be used to play card (removing from hand )
     public void deleteMiddle(Card card){
     Card previous;
     previous = getPreviousCard(card);
     previous.setNextCard(card.getNextCard());

         }
//will be used to play card (removing from hand and deck )
     public void deleteLast(){
     tail= getPreviousCard(tail);
     if(tail != null){
         tail.setNextCard(null);
     }else{
         head=null;
     }
         }

    /**
     *
     * @param cardInHand
     * @return
     */
       public Card searchCard(Hand cardInHand){     //search a card for bots from their hand to make a valid play
     Card tmp =head;
     return null;        //will be fixed later
    }

    /**
     *
     * @param n
     * @return
     */
     public Card getNthCard(int n){
         Card tmp = head;
         int index = 0;
         while (tmp != null) {
             if (index == n){
                 return tmp;
             }
             index++;
             tmp = tmp.getNextCard();
         }
         return null;
     }

}
