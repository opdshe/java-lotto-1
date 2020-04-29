package dongheon.lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
