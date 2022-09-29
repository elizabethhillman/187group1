package hw2;
/*
  Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
  Date: 10/01/22
  Assignment: Scholarship - Control Flow
  Problem Statement: Determine if a student is eligible for a scholarship or for dean consideration
  based on their age, where they live, their work history, taxes, volunteering history, and income

 */

import java.util.Scanner;

public class Scholarship {
    //variables used to determine the students eligibility
    static int age = 0;
    static boolean resident = false;
    static boolean partTimeWorker = false;
    static boolean paidStateTax = false;
    static boolean volunteered = false;
    static int houseHoldIncome = 0;

    /**
     * This method will call checkEligibility to determine the student's eligibility status
     */
    public static void main(String[] args) {
        checkEligibility();
    }

    /**
     * this method will be used to determine the users eligibility for the scholarship based on their input
     * prints 0 if they aren't eligible, 1 if they are or for dean for consideration
     */
    public static void checkEligibility()
    {
        //scanner to get user info
        Scanner sc = new Scanner(System.in);

        //used to get the users age
        System.out.println("Enter your age");
        age = sc.nextInt();
        //if they do not meet age requirements, they will not be eligible and code will end
        if (age < 18 || age > 24)
        {
            System.out.println("0");
            System.exit(0);
        }

        //used to verify the user has lived in CA for 2 years
        System.out.println("Have you lived in california for last 2 years: Y/N");
        resident = charToBool(sc.next().charAt(0));

        //used to verify the users work history
        System.out.println("have you worked part time or full time for at least 6 months");
        partTimeWorker = charToBool(sc.next().charAt(0));

        //used to verify the user's parents tax info
        System.out.println("have your parents paid CA state tax and lived in CA for 1 year");
        paidStateTax = charToBool(sc.next().charAt(0));

        //used to verify the users volunteering history
        System.out.println("have you volunteered for a public cause in CA and have proof");
        volunteered = charToBool(sc.next().charAt(0));

        //checks if the user meets at least one CA residency conditions
        if (resident || partTimeWorker || paidStateTax || volunteered) {
            System.out.println("1");
            System.exit(0);
        }
        //used to very the users income
        System.out.println("Enter your HouseHold Income");
        houseHoldIncome = sc.nextInt();

        //if they do not meet residency conditions but meet requirements then they will be up for dean consideration
        if (houseHoldIncome < 5000) {
            System.out.println("Dean for consideration");
            System.exit(0);
        }
        //if they don't meet residency conditions and also have too high of an income they will not be eligible
        else
        {
            System.out.println("0");
            System.exit(0);
        }
    }

    /**
     * this method will alter the users text input to be saved as a boolean value
     * @param c - user input (y or n)
     * @return - boolean value based on input or an exception if the user input is incorrect
     */
    public static boolean charToBool(char c) {
        return switch (c) {
            case 'y' -> true;
            case 'n' -> false;
            default -> throw new IllegalArgumentException("Must be either 'y' or 'n'.");
        };
    }
}
