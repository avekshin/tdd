
public class FizzBuzz {

    private static final int FIZZ_DIVISOR = 3;
    private static final int BUZZ_DIVISOR = 5;

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public String process(int i) {
        if (isFizzBuzz(i))
            return buildFizzBuzz();
        else if (isFizz(i))
            return FIZZ;
        else if (isBuzz(i))
            return BUZZ;

        return String.valueOf(i);
    }

    private boolean isFizzBuzz(int i) {
        return isFizz(i) && isBuzz(i);
    }

    private String buildFizzBuzz() {
        return FIZZ + BUZZ;
    }

    private boolean isFizz(int i) {
        return isDividedBy(i, FIZZ_DIVISOR);
    }

    private boolean isDividedBy(int i, int divisor) {
        return i % divisor == 0;
    }

    private boolean isBuzz(int i) {
        return isDividedBy(i, BUZZ_DIVISOR);
    }

}
