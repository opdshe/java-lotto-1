package dongheon.lotto;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.domain.WinningLotto;
import dongheon.lotto.view.InputView;
import dongheon.lotto.view.OutputView;


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



    }
}
