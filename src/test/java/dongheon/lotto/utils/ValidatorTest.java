package dongheon.lotto.utils;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    void 구입금액_숫자입력_확인() {
        //given
        String testPrice = "천원";
        //when
        boolean testResult = Validator.checkTotalPrice(testPrice);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 구입금액_범위_확인() {
        // given
        String testPrice = "-1000";
        // when
        boolean testResult = Validator.checkTotalPrice(testPrice);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 구입금액_단위_확인() {
        // given
        String testPrice = "1500";
        // when
        boolean testResult = Validator.checkTotalPrice(testPrice);
        // then
        assertThat(testResult).isFalse();
    }

}