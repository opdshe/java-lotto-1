package dongheon.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RankCount {
    private Map<Rank, Integer> result = new TreeMap<>();

    public void countRank(List<Lotto> inventory, WinningLotto winningLotto) {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        for (Lotto lotto : inventory) {
            Rank rank = winningLotto.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

}
