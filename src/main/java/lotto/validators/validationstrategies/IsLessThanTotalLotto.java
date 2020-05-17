package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;

public class IsLessThanTotalLotto implements ValidationStrategy {
    @Override
    public boolean execute(int countOfTotalLotto, String countOfManualLotto) throws Exception {
        if (Integer.parseInt(countOfManualLotto) > countOfTotalLotto) {
            throw new IllegalArgumentException("수동 로또 개수가 전체 로또 개수보다 많습니다.");
        }
        return true;
    }
}
