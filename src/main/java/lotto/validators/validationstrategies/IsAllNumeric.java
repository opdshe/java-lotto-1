package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;

public class IsAllNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) throws Exception {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return true;
    }
}
