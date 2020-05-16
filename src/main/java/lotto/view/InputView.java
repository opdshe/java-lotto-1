package lotto.view;

import lotto.model.Lotto;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.view.OutputView.printMessage;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumOfTotalLotto() {
        String totalPrice;
        do {
            printMessage("구입 금액을 입력해 주세요.");
            totalPrice = scanner.nextLine();
        } while (!Validator.validateTotalPrice(totalPrice));
        return Integer.parseInt(totalPrice) / LOTTO_PRICE;
    }

    public static int getNumOfManualLotto(int numOfTotalLotto) {
        String numOfManualLotto;
        do {
            printMessage("수동으로 구매할 로또 수를 입력해 주세요. ");
            numOfManualLotto = scanner.nextLine();
        } while (!Validator.validateNumOfManualLotto(numOfTotalLotto, numOfManualLotto));
        return Integer.parseInt(numOfManualLotto);
    }

    public static List<Integer> getManualLottoNums() {
        List<Integer> manualLottoNums;
        do {
            manualLottoNums = Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .distinct()
                    .collect(Collectors.toList());
        } while (!Validator.validateLotto(manualLottoNums));
        return manualLottoNums;
    }

    public static Lotto getLastWeekLotto() {
        printMessage("지난 주 당첨 번호를 입력해 주세요. ");
        return new Lotto(getManualLottoNums());
    }

    public static int getLastWeekBonus(List<Integer> lastWeekAnswers) {
        int bonus;
        do {
            printMessage("보너스 볼을 입력해 주세요. ");
            bonus = scanner.nextInt();
        } while (!Validator.validateBonus(lastWeekAnswers, bonus));
        return bonus;
    }
}
