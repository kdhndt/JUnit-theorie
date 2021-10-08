package domain;

public class Woord {
    private final String woord;

    public Woord(String woord) {
        this.woord = woord;
    }

    public boolean isPalindroom() {
/*        int begin = 0;
        var einde = woord.length() - 1;
        while (begin < einde) {
            if (woord.charAt(begin) != woord.charAt(einde)) {
                return false;
            }
            begin++;
            einde--;
        }
        return true;*/
        var omgekeerd = new StringBuilder(woord).reverse().toString();
        return woord.equals(omgekeerd);
    }

    @Override
    public String toString() {
        return woord;
    }
}