import repositories.CSVPersoonRepository;
import services.PersoonService;

import java.io.IOException;

public class StandaardAfwijking {
    public static void main(String[] args) {
        try {
            var service = new PersoonService(new CSVPersoonRepository());
            System.out.println(service.standaardAfwijkingWeddes());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
