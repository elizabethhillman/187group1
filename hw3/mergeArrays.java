package hw3;
/*
  Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
  Date: 10/08/22
  Assignment: mergeArrays - Data Flow
  Problem Statement: Given two sorted integer arrays A and B, write a program to merge them into a single sorted array C
 */

import java.util.*;

public class mergeArrays {
    //variables for each array and their size
    static int[] A;
    static int[] B;
    static int[] C;
    static int ASize;
    static int BSize;
    static int CSize;

    /*
     * this method will get the size and values for array A and B and print the output of them being merged
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        //saves the size of user's first array
        System.out.println("What size is array A?");
        ASize = scan.nextInt();
        A = new int[ASize];

        //loops through dependent on the size given by user and adds it to the first array
        for(int i = 0; i < ASize; i++)
        {
            System.out.println("Enter integer #" + i + " element in array A");
            A[i] = scan.nextInt();
        }

        //saves the size of user's second array
        System.out.println("What size is array B?");
        BSize = scan.nextInt();
        B = new int[BSize];

        //loops through dependent on the size given by user and adds it to the first array
        for(int i = 0; i < BSize; i++)
        {
            System.out.println("Enter integer #" + i + " element in array B");
            B[i] = scan.nextInt();
        }

        //initializes C array with the size of both users given arrays
        CSize = ASize + BSize;
        C = new int[CSize];

        //merges the users given arrays and prints the output
        C = merge(A, B);
        System.out.println(Arrays.toString(C));
    }

    /*
     * this method will take in array A and B to then return the merge of both arrays
     */
    public static int[] merge(int[] arrayA, int[] arrayB)
    {
        int[] arrayC = new int[CSize];
        int AIndex = 0;
        int BIndex = 0;
        int CIndex = 0;

        //loops through until the returning array is the length of A + B
        while(CIndex < CSize)
        {
            //if array B is larger than A, then just add values from array B
            if(AIndex >= ASize)
            {
                arrayC[CIndex] = arrayB[BIndex];
                BIndex++;
            }
            //if array A is larger than B, then just add values from array A
            else if (BIndex >= BSize)
            {
                arrayC[CIndex] = arrayA[AIndex];
                AIndex++;
            }
            //if the current value from A is smaller than current value from B, then add current value of A first
            else if(arrayA[AIndex] < arrayB[BIndex])
            {
                arrayC[CIndex] = arrayA[AIndex];
                AIndex++;
            }
            //if the current value from B is smaller than current value from A, then add current value of B first
            else
            {
                arrayC[CIndex] = arrayB[BIndex];
                BIndex++;
            }
            CIndex++;
        }
        return arrayC;
    }
}
