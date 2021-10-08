package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RekeningTest {

    @Test
    void hetSaldoVanEenNieuweREkeningIs0EUR() {
        var rekening = new Rekening();
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    void nadatJe10EURStortIsHetSaldo10EUR() {
        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    void nadatJe10EUREn1EURStortIsHetSaldo11EUR() {
        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
}