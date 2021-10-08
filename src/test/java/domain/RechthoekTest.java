package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class RechthoekTest {
    @Test
    void berekenOppervlakte() {
        assertThat(new Rechthoek(5, 3).getOppervlakte()).isEqualTo(15);
    }

    @Test
    void berekenOmtrek() {
        assertThat(new Rechthoek(5, 3).getOmtrek()).isEqualTo(16);

    }
}