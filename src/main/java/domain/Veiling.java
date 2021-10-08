package domain;

import java.math.BigDecimal;

public class Veiling {
    private BigDecimal hoogstebod = BigDecimal.ZERO;

    public void doeBod(BigDecimal bedrag) {
        if (bedrag.compareTo(hoogstebod) > 0) {
            hoogstebod = bedrag;
        }
    }

    public BigDecimal getHoogstebod() {
        return hoogstebod;
    }
}
