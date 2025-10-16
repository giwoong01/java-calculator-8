package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(new ExpressionParser());
    }

    @DisplayName("입력된 문자열의 숫자들을 모두 더하여 반환합니다.")
    @Test
    void 덧셈_성공() {
        // given
        String expression = "//;\\n1,2;3";

        // when
        int result = calculator.add(expression);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("입력값이 null이거나 빈 문자열일 경우 0을 반환합니다.")
    @ParameterizedTest
    @NullAndEmptySource
    void 덧셈_NULL_EMPTY_성공(String expression) {
        // when
        int result = calculator.add(expression);

        // then
        assertThat(result).isZero();
    }

    @DisplayName("숫자가 하나만 포함된 문자열을 입력할 경우 해당 숫자를 반환합니다.")
    @Test
    void 덧셈_단일숫자_성공() {
        // given
        String expression = "5";

        // when
        int result = calculator.add(expression);

        // then
        assertThat(result).isEqualTo(5);
    }

}