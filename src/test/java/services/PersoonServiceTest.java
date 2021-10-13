package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.PersoonRepository;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//je vraagt JUnit de test uit te voeren in samenwerking met Mockito


class PersoonServiceTest {
    @Mock
    private PersoonRepository repository;
    //de mock maakt een object van een class die PersoonRepository interface implementeert
    //en steek dit in de "repository" variabele
    //dit is dus een "dummy" dependency

    private PersoonService service;

    @BeforeEach
    void beforeEach() {
        //gebruik een dummy repo, maak die aan in je test folder, deze class implementeert de PersoonRepository interface
        //maar is niet afhankelijk v/e collega zijn code en is kleiner in data, wat het testen vergemakkelijkt
/*
        service = new PersoonService(new PersoonRepositoryStub());
*/
        //vervang de stub injectie door een mock injectie
        service = new PersoonService(repository);
    }

    @Test
    void deWeddeStandaardAfwijkingIsPositief() throws IOException {
        //je traint de mock, anders returnt hij default waardes zoals null of een lege array
        when(repository.findAllWeddes()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9),
        });
        assertThat(service.standaardAfwijkingWeddes()).isPositive();
        //je verifieert of het te testen object de mock opriep
        verify(repository).findAllWeddes();
    }

    @Test
    void deWeddeStandaardAfwijkingIsTwee() throws IOException {
        when(repository.findAllWeddes()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9),
        });
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }

}