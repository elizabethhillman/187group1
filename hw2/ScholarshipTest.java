package hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipTest {

    /**
     * initial values for variables so all test cases are given the same values except for what we are testing
     */
    @BeforeEach
    void setUp() {
        Scholarship.age = 18;
        Scholarship.resident = false;
        Scholarship.partTimeWorker = false;
        Scholarship.paidStateTax = false;
        Scholarship.volunteered = false;
        Scholarship.houseHoldIncome = 0;
    }

    /**
     * Test case 1: If the user’s age is less than 18 years old, they are not eligible for the scholarship.
     */
    @Test
    void smallAge() {
        setUp();
        Scholarship.age = 1;
        assertEquals(0, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }

    /**
     * Test case 2: If the user’s age is greater than 24 years old, they are not eligible for the scholarship.
     */
    @Test
    void largeAge() {
        setUp();
        Scholarship.age = 25;
        assertEquals(0, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }

    /**
     * Test case 3:  If the user’s age is within the age limit and they have lived in California for the last two years, then they meet the CA residency requirements. This makes them eligible for the scholarship.
     */
    @Test
    void californiaResident() {
        setUp();
        Scholarship.resident = true;
        assertEquals(1, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }

    /**
     * Test case 4:  If the user’s age is within the age limit and they have worked in California (part-time or full time) at least for six months, then they meet the CA residency requirements. This makes them eligible for the scholarship.
     */
    @Test
    void californiaWorker() {
        setUp();
        Scholarship.partTimeWorker = true;
        assertEquals(1, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }

    /**
     * Test case 5:  If the user’s age is within the age limit and the student's parents have lived in California for at least one year, then they meet the CA residency requirements. This makes them eligible for the scholarship.
     */
    @Test
    void californiaTax() {
        setUp();
        Scholarship.paidStateTax = true;
        assertEquals(1, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));

    }

    /**
     * Test case 6:  If the user’s age is within the age limit and the student has volunteered for a public cause in California and can show proof of it, then they meet the CA residency requirements. This makes them eligible for the scholarship.
     */
    @Test
    void californiaVolunteer()
    {
        setUp();
        Scholarship.volunteered = true;
        assertEquals(1, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }

    /**
     * Test case 7: If the user’s age is within the age limit and the student does not meet any CA residency requirements, yet they have an income less than $5,000 then they qualify for Dean for consideration.
     */
    @Test
    void noResidentYesIncome()
    {
        setUp();
        assertEquals(-1, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }

    /**
     * Test case 8:  If the user’s age is within the age limit, the student does not meet any CA residency requirements, and they have an income more than $5,000 then they are not eligible for the scholarship or for dean consideration
     */
    @Test
    void noResidentNoIncome()
    {
        setUp();
        Scholarship.houseHoldIncome = 123456789;
        assertEquals(0, Scholarship.checkEligibility(Scholarship.age, Scholarship.resident, Scholarship.partTimeWorker, Scholarship.paidStateTax, Scholarship.volunteered, Scholarship.houseHoldIncome));
    }
}