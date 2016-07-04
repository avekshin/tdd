import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;
    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void shouldConvertNumberToString() {
        assertEquals("1", fizzBuzz.process(1));
        assertEquals("13", fizzBuzz.process(13));
    }

    @Test
    public void shouldReturnFizzForThree() {
        assertEquals(FIZZ, fizzBuzz.process(3));
    }

    @Test
    public void shouldReturnFizzIfNumberDividerByThree() {
        assertEquals(FIZZ, fizzBuzz.process(6));
        assertEquals(FIZZ, fizzBuzz.process(9));
    }

    @Test
    public void shouldReturnBuzzForFive() {
        assertEquals(BUZZ, fizzBuzz.process(5));
    }

    @Test
    public void shouldReturnBuzzIfNumberDividerByFive() {
        assertEquals(BUZZ, fizzBuzz.process(10));
    }

    @Test
    public void shouldReturnFizzBuzzIfNumberDividerByThreeAndFive() {
        assertEquals(FIZZ_BUZZ, fizzBuzz.process(15));
        assertEquals(FIZZ_BUZZ, fizzBuzz.process(30));
        assertEquals(FIZZ_BUZZ, fizzBuzz.process(45));
        assertEquals(FIZZ_BUZZ, fizzBuzz.process(150));
    }

}
