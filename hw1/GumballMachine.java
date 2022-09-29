package hw1;
/**
 * Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
 * Date: 8/30/22
 * Assignment: Gumball Vending Machine - Writing Test Cases I
 * Problem Statement: Allows users to input nickel(s), dime(s), quarter(s),
 * in order to receive how every many red gumballs and yellow gumballs they desire with a balance allowing them to do so
 */

import java.util.Scanner;

public class GumballMachine {
    //Variable to hold the users current balance
    static double userBalance = 0;
    //Variables to hold the value of a gumball
    static int redGumball = 5;
    static int yellowGumball = 10;
    //Variables to hold a counter for how many of each color gumball the user requests
    static int numRed = 0;
    static int numYellow = 0;
    //Scanner to get user input
    static Scanner scan = new Scanner(System.in);
    //Boolean variables to determine when user is done adding money or when they want their change
    static boolean wantChange = false;
    static boolean doneAddingMoney = false;

    static double getUserBalance(){
        return userBalance;
    }

    static boolean refund() {
        System.out.println(getUserBalance() + " is your change");
        return wantChange = true;
    }

    /**
     * This method will take user input to determine how much money the user wants to insert into a gumball machine,
     * determines what color gumball they want and how many of each color
     */
    public static void main(String[] args) {
        //continues to prompt the user to add money until they are finished
        while (!doneAddingMoney) {
            //prompts user to add money
            System.out.println("Balance: " + getUserBalance() + " Do you want to enter a n, d or q? Say no if you are done");
            askUserForMoney(scan.nextLine());
        }

        //continues to prompt the user to push a colored lever until they run out of money or want change
        while (!wantChange && userBalance >= 0) {
            //once the user runs out of money, they will be told so and how many of each color gumball they acquired
            if (userBalance == 0) {
                System.out.println("You are out of money. You got " + numRed + " red gumballs and " + numYellow + " yellow gumballs");
                break;
            }
            /*
            once the user still has money remaining, they will be told their current balance and number of each color gumball
            they have already acquired. then will be prompted for what color gumball they want next or if they want their
            change back
            */
            else {
                System.out.println("Current balance: " + getUserBalance() + ". You have " + numRed + " red gumballs and " + numYellow + " yellow gumballs");
                System.out.println("Do you want a red or yellow gumball? Or Select 'Return My Change' if you are done");
                askUserWhatGumballs(scan.nextLine());
            }
        }
    }

    /**
     * This method will determine the user balance based on what coins they add
     *
     * @param input - the type of coin the user wishes to input
     */
    public static void askUserForMoney(String input) {
        switch (input) {
            //once the user adds a nickel, then their balance will increase by 5
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
                System.out.println(input + " is invalid");
                break;
        }
    }

    /**
     * This method will determine the amount of each color gumball the user gets, if they have enough money for it
     *
     * @param input - the color of gumball the user wants
     */
    public static void askUserWhatGumballs(String input) {
        //once the user selects a red gumball and if they have enough money for it, then their balance will decrease and the count of red gumballs acquired will increment
        if (input.equals("red") && userBalance >= 5) {
            userBalance -= redGumball;
            numRed++;
        }

        //once the user selects a yellow gumball and if they have enough money for it, then their balance will decrease and the count of red gumballs acquired will increment
        else if (input.equals("yellow") && userBalance >= 10) {
            userBalance -= yellowGumball;
            numYellow++;
        }

        //once the user requests their change back, they will receive their change and the program will end
        else if (input.equals("Return My Change")) {
            refund();
        } else if ((userBalance < redGumball && input.equals("red")) || (userBalance < yellowGumball && input.equals("yellow"))) {
            System.out.println("You do not have enough money");
        }
        //once there is any type of input error, the user will be prompted again for what color gumball they want
        else {
            System.out.println("Invalid input. Try again");
        }
    }


}

