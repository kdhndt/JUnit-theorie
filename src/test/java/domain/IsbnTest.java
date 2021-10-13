package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

class IsbnTest {

    @ParameterizedTest
    @ValueSource(longs = {9789027439642L, 9789227439640L})
    void correcteISBNNummers(long nummer) {
        new Isbn(nummer);
    }

    @ParameterizedTest
    @ValueSource(longs = {8789027439642L, 9789027439643L, 0, -97803407661632L, 97803407661632L,
            978034076616L, 9770340766163L})
    void verkeerdeISBNNummers(long nummer) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(nummer));
    }

    @Test
    void toStringMoetHetNummerTerugGeven() {
        assertThat(new Isbn(9789027439642L)).hasToString("9789027439642");
    }

    //correct
/*    @Test
    void ISBN9780340766163IsCorrect() {
        new Isbn(9789027439642L);
    }
    @Test
    void CorrectControleGetal2() {
        new Isbn(9789027439642L);
    }
    @Test
    void CorrectControleGetal0() {
        new Isbn(9789227439640L);
    }*/
    //verkeerd
/*    @Test
    void VerkeerdControleGetal2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(8789027439642L));
    }
    @Test
    void VerkeerdControleGetal3() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(9789027439643L));
    }
    @Test
    void ISBNMetNullIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(0));
    }
    @Test
    void eenNegatiefNummerIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(-97803407661632L));
    }
    @Test
    void DertienCijfersIsTeLang() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(97803407661632L));
    }
    @Test
    void TwaalfCijfersIsTeKort() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(978034076616L));
    }
    @Test
    void Eerste3CijfersMoeten978Of979Zijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(9770340766163L));
    }*/
}