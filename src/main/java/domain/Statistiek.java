package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Statistiek {

    //maak de method static, dit is nu een class method, zo hoef je geen object aan te maken v/d class
    //maar doen we Statistiek.getGemiddelde()
    //a class method servers more as utility (e.g. Pattern) instead of storing data?

    public static BigDecimal getGemiddelde(BigDecimal[] getallen) {
        if (getallen.length == 0) {
            throw new IllegalArgumentException("Lege array");
        }
        return  Arrays.stream(getallen)
                //we maken de som, startwaarde is 0 en voegen elk element v/d array toe
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                //we delen door de grootte van onze verzamling (array, list, etc.)
                .divide(BigDecimal.valueOf(getallen.length), 2, RoundingMode.HALF_UP);

    }
}
