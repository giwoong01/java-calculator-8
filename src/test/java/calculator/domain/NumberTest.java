package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("유효한 숫자 문자열로 Number 객체를 정상적으로 생성합니다.")
    @Test
    void 숫자생성_성공() {
        // given
        String input = "5";

        // when
        Number number = new Number(input);

        // then
        assertThat(number.getValue()).isEqualTo(5);
    }

    @DisplayName("입력값이 0일 경우 정상적으로 생성됩니다.")
    @Test
    void 숫자생성_입력_0_성공() {
        // given
        String input = "0";

        // when
        Number number = new Number(input);

        // then
        assertThat(number.getValue()).isEqualTo(0);
    }

    @DisplayName("입력값이 null, 비어있거나, 공백일 경우 예외가 발생합니다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void 숫자생성_입력_NULL_EMPTY_공백_예외(String input) {
        // when & then
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 음수일 경우 예외가 발생합니다.")
    @Test
    void 숫자생성_입력_음수_예외() {
        // given
        String input = "-1";

        // when & then
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수('-1')는 계산할 수 없습니다.");
    }

    @DisplayName("입력값이 숫자가 아닌 문자인 경우 예외가 발생합니다.")
    @Test
    void 숫자생성_입력_NOT_숫자_예외() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값 'a'는(은) 유효한 숫자가 아닙니다.");
    }

}