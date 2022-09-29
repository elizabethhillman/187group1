package hw2;
/*
  Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
  Date: 9/22/22
  Assignment: Scholarship - Control Flow
  Problem Statement: This program will determine if a student is eligible for a scholarship
  based on age, where they live, their work history, taxes, volunteering history, and income
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
        System.out.println("have you worked part time");
        partTimeWorker = charToBool(sc.next().charAt(0));

        //used to verify the user's parents tax info
        System.out.println("have your parents paid state tax");
        paidStateTax = charToBool(sc.next().charAt(0));

        //used to verify the users volunteering history
        System.out.println("have you volunteered for a cause");
        volunteered = charToBool(sc.next().charAt(0));

        //used to very the users income
        System.out.println("Enter your HouseHold Income");
        houseHoldIncome = sc.nextInt();

        //this will pass the users information to checkEligibility() method to determine if the user is eligible for scholarship or not
        int eligible = checkEligibility(age, resident, partTimeWorker, paidStateTax, volunteered, houseHoldIncome);

        //if the user does not have the correct input to be eligible for the scholarship, they will be told they are not
        if (eligible == 0) {
            System.out.println("not");

        }
        //if the user satisfy the requirements, then they will be told they are eligible
        else if (eligible == 1) {
            System.out.println("eligible");

        }
        //if the user satisfy most requirements but does in fact satisfy the requirement to be passed for dean consideration, then they will be told so
        else {
            System.out.println("Dean for consideration");
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
        //if user age is within the accepted range then will return 0
        if (age < 18 || age > 24)
        {
            return 0;
        }
        //if user hasn't been a resident of CA for 2 years and their parents haven't paid taxes, will return 0
        if (!isResident) {
            if (!hasPaidStateTax) {
                return 0;
            }
        }
        //if the user hasn't volunteered for a cause then will return 0
        if (!hasVolunteered) {
            return 0;
        }
        //if the user hasn't worked part-time (don't need to check for volunteer status as that is covered first) returns 0
        if (!isPartTimeWorker) {
            return 0;
        }
        //if the users parents haven't paid taxes return 0
        if (!hasPaidStateTax) {
            return 0;
        }
        //if the users income is below the threshold then they will be sent for dean consideration
        if (houseHoldIncome < 5000) {
            return -1;
        }
        //if the user satisfy the conditions, then they will be eligible
        return 1;
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
