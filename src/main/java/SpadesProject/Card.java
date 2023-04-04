package SpadesProject;

public class Card {

    private final String suit;
    private final String value;
    private Card nextCard;
    protected int intValue;

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

    // the method that specify the values of the cards. for ex: ace=14 , jack=11 etc. (Switch)
    public void matchValues(){

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

    public String toString(){

        return  value+" of "+suit+"";
}

}
