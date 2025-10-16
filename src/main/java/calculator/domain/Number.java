package calculator.domain;

public class Number {

    private static final String NOT_NUMBER_MESSAGE = "입력값 '%s'는(은) 유효한 숫자가 아닙니다.";
    private static final String NOT_POSITIVE_MESSAGE = "음수('%d')는 계산할 수 없습니다.";

    private final int value;

    public Number(String input) {
        int parsedValue = parserToInt(input);
        validatePositive(parsedValue);
        this.value = parsedValue;
    }

    private int parserToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER_MESSAGE, input));
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format(NOT_POSITIVE_MESSAGE, number));
        }
    }

    public int getValue() {
        return value;
    }

}
