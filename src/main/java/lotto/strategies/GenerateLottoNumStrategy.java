package lotto.strategies;

import java.util.List;

public interface GenerateLottoNumStrategy {
    default List<Integer> generate() {
        return null;
    }

    default List<Integer> generate(String s) {
        return null;
    }
}
