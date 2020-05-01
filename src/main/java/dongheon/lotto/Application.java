package dongheon.lotto;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.domain.LottoResult;
import dongheon.lotto.domain.WinningLotto;
import dongheon.lotto.view.InputView;
import dongheon.lotto.view.OutputView;

import java.util.List;

import static dongheon.lotto.domain.Lotto.LOTTO_PRICE;


public class Application {
    public static void main(String[] args) {
        int numOfTotalLotto = InputView.getNumOfTotalLotto();
        int numOfManualLotto= InputView.getNumOfManualLotto(numOfTotalLotto);
        LottoGame lottoGame = new LottoGame(numOfTotalLotto, numOfManualLotto);
        lottoGame.init();
        OutputView.printPurchaseStatus(lottoGame);

        WinningLotto winningLotto = WinningLotto.getWinningLotto();

        LottoResult lottoResult = new LottoResult();
        List<Lotto> inventory = lottoGame.getLottoRepository().getInventory();
        lottoResult.calculate(inventory, winningLotto);
        OutputView.printResult(lottoResult, numOfTotalLotto * LOTTO_PRICE);




    }
}
