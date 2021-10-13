package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.KostRepositoryStub;
import repositories.OpbrengstRepositoryStub;

import static org.assertj.core.api.Assertions.*;

class WinstServiceTest {

    private WinstService winstService;

    @BeforeEach
    void beforeEach() {
        winstService = new WinstService(new OpbrengstRepositoryStub(), new KostRepositoryStub());
    }

    @Test
    void eenOpbrengstVan10000EnEenKostVan5000GeeftEenWinstVan5000() {
        assertThat(winstService.getWinst()).isEqualByComparingTo("5000");
    }

}