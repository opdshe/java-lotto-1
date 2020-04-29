package dongheon.lotto.utils;

import java.util.InputMismatchException;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    public static boolean checkTotalPrice(String totalPrice) {
        try {
            checkTotalPriceRange(totalPrice);
            checkTotalPriceInputFormat(totalPrice);
            checkTotalPriceMod(totalPrice);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkTotalPriceRange(String totalPrice) throws IllegalArgumentException {
        if (Integer.parseInt(totalPrice) < ZERO) {
            throw new IllegalArgumentException("0 이상의 정수로 입력해 주세요.");
        }
    }

    private static void checkTotalPriceInputFormat(String totalPrice) throws InputMismatchException{
        for (int i = 0; i < totalPrice.length(); i++) {
            checkIsCharDigit(totalPrice.charAt(i));
        }
    }

    private static void checkIsCharDigit(char character) throws InputMismatchException {
        if (!Character.isDigit(character)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }
    }

    private static void checkTotalPriceMod(String totalPrice) throws IllegalArgumentException{
        if (Integer.parseInt(totalPrice) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "단위로 입력해 주세요.");
        }
    }
}
