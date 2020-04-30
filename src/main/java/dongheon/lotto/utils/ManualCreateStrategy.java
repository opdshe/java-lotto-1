package dongheon.lotto.utils;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.domain.LottoRepository;
import dongheon.lotto.interfaces.LottoCreateStrategy;
import dongheon.lotto.view.InputView;

import java.util.List;

import static dongheon.lotto.view.OutputView.printMessage;


public class ManualCreateStrategy implements LottoCreateStrategy {
    @Override
    public void create(LottoGame lottoGame) {
        int numOfManualLotto = lottoGame.getNumOfManualLotto();
        if (numOfManualLotto > 0) {
            printMessage("수동으로 구매할 번호를 입력해 주세요. ");
        }
        for (int i = 0; i < numOfManualLotto; i++) {
            List<Integer > lottoNums = InputView.getManualLottoNums();
            LottoRepository lottoRepository = lottoGame.getLottoRepository();
            lottoRepository.addLotto(new Lotto(lottoNums));
        }
    }
}
