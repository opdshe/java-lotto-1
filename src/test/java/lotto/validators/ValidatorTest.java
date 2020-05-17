package lotto.validators;

import lotto.model.Lotto;
import lotto.validators.validationstrategies.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {
    private Validator validator;

    @Test
    void 인풋_문자열이_숫자가_아닐_경우_예외_발생() {
        // given
        String input = "hello1234";
        validator = new Validator(new IsAllNumeric());

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(input))
                .withMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 인풋_문자열이_숫자일_경우() throws Exception {
        // given
        String input = "1234";
        validator = new Validator(new IsAllNumeric());
        //when
        boolean result = validator.validate(input);
        // then
        assertThat(result).isTrue();
    }

    @Test
    void 구입금액이_로또가격의_배수가_아닌_경우() {
        // given
        int lottoPrice = Lotto.LOTTO_PRICE;
        String fakePrice = String.valueOf(lottoPrice + 500);
        validator = new Validator(new IsMultiplesOfLottoPrice());

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(fakePrice))
                .withMessageContaining("구입 금액은 " + Lotto.LOTTO_PRICE + "단위로 입력해 주세요. ");
    }

    @Test
    void 구입금액이_로또가격의_배수가_맞을_경우() throws Exception {
        // given
        String lottoPrice = String.valueOf(Lotto.LOTTO_PRICE * 3);
        validator = new Validator(new IsMultiplesOfLottoPrice());

        //when
        boolean result = validator.validate(lottoPrice);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 수동로또가_전체로또보다_많을_때() {
        // given
        int totalLotto = 5;
        String manualLotto = "6";
        validator = new Validator(new IsLessThanTotalLotto());

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(totalLotto, manualLotto))
                .withMessageContaining("수동 로또 개수가 전체 로또 개수보다 많습니다.");
    }

    @Test
    void 수동로또가_전체로또보다_적을_때() throws Exception {
        // given
        int totalLotto = 5;
        String manualLotto = "3";
        validator = new Validator(new IsLessThanTotalLotto());
        //when
        boolean result = validator.validate(totalLotto, manualLotto);
        // then
        assertThat(result).isTrue();
    }

    @Test
    void 로또번호_길이가_올바르지_않을_때() {
        // given
        validator = new Validator(new IsCorrectLength());
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5);
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(lottoNum))
                .withMessageContaining("로또 번호는 6개이어야 합니다. ");
    }

    @Test
    void 로또번호_길이가_올바를_때() throws Exception {
        // given
        validator = new Validator(new IsCorrectLength());
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        boolean result = validator.validate(lottoNum);
        // then
        assertThat(result).isTrue();
    }

    @Test
    void 로또번호_범위가_올바르지_않을_때() throws Exception {
        // given
        validator = new Validator(new IsCorrectRange());
        List<Integer> lottoNum = Arrays.asList(0, 45, 46, 47, 48, 49);
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(lottoNum))
                .withMessageContaining("로또 번호는 1 ~ 45 사이로 입력해 주세요. ");
    }

    @Test
    void 로또번호_범위가_올바를_때() throws Exception {
        // given
        validator = new Validator(new IsCorrectRange());
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5, 45);
        //when
        boolean result = validator.validate(lottoNum);
        // then
        assertThat(result).isTrue();
    }
}