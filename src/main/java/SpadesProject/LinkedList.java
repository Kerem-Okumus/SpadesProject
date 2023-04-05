package SpadesProject;

public class LinkedList {

    protected Card head;
    protected Card tail;

    /**
     * const of the linkedlist
     */
 public LinkedList(){
    head= null;
    tail=null;

 }

    public Card getTail() {
        return tail;
    }

    /**
     * method that gets selected card and returns the previous card (used in deleteMiddle() and insertMiddle())
     * @param card
     * @return
     */
    public Card getPreviousCard(Card card){
        if (card == head) {
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
        return previous;
    }

    /**
     * method that uset to add cards to hand, deck and table (also used in shuffling)
     * @param newCard
     */
    public void insertFirst(Card newCard){
        if (head == null) {

            tail=newCard;
        }
        newCard.setNextCard(head);
        head = newCard;
    }

    /**
     * method that uset to add cards to hand, deck and table (also used in shuffling)
     * @param newCard
     */
     public void insertLast(Card newCard) {
     if(head==null){
         head=newCard;
     }
     else{
         tail.setNextCard(newCard);
     }
     tail=newCard;
     }


    /**
     * method used in shuffling cards
     */
     public void deleteFirst(){
     head=head.getNextCard();
         if(head==null){
             tail=null;
         }
 }


    /**
     * method used in shuffling cards
     * @param card
     */
     public void deleteMiddle(Card card){
     Card previous;
     previous = getPreviousCard(card);
     previous.setNextCard(card.getNextCard());

         }


    /**
     * method used in shuffling cards
     * @param newCard
     * @param previous
     */
     public void insertMiddle(Card newCard, Card previous){
     newCard.setNextCard(previous.getNextCard());
     previous.setNextCard(newCard);
     }


    /**
     * used to play card (removing from hand ,table and deck )
     */
     public void deleteLast(){
     tail= getPreviousCard(tail);
     if(tail != null){
         tail.setNextCard(null);
     }
     else{
         head=null;
     }
         }

    /**
     *The method that searches a card for bots from their hand to make a valid play
     * @param openingCard
     * @return
     */
       public Card searchCard(Card openingCard){
           Card tmp;
           tmp = head;
           while (tmp != null){
               if (tmp.getCardSuit() == openingCard.getCardSuit()) {
                   Card tmp2=head;
                   while(tmp2 != null){
                       if(tmp2.getCardSuit()==tmp.getCardSuit() && tmp2.getIntValue() > tmp.getIntValue()){
                           tmp=tmp2;
                       }
                       tmp2=tmp2.getNextCard();
                   }
                   return tmp;
               }
               tmp = tmp.getNextCard();
           }

           Card tmp1 =head;
           while(tmp1 !=null){
               if(tmp1.getCardSuit()=="Spades"){
                   Card tmp2=head;
                   while(tmp2 != null){
                       if(tmp2.getCardSuit()==tmp1.getCardSuit() && tmp2.getIntValue() < tmp1.getIntValue()){
                           tmp1=tmp2;
                       }
                       tmp2=tmp2.getNextCard();
                   }
                   return tmp1;
               }
               tmp1=tmp1.getNextCard();
           }
     return null;
    }

    /**
     *method that returns nth index of the card in linkedlist
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

    /**
     * method that returns the number of the cards in the hand ,deck and table
     * @return
     */
    public int cardCount(){
        int count = 0;
        Card tmp;
        tmp = head;
        while (tmp != null){
            tmp = tmp.getNextCard();
            count++;
        }
        return count;
    }

    /**
     * method that returns cards on the deck and the table
     * @return
     */
     public String toString(){
         String res= "";
         Card tmp =head;
         while(tmp !=null){
             res =res +"( "+tmp.toString()+")"+" ";
             tmp=tmp.getNextCard();
         }
         return res;
     }

    /**
     * method that return players hands with numbers near them ( to select index when playing
     * @return
     */
      public String handToString(){
         int totalCards=cardCount();
         int i=0;
          String res= "";
          Card tmp =head;
          while(tmp !=null){
              res =res +i+"-("+tmp.toString()+") , ";
              tmp=tmp.getNextCard();
              i++;
          }
          return res;
      }

}
