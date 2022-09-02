/**
 * Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
 * Date: 8/30/22
 * Assignment: Gumball Vending Machine - Writing Test Cases I
 * Problem Statement:
 */

import java.util.Scanner;

public class Gumball{

    /*
     * This method will take user input to determine how much money the user wants to insert into a gumball machine,
     * determines what color gumball they want and how many of each color
     *
     * Output: Number of gumballs and balance
     */
    public static void main(String[] args)
    {
        //Variables to hold the value of a gumball
        int redGumball = 5;
        int yellowGumball = 10;

        //Variables to hold a counter for how many of each color gumball the user requests
        int numRed = 0;
        int numYellow = 0;

        //Variable to hold the remaining money that the user has
        double userBalance = 0;

        //Variable to hold  which color gumball they want
        String userColorGumball;

        //scanner to get user input
        Scanner scan = new Scanner(System.in);

        //boolean variables to determine when user is done adding money or when they want their change
        boolean doneAddingMoney = false;
        boolean wantChange = false;

        //continue to prompt user to add a nickel, quarter or dime until they are finished
        while(!doneAddingMoney)
        {
            //prompts user to add money
            System.out.println("Balance: " + userBalance + " Do you want to enter a n, d or q? Say no if you are done");
            String userTotalMoney = scan.nextLine();

            //once the user adds a nickel, then their balance will increase by 5
            switch (userTotalMoney) {
                case "n":
                    userBalance += 5;
                    break;
                //once the user adds a dime, then their balance will increase by 10
                case "d":
                    userBalance += 10;
                    break;
                //once the user adds a quarter, then their balance will increase by 25
                case "q":
                    userBalance += 25;
                    break;
                case "no":
                    doneAddingMoney = true;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }

        //continues to prompt the user to push a colored lever until they run out of money or want change
        while(!wantChange && userBalance >= 0)
        {
            //once the user runs out of money, they will be told so and how many of each color gumball they acquired
            if(userBalance == 0)
            {
                System.out.println("You are out of money. You got " + numRed + " red gumballs and " + numYellow + " yellow gumballs");
                break;
            }

            /*
            once the user still has money remaining, they will be told their current balance and number of each color gumball
            they have already acquired. then will be prompted for what color gumball they want next or if they want their
            change back
            */
            else
            {
                System.out.println("Current balance: " + userBalance + ". You have " + numRed + " red gumballs and " + numYellow + " yellow gumballs");
                System.out.println("Do you want a red or yellow gumball? Or Select 'Return My Change' if you are done");
                userColorGumball = scan.nextLine();
            }

            //once the user selects a red gumball and if they have enough money for it, then their balance will decrease and the count of red gumballs acquired will increment
            if(userColorGumball.equals("red") && userBalance >= 5)
            {
                userBalance -= redGumball;
                numRed++;
            }

            //once the user selects a yellow gumball and if they have enough money for it, then their balance will decrease and the count of red gumballs acquired will increment
            else if(userColorGumball.equals("yellow") && userBalance >= 10)
            {
                userBalance -= yellowGumball;
                numYellow++;
            }

            //once the user requests their change back, they will receive their change and the program will end
            else if(userColorGumball.equals("Return My Change"))
            {
                System.out.println(userBalance + " is your change");
                wantChange = true;
                break;
            }

            else if((userBalance < redGumball && userColorGumball.equals("red")) || (userBalance < yellowGumball && userColorGumball.equals("yellow")))
            {
                System.out.println("You do not have enough money");
            }
            //once there is any type of input error, the user will be prompted again for what color gumball they want
            else
            {
                System.out.println("Try again");
            }
        }
    }
}