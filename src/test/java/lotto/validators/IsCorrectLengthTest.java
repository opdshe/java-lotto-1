package lotto.validators;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsCorrectLengthTest {
    private List<Integer> lottoNum;

    @Test
    void 로또번호_길이가_올바르지_않을_때() {
        // given
        lottoNum = Arrays.asList(1, 2, 3, 4, 5);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsCorrectLength.test(lottoNum))
                .withMessageContaining("로또 번호는 6개이어야 합니다. ");
    }

    @Test
    void 로또번호_길이가_올바를_때() throws Exception {
        // given
        lottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);

        // then
        IsCorrectLength.test(lottoNum);
    }

}