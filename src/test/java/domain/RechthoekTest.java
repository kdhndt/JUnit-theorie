package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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

    @Test
    void rechthoekenMetDezelfdeAfmetingenZijnGelijk() {
        assertThat(new Rechthoek(5, 3)).isEqualTo(new Rechthoek(5,3));
    }

    @Test
    void rechthoekenMetVerschillendeAfmetingenZijnNietGelijk() {
        assertThat(new Rechthoek(5,3)).isNotEqualTo(new Rechthoek(5,2));
    }

    @Test
    void deHashCodeVanRechthoekenMetDezelfdeAfmetingenIsGelijk() {
        assertThat(new Rechthoek(5, 3)).hasSameHashCodeAs(new Rechthoek(5,3));

    }
    @Test
    void eenRechthoekMetNegatieveLengteKanNiet() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(-1, 2));
    }

    @Test
    void eenRechthoekMetNegatieveBreedteKanNiet() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(2, -1));
    }

    @Test
    void eenRechthoekWaarvanLengteKleinerIsDanBreedteKanNiet() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(3, 6));
    }
}