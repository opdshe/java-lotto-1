package dongheon.lotto.utils;

import java.util.InputMismatchException;

import static dongheon.lotto.domain.Lotto.LOTTO_PRICE;

public class Validator {
    private static final int ZERO = 0;

    public static boolean checkTotalPrice(String totalPrice) {
        try {
            checkRangeOfValue(totalPrice);
            checkTypeOfValueIsNum(totalPrice);
            checkTotalPriceMod(totalPrice);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkRangeOfValue(String value) throws IllegalArgumentException {
        if (Integer.parseInt(value) < ZERO) {
            throw new IllegalArgumentException("0 이상의 정수로 입력해 주세요.");
        }
    }

    private static void checkTypeOfValueIsNum(String value) throws InputMismatchException{
        for (int i = 0; i < value.length(); i++) {
            checkCharIsDigit(value.charAt(i));
        }
    }

    private static void checkCharIsDigit(char character) throws InputMismatchException {
        if (!Character.isDigit(character)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }
    }

    private static void checkTotalPriceMod(String totalPrice) throws IllegalArgumentException{
        if (Integer.parseInt(totalPrice) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "단위로 입력해 주세요.");
        }
    }

    public static boolean checkNumOfManualLotto(String numOfManualLotto) {
        try{
            checkRangeOfValue(numOfManualLotto);
            checkTypeOfValueIsNum(numOfManualLotto);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
