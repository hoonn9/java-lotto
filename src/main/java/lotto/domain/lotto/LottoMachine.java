package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    
    public List<Lotto> buy(Integer amount) {
        validate(amount);
        return publish(getCount(amount));
    }
    
    private List<Lotto> publish(Integer count) {
        List<Lotto> result = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(new ArrayList<>(LottoNumberGenerator.randomLottoNumberList()));
            result.add(lotto);
        }
        
        return result;
    }
    
    private int getCount(Integer amount) {
        return amount / LottoMachineEnum.LOTTO_PRICE.getValue();
    }
    
    private void validate(Integer amount) {
        if (amount % LottoMachineEnum.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }
}
