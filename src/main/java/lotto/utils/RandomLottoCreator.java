package lotto.utils;

import java.util.ArrayList;
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

    private List<Integer> createRandomNumbers() {
        Collections.shuffle(randomBox);
        return randomBox.subList(ZERO, LOTTO_LENGTH);
    }

    public static List<List<Integer>> getAutoLottoNums(int numOfAutoLotto) {
        List<List<Integer>> autoLottoNums = new ArrayList<>();
        for (int i = 0; i < numOfAutoLotto; i++) {
            RandomLottoCreator randomLottoCreator = new RandomLottoCreator();
            List<Integer> autoLottoNum = randomLottoCreator.createRandomNumbers();
            autoLottoNums.add(autoLottoNum);
        }
        return autoLottoNums;
    }
}
