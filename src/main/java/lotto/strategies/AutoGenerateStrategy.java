package lotto.strategies;

import lotto.model.RandomLottoNumCreator;

import java.util.List;

public class AutoGenerateStrategy implements GenerateLottoNumStrategy {
    @Override
    public List<Integer> generate() {
        return RandomLottoNumCreator.getAutoLottoNums();
    }
}
