package lotto.model;

import lotto.strategies.AutoGenerateStrategy;
import lotto.strategies.ManualGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private List<Lotto> inventory;

    public LottoRepository(int numOfManualLotto, int numOfAutoLotto) throws Exception {
        inventory = new ArrayList<>();
        List<Lotto> manualLotto = LottoBundleCreator.createLottoBundle(numOfManualLotto, new ManualGenerateStrategy());
        List<Lotto> autoLotto = LottoBundleCreator.createLottoBundle(numOfAutoLotto, new AutoGenerateStrategy());
        inventory.addAll(manualLotto);
        inventory.addAll(autoLotto);
    }

    public List<Lotto> getInventory() {
        return Collections.unmodifiableList(inventory);
    }
}
