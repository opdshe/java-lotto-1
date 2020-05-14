package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.utils.RandomLottoCreator;
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

        LottoRepository lottoRepository = new LottoRepository(init(numOfManualLotto, numOfAutoLotto));
        OutputView.printPurchaseStatus(lottoRepository, numOfManualLotto, numOfAutoLotto);
        Lotto lastWeekLotto = InputView.getLastWeekLotto();
        int lastWeekBonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, lastWeekBonus);

        LottoResult lottoResult = new LottoResult(lottoRepository, winningLotto);
        OutputView.printResult(lottoResult, numOfTotalLotto * LOTTO_PRICE);
    }

    private static List<Lotto> init(int numOfManualLotto, int numOfAutoLotto) {
        List<Lotto> lottos = new ArrayList<>();
        List<List<Integer>> lottoNums = new ArrayList<>();

        OutputView.printManualInputGuideMessage(numOfManualLotto);
        lottoNums.addAll(InputView.getManualLottoNums(numOfManualLotto));
        lottoNums.addAll(RandomLottoCreator.getAutoLottoNums(numOfAutoLotto));
        createLotto(lottos, lottoNums);
        return lottos;
    }

    private static void createLotto(List<Lotto> lottos, List<List<Integer>> lottoNums) {
        lottoNums.forEach(lottoNum -> {
            lottos.add(new Lotto(lottoNum));
        });
    }

}
