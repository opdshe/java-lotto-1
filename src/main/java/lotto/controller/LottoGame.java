package lotto.controller;

import lotto.interfaces.LottoCreateStrategy;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.utils.AutoCreateStrategy;
import lotto.utils.ManualCreateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.LOTTO_PRICE;

public class LottoGame {

    public static void play() {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto = InputView.getNumOfManualLotto(numOfTotalLotto);
        int numOfAutoLotto = numOfTotalLotto - numOfManualLotto;
        LottoRepository lottoRepository = new LottoRepository(init(numOfTotalLotto, numOfManualLotto));
        OutputView.printPurchaseStatus(lottoRepository, numOfManualLotto, numOfAutoLotto);
        Lotto lastWeekLotto = InputView.getLastWeekLotto();
        int lastWeekBonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, lastWeekBonus);
        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);
        OutputView.printResult(lottoResult, numOfTotalLotto * LOTTO_PRICE);
    }

    private static List<Lotto> init(int countOfTotalLotto, int countOfManualLotto) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createLotto(new ManualCreateStrategy(), countOfManualLotto));
        lottos.addAll(createLotto(new AutoCreateStrategy(), countOfTotalLotto));
        return lottos;
    }

    private static List<Lotto> createLotto(LottoCreateStrategy strategy, int countOfLotto) {
        return strategy.create(countOfLotto);
    }

}
