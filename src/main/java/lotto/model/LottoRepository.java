package lotto.model;

import lotto.strategies.AutoGenerateStrategy;
import lotto.strategies.GenerateLottoNumStrategy;
import lotto.strategies.ManualGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private List<Lotto> inventory;

    public LottoRepository(int numOfManualLotto, int numOfAutoLotto) {
        inventory = new ArrayList<>();
        List<Lotto> manualLotto = createLottoBundle(numOfManualLotto, new ManualGenerateStrategy());
        List<Lotto> autoLotto = createLottoBundle(numOfAutoLotto, new AutoGenerateStrategy());
        inventory.addAll(manualLotto);
        inventory.addAll(autoLotto);
    }

    private static List<Lotto> createLottoBundle(int countOfLotto, GenerateLottoNumStrategy generateLottoNumStrategy) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            Lotto lotto = createLotto(generateLottoNumStrategy);
            lottoBundle.add(lotto);
        }
        return lottoBundle;
    }

    private static Lotto createLotto(GenerateLottoNumStrategy generateLottoNumStrategy) {
        List<Integer> lottoNum = generateLottoNumStrategy.generate();
        return new Lotto(lottoNum);
    }

    public List<Lotto> getInventory() {
        return Collections.unmodifiableList(inventory);
    }
}
