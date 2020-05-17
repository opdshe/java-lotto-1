package lotto.strategies;

import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualGenerateStrategy implements GenerateLottoNumStrategy{
    @Override
    public List<Integer> generate() {
        String rawNumber = InputView.getManualLottoNum();
        return Arrays.stream(rawNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }
}
