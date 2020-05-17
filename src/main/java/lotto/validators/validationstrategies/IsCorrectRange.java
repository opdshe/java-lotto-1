package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;

import java.util.List;

import static lotto.model.Lotto.LOTTO_MAX_VALUE;
import static lotto.model.Lotto.LOTTO_MIN_VALUE;

public class IsCorrectRange implements ValidationStrategy {
    @Override
    public boolean execute(List<Integer> lottoNum) throws Exception {
        lottoNum.forEach(num -> {
            if (num < LOTTO_MIN_VALUE || num > LOTTO_MAX_VALUE) {
                throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이로 입력해 주세요. ");
            }
        });
        return true;
    }
}
