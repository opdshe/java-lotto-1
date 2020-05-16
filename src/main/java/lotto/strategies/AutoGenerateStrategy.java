package lotto.strategies;

import lotto.utils.RandomLottoCreator;

import java.util.List;

public class AutoGenerateStrategy implements GenerateLottoNumStrategy {
    @Override
    public List<Integer> generate() {
        return RandomLottoCreator.getAutoLottoNums();

    }
}
