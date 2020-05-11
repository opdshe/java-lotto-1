package lotto.controller;

import lotto.interfaces.LottoCreateStrategy;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.utils.AutoCreateStrategy;
import lotto.utils.ManualCreateStrategy;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void play () {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto = InputView.getNumOfManualLotto(numOfTotalLotto);
        LottoRepository lottoRepository = new LottoRepository(init(numOfTotalLotto, numOfManualLotto));
    }

    private List<Lotto> init(int countOfTotalLotto, int countOfManualLotto) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createLotto(new ManualCreateStrategy(), countOfManualLotto));
        lottos.addAll(createLotto(new AutoCreateStrategy(), countOfTotalLotto));
        return lottos;
    }

    private List<Lotto> createLotto(LottoCreateStrategy strategy, int countOfLotto) {
        return strategy.create(countOfLotto);
    }

}
