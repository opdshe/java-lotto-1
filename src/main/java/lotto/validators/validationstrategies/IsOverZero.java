package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;

import static lotto.model.Lotto.ZERO;

public class IsOverZero implements ValidationStrategy {
    @Override
    public boolean execute(String s) throws Exception {
        if (Integer.parseInt(s) < ZERO) {
            throw new IllegalArgumentException("0 이상의 정수로 입력해 주세요.");
        }
        return true;
    }
}
