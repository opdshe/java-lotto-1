package lotto.model;

import java.util.*;

public class RankCount {
    private Map<Rank, Integer> result ;

    public RankCount(LottoRepository lottoRepository, WinningLotto winningLotto) {
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        for (Lotto lotto : lottoRepository.getInventory()) {
            Rank rank = winningLotto.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

}
