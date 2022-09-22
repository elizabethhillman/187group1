import java.util.Scanner;

public class Scholarship {
    static  int age;
    static boolean resident;
    static boolean partTimeWorker;
    static boolean paidStateTax;
    static boolean volutered;
    static int houseHoldIncome;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age");
        age = sc.nextInt();


        System.out.println("Have you lived in california for last 2 years: Y/N");
       resident = charToBool(sc.next().charAt(0));


        System.out.println("have you worked part time");
        partTimeWorker = charToBool(sc.next().charAt(0));


        System.out.println("have your parents paid state tax");
        paidStateTax = charToBool(sc.next().charAt(0));


        System.out.println("have you volunteered for a cause");
        volutered = charToBool(sc.next().charAt(0));


        System.out.println("Enter your HouseHold Income");
        houseHoldIncome = sc.nextInt();


       int eligible = checkEligibility(age, resident, partTimeWorker, paidStateTax, volutered, houseHoldIncome);

       if(eligible== 0){
           System.out.println("not");

       }
       else if(eligible==1){
           System.out.println("eligible");

       }
       else{
           System.out.println("Dean for consedation");
       }

    }

    public static int checkEligibility(int age, boolean isResident, boolean isPartTimeWorker,boolean hasPaidStateTax,
                                boolean hasVolutered, int houseHoldIncome){
        if(age < 18 || age >24){
            return 0;
        }
        if(isResident == false){
            if(hasPaidStateTax== false){
                return 0;
            }
        }
        if( hasVolutered== false){
            return 0;
        }
        if(isPartTimeWorker== false){
            if(hasVolutered== false){
                return 0;
            }
        }
        if(hasPaidStateTax==false){
            return 0;
        }
        if(houseHoldIncome < 5000){
            return -1;
        }

        return 1;
    }



    public static boolean charToBool(char c) {
        // c = Character.toLowerCase(c);
        switch (c) {
            case 'y':
                return true;
            case 'n':
                return false;
            default:
                throw new IllegalArgumentException("Must be either 'y' or 'n'.");
        }
    }
}
