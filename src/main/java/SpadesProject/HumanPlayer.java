package SpadesProject;
import java.util.Scanner;
public class HumanPlayer extends Player {

static Scanner input=new Scanner(System.in);


    protected int remainingCards=13; //remaining cards number at the end of the round in hand
    protected Card selectedCard; //the card that player has selected to play

    /**
     * Constructor of the HumanPlayer
     * @param hand
     * @param playerIndex
     */
    public HumanPlayer(Hand hand, int playerIndex) {
        super(hand,playerIndex);
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }


    public int getRemainingCards() {
        return remainingCards;
    }

    public void setRemainingCards(int remainingCards) {
        this.remainingCards = remainingCards;
    }

    /**
     * method that checks whether the index is valid or not (used in getting card index and bid number)
     * @param index
     * @return
     */
    public boolean isValidIndex(int index){
        if(index > getRemainingCards()-1 || index < 0){
            return false;
        }
        return true;
    }

    /**
     * method allows player to make plays if it is valid
     * @param table
     */
    public void humanPlay(Table table){

        System.out.println("--------Your Current Hand--------");
        System.out.println(getPlayerHand().getCardsInHand().handToString());
        System.out.println("It is your turn , enter the index of the card you want to play");
        int index=input.nextInt();
        while(isValidIndex(index)==false) {

            System.out.println("please enter a valid index");
            index=input.nextInt();

        }
        setSelectedCard(getPlayerHand().getCardsInHand().getNthCard(index));
        isValidPlay(table);

        while(isValidPlay(table)==false){
            System.out.println("You can not play this card now, please select another card ");
            index=input.nextInt();
            setSelectedCard(getPlayerHand().getCardsInHand().getNthCard(index));
        }

        if(isValidPlay(table)){
           Card tmp=selectedCard;

            for(int i = 0;i<remainingCards;i++){

                if (tmp == getPlayerHand().getCardsInHand().getNthCard(i)) {
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
        }remainingCards--;

        System.out.println("You have played "+selectedCard.toString());
    }

    /**
     * method that checks whether the play is valid or not
     */
    public boolean isValidPlay(Table table) {

        Card tmp =getSelectedCard();
        if(tmp.getCardSuit()==table.getOpeningCard().getCardSuit()){
            return true;
        }
        if(getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard())==null){
            return true;
        }
        if(getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard()) != null  && getSelectedCard().getCardSuit()=="Spades"){
            return true;
        }
        return false;
    }

}
