package lotto.model;

import lotto.validators.Validator;
import lotto.validators.validationstrategies.ValidateLotto;

import java.util.List;

public class LottoCreator {
    public static Lotto createLotto(List<Integer> lottoNum) throws Exception {
        Validator validator = new Validator(new ValidateLotto());
        if(validator.validate(lottoNum)){
            return new Lotto(lottoNum);
        };
        return null;
    }
}
