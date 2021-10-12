package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class StatistiekTest {
    @Test
    void hetGemiddeldeVan0En10Is5() {
        assertThat(Statistiek.getGemiddelde(new BigDecimal[] {BigDecimal.ZERO,
        BigDecimal.TEN})).isEqualByComparingTo("5");
    }
    //variabele enigGetal aanmaken?
    @Test
    void hetGemiddeldeVanEenGetalIsDatGetal() {
        assertThat(Statistiek.getGemiddelde(new BigDecimal[] {BigDecimal.valueOf(1.23)})).isEqualByComparingTo("1.23");
    }
    //resultaat is negatief, dus throw een exception
    @Test
    void hetGemiddeldeVanEenLegeVerzamelingKanJeNietBerekenen() {
        assertThatIllegalArgumentException().isThrownBy(() -> Statistiek.getGemiddelde(new BigDecimal[] {}));
    }
    @Test
    void hetGemiddeldeVanNullKanJeNietBerekenen() {
        assertThatNullPointerException().isThrownBy(() -> Statistiek.getGemiddelde(null));
    }
    @Test
    void eenArrayElementMagNietNullBevatten() {
        assertThatNullPointerException().isThrownBy(() -> Statistiek.getGemiddelde(new BigDecimal[] {null}));
    }

}