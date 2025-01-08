// AtomicInteger voor veilige operaties
import java.util.concurrent.atomic.AtomicInteger;

public class Vliegtuig {
    // Teller voor unieke vliegtuigcodes
    private static final AtomicInteger counter = new AtomicInteger(1);

    private String vliegtuigCode;
    private String vertrekLocatie;
    private String bestemming;
    private int economyStoelen;
    private int businessStoelen;

    // Constructor om een vliegtuig te creëren met gegeven gegevens
    public Vliegtuig(String vertrekLocatie, String bestemming, int economyStoelen, int businessStoelen) {
        this.vliegtuigCode = generateVliegtuigCode();
        this.vertrekLocatie = vertrekLocatie;
        this.bestemming = bestemming;
        this.economyStoelen = economyStoelen;
        this.businessStoelen = businessStoelen;
    }

    // Maakt een vliegtuigcode (VL001, VL002, ..)
    private String generateVliegtuigCode() {
        return "VL" + String.format("%03d", counter.getAndIncrement());
    }

    // Reserveert een economy stoel, als beschikbaar
    public boolean reserveerEconomy() {
        if (economyStoelen > 0) {  // Controleer of er economy stoelen beschikbaar zijn
            economyStoelen--;
            return true;
        }
        return false; // Geen stoelen beschikbaar
    }

    // Reserveert een business stoel, als er beschikbaar zijn
    public boolean reserveerBusiness() {
        if (businessStoelen > 0) {
            businessStoelen--;
            return true;
        }
        return false;
    }

    // Geeft de unieke vliegtuigcode terug
    public String getVliegtuigCode() {
        return vliegtuigCode;
    }
}
