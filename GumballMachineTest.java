import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;


class GumballMachineTest {
Scanner scan = new Scanner(System.in);

    @Test
    void main() {
    }

    @Test
    void askUserForMoney() {
        //Test Case: User Inputs only one nickel before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a nickel, their balance is actually increased by 5 cents
        GumballMachine.howMuchToAdd=0;
        GumballMachine.userTotalMoney = "n";
        assertEquals(5, GumballMachine.askUserForMoney(GumballMachine.userTotalMoney));

        //Test Case: User Inputs only one dime before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a dime, their balance is actually increased by 10 cents
        GumballMachine.howMuchToAdd=0;
        GumballMachine.userTotalMoney = "d";
        assertEquals(10,GumballMachine.askUserForMoney(GumballMachine.userTotalMoney));

        //Test Case: User Inputs only one quarter before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a quarter, their balance is actually increased by 25 cents
        GumballMachine.howMuchToAdd=0;
        GumballMachine.userTotalMoney = "q";
        assertEquals(25,GumballMachine.askUserForMoney(GumballMachine.userTotalMoney));

        //Test Case: User Inputs an invalid currency before pressing a color gumball lever
        //Reasoning: To make sure when a user tries to input a currency that is not accepted by the machine, then nothing will happen to the users balance
        GumballMachine.howMuchToAdd=0;
        GumballMachine.userTotalMoney = "r";
        assertEquals(0,GumballMachine.askUserForMoney(GumballMachine.userTotalMoney));

        //Test Case: User Inputs multiple nickels
        //Reasoning: To make sure the user can input multiple coins before pressing the lever
        GumballMachine.howMuchToAdd=0;
        GumballMachine.userTotalMoney = "n";
        GumballMachine.askUserForMoney(GumballMachine.userTotalMoney);
        GumballMachine.userTotalMoney = "n";
        assertEquals(10,GumballMachine.askUserForMoney(GumballMachine.userTotalMoney));

    }

    @Test
    void askUserWhatGumballs() {
    }
}