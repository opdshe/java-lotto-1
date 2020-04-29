package dongheon.lotto.view;

import dongheon.lotto.utils.Validator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int setNumOfOrder() {
        String totalPrice;
        do {
            System.out.println("구입 금액을 입력해 주세요.");
            totalPrice = scanner.nextLine();
        } while (!Validator.checkTotalPrice(totalPrice));
        return Integer.parseInt(totalPrice);
    }
}
