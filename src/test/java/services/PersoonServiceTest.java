package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.PersoonRepositoryStub;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PersoonServiceTest {
    private PersoonService service;

    @BeforeEach
    void beforeEach() {
        //gebruik een dummy repo, maak die aan in je test folder, deze class implementeert de PersoonRepository interface
        //maar is niet afhankelijk v/e collega zijn code en is kleiner in data, wat het testen vergemakkelijkt
        service = new PersoonService(new PersoonRepositoryStub());
    }

    @Test
    void deWeddeStandaardAfwijkingIsPositief() throws IOException {
        assertThat(service.standaardAfwijkingWeddes()).isPositive();
    }

    @Test
    void deWeddeStandaardAfwijkingIsTwee() throws IOException {
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }

}