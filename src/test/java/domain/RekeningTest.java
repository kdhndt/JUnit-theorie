package domain;

import exceptions.OnvoldoendeSaldoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RekeningTest {

    private Rekening rekening;
    private static final BigDecimal TWEE = BigDecimal.valueOf(2);

    @BeforeEach
    void beforeEach() {
        rekening = new Rekening();
    }

    @Test
    void hetSaldoVanEenNieuweRekeningIs0EUR() {
//        var rekening = new Rekening();
        assertThat(rekening.getSaldo()).isZero();
    }
    @Test
    void nadatJe10EURStortIsHetSaldo10EUR() {
//        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }
    @Test
    void nadatJe10EUREn1EURStortIsHetSaldo11EUR() {
//        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
    @Test
    void hetGestorteBedragMagNietNulZijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.ZERO));
    }
    @Test
    void hetGestorteBedragMagNietNegatiefZijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.valueOf(-1)));
    }
    @Test
    void stortMetNullKanNiet() {
        assertThatNullPointerException().isThrownBy(() -> rekening.stort(null));
    }

    @Test
    void bedragGroterDanSaldoAfhalenKanNiet() {
        assertThatExceptionOfType(OnvoldoendeSaldoException.class).isThrownBy(() -> rekening.haalAf(BigDecimal.TEN));
    }
//method die collection teruggeeft
    @Test
    void eenNieuweRekeningHeeftGeenStortingen() {
        assertThat(rekening.getStortingen().isEmpty());
    }
    @Test
    void nadatJe10EURStortIsErEenStortingVan10EUR() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }
    @Test
    void nadatJe10EUREn1EURStortZijnDeStortingen10EUREn1EUR() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen()).containsExactly(BigDecimal.TEN, BigDecimal.ONE);
    }
    @Test
    void nadatJe10EUREn1EUREn2EURStortZijnDeStortingenGesorteerd1EUREn2EUREn10EUR() {
        rekening.stort((BigDecimal.TEN));
        rekening.stort((BigDecimal.ONE));
        rekening.stort((TWEE));
        assertThat(rekening.getStortingenGesorteerd()).isSorted().containsExactly(BigDecimal.ONE, TWEE, BigDecimal.TEN);
    }
}