package lotto.validators;

import lotto.strategies.ValidationStrategy;
import lotto.view.OutputView;

import java.util.List;

import static lotto.model.Lotto.*;

public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) throws Exception {
        return strategy.execute(s);
    }

    public boolean validate(int i, String s) throws Exception {
        return strategy.execute(i, s);
    }

    public boolean validate(List<Integer> lottoNum) throws Exception {
        return strategy.execute(lottoNum);
    }

    public boolean validate(List<Integer> lottoNum, int i){
        return strategy.execute(lottoNum, i);
    }

}
