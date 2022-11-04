package hw5;

/*
  Authors: Elizabeth Hillman, Camellia Bazargan, Vy Nguyen, Jagjit Singh
  Date: 11/05/22
  Assignment: NextDate - Equivalent Class Testing
  Problem Statement: After receiving a date input in the format MM/DD/YYYY between the years 1900-2099, output the next date in the same format
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NextDate {
    static String date;

    public static int getMonth(String time) {
        int month = 0;
        try {
            month = Integer.parseInt(time.substring(0,2));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error in month");
        }
        return month;
    }

    public static int getYear(String time) {
        int year = 0;
        try {
            year = Integer.parseInt(time.substring(6));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error in year");
        }
        return year;
    }
    public static int getDay(String time) {
        int day = 0;
        try {
            day = Integer.parseInt(time.substring(3,5));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error in day");
        }
        return day;
    }

    static boolean goodDate = false;
    public static Map<Integer, Integer> monthsLength;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        //prompts user for a date until the format is correct
        while(!goodDate)
        {
            System.out.println("Please enter a date between 1900-2099 in the format MM/DD/YYYY");
            date = scan.nextLine();
            try
            {
                //checks length of string to verify it has enough characters to be of the correct format
                if(date.length() == 10)
                {
                    //checks if given a valid year
                    if(checkYear(date))
                    {
                        //checks if given a valid month
                        if(checkMonth(date))
                        {
                            //checks if given a valid day
                            if(checkDay(date))
                            {
                                //verifies there is '/' in correct places
                                if(date.charAt(2) == '/' && date.charAt(5) == '/')
                                {
                                    goodDate = true;
                                }
                            }
                        }
                    }
                }
                //catches if user inputs something other than numbers
            }catch (NumberFormatException e)
            {
                System.out.println("Error in date");
            }
        }
        //prints out the next date
        System.out.println(returnNextDate(date));
    }

    //this method checks what the next date would be
    public static String returnNextDate(String time)
    {
        int day = getDay(time);
        int month = getMonth(time);
        int year = getYear(time);
        //configures map with months --> how many days are in that month
        setUpMap();
        String nextDate;
        //for a leap year, sets month of february to have 29 days rather than 28
        if(year % 4 == 0)
        {
            monthsLength.replace(2,29);
        }
        //checks if the next day would be within the same month
        if((day +1) <= monthsLength.get(month))
        {
            nextDate = String.format("%02d", month)+"/"+String.format("%02d", day+1)+"/"+year;
        }
        //if given the last day of the year, then returns the first of the next year
        else if(month == 12)
        {
            nextDate = "01/01/"+(year+1);
        }
        //if given the last day of a month, it returns the first of the next month
        else
        {
            nextDate = String.format("%02d", month+1)+ "/01/" + year;
        }
        return nextDate;
    }

    //checks to make sure the given day is within the correct domain (1 --> last day of that month)
    public static boolean checkDay(String time)
    {
        int day = getDay(time);
        int month = getMonth(time);
        return day <= monthsLength.get(month) && day > 0;
    }

    //checks to make sure the given month is within the correct domain (1 --> 12)
    public static boolean checkMonth(String time)
    {
        int month = getMonth(time);
        return monthsLength.containsKey(month);
    }

    //checks to make sure the given month is within the correct domain (1900 --> 2099)
    public static boolean checkYear(String time)
    {
        int year = getYear(time);
        return year >= 1900 & year <= 2099;
    }

    //configures a hash map with every month mapped to how many days are in that month
    public static void setUpMap()
    {
        monthsLength = new HashMap<>();
        monthsLength.put(1, 31);
        monthsLength.put(2, 28);
        monthsLength.put(3, 31);
        monthsLength.put(4, 30);
        monthsLength.put(5, 31);
        monthsLength.put(6, 30);
        monthsLength.put(7, 31);
        monthsLength.put(8, 31);
        monthsLength.put(9, 30);
        monthsLength.put(10, 31);
        monthsLength.put(11, 30);
        monthsLength.put(12, 31);
    }
}
