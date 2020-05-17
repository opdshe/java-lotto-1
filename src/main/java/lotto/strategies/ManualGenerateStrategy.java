package lotto.strategies;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualGenerateStrategy implements GenerateLottoNumStrategy{
    @Override
    public List<Integer> generate(String manualLottoNum) {
        return Arrays.stream(manualLottoNum.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }
}
