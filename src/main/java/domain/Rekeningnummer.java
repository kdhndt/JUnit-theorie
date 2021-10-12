package domain;

import java.util.regex.Pattern;

public class Rekeningnummer {
    private final String nummer;
    private static final Pattern PATTERN = Pattern.compile("^BE(\\d{2})(\\d{12})$");

    public Rekeningnummer(String nummer) {
        var matcher = PATTERN.matcher(nummer);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Verkeerd formaat");
        }
        var controleGetal = Integer.valueOf(matcher.group(1));
        if (controleGetal < 2 || controleGetal > 98) {
            throw new IllegalArgumentException("1e of 2e cijfer verkeerd");
        }
        var teControlerenNummer = Long.valueOf(matcher.group(2) + "1114" + matcher.group(1));
        if (teControlerenNummer % 97 != 1) {
            throw new IllegalArgumentException("Nummer bevat verkeerde cijfers");
        }
        this.nummer = nummer;

    }

    @Override
    public String toString() {
        return nummer;
    }
}
