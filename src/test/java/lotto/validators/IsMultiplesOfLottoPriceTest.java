package lotto.validators;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IsMultiplesOfLottoPriceTest {

    @Test
    void 구입금액이_로또가격의_배수가_아닌_경우() {
        // given
        int lottoPrice = Lotto.LOTTO_PRICE;
        String fakePrice = String.valueOf(lottoPrice + 500);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IsMultiplesOfLottoPrice.test((fakePrice)))
                .withMessageContaining("구입 금액은 " + Lotto.LOTTO_PRICE + "단위로 입력해 주세요. ");
    }

    @Test
    void 구입금액이_로또가격의_배수가_맞을_경우() throws Exception {
        // given
        int lottoPrice = Lotto.LOTTO_PRICE;
        String specifiedPrice = String.valueOf(lottoPrice* 3);

        // then
        IsMultiplesOfLottoPrice.test(specifiedPrice);
    }
}