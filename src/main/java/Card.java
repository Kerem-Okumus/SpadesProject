public class Card {

    private String suit;
    private int value;


    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }

    /* getters and setters
*/

    // the method that specify the values of the cards. for ex: ace=1 , jack=11 etc.
    public void matchValues(){

    }


    public String toString(){
        return value+"of"+suit;
}

}
