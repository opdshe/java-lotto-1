package dongheon.lotto.view;

import dongheon.lotto.domain.LottoGame;
import dongheon.lotto.domain.LottoRepository;


public class OutputView {
    public static void printPurchaseStatus(LottoGame lottoGame) {
        System.out.println("수동으로 " + lottoGame.getNumOfManualLotto() + "개 "
                + "자동으로 " + lottoGame.getNumOfAutoLotto() + "개를 구매했습니다. ");
        LottoRepository lottoRepository = lottoGame.getLottoRepository();
        lottoRepository.getInventory()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}
