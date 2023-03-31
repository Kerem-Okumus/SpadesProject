package SpadesProject;

public class Card {

    private final String suit;
    private final String value;
    private Card nextCard;
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

        return  value+"of"+suit;
}

}
