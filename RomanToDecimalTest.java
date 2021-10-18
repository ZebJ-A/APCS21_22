import static org.junit.Assert.*;

/**
 * Class RomanToDecimalTest uses junit test to determine the values of various romans in decimal form
 */
public class RomanToDecimalTest {

    @org.junit.Test
    /**
     * romanToDecimal uses assertEquals to determine expected and actual outputs
     */
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("XLII"), 42);
        assertEquals(RomanToDecimal.romanToDecimal("MMM"), 3000);
        assertEquals(RomanToDecimal.romanToDecimal("C"), 100);
        assertEquals(RomanToDecimal.romanToDecimal("LXXXVIII"), 88);
        assertEquals(RomanToDecimal.romanToDecimal("MI"), 1001);
        assertEquals(RomanToDecimal.romanToDecimal("MMXXI"), 2021);
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("III"), 3);
        assertEquals(RomanToDecimal.romanToDecimal("HELLOWORLD"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("123"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("!@#$%^&*"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("THISSHOULDRETURN-1"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("IV"), 6);
        assertNotEquals(RomanToDecimal.romanToDecimal("THISISNOT7"), 7);
    }
}