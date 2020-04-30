package dongheon.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoResultTest {
    @Test
    void 랭크_개수_카운트_확인() {
        // given
        LottoResult lottoResult =new LottoResult();
        List<Lotto> inventory = new ArrayList<>();
        inventory.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

        Lotto lastWeekAnswer = new Lotto(Arrays.asList(1,2,3,4,5,45));
        int bonus = 6;
        WinningLotto winningLotto = new WinningLotto(lastWeekAnswer,bonus);

        // when
        lottoResult.calculate(inventory, winningLotto);

        //then
        assertThat(lottoResult.getResult().get(Rank.SECOND)).isEqualTo(1);
    }

}