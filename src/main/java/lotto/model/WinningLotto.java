package lotto.model;

import lotto.view.InputView;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    private WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countOfMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    public static WinningLotto getWinningLotto() {
        Lotto lastWeekLotto = InputView.getLastWeekLotto();
        int bonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        return new WinningLotto(lastWeekLotto, bonus);
    }
}
