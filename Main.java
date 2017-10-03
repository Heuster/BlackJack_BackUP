
/**
 * Write a description of class Main here.
 * BlackJack
 * 
 * 
 * @author Danny Heu
 * @version 9.26.2017
 */

import java.util.Scanner;
import java.lang.Math;
public class Main
{
    public static void begin() {
        Scanner start = new Scanner(System.in);
        System.out.println("Do you want to play BlackJack? Press Enter to play" );

        String play = start.nextLine();
        System.out.println("Lets Play");
        boolean bust = false;

        Hand player = new Hand();
        Hand dealer = new Hand();
        System.out.println("Your hand, " + player.getCard() +" " + player.getCard2()); 
        System.out.println("Your total, " + player.getTotal());
        System.out.println("Dealer shows, " + dealer.getCard());
        String hitVal = "y";
        while (!hitVal.equals("n")){
            System.out.println("Do you want to hit? (Y/N) ");
            hitVal = start.next();

            if (hitVal.equals("y")) {
                System.out.println("Your new card, " + player.getHit() + "\n" + "Your total, " + player.getTotal());
            } else if (hitVal.equals("n")) {
                System.out.println("Your total, " + player.getTotal());
            }

            int checkHand = 21;
            if (player.getTotal() > checkHand) {
                System.out.println("BUSTED, your Total was over 21");
                bust = true;

            }

        }

        while (dealer.getTotal() <= 17 && !bust) {
            System.out.println("The dealer's total is less than 17, he has to keep hitting. ");
            System.out.println("Dealer's new card, " + dealer.getHit() + "\n" + "Dealer's total, " + dealer.getTotal());
            int checkDealer = 21;
            if (dealer.getTotal() > checkDealer) {
                System.out.println("BUSTED, Dealer's Total was over 21");
            }

        }

        if (bust){
            
        } else if (dealer.getTotal() > 21){
            System.out.println("Dealer total was over 21, BUSTED \n You Win!");
        } else if (dealer.getTotal() > player.getTotal()){
            System.out.println("Dealer's total was greater than yours, Dealer Wins! " );
        } else if (dealer.getTotal() < player.getTotal()){
            System.out.println("Your total was greater than Dealer, You Win! " );
        } else {
            System.out.println("GAME OVER");
        }
    }
}
