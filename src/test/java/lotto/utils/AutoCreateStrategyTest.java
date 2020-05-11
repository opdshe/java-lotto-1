package lotto.utils;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoCreateStrategyTest {
    @Test
    void 로또게임_자동생성전략_동작_확인() {
        // given
        int numOfAutoLotto = 3;
        AutoCreateStrategy autoCreateStrategy = new AutoCreateStrategy();
        // when
        List<Lotto> autoLotto = autoCreateStrategy.create(numOfAutoLotto);
        // then
        assertThat(autoLotto.size()).isEqualTo(3);
    }

}