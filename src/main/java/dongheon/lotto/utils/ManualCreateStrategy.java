package dongheon.lotto.utils;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.interfaces.LottoCreateStrategy;
import dongheon.lotto.view.InputView;

import static dongheon.lotto.view.InputView.printMessage;


public class ManualCreateStrategy implements LottoCreateStrategy {
    @Override
    public void create(LottoGame lottoGame) {
        int numOfManualLotto = lottoGame.getNumOfManualLotto();
        printMessage("수동으로 구매할 번호를 입력해 주세요. ");
        for (int i = 0; i < numOfManualLotto; i++) {
            Lotto manualLotto = new Lotto(InputView.setManualLottoNums());
            lottoGame.addLotto(manualLotto);
        }
    }
}
