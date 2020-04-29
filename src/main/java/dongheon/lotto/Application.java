package dongheon.lotto;

import dongheon.lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        int totalPrice = InputView.setNumOfOrders();
        int numOfManualLotto = InputView.setNumOfManualLotto();
    }
}
