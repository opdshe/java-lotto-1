package dongheon.lotto;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.domain.LottoResult;
import dongheon.lotto.domain.WinningLotto;
import dongheon.lotto.view.InputView;
import dongheon.lotto.view.OutputView;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto= InputView.getNumOfManualLotto(numOfTotalLotto);
        LottoGame lottoGame = new LottoGame(numOfTotalLotto, numOfManualLotto);
        lottoGame.init();

        OutputView.printPurchaseStatus(lottoGame);
        Lotto lastWeekLotto = InputView.getLastWeekLotto();
        int bonus = InputView.getLastWeekBonus(lastWeekLotto.getNumbers());
        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, bonus);

        LottoResult lottoResult = new LottoResult();
        List<Lotto> inventory = lottoGame.getLottoRepository().getInventory();
        lottoResult.calculate(lottoGame.getLottoRepository().getInventory(), winningLotto);

        OutputView.printRankCount(lottoResult);



    }
}
