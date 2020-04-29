package dongheon.lotto.view;

import dongheon.lotto.utils.Validator;

import java.util.Scanner;

import static dongheon.lotto.domain.Lotto.LOTTO_PRICE;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int setNumOfOrders() {
        String totalPrice;
        do {
            System.out.println("구입 금액을 입력해 주세요.");
            totalPrice = scanner.nextLine();
        } while (!Validator.checkTotalPrice(totalPrice));
        return Integer.parseInt(totalPrice) / LOTTO_PRICE;
    }

    public static int setNumOfManualLotto() {
        String numOfManualLotto;
        do {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요. ");
            numOfManualLotto = scanner.nextLine();
        } while (!Validator.checkNumOfManualLotto(numOfManualLotto));
        return Integer.parseInt(numOfManualLotto);
    }
}
