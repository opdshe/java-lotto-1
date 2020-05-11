package lotto.controller;

import lotto.interfaces.LottoCreateStrategy;
import lotto.model.LottoRepository;
import lotto.utils.AutoCreateStrategy;
import lotto.utils.ManualCreateStrategy;

public class LottoGame {

    private final int numOfManualLotto;
    private final int numOfAutoLotto;

    public LottoGame(int numOfTotalOrders, int numOfManualOrders) {
        this.numOfManualLotto = numOfManualOrders;
        this.numOfAutoLotto = numOfTotalOrders - numOfManualOrders;
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
