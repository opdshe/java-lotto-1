package lotto.model;

import java.util.List;

public class LottoCreator {
    public static Lotto createLotto(List<Integer> lottoNum) throws Exception {
        return new Lotto(lottoNum);
    }
}
