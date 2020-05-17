package lotto.validators.validationstrategies;

import lotto.strategies.ValidationStrategy;
import lotto.validators.Validator;
import lotto.view.OutputView;

public class ValidateLottoPrice implements ValidationStrategy {
    @Override
    public boolean execute(String price) throws Exception {
        try {
            Validator numericValidator = new Validator(new IsAllNumeric());
            Validator positiveValidator = new Validator(new IsOverZero());
            Validator modValidator = new Validator(new IsMultiplesOfLottoPrice());
            numericValidator.validate(price);
            positiveValidator.validate(price);
            modValidator.validate(price);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
