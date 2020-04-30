package dongheon.lotto.utils;

import java.util.InputMismatchException;
import java.util.List;

import static dongheon.lotto.domain.Lotto.*;
import static dongheon.lotto.domain.LottoGame.ZERO;

public class Validator {

    public static boolean validateTotalPrice(String totalPrice) {
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

    private static void checkTypeOfValueIsNum(String value) throws InputMismatchException {
        for (int i = 0; i < value.length(); i++) {
            checkCharIsDigit(value.charAt(i));
        }
    }

    private static void checkCharIsDigit(char character) throws InputMismatchException {
        if (!Character.isDigit(character)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }
    }

    private static void checkTotalPriceMod(String totalPrice) throws IllegalArgumentException {
        if (Integer.parseInt(totalPrice) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "단위로 입력해 주세요.");
        }
    }

    public static boolean validateNumOfManualLotto(int numOfTotalLotto, String numOfManualLotto) {
        try {
            checkRangeOfValue(numOfManualLotto);
            checkTypeOfValueIsNum(numOfManualLotto);
            checkNumOfLottos(numOfTotalLotto, numOfManualLotto);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkNumOfLottos(int numOfTotalLotto, String numOfManualLotto) {
        if (Integer.parseInt(numOfManualLotto) > numOfTotalLotto) {
            throw new IllegalArgumentException("수동 로또 개수가 전체 로또 개수보다 많습니다.");
        }
    }

    public static boolean validateLotto(List<Integer> manualLottoNums) {
        try {
            checkLottoLength(manualLottoNums);
            checkLottoRange(manualLottoNums);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkLottoLength(List<Integer> lottoNums) throws IllegalArgumentException {
        if (lottoNums.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다. ");
        }
    }

    private static void checkLottoRange(List<Integer> lottoNums) throws IllegalArgumentException {
        lottoNums.forEach(num -> {
            if (num > LOTTO_MAX_VALUE || num < LOTTO_MIN_VALUE) {
                throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이로 입력해 주세요. ");
            }
        });
    }
}
