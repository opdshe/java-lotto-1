package lotto.controller;

import lotto.model.*;
import lotto.strategies.AutoGenerateStrategy;
import lotto.strategies.GenerateLottoNumStrategy;
import lotto.strategies.ManualGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.LOTTO_PRICE;

public class LottoGame {

    public static void play() throws Exception {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto = InputView.getNumOfManualLotto(numOfTotalLotto);
        int numOfAutoLotto = numOfTotalLotto - numOfManualLotto;

        OutputView.printManualInputGuideMessage(numOfManualLotto);
        List<Lotto> lottoRepository = initLottoRepository(numOfManualLotto, numOfAutoLotto);
        OutputView.printPurchaseStatus(lottoRepository, numOfManualLotto, numOfAutoLotto);

        Lotto lastWeekLotto = LottoCreator.createLotto(InputView.getLastWeekLottoNum());
        int lastWeekBonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, lastWeekBonus);

        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);
        OutputView.printResult(lottoResult, numOfTotalLotto * LOTTO_PRICE);
    }

    private static List<Lotto> initLottoRepository(int numOfManualLotto, int numOfAutoLotto) throws Exception {
        List<Lotto> lottoRepository = new ArrayList<>();
        lottoRepository.addAll(createLottoBundle(new ManualGenerateStrategy(), numOfManualLotto));
        lottoRepository.addAll(createLottoBundle(new AutoGenerateStrategy(), numOfAutoLotto));
        return lottoRepository;
    }

    private static List<Lotto> createLottoBundle(GenerateLottoNumStrategy strategy, int countOfLotto) throws Exception {
        List<Lotto> lottoBundle = new ArrayList<>();
        while (lottoBundle.size() < countOfLotto) {
            List<Integer> lottoNum = generateLottoNum(strategy);
            Lotto lotto = LottoCreator.createLotto(lottoNum);
            if (lotto != null) {
                lottoBundle.add(lotto);
            }
        }
        return lottoBundle;
    }

    private static List<Integer> generateLottoNum(GenerateLottoNumStrategy strategy) {
        if (strategy.getClass() == AutoGenerateStrategy.class) {
            return strategy.generate();
        }
        return strategy.generate(InputView.getManualLottoNum());
    }
}
