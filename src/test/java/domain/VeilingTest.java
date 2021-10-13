package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class VeilingTest {

    private Veiling veiling;

    @BeforeEach
    public void beforeEach() {
        //we gebruiken hier geen var keyword, veiling bestaat al als membervariable dus is niet nieuw
        veiling = new Veiling();
    }

    @Test
    void wanneerGeenBodUitgevoerdIsHoogsteBodNul() {
//        var veiling = new Veiling();
        assertThat(veiling.getHoogstebod()).isZero();
    }


    @Test
    void naBodVan100EURIsHetHoogsteBod100EUR() {
//        var veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(100));
        assertThat(veiling.getHoogstebod()).isEqualByComparingTo("100");
    }

    @Test
    void naBodVan100EUREn15EURIsHetHoogsteBod115EUR() {
//        var veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(100));
        veiling.doeBod(BigDecimal.valueOf(15));
        assertThat(veiling.getHoogstebod()).isEqualByComparingTo("100");
    }
}