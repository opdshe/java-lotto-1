package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    @Test
    void 로또_레퍼지토리_생성자_확인() {
        // given
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        // when
        LottoRepository lottoRepository = new LottoRepository(lottos);
        // then
        assertThat(lottoRepository.getInventory().equals(lottos)).isTrue();
    }

}