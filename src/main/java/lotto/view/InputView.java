package lotto.view;

import lotto.strategies.GenerateLottoNumStrategy;
import lotto.strategies.ManualGenerateStrategy;
import lotto.validators.Validator;
import lotto.validators.validationstrategies.IsContainedInLastLotto;
import lotto.validators.validationstrategies.ValidateCountOfManualLotto;
import lotto.validators.validationstrategies.ValidateLotto;
import lotto.validators.validationstrategies.ValidateLottoPrice;

import java.util.List;
import java.util.Scanner;

import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.view.OutputView.printMessage;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumOfTotalLotto() throws Exception {
        String totalPrice;
        Validator validator = new Validator(new ValidateLottoPrice());
        do {
            printMessage("구입 금액을 입력해 주세요.");
            totalPrice = scanner.nextLine();
        } while (!validator.validate(totalPrice));
        return Integer.parseInt(totalPrice) / LOTTO_PRICE;
    }

    public static int getNumOfManualLotto(int numOfTotalLotto) throws Exception {
        Validator validator = new Validator(new ValidateCountOfManualLotto());
        String numOfManualLotto;
        do {
            printMessage("수동으로 구매할 로또 수를 입력해 주세요. ");
            numOfManualLotto = scanner.nextLine();
        } while (!validator.validate(numOfTotalLotto, numOfManualLotto));
        return Integer.parseInt(numOfManualLotto);
    }

    public static String getManualLottoNum() {
        return scanner.nextLine();
    }

    public static List<Integer> getLastWeekLottoNum() throws Exception {
        Validator validator = new Validator(new ValidateLotto());
        GenerateLottoNumStrategy strategy = new ManualGenerateStrategy();
        List<Integer> lastWeekLottoNum;
        printMessage("지난 주 당첨 번호를 입력해 주세요. ");
        do {
            String lottoNum = getManualLottoNum();
            lastWeekLottoNum = strategy.generate(lottoNum);
        } while (!validator.validate(lastWeekLottoNum));
        return lastWeekLottoNum;
    }

    public static int getLastWeekBonus(List<Integer> lastWeekAnswers) {
        int bonus;
        Validator validator = new Validator(new IsContainedInLastLotto());
        printMessage("보너스 볼을 입력해 주세요. ");
        do {
            bonus = scanner.nextInt();
        } while (!validator.validate(lastWeekAnswers, bonus));
        return bonus;
    }
}
