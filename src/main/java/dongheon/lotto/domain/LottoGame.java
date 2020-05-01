package dongheon.lotto.domain;

import dongheon.lotto.interfaces.LottoCreateStrategy;
import dongheon.lotto.utils.AutoCreateStrategy;
import dongheon.lotto.utils.ManualCreateStrategy;

public class LottoGame {

    private LottoRepository lottoRepository;
    private final int numOfManualLotto;
    private final int numOfAutoLotto;

    public LottoGame(int numOfTotalOrders, int numOfManualOrders) {
        this.numOfManualLotto = numOfManualOrders;
        this.numOfAutoLotto = numOfTotalOrders - numOfManualOrders;
        lottoRepository= new LottoRepository();
    }

    public void init() {
        createLotto(new ManualCreateStrategy());
        createLotto(new AutoCreateStrategy());
    }

    private void createLotto(LottoCreateStrategy strategy) {
        strategy.create(this);
    }

    public int getNumOfManualLotto() {
        return numOfManualLotto;
    }

    public int getNumOfAutoLotto() {
        return numOfAutoLotto;
    }

    public LottoRepository getLottoRepository() {
        return lottoRepository;
    }
}
