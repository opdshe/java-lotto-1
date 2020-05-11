package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.*;

import java.util.Map;


public class OutputView {
    public static void printPurchaseStatus(LottoGame lottoGame) {
        System.out.println("수동으로 " + lottoGame.getNumOfManualLotto() + "개 "
                + "자동으로 " + lottoGame.getNumOfAutoLotto() + "개를 구매했습니다. ");
        LottoRepository lottoRepository = lottoGame.getLottoRepository();
        lottoRepository.getInventory()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(LottoResult lottoResult, int totalPrice) {
        printRankCount(lottoResult);
        printPrize(lottoResult, totalPrice);

    }
    private static void printRankCount(LottoResult lottoResult){
        printMessage("---- 당첨 통계 ----");
        lottoResult.getRankCount().getResult().entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .forEach(OutputView::printOneRank);
    }

    private static void printOneRank(Map.Entry<Rank, Integer> oneRank) {
        StringBuilder resultForOneRank = new StringBuilder();
        resultForOneRank.append(oneRank.getKey().getCountOfMatch()).append("개 일치");
        if (oneRank.getKey() == Rank.SECOND) {
            resultForOneRank.append(", 보너스볼 일치");
        }
        printMessage(resultForOneRank + "(" + oneRank.getKey().getWinningMoney() + ")" + " - " + oneRank.getValue() + "개");
    }

    private static void printPrize(LottoResult lottoResult, int totalPrice) {
        float rateOfReturn = (float) lottoResult.getPrize() / (float) totalPrice;
        printMessage("총 수익률은 " + rateOfReturn + "입니다. ");
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

}
