package lotto.model;

import java.util.List;

public class LottoRepository {
    private List<Lotto> inventory;

    public LottoRepository(List<Lotto> lottos) {
        inventory = lottos;
    }
}
