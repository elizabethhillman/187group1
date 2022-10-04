package hw3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class mergeArraysTest {

    /*
     * this will test if both arrays have a length of 0
     */
    @Test
    void both0() {
        mergeArrays.A = new int[0];
        mergeArrays.ASize = mergeArrays.A.length;
        mergeArrays.B = new int[0];
        mergeArrays.BSize = mergeArrays.B.length;
        mergeArrays.CSize = mergeArrays.ASize + mergeArrays.BSize;
        mergeArrays.C = mergeArrays.merge(mergeArrays.A,mergeArrays.B);

        assertEquals(0, mergeArrays.C.length);
        assertEquals("[]", Arrays.toString(mergeArrays.C));
    }

    /*
     * this will test if array A has a length of 0 and B has a length greater than 0
     */
    @Test
    void A0() {
        mergeArrays.A = new int[0];
        mergeArrays.ASize = mergeArrays.A.length;
        mergeArrays.B = new int[]{3, 7, 13, 16, 29};
        mergeArrays.BSize = mergeArrays.B.length;
        mergeArrays.CSize = mergeArrays.ASize + mergeArrays.BSize;
        mergeArrays.C = mergeArrays.merge(mergeArrays.A,mergeArrays.B);

        assertEquals(5, mergeArrays.C.length);
        assertEquals("[3, 7, 13, 16, 29]", Arrays.toString( mergeArrays.C));
    }

    /*
     * this will test if array B has a length of 0 and A has a length greater than 0
     */
    @Test
    void B0()
    {
        mergeArrays.A = new int[]{3, 7, 13, 16, 29};
        mergeArrays.ASize = mergeArrays.A.length;
        mergeArrays.B = new int[0];
        mergeArrays.BSize = mergeArrays.B.length;
        mergeArrays.CSize = mergeArrays.ASize + mergeArrays.BSize;
        mergeArrays.C = mergeArrays.merge(mergeArrays.A,mergeArrays.B);

        assertEquals(5, mergeArrays.C.length);
        assertEquals("[3, 7, 13, 16, 29]", Arrays.toString( mergeArrays.C));
    }

    /*
     * this will test if array A has a length of greater than array B
     */
    @Test
    void ALarger()
    {
        mergeArrays.A = new int[]{3, 7, 13, 16, 29};
        mergeArrays.ASize = mergeArrays.A.length;
        mergeArrays.B = new int[]{1, 2, 7, 11};
        mergeArrays.BSize = mergeArrays.B.length;
        mergeArrays.CSize = mergeArrays.ASize + mergeArrays.BSize;
        mergeArrays.C = mergeArrays.merge(mergeArrays.A,mergeArrays.B);

        assertEquals(9, mergeArrays.C.length);
        assertEquals("[1, 2, 3, 7, 7, 11, 13, 16, 29]", Arrays.toString( mergeArrays.C));
    }

    /*
     * this will test if array B has a length of greater than array A
     */
    @Test
    void BLarger()
    {
        mergeArrays.A = new int[]{1, 2, 7, 11};
        mergeArrays.ASize = mergeArrays.A.length;
        mergeArrays.B = new int[]{3, 7, 13, 16, 29};
        mergeArrays.BSize = mergeArrays.B.length;
        mergeArrays.CSize = mergeArrays.ASize + mergeArrays.BSize;
        mergeArrays.C = mergeArrays.merge(mergeArrays.A,mergeArrays.B);

        assertEquals(9, mergeArrays.C.length);
        assertEquals("[1, 2, 3, 7, 7, 11, 13, 16, 29]", Arrays.toString( mergeArrays.C));
    }

    /*
     * this will test if array A and array B have the same length
     */
    @Test
    void sameSize()
    {
        mergeArrays.A = new int[]{3, 7, 13, 16, 29};
        mergeArrays.ASize = mergeArrays.A.length;
        mergeArrays.B = new int[]{3, 7, 13, 16, 29};
        mergeArrays.BSize = mergeArrays.B.length;
        mergeArrays.CSize = mergeArrays.ASize + mergeArrays.BSize;
        mergeArrays.C = mergeArrays.merge(mergeArrays.A,mergeArrays.B);

        assertEquals(10, mergeArrays.C.length);
        assertEquals("[3, 3, 7, 7, 13, 13, 16, 16, 29, 29]", Arrays.toString( mergeArrays.C));
    }
}