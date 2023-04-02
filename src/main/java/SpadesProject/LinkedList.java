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

    public Card getTail() {
        return tail;
    }

    public Card getPreviousCard(Card card){
       /* if (card == head) {
            return head;
        }
        Card tmp = head;
        Card previous = null;
        while (tmp != null) {
            if (tmp.getNextCard() == card) {
                previous = tmp;
                break;
            }
            tmp = tmp.getNextCard();
        }
        return previous;*/
     Card tmp=head;
     Card previousCard =null;
     while(tmp!= card){
         previousCard =tmp;
         tmp= tmp.getNextCard();
     }
     return previousCard;
    }

    public void insertFirst(Card newCard){
        if (head == null) {

            tail=newCard;
        }
        newCard.setNextCard(head);
        head = newCard;
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

     public void deleteCard(Card card){

     }

     public void insertMiddle(Card newCard, Card previous){
     newCard.setNextCard(previous.getNextCard());
     previous.setNextCard(newCard);
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
     * @param openingCard
     * @return
     */
       public Card searchCard(Card openingCard){     //search a card for bots from their hand to make a valid play
           Card tmp;
           tmp = head;
           while (tmp != null){
               if (tmp.getCardSuit() == openingCard.getCardSuit()) {
                   return tmp;
               }
               tmp = tmp.getNextCard();
           }

           Card tmp1 =head;
           while(tmp !=null){
               if(tmp.getCardSuit()=="Spades"){
                   return tmp1;
               }
               tmp1=tmp1.getNextCard();
           }


     return null;
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

     public String toString(){
         String res= "";
         Card tmp =head;
         while(tmp !=null){
             res =res +tmp.toString()+" ";
             tmp=tmp.getNextCard();
         }
         return res;
     }

      public String handToString(){
         int i=0;
          String res= "";
          Card tmp =head;
          while(tmp !=null){
              res =res +tmp.toString()+" ";
              tmp=tmp.getNextCard();
          }
          return res;
      }

}
