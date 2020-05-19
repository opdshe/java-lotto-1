package lotto.validators;

import lotto.exceptions.AlreadyInLastLottoException;

import java.util.List;

public class BonusNumberValidator {
    public static void test(List<Integer> lastWeekLottoNum, int bonus) throws AlreadyInLastLottoException {
        if (lastWeekLottoNum.contains(bonus)) {
            throw new AlreadyInLastLottoException();
        }
    }
}
