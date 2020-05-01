package dongheon.lotto.utils;

import dongheon.lotto.domain.LottoGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoCreateStrategyTest {
    @Test
    void 로또게임_자동생성전략_동작_확인() {
        // given
        int numOfTotalLotto = 3;
        int numOfManualLotto = 0;
        LottoGame lottoGame = new LottoGame(numOfTotalLotto, numOfManualLotto);
        // when
        lottoGame.init();
        // then
        assertThat(lottoGame.getLottoRepository().getInventory().size()).isEqualTo(3);

    }

}