package dongheon.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RankCountTest {
    @Test
    void 랭크_개수_카운트_확인() {
        // given
        RankCount rankCount =new RankCount();
        List<Lotto> inventory = new ArrayList<>();
        inventory.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

        Lotto lastWeekAnswer = new Lotto(Arrays.asList(1,2,3,4,5,45));
        int bonus = 6;
        WinningLotto winningLotto = new WinningLotto(lastWeekAnswer,bonus);

        // when
        rankCount.countRank(inventory, winningLotto);

        //then
        assertThat(rankCount.getResult().get(Rank.SECOND)).isEqualTo(1);
    }

}