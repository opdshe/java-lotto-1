package dongheon.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private List<Lotto> inventory;

    public LottoRepository() {
        inventory = new ArrayList<>();
    }
    public void addLotto(Lotto lotto) {
        inventory.add(lotto);
    }

    public List<Lotto> getInventory() {
        return Collections.unmodifiableList(inventory);
    }
}
