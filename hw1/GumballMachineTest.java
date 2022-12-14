package hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GumballMachineTest {


    /**
     * This method will test for initial balance
     */
    @Test
    void testInitialBalance(){
        assertEquals(0,GumballMachine.getUserBalance());
    }

    /**
     * This method will test for return Change
     */
    @Test
    void testReturnChange(){
        //Test Case: User wants to return change and dispensing gumball
        GumballMachine.userBalance= 10; //set user balance to 10
        assertTrue(GumballMachine.refund()); // test for successful refund
        assertEquals(10,GumballMachine.getUserBalance()); //check the refund balance
    }

    /**
     * This method will test the method askUsersForMoney from hw1.GumballMachine
     */
    @Test
    void askUserForMoney() {
        //Test Case: User Inputs only one nickel before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a nickel, their balance is actually increased by 5 cents
        GumballMachine.userBalance = 0;
        GumballMachine.askUserForMoney("n");
        assertEquals(5, GumballMachine.userBalance);

        //Test Case: User Inputs only one dime before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a dime, their balance is actually increased by 10 cents
        GumballMachine.userBalance = 0;
        GumballMachine.askUserForMoney("d");
        assertEquals(10, GumballMachine.userBalance);

        //Test Case: User Inputs only one quarter before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a quarter, their balance is actually increased by 25 cents
        GumballMachine.userBalance = 0;
        GumballMachine.askUserForMoney("q");
        assertEquals(25, GumballMachine.userBalance);

        //Test Case: User Inputs an invalid currency before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a currency that is not accepted by the machine, then nothing will happen to the users balance
        GumballMachine.userBalance = 0;
        GumballMachine.askUserForMoney("r");
        assertEquals(0, GumballMachine.userBalance);

        //Test Case: User Inputs multiple nickels
        //Reasoning: To make sure the user can input multiple coins before pressing the lever
        GumballMachine.userBalance = 0;
        GumballMachine.askUserForMoney("n");
        GumballMachine.askUserForMoney("n");
        assertEquals(10, GumballMachine.userBalance);
        
        //Test Case: User Inputs mix coins
        //Reasoning: To make sure the user can input mix coins before pressing the lever
        GumballMachine.userBalance = 0;
        GumballMachine.askUserForMoney("d");
        GumballMachine.askUserForMoney("q");
        assertEquals(35, GumballMachine.userBalance);
    }

    /**
     * This method will test the method askUserWhatGumballs from hw1.GumballMachine
     */
    @Test
    void askUserWhatGumballs() {
        //Test case: User asks for 1 red gumball and has enough money
        //Reasoning: To make sure that when the user balance is at least 5, and they want a red gumball, they get it
        GumballMachine.numRed = 0;
        GumballMachine.numYellow = 0;
        GumballMachine.userBalance = 5;
        GumballMachine.askUserWhatGumballs("red");
        assertEquals(1, GumballMachine.numRed);

        //Test case: User asks for 1 yellow gumball and has enough money
        //Reasoning: To make sure that when the user balance is at least 10, and they want a yellow gumball, they get it
        GumballMachine.numRed = 0;
        GumballMachine.numYellow = 0;
        GumballMachine.userBalance = 10;
        GumballMachine.askUserWhatGumballs("yellow");
        assertEquals(1, GumballMachine.numYellow);

        //Test case: User asks for 1 red gumball and doesn't have enough money
        //Reasoning: To make sure that when the user balance is less than 5, and they want a red gumball, they can not get it
        GumballMachine.numRed = 0;
        GumballMachine.numYellow = 0;
        GumballMachine.userBalance = 0;
        GumballMachine.askUserWhatGumballs("red");
        assertEquals(0, GumballMachine.numRed);

        //Test case: User asks for 1 yellow gumball and doesn't have enough money
        //Reasoning: To make sure that when the user balance is less than 10, and they want a yellow gumball, they can not get it
        GumballMachine.numRed = 0;
        GumballMachine.numYellow = 0;
        GumballMachine.userBalance = 5;
        GumballMachine.askUserWhatGumballs("yellow");
        assertEquals(0, GumballMachine.numYellow);

        //Test case: User tries to get another color gumball that does not exist
        //Reasoning: To make sure that if this occurs, the user will not receive any gumballs
        GumballMachine.numRed = 0;
        GumballMachine.numYellow = 0;
        GumballMachine.userBalance = 5;
        GumballMachine.askUserWhatGumballs("Orange");
        assertEquals(0, GumballMachine.numYellow);
        assertEquals(0, GumballMachine.numRed);

        //Test case: User asks to return their change
        //Reasoning: To make sure that when user wants their change, their change is returned
        GumballMachine.userBalance = 10;
        GumballMachine.askUserWhatGumballs("Return My Change");
        assertTrue(GumballMachine.wantChange);
    }
    
    /**
     * This method will test for multiple dispenses from the Gumball Machine
     * check the correct amount of change returned 
     */
    @Test
    void testMultipleDispense() {
        //Test case: Dispense Multiple gumballs to get correct change
        //Reasoning: To check if user can dispense multiple gumballs and get back correct change
        GumballMachine.userBalance = 25;
        GumballMachine.askUserWhatGumballs("yellow");
        GumballMachine.askUserWhatGumballs("red");
        GumballMachine.refund();
        assertEquals(1, GumballMachine.numYellow);
        assertEquals(1, GumballMachine.numRed);
        assertEquals(10,GumballMachine.getUserBalance());
    }
}
