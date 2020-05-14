package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoCreatorTest {
    @Test
    void 매번_다른_번호_생성하는_지_확인() {
        // given
        int numOfAutoLotto = 10;
        List<List<Integer>> autoLottoNums = RandomLottoCreator.getAutoLottoNums(10);
        // when
        Set<List<Integer>> lottoNums = new HashSet<>(autoLottoNums);
        // then
        assertThat(lottoNums.size()).isEqualTo(numOfAutoLotto);
    }

}