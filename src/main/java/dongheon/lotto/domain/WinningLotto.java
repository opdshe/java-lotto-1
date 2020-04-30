package dongheon.lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = lotto.countOfMatch(userLotto);
        boolean matchBonus = lotto.containNumber(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
