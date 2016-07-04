import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public class NegativeNumberException extends RuntimeException {

        public NegativeNumberException(String s) {
            super(s);
        }
    }

    public static final String DELIMITER_REGEXP = ",|\\n";

    public int add(String s) {
        if (isEmpty(s))
            return 0;
        if (hasDelimiter(s))
            return calculateWithDelimiter(s);
        return calculateSum(split(s, DELIMITER_REGEXP));
    }

    private boolean hasDelimiter(String s) {
        return containsDelimiter(s) && isValidDelimiter(getPotentialDelimiter(s));
    }

    private int calculateWithDelimiter(String s) {
        String customDelimiter = getPotentialDelimiter(s);
        String[] splitted = split(getStringWithoutDelimiter(s), customDelimiter);
        return calculateSum(splitted);
    }

    private boolean containsDelimiter(String s) {
        return s.length() > 1 && s.charAt(1) == '\n';
    }

    private String getPotentialDelimiter(String s) {
        return String.valueOf(s.charAt(0));
    }

    private String getStringWithoutDelimiter(String s) {
        return s.substring(2);
    }

    private boolean isEmpty(String s) {
        return s == null || s == "";
    }

    private String[] split(String s, String delimiterRegexp) {
        return s.split(delimiterRegexp);
    }

    private int calculateSum(String[] numbers) {
        validateForNegativeNumbers(findNegativeNumbers(numbers));
        return sum(numbers);
    }

    private List<String> findNegativeNumbers(String[] numbers) {
        List<String> list = new ArrayList<String>();
        for (String item : numbers) {
            if (isNegative(Integer.valueOf(item))) {
                list.add(item);
            }
        }
        return list;
    }

    private void validateForNegativeNumbers(List<String> negative) {
        if (!negative.isEmpty())
            throwNegativeNumberException(negative);
    }

    private void throwNegativeNumberException(List<String> message) {
        throw new NegativeNumberException("negatives not allowed:" + message);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String item : numbers) {
            sum += Integer.valueOf(item);
        }
        return sum;
    }

    private boolean isValidDelimiter(String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }
}
