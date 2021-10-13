package services;

import repositories.CSVPersoonRepository;
import repositories.PersoonRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PersoonService {
//    private final PersoonRepository repository = new CSVPersoonRepository();
    private final PersoonRepository repository;

    public PersoonService(PersoonRepository repository) {
        this.repository = repository;
    }

    public BigDecimal standaardAfwijkingWeddes() throws IOException {
        var weddes = repository.findAllWeddes();
        var totaal = BigDecimal.ZERO;
        for (var wedde : weddes) {
            totaal = totaal.add(wedde);
        }
        var gemiddelde = totaal.divide(BigDecimal.valueOf(weddes.length), 2, RoundingMode.HALF_UP);
        totaal = BigDecimal.ZERO;
        for (var wedde : weddes) {
            var verschil = wedde.subtract(gemiddelde);
            var kwadraat = verschil.pow(2);
            //NB! variable vermelden voor je begint adden o.i.d. wanneer je met BigDecimal werkt
            totaal = totaal.add(kwadraat);
        }
        var variantie = totaal.divide(BigDecimal.valueOf(weddes.length), 2, RoundingMode.HALF_UP);
        var standaardAfwijking = BigDecimal.valueOf(Math.sqrt(variantie.doubleValue()));
        return standaardAfwijking;

    }

}
