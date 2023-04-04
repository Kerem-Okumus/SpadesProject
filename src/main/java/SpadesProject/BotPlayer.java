package SpadesProject;
import java.util.Random;
public class BotPlayer extends Player {

    static Random random=new Random();

    protected int remainingCards=13;
    protected Card selectedCard;

    /**
     * @param hand
     * @param playerIndex
     */
    public BotPlayer(Hand hand, int playerIndex) {
        super(hand, playerIndex);
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

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
