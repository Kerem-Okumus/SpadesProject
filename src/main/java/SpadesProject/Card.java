package SpadesProject;

public class Card {

    private final String suit; //suit of the card SPADES ,DIAMONDS ,CLUBS ,HEARTS
    private final String value; //values of the cards 2 to 14
    private Card nextCard;
    protected int intValue;  //integer value of the cards

    /**
     * @param suit
     * @param value
     * @param nextCard
     */
    public Card(String suit, String value, Card nextCard){
        this.suit=suit;
        this.value=value;
        this.nextCard = nextCard;

    }

    /**
     *
     * @param suit
     * @param value
     * @param intValue
     */
    public Card(String suit, String value ,int intValue) {
        this.suit = suit;
        this.value = value;
        this.intValue=intValue;
    }

    /**
     *
     * @return
     */
    public Card getNextCard(){
        return nextCard;
    }

    /**
     *
     */
    public void setNextCard(Card next){
        this.nextCard=next;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    /**
     *
     * @return
     */
    public String getCardSuit(){
        return suit;
    }

    /**
     *
     * @return
     */
    public String getCardValue(){
        return value;
    }

    /**
     * Card to string
     * @return
     */
    public String toString(){
        return  value+" of "+suit+"";
}

}
