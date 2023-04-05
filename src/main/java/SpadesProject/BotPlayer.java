package SpadesProject;
import java.util.Random;

public class BotPlayer extends Player {

    protected int remainingCards=13; //remaining cards number at the end of the round in hand
    protected Card selectedCard; //the card that player has selected to play

    /**
     * constructor of the BotPlayer
     * @param hand
     * @param playerIndex
     */
    public BotPlayer(Hand hand, int playerIndex) {
        super(hand, playerIndex);
    }

    public int getRemainingCards() {
        return remainingCards;
    }

    public void setRemainingCards(int remainingCards) {
        this.remainingCards = remainingCards;
    }


    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    /**
     * bots are playing cards according to this method, it includes playing logic and also searchValidCard() method
     * @param table
     */
    public void botPlay(Table table){
        Card tmp;

        if(getPlayerIndex()==1){
            Random random=new Random();
            int indexOfCard = random.nextInt(remainingCards);
            tmp = getPlayerHand().getCardsInHand().getNthCard(indexOfCard);
            setSelectedCard(tmp);
            table.setOpeningCard(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()));

            if(indexOfCard==0){
                getPlayerHand().getCardsInHand().deleteFirst();
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()));
            }
            else if(indexOfCard !=remainingCards-1){
                getPlayerHand().getCardsInHand().deleteMiddle(getPlayerHand().getCardsInHand().getNthCard(indexOfCard));
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()));
            }
            else{
                getPlayerHand().getCardsInHand().deleteLast();
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue(),tmp.getIntValue()));
            }
            System.out.println("-player "+ getPlayerIndex()+" played "+tmp.getCardValue()+" of "+tmp.getCardSuit());
        }
        else{
            tmp=getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard());
            if(tmp==null){
                Random random=new Random();
                int indexOfCard = random.nextInt(remainingCards);
                Card tmp1 = getPlayerHand().getCardsInHand().getNthCard(indexOfCard);
                setSelectedCard(tmp1);

                if(indexOfCard==0){
                    getPlayerHand().getCardsInHand().deleteFirst();
                    table.getCardsOnTable().insertLast(new Card(tmp1.getCardSuit(),tmp1.getCardValue(),tmp1.getIntValue()));

                }
                else if(indexOfCard !=remainingCards-1){
                    getPlayerHand().getCardsInHand().deleteMiddle(getPlayerHand().getCardsInHand().getNthCard(indexOfCard));
                    table.getCardsOnTable().insertLast(new Card(tmp1.getCardSuit(),tmp1.getCardValue(),tmp1.getIntValue()));

                }
                else{
                    getPlayerHand().getCardsInHand().deleteLast();
                    table.getCardsOnTable().insertLast(new Card(tmp1.getCardSuit(),tmp1.getCardValue(),tmp1.getIntValue()));

                }
                System.out.println("-player "+ getPlayerIndex()+" played "+tmp1.getCardValue()+" of "+tmp1.getCardSuit());
            } else {

                for(int i = 0;i<remainingCards;i++){

                    if (tmp == getPlayerHand().getCardsInHand().getNthCard(i)) {
                        setSelectedCard(tmp);
                        if (i == 0) {
                            getPlayerHand().getCardsInHand().deleteFirst();
                            table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue(),tmp.getIntValue()));

                        } else if (i != remainingCards - 1) {
                            getPlayerHand().getCardsInHand().deleteMiddle(getPlayerHand().getCardsInHand().getNthCard(i));
                            table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue(),tmp.getIntValue()));

                        } else {
                            getPlayerHand().getCardsInHand().deleteLast();
                            table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue(),tmp.getIntValue()));

                        }
                    }
                }
                System.out.println("-player "+ getPlayerIndex()+" played "+tmp.getCardValue()+" of "+tmp.getCardSuit());
            }
        }

        remainingCards--;



    }

}
