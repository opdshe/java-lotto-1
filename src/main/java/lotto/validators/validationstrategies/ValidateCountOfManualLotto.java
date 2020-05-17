package lotto.validators.validationstrategies;


import lotto.strategies.ValidationStrategy;
import lotto.validators.Validator;
import lotto.view.OutputView;

public class ValidateCountOfManualLotto implements ValidationStrategy {

    @Override
    public boolean execute(int countOfLotto, String countOfManualLotto) throws Exception {
        try {
            Validator overZeroValidator = new Validator(new IsOverZero());
            Validator numericValidator = new Validator(new IsAllNumeric());
            Validator underTotalLottoValidator = new Validator(new IsLessThanTotalLotto());
            overZeroValidator.validate(countOfManualLotto);
            numericValidator.validate(countOfManualLotto);
            underTotalLottoValidator.validate(countOfManualLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
