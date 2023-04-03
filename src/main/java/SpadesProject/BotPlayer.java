package SpadesProject;
import java.util.Random;
public class BotPlayer extends Player {

    static Random random=new Random();

    /**
     * @param hand
     * @param playerIndex
     */
    public BotPlayer(Hand hand, int playerIndex) {
        super(hand, playerIndex);
    }

    public static void botPlay(Player player,Table table){
        Card tmp;
        int initial=13;
        if(player.getPlayerIndex()==1){
            Random random=new Random();
            int indexOfCard = random.nextInt(initial);
            tmp = player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard);
            table.setOpeningCard(new Card(tmp.getCardSuit(),tmp.getCardValue()));

            if(indexOfCard==0){
                player.getPlayerHand().getCardsInHand().deleteFirst();
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
            }
            else if(indexOfCard !=initial-1){
                player.getPlayerHand().getCardsInHand().deleteMiddle(player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard));
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
            }
            else{
                player.getPlayerHand().getCardsInHand().deleteLast();
                table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));
            }
            System.out.println("-player "+ player.getPlayerIndex()+" played "+tmp.getCardValue()+" of "+tmp.getCardSuit());
        }
        else{
            tmp=player.getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard());
            if(player.getPlayerHand().getCardsInHand().searchCard(table.getOpeningCard())==null){
                Random random=new Random();
                int indexOfCard = random.nextInt(initial);
                tmp = player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard);

                if(indexOfCard==0){
                    player.getPlayerHand().getCardsInHand().deleteFirst();
                    table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));

                }
                else if(indexOfCard !=initial-1){
                    player.getPlayerHand().getCardsInHand().deleteMiddle(player.getPlayerHand().getCardsInHand().getNthCard(indexOfCard));
                    table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));

                }
                else{
                    player.getPlayerHand().getCardsInHand().deleteLast();
                    table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(),tmp.getCardValue()));

                }
            } else {

                for(int i = 0;i<initial;i++){

                    if (tmp == player.getPlayerHand().getCardsInHand().getNthCard(i)) {
                        if (i == 0) {
                            player.getPlayerHand().getCardsInHand().deleteFirst();
                            table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue()));

                        } else if (i != initial - 1) {
                            player.getPlayerHand().getCardsInHand().deleteMiddle(player.getPlayerHand().getCardsInHand().getNthCard(i));
                            table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue()));

                        } else {
                            player.getPlayerHand().getCardsInHand().deleteLast();
                            table.getCardsOnTable().insertLast(new Card(tmp.getCardSuit(), tmp.getCardValue()));

                        }
                    }
                }
                System.out.println("-player "+ player.getPlayerIndex()+" played "+tmp.getCardValue()+" of "+tmp.getCardSuit());
            }
        }

        initial--;



    }

}
