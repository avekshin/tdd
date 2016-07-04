import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void shouldReturnZeroIfNull() {
        assertEquals(0, stringCalculator.add(null));
    }

    @Test
    public void shouldCalculateSingleNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void shouldCalculateSumOfTwoNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void shouldCalculateSumOfMultipleNumbers() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void shouldSupportNewLineAsDelimiter() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void shouldSupportCustomDelimeter() {
        assertEquals(10, stringCalculator.add(";\n1;2;3;4"));
    }

    @Test(expected = StringCalculator.NegativeNumberException.class)
    public void shouldThrowExceptionForNegativeNumber() {
        stringCalculator.add("1,-2");
    }

    @Test
    public void shouldPutNegativeNumberToException() {
        try {
            stringCalculator.add("1,-2");
        } catch (StringCalculator.NegativeNumberException e) {
            assertTrue(e.getMessage().contains("-2"));
        }
    }

    @Test
    public void shouldPutAllNegativeNumbersToExceptionMessage() {
        try {
            stringCalculator.add("-1,-2,-3");
        } catch (StringCalculator.NegativeNumberException e) {
            assertTrue(e.getMessage().contains("-1"));
            assertTrue(e.getMessage().contains("-2"));
            assertTrue(e.getMessage().contains("-3"));
        }
    }

}
