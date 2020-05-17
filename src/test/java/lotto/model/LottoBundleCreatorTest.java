package lotto.model;

import lotto.strategies.AutoGenerateStrategy;
import lotto.strategies.GenerateLottoNumStrategy;
import lotto.strategies.ManualGenerateStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class LottoBundleCreatorTest {
    @Test
    void 로또_번들_생성_작동_확인_자동생성전략() throws Exception {
        // given
        GenerateLottoNumStrategy autoGenerateStrategy = new AutoGenerateStrategy();
        int countOfLotto = 5;
        List<Lotto> lottoBundle;
        // when
        lottoBundle = LottoBundleCreator.createLottoBundle(countOfLotto,autoGenerateStrategy);
        // then
        assertThat(lottoBundle.size()).isEqualTo(countOfLotto);
    }

    @Test
    void 로또_번들_생성_작동_확인_수동생성전략() throws Exception {
        // given
        List<String> specifiedLottoNums = new ArrayList<>();
        specifiedLottoNums.add("1,2,3,4,5,6");
        specifiedLottoNums.add("7,8,9,10,11,12");
        specifiedLottoNums.add("13,14,15,16,17,18");
        GenerateLottoNumStrategy manualGenerateStrategy = new ManualGenerateStrategy(){
            @Override
            public List<Integer> generate() {
                return Arrays.stream(specifiedLottoNums.remove(0).split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .distinct()
                        .collect(Collectors.toList());            }
        };

        List<Lotto> lottoBundle;
        int countOfLotto = specifiedLottoNums.size();

        // when
        lottoBundle = LottoBundleCreator.createLottoBundle(countOfLotto,manualGenerateStrategy);
        // then
        assertThat(lottoBundle.size()).isEqualTo(countOfLotto);
    }

}