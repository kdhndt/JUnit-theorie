package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class WoordTest {
    @Test
    @DisplayName("Een lepel is een palindroom.")
    void lepelIsEenPalindroom() {
    assertThat(new Woord("lepel").isPalindroom()).isTrue();
    }

    @Test
    void vorkIsGeenPalindroom() {
        assertThat(new Woord("vork").isPalindroom()).isFalse();
    }

    @Test
    void toStringGeeftHetWoordAlsTekst() {
        assertThat(new Woord("Test")).hasToString("Test");
    }
}