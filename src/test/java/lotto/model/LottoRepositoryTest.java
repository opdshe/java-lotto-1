package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    @Test
    void 로또_추가_동작_확인() {
        // given
        LottoRepository lottoRepository = new LottoRepository();
        // when
        lottoRepository.addLotto(new Lotto(Arrays.asList(1,2,3,3,4,5,6)));
        // then
        assertThat(lottoRepository.getInventory().size())
                .isNotNull()
                .isEqualTo(1);
    }

}