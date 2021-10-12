package domain;

import exceptions.OnvoldoendeSaldoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rekening {
    private BigDecimal saldo = BigDecimal.ZERO;
    private final List<BigDecimal> stortingen = new ArrayList<>();

    public void stort(BigDecimal bedrag) {
        if (bedrag.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bedrag moet positief zijn");
        }
        saldo = saldo.add(bedrag);
        stortingen.add(bedrag);
    }

    public void haalAf(BigDecimal bedrag) throws OnvoldoendeSaldoException {
        if (bedrag.compareTo(saldo) > 0) {
            throw new OnvoldoendeSaldoException();
        }
        saldo = saldo.subtract(bedrag);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<BigDecimal> getStortingen() {
        return stortingen;
    }



    public List<BigDecimal> getStortingenGesorteerd() {
        return stortingen.stream().sorted().collect(Collectors.toList());

    }
}
