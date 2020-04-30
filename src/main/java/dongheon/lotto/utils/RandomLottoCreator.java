package dongheon.lotto.utils;

import dongheon.lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dongheon.lotto.domain.Lotto.*;
import static dongheon.lotto.domain.LottoGame.ZERO;

public class RandomLottoCreator {
    private final List<Integer> randomBox = IntStream
            .rangeClosed(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE)
            .boxed().collect(Collectors.toList());

    public Lotto createRandomLotto() {
        Collections.shuffle(randomBox);
        List<Integer> lottoNum = randomBox.subList(ZERO, LOTTO_LENGTH);
        return new Lotto(lottoNum);
    }
}
