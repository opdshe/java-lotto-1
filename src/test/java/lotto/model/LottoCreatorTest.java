package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreatorTest {
    @Test
    void 올바른_로또_번호_주입_시_로또_생성() throws Exception {
        // given
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        Lotto lotto = LottoCreator.createLotto(lottoNum);
        // then
        assertThat(lotto.getNumbers()).isNotNull()
                .isEqualTo(lottoNum);
    }

    @Test
    void 잘못된_로또_번호_주입() throws Exception {
        // given
        List<Integer> lottoNum = Arrays.asList(1, 2, 3);
        // when
        Lotto lotto = LottoCreator.createLotto(lottoNum);
        // then
        assertThat(lotto).isNull();
    }

}
