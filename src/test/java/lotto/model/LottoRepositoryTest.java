package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    @Test
    void 로또_레퍼지토리_생성자_확인() {
        // given
        int numOfManualLotto = 3;
        int numOfAutoLotto = 3;
        // when
        LottoRepository lottoRepository = new LottoRepository(numOfManualLotto, numOfAutoLotto);
        // then
        assertThat(lottoRepository.getInventory().size()).isEqualTo(numOfAutoLotto+numOfManualLotto);
    }

}