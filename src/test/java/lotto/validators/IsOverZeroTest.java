package lotto.validators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsOverZeroTest {
    private String input;

    @Test
    public void 인풋값이_0이하일_때_예외_발생() {
        // given
        input = "0";

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsOverZero.test(input));
    }

    @Test
    public void 인풋값이_0초과일_때_예외_발생_안함() throws Exception {
        // given
        input = "1";

        // then
        IsOverZero.test(input);
    }

}