package dongheon.lotto.domain;

import dongheon.lotto.interfaces.LottoCreateStrategy;
import dongheon.lotto.utils.AutoCreateStrategy;
import dongheon.lotto.utils.ManualCreateStrategy;

import java.util.List;

public class LottoGame {
    public static final int ZERO = 0;

    private List<Lotto> lottos;
    private final int numOfTotalLotto;
    private final int numOfManualLotto;
    private final int numOfAutoLotto;

    public LottoGame(int numOfTotalOrders, int numOfManualOrders) {
        this.numOfTotalLotto = numOfTotalOrders;
        this.numOfManualLotto = numOfManualOrders;
        this.numOfAutoLotto = numOfTotalLotto - numOfManualOrders;
    }

    public void init() {
        for (int i = 0; i < numOfManualLotto; i++) {
            createLotto(new ManualCreateStrategy());
        }
        for (int i = 0; i < numOfAutoLotto; i++) {
            createLotto(new AutoCreateStrategy());
        }
    }

    private void createLotto(LottoCreateStrategy strategy) {
        strategy.create(this);
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int getNumOfManualLotto() {
        return numOfManualLotto;
    }

    public int getNumOfAutoLotto() {
        return numOfAutoLotto;
    }
}
