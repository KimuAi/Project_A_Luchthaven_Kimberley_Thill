import java.util.concurrent.atomic.AtomicInteger;

public class Vliegtuig {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String vliegtuigCode;
    private String vertrekLocatie;
    private String bestemming;
    private int economyStoelen;
    private int businessStoelen;

    public Vliegtuig(String vertrekLocatie, String bestemming, int economyStoelen, int businessStoelen) {
        this.vliegtuigCode = generateVliegtuigCode();
        this.vertrekLocatie = vertrekLocatie;
        this.bestemming = bestemming;
        this.economyStoelen = economyStoelen;
        this.businessStoelen = businessStoelen;
    }

    private String generateVliegtuigCode() {
        return "VL" + String.format("%03d", counter.getAndIncrement());
    }

    public boolean reserveerEconomy() {
        if (economyStoelen > 0) {
            economyStoelen--;
            return true;
        }
        return false;
    }

    public boolean reserveerBusiness() {
        if (businessStoelen > 0) {
            businessStoelen--;
            return true;
        }
        return false;
    }

    public String getVliegtuigCode() {
        return vliegtuigCode;
    }
}