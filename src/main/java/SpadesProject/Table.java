package SpadesProject;

import SpadesProject.LinkedList;

public class Table {

    protected static Card openingCard;
    private LinkedList cardsOnTable= new LinkedList();

    /**
     * method that collect 4 cards from each players hand
     */
    public void addCardsToTable(){}


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
