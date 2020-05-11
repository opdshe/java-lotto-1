package lotto.utils;

import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.interfaces.LottoCreateStrategy;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.OutputView.printMessage;


public class ManualCreateStrategy implements LottoCreateStrategy {
    @Override
    public void create(int numOfManualLotto) {
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
