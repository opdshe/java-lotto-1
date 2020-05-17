package lotto.strategies;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualGenerateStrategyTest {
    @Test
    void 수동로또_생성_전략_반환값이_입력값과_같은_지_확인() {
        // given
        String specifiedNumber = "1, 2, 3, 4, 5, 6";
        GenerateLottoNumStrategy generateLottoNumStrategy = new ManualGenerateStrategy(){
            @Override
            public List<Integer> generate() {
                return Arrays.stream(specifiedNumber.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .distinct()
                        .collect(Collectors.toList());
            }
        };
        // when
        List<Integer> lottoNum = generateLottoNumStrategy.generate();
        String stringLottoNum = lottoNum.toString().replaceAll("[\\[\\]]", "");
        // then
        assertThat(specifiedNumber).isEqualTo(stringLottoNum);
    }

}