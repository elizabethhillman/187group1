package hw4;
/*
  Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
  Date: 10/29/22
  Assignment: GamesExpo - Domain Testing
  Problem Statement: Determine which of the six competition a child is eligible for, based on their age and gender.
 */
import java.util.*;

public class GamesExpo {
    static int age;
    static String gender;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        //gets user age
        System.out.println("Enter your age");
        age = scan.nextInt();

        //gets user gender
        System.out.println("Enter your gender: boy or girl");
        gender = scan.next();

        //used to determine which event the child can participate in
        if(canParticipateInStorytelling(age,gender)) {
            System.out.println("Can participate in Storytelling");
        } else if (canParticipateInDrawing(age,gender)) {
            System.out.println("Can participate in Drawing");
        } else if (canParticipateInQuiz(age,gender)) {
            System.out.println("Can participate in Quiz");
        } else if (canParticipateInEssayWriting(age,gender)) {
            System.out.println("Can participate in Essay Writing");
        } else if (canParticipateInRhyming(age)) {
            System.out.println("Can participate in Rhyming");
        } else if (canParticipateInPoetry(age)) {
            System.out.println("Can participate in Poetry");
        } else if (canNotParticipate(age)){
            System.out.println("Can not participate in any event");
        }
    }

    //predicate function that returns true if the child is a boy and within age > 7 and < 10
    public static boolean canParticipateInStorytelling(int age, String gender)
    {
        return (gender.equals("boy")) && (age >= 7 && age <= 10);
    }

    //predicate function that returns true if the child is a girl and within age > 7 and < 10
    public static boolean canParticipateInDrawing(int age, String gender)
    {
        return (gender.equals("girl")) && (age >= 7 && age <= 10);
    }

    //predicate function that returns true if the child is a boy and within age > 11 and < 15
    public static boolean canParticipateInQuiz(int age, String gender)
    {
        return (gender.equals("boy")) && (age >= 11 && age <= 15);
    }

    //predicate function that returns true if the child is a girl and within age > 10 and < 15
    public static boolean canParticipateInEssayWriting(int age, String gender)
    {
        return (gender.equals("girl")) && (age >= 10 && age <= 15);
    }

    //predicate function that returns true if the child is < age 6
    public static boolean canParticipateInRhyming(int age)
    {
        return age <= 6 && age >=0;
    }

    //predicate function that returns true if the child is > age 20
    public static boolean canParticipateInPoetry(int age)
    {
        return age >= 20;
    }

    //predicate function that returns true if the child is age > 15 and < 20
    public static boolean canNotParticipate(int age)
    {
        return age > 15 && age < 20;
    }
}
