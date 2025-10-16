package calculator.domain;

public class Number {

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
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
