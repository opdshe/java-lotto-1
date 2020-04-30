package dongheon.lotto.utils;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    void 구입금액_숫자입력_확인() {
        //given
        String testPrice = "천원";
        //when
        boolean testResult = Validator.validateTotalPrice(testPrice);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 구입금액_범위_확인() {
        // given
        String testPrice = "-1000";
        // when
        boolean testResult = Validator.validateTotalPrice(testPrice);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 구입금액_단위_확인() {
        // given
        String testPrice = "1500";
        // when
        boolean testResult = Validator.validateTotalPrice(testPrice);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 수동로또_숫자입력_확인() {
        // given
        int numOfTotalLotto = 5;
        String numOfManualLotto = "세개";
        // when
        boolean testResult = Validator.validateNumOfManualLotto(numOfTotalLotto, numOfManualLotto);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 수동로또_범위_확인() {
        // given
        int numOfTotalLotto = 5;
        String numOfManualLotto = "-1";
        // when
        boolean testResult = Validator.validateNumOfManualLotto(numOfTotalLotto, numOfManualLotto);
        // then
        assertThat(testResult).isFalse();
    }

    @Test
    void 전체로또가_수동로또보다_많은_지_확인() {
        // given
        int numOfTotalLotto = 5;
        String numOfManualLotto = "8";
        // when
        boolean testResult = Validator.validateNumOfManualLotto(numOfTotalLotto, numOfManualLotto);
        // then
        assertThat(testResult).isFalse();
    }

}