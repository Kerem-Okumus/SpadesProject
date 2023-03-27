public class Card {

    private final String suit;
    private final int value;


    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }




    // the method that specify the values of the cards. for ex: ace=1 , jack=11 etc. (Switch)
    public void matchValues(){

    }


    public String toString(){
        return value+"of"+suit;
}

}
