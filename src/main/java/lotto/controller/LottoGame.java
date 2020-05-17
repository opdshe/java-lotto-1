package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.model.Lotto.LOTTO_PRICE;

public class LottoGame {

    public static void play() throws Exception {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto = InputView.getNumOfManualLotto(numOfTotalLotto);
        int numOfAutoLotto = numOfTotalLotto - numOfManualLotto;

        OutputView.printManualInputGuideMessage(numOfManualLotto);
        LottoRepository lottoRepository = new LottoRepository(numOfManualLotto, numOfAutoLotto);
        OutputView.printPurchaseStatus(lottoRepository, numOfManualLotto, numOfAutoLotto);
        Lotto lastWeekLotto = LottoCreator.createLotto(InputView.getLastWeekLottoNum());
        int lastWeekBonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, lastWeekBonus);

        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);
        OutputView.printResult(lottoResult, numOfTotalLotto * LOTTO_PRICE);
    }
}
