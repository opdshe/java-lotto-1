package dongheon.lotto.view;

import dongheon.lotto.domain.Lotto;
import dongheon.lotto.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static dongheon.lotto.domain.Lotto.LOTTO_PRICE;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int setNumOfTotalLotto() {
        String totalPrice;
        do {
            printMessage("구입 금액을 입력해 주세요.");
            totalPrice = scanner.nextLine();
        } while (!Validator.validateTotalPrice(totalPrice));
        return Integer.parseInt(totalPrice) / LOTTO_PRICE;
    }

    public static int setNumOfManualLotto(int numOfTotalLotto) {
        String numOfManualLotto;
        do {
            printMessage("수동으로 구매할 로또 수를 입력해 주세요. ");
            numOfManualLotto = scanner.nextLine();
        } while (!Validator.validateNumOfManualLotto(numOfTotalLotto, numOfManualLotto));
        return Integer.parseInt(numOfManualLotto);
    }

    public static List<Integer> setManualLottoNums() {
        List<Integer> manualLottoNums;
        do {
            manualLottoNums = Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .distinct()
                    .collect(Collectors.toList());
        } while (Validator.validateLotto(manualLottoNums));
        return manualLottoNums;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
