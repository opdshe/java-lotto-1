package lotto.validators.validationstrategies;

import lotto.model.Lotto;
import lotto.strategies.ValidationStrategy;

import static lotto.model.Lotto.ZERO;

public class IsMultiplesOfLottoPrice implements ValidationStrategy {

    @Override
    public boolean execute(String s) throws Exception {
        if (Integer.parseInt(s) % Lotto.LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("구입 금액은 " + Lotto.LOTTO_PRICE + "단위로 입력해 주세요. ");
        }
        return true;
    }
}
