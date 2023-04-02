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



}
