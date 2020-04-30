package dongheon.lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_MAX_VALUE= 45;
    public static final int LOTTO_MIN_VALUE= 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
