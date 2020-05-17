package lotto.model;

import lotto.strategies.GenerateLottoNumStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleCreator {
    public static List<Lotto> createLottoBundle(int countOfLotto, GenerateLottoNumStrategy generateLottoNumStrategy) throws Exception {
        List<Lotto> lottoBundle = new ArrayList<>();
        while (lottoBundle.size() < countOfLotto) {
            List<Integer> lottoNum = generateLottoNumStrategy.generate();
            Lotto lotto = LottoCreator.createLotto(lottoNum);
            if (lotto != null) {
                lottoBundle.add(lotto);
            }
        }
        return lottoBundle;
    }
}
