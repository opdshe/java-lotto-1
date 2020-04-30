package dongheon.lotto.domain;

import dongheon.lotto.interfaces.LottoCreateStrategy;
import dongheon.lotto.utils.AutoCreateStrategy;
import dongheon.lotto.utils.ManualCreateStrategy;

import java.util.ArrayList;
import java.util.Collections;
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
        lottos = new ArrayList<>();
    }

    public void init() {
        createLotto(new ManualCreateStrategy());
        createLotto(new AutoCreateStrategy());
    }

    private void createLotto(LottoCreateStrategy strategy) {
        strategy.create(this);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getNumOfManualLotto() {
        return numOfManualLotto;
    }

    public int getNumOfAutoLotto() {
        return numOfAutoLotto;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
