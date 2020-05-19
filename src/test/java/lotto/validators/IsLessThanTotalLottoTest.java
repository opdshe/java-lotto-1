package lotto.validators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsLessThanTotalLottoTest {
    private int totalLotto = 5;

    @Test
    void 수동로또가_전체로또보다_많을_때() {
        // given
        String manualLotto = "6";

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsLessThanTotalLotto.test(totalLotto, manualLotto))
                .withMessageContaining("수동 로또 개수가 전체 로또 개수보다 많습니다.");
    }

    @Test
    void 수동로또가_전체로또보다_적을_때() throws Exception {
        // given
        String manualLotto = "4";
        //when
        IsLessThanTotalLotto.test(totalLotto, manualLotto);
    }
}