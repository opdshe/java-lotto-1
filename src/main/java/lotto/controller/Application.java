package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.model.Lotto.LOTTO_PRICE;


public class Application {
    public static void main(String[] args) {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto= InputView.getNumOfManualLotto(numOfTotalLotto);
        LottoGame lottoGame = new LottoGame(numOfTotalLotto, numOfManualLotto);
        LottoRepository lottoRepository = new LottoRepository();
        lottoGame.init();
        OutputView.printPurchaseStatus(lottoGame);
        WinningLotto winningLotto = WinningLotto.getWinningLotto();
        LottoResult lottoResult = new LottoResult();
        List<Lotto> inventory = lottoGame.getLottoRepository().getInventory();
        lottoResult.calculate(inventory, winningLotto);
        OutputView.printResult(lottoResult, numOfTotalLotto * LOTTO_PRICE);

    }
}
