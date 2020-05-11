package lotto.utils;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.*;

public class RandomLottoCreator {

    private final List<Integer> randomBox = IntStream
            .rangeClosed(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE)
            .boxed()
            .collect(Collectors.toList());

    public List<Integer> createRandomNumbers() {
        Collections.shuffle(randomBox);
        return randomBox.subList(ZERO, LOTTO_LENGTH);
    }
}
