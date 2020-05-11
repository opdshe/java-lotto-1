package lotto.interfaces;

import lotto.model.Lotto;
import java.util.List;

public interface LottoCreateStrategy {
    List<Lotto> create(int countOfLotto);
}
