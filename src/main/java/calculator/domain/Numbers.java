package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String[] parts) {
        this.numbers = Arrays.stream(parts)
                .map(Number::new)
                .toList();
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }

}
