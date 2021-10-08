package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ConverterTest {
    @Test
    void eenInchIs2Komma54Centimeters() {
        assertThat(new Converter().inchesNaarCentimeters(BigDecimal.ONE)).isEqualByComparingTo("2.54");
    }

    @Test
    void tweehonderdInches508Centimeters() {
        assertThat(new Converter().inchesNaarCentimeters(BigDecimal.valueOf(200))).
                isEqualByComparingTo("508");
    }

}