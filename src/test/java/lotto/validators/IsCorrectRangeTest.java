package lotto.validators;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsCorrectRangeTest {
    private List<Integer> lottoNum;

    @Test
    void 로또번호_범위가_올바르지_않을_때() throws Exception {
        // given
        lottoNum = Arrays.asList(0, 45, 46, 47, 48, 49);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsCorrectRange.test(lottoNum))
                .withMessageContaining("로또 번호는 1 ~ 45 사이로 입력해 주세요. ");
    }

    @Test
    void 로또번호_범위가_올바를_때() throws Exception {
        // given
        lottoNum = Arrays.asList(1, 2, 3, 4, 5, 45);

        // then
        IsCorrectRange.test(lottoNum);
    }

}