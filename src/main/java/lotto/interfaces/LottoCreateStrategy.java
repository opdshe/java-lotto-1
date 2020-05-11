package lotto.interfaces;

import lotto.model.LottoRepository;


public interface LottoCreateStrategy {
    void create(LottoRepository lottoRepository, int countOfLotto);
}
