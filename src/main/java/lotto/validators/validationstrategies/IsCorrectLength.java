package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;

import java.util.List;

import static lotto.model.Lotto.LOTTO_LENGTH;

public class IsCorrectLength implements ValidationStrategy {
    @Override
    public boolean execute(List<Integer> lottoNum) throws Exception {
        if (lottoNum.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다. ");
        }
        return true;
    }
}
