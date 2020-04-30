package dongheon.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    int numOfTotalLotto;
    int numOfManualLotto;
    LottoGame lottoGame;

    @Test
    void 로또_추가_동작_확인() {
        // given
        numOfTotalLotto = 1;
        numOfManualLotto = 1;
        lottoGame = new LottoGame(numOfTotalLotto, numOfManualLotto);
        List<Integer> lottoNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        lottoGame.addLotto(new Lotto(lottoNums));
        // then
        assertThat(lottoGame.getLottos().size()).isEqualTo(1);
    }





}