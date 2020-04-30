package dongheon.lotto.domain;

import java.util.List;

public class LottoResult {
    private RankCount rankCount;
    private int prize;

    public LottoResult() {
        rankCount = new RankCount();
        prize = 0;
    }

    public void calculate(List<Lotto> inventory, WinningLotto winningLotto) {
        rankCount.countRank(inventory, winningLotto);
        calculatePrize(inventory, winningLotto);
    }

    private void calculatePrize(List<Lotto> inventory, WinningLotto winningLotto) {
        rankCount.getResult().entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .forEach(entry -> {
                    prize += entry.getKey().getWinningMoney() * entry.getValue();
                });
    }

    public RankCount getRankCount() {
        return rankCount;
    }

    public int getPrize() {
        return prize;
    }
}
