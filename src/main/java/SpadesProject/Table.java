package SpadesProject;

public class Table {

    protected static Card openingCard;  //the first card played to the table each round
    private LinkedList cardsOnTable= new LinkedList();


    public LinkedList getCardsOnTable(){
        return cardsOnTable;
    }

    public void setOpeningCard(Card openingCard) {
        this.openingCard = openingCard;
    }

    public Card getOpeningCard() {
        return openingCard;
    }

}
