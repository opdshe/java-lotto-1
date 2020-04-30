package dongheon.lotto;

import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        int numOfTotalLotto = InputView.setNumOfTotalLotto();
        int numOfManualLotto= InputView.setNumOfManualLotto(numOfTotalLotto);
        LottoGame lottoGame = new LottoGame(numOfTotalLotto, numOfManualLotto);
    }
}
