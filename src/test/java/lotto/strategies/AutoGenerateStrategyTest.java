package lotto.strategies;

import lotto.validators.Validator;
import lotto.validators.validationstrategies.ValidateLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoGenerateStrategyTest {
    @Test
    void 자동로또_생성_전략_올바른_값_반환_확인() throws Exception {
        // given
        Validator validator = new Validator(new ValidateLotto());
        GenerateLottoNumStrategy generateLottoNumStrategy = new AutoGenerateStrategy();
        // when
        List<Integer> lottoNum = generateLottoNumStrategy.generate();
        boolean result = validator.validate(lottoNum);
        // then
        assertThat(result).isTrue();
    }

}