package lotto.utils;

import lotto.model.Lotto;
import lotto.interfaces.LottoCreateStrategy;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.OutputView.printMessage;


public class ManualCreateStrategy implements LottoCreateStrategy {
    @Override
    public List<Lotto> create(int numOfManualLotto) {
        List<Lotto> manualLotto = new ArrayList<>();
        if (numOfManualLotto > 0) {
            printMessage("수동으로 구매할 번호를 입력해 주세요. ");
        }
        for (int i = 0; i < numOfManualLotto; i++) {
            List<Integer > lottoNums = InputView.getManualLottoNums();
            manualLotto.add(new Lotto(lottoNums));
        }
        return manualLotto;
    }
}
