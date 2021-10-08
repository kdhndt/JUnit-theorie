package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


class ArtikelTest {
    @Test
    void prijsExclusiefVan30EURMetBtwPercentageVan6EURIs31Komma8EURInclusiefBTW() {
        assertThat(new Artikel(BigDecimal.valueOf(30),
                BigDecimal.valueOf(6)).getPrijsInclusiefBtw()).isEqualByComparingTo("31.8");
    }



}
