package lotto.model;

import java.util.List;

public class LottoResult {
    private final RankCount rankCount;
    private int prize;

    public LottoResult(LottoRepository lottoRepository, WinningLotto winningLotto) {
        rankCount = new RankCount(lottoRepository, winningLotto);
        calculatePrize(lottoRepository.getInventory(), winningLotto);
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
