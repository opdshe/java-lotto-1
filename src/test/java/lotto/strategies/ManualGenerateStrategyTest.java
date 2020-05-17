package lotto.strategies;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualGenerateStrategyTest {
    @Test
    void 수동로또_생성_전략_반환값이_입력값과_같은_지_확인() {
        // given
        String specifiedNumber = "1, 2, 3, 4, 5, 6";
        GenerateLottoNumStrategy generateLottoNumStrategy = new ManualGenerateStrategy();
        // when
        List<Integer> lottoNum = generateLottoNumStrategy.generate(specifiedNumber);
        String stringLottoNum = lottoNum.toString().replaceAll("[\\[\\]]", "");
        // then
        assertThat(specifiedNumber).isEqualTo(stringLottoNum);
    }

}