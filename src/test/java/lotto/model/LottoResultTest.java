package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoResultTest {
    @Test
    void 로또_상금_확인() {
        // given
        LottoRepository lottoRepository = mock(LottoRepository.class);
        when(lottoRepository.getInventory())
                .thenReturn(Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                ));

        Lotto lastWeekAnswer = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        int bonus = 6;
        WinningLotto winningLotto = new WinningLotto(lastWeekAnswer, bonus);

        //when
        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);

        //then
        assertThat(lottoResult.getPrize()).isEqualTo(30_000_000);

    }

}