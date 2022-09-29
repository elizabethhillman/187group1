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
     * This method will take user input to then be used to determine their eligibility for the scholarship
     */
    public static void main(String[] args) {
        //scanner to get user info
        Scanner sc = new Scanner(System.in);

        //used to get the users age
        System.out.println("Enter your age");
        age = sc.nextInt();

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

        //used to very the users income
        System.out.println("Enter your HouseHold Income");
        houseHoldIncome = sc.nextInt();

        //this will pass the users information to checkEligibility() method to determine if the user is eligible for scholarship or not
        int eligible = checkEligibility(age, resident, partTimeWorker, paidStateTax, volunteered, houseHoldIncome);

        //if the user doesn't meet CA residency but has income less than $5k they will be told they are up for dean consideration
        if (eligible == -1) {
            System.out.println("Dean for consideration");
        }
        //will print 0 if they aren't eligible and 1 for eligible
        else {
            System.out.println(eligible);
        }
    }

    /**
     * this method will be used to determine the users eligibility for the scholarship based on their input
     * @param age - user input
     * @param isResident - user input
     * @param isPartTimeWorker- user input
     * @param hasPaidStateTax- user input
     * @param hasVolunteered- user input
     * @param houseHoldIncome- user input
     * @return - 0 if they aren't eligible, 1 if they are and -1 for dean for consideration
     */
    public static int checkEligibility(int age, boolean isResident, boolean isPartTimeWorker, boolean hasPaidStateTax,
                                       boolean hasVolunteered, int houseHoldIncome)
    {
        //if user age is not within the accepted range then will return 0 (false)
        if (age < 18 || age > 24)
        {
            return 0;
        }
        //if user has met at least one of the CA residency conditions they will be eligible
        if (isResident || isPartTimeWorker || hasPaidStateTax || hasVolunteered) {
            return 1;
        }

        //if the users income is below the threshold then they will be sent for dean consideration
        if (houseHoldIncome < 5000) {
            return -1;
        }
        //if the user doesn't satisfy CA residency conditions or income less than threshold they will not be eligible
        return 0;
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
