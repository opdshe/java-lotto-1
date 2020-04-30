package dongheon.lotto.utils;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.domain.LottoRepository;
import dongheon.lotto.interfaces.LottoCreateStrategy;

public class AutoCreateStrategy implements LottoCreateStrategy {
    @Override
    public void create(LottoGame lottoGame) {
        int numOfAutoLotto = lottoGame.getNumOfAutoLotto();
        for (int i = 0; i < numOfAutoLotto; i++) {
            RandomLottoCreator randomLottoCreator = new RandomLottoCreator();
            Lotto lotto = randomLottoCreator.createRandomLotto();
            LottoRepository lottoInventory = lottoGame.getLottoRepository();
            lottoInventory.addLotto(lotto);
        }
    }
}
