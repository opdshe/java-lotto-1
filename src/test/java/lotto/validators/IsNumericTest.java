package lotto.validators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsNumericTest {

    @Test
    void 인풋_문자열이_숫자가_아닐_경우_예외_발생() {
        // given
        String input = "hello1234";

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsNumeric.test(input))
                .withMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 인풋_문자열이_숫자일_경우_예외_발생_안함() throws Exception {
        // given
        String input = "1234";

        // then
        IsNumeric.test(input);
    }
}