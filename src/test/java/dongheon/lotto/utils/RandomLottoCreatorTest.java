package dongheon.lotto.utils;

import dongheon.lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoCreatorTest {
    @Test
    void 매번_다른_번호_생성하는_지_확인() {
        // given
        Lotto a;
        Lotto b;
        RandomLottoCreator randomLottoCreator = new RandomLottoCreator();
        // when
        a = randomLottoCreator.createRandomLotto();
        b = randomLottoCreator.createRandomLotto();
        // then
        assertThat(a.equals(b)).isFalse();
    }

}