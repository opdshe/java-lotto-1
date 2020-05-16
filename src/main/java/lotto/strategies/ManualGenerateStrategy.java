package lotto.strategies;

import lotto.view.InputView;

import java.util.List;

public class ManualGenerateStrategy implements GenerateLottoNumStrategy {
    @Override
    public List<Integer> generate() {
        return InputView.getManualLottoNums();
    }
}
