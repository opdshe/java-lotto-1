package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;

import java.util.List;

public class IsContainedInLastLotto implements ValidationStrategy {
    @Override
    public boolean execute(List<Integer> lastLottoNum, int bonus) {
        if (lastLottoNum.contains(bonus)) {
            return false;
        }
        return true;
    }
}
