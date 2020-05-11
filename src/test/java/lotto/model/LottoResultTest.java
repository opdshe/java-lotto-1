package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 로또_상금_확인() {
        // given
        LottoResult lottoResult = new LottoResult();
        List<Lotto> inventory = new ArrayList<>();
        inventory.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lastWeekLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, 6);
        // when
        lottoResult.calculate(inventory, winningLotto);
        // then
        assertThat(lottoResult.getPrize()).isEqualTo(30_000_000);
    }

}