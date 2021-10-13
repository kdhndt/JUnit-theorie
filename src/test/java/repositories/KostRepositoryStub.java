package repositories;

import java.math.BigDecimal;

public class KostRepositoryStub implements KostRepository {
    @Override
    public BigDecimal findTotaleKost() {
        return BigDecimal.valueOf(5_000);
    }
}
