package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("숫자 배열의 합을 정상적으로 계산합니다.")
    @Test
    void 덧셈_성공() {
        // given
        Numbers numbers = new Numbers(new String[]{"1", "2", "3"});

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 배열이 비어있을 때 합계는 0을 반환합니다.")
    @Test
    void 덧셈_숫자배열_EMPTY_성공() {
        // given
        Numbers numbers = new Numbers(new String[]{});

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isZero();
    }

    @DisplayName("숫자가 하나만 있을때 해당 숫자를 반환합니다.")
    @Test
    void 덧셈_숫자배열_단일숫자_성공() {
        // given
        Numbers numbers = new Numbers(new String[]{"7"});

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(7);
    }

}