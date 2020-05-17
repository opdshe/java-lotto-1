package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;
import lotto.validators.Validator;
import lotto.view.OutputView;

import java.util.List;

public class ValidateLotto implements ValidationStrategy {
    @Override
    public boolean execute(List<Integer> lottoNum) throws Exception {
        try {
            Validator lengthValidator = new Validator(new IsCorrectLength());
            Validator rangeValidator = new Validator(new IsCorrectRange());
            lengthValidator.validate(lottoNum);
            rangeValidator.validate(lottoNum);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
