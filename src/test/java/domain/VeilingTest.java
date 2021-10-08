package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class VeilingTest {
    @Test
    void eersteBodVan100EURIsHetHoogsteBod() {
        var veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(100));
        assertThat(veiling.getHoogstebod()).isEqualByComparingTo("100");
    }

    @Test
    void tweedeBodvan200EURIsHetHoogsteBod() {
        var veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(200));
        assertThat(veiling.getHoogstebod()).isEqualByComparingTo("200");
    }
}