package SpadesProject;
import java.util.Scanner;
public class HumanPlayer extends Player {

static Scanner input=new Scanner(System.in);

    /**
     * @param hand
     * @param playerIndex
     */
    public HumanPlayer(Hand hand, int playerIndex) {
        super(hand,playerIndex);
    }

    public static void humanPlay(){
        System.out.println("enter the index of the card you want to play");
        int index=input.nextInt();
    }


}
