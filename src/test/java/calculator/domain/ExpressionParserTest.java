package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionParserTest {

    private ExpressionParser expressionParser;

    @BeforeEach
    void setUp() {
        expressionParser = new ExpressionParser();
    }

    @DisplayName("기본 구분자(쉼표, 콜론)와 커스텀 구분자를 혼용하여 파싱합니다.")
    @Test
    void 기본_커스텀_구분자_파싱() {
        // given
        String expression = "//;\\n1;2,3:4";

        // when
        String[] result = expressionParser.split(expression);

        // then
        assertThat(result).containsExactly("1", "2", "3", "4");
    }

    @DisplayName("기본 구분자(쉼표, 콜론)만으로 파싱합니다.")
    @Test
    void 기본_구분자_파싱() {
        // given
        String expression = "2,3:4";

        // when
        String[] result = expressionParser.split(expression);

        // then
        assertThat(result).containsExactly("2", "3", "4");
    }

    @DisplayName("커스텀 구분자만으로 파싱합니다.")
    @ParameterizedTest
    @ValueSource(strings = {";!", ";", "!", "@", "!@"})
    void 커스텀_구분자_파싱(String input) {
        // given
        String expression = String.format("//%s\\n1%s2%s3", input, input, input);

        // when
        String[] result = expressionParser.split(expression);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

}