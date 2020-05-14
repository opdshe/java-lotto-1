package lotto.model;

public class LottoResult {

    private final RankCount rankCount;
    private int prize;

    public LottoResult(LottoRepository lottoRepository, WinningLotto winningLotto) {
        rankCount = new RankCount(lottoRepository, winningLotto);
        calculatePrize();
    }

    private void calculatePrize() {
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
