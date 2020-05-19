package lotto.validators;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsContainedInLastLottoTest {

    private List<Integer> lastLottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);
    private int bonus;

    @Test
    public void 지난주_로또_번호에_보너스가_포함_되어있으면_예외_발생() {
        // given
        bonus = 1;
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsContainedInLastLotto.test(lastLottoNum, bonus));
    }

    @Test
    public void 지난주_로또_번호에_보너스가_포함_되어있지_않으면_예외_발생_안함() {
        // given
        bonus = 45;
        // then
        IsContainedInLastLotto.test(lastLottoNum, bonus);
    }

}