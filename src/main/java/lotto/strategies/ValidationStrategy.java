package lotto.strategies;

import java.util.List;

public interface ValidationStrategy {
    default boolean execute(String s) throws Exception {
        return false;
    }

    default boolean execute(int countOfLotto, String s) throws Exception {
        return false;
    }

    default boolean execute(List<Integer> lottoNum) throws Exception {
        return false;
    }

    default boolean execute(List<Integer> lottoNum, int i){
        return false;
    }
}
