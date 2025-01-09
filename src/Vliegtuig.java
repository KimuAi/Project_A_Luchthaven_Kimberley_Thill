// AtomicInteger voor veilige operaties
import java.util.concurrent.atomic.AtomicInteger;

/**
 * De Vliegtuig klasse vertegenwoordigt een vliegtuig met unieke eigenschappen zoals een vliegtuigcode, vertreklocatie,
 * bestemming en het aantal beschikbare stoelen in de economy- en businessklasse. De klasse bevat methoden voor het reserveren
 * van stoelen in beide klassen.
 */
public class Vliegtuig {

    // Teller voor unieke vliegtuigcodes, gebruikt een AtomicInteger voor thread-safe operaties
    private static final AtomicInteger counter = new AtomicInteger(1);

    // Unieke code die het vliegtuig identificeert
    private String vliegtuigCode;

    // Locatie waar het vliegtuig vandaan vertrekt
    private String vertrekLocatie;

    // Bestemming van het vliegtuig
    private String bestemming;

    // Aantal beschikbare economy stoelen
    private int economyStoelen;

    // Aantal beschikbare business stoelen
    private int businessStoelen;

    public Vliegtuig(String vertrekLocatie, String bestemming, int economyStoelen, int businessStoelen) {
        this.vliegtuigCode = generateVliegtuigCode();
        this.vertrekLocatie = vertrekLocatie;
        this.bestemming = bestemming;
        this.economyStoelen = economyStoelen;
        this.businessStoelen = businessStoelen;
    }

    /**
     * Genereert een unieke vliegtuigcode die begint met "VL" gevolgd door een oplopend nummer.
     *
     * @return Een unieke vliegtuigcode (bijv. "VL001", "VL002", etc.).
     */
    private String generateVliegtuigCode() {
        return "VL" + String.format("%03d", counter.getAndIncrement());
    }

    /**
     * Probeert een economy stoel te reserveren. De stoel wordt gereserveerd als er een beschikbare stoel is.
     *
     * @return true als de stoel succesvol is gereserveerd, false als er geen beschikbare stoelen zijn.
     */
    public boolean reserveerEconomy() {
        if (economyStoelen > 0) {  // Controleer of er economy stoelen beschikbaar zijn
            economyStoelen--;
            return true;
        }
        return false; // Geen stoelen beschikbaar
    }

    /**
     * Probeert een business stoel te reserveren. De stoel wordt gereserveerd als er een beschikbare stoel is.
     *
     * @return true als de stoel succesvol is gereserveerd, false als er geen beschikbare stoelen zijn.
     */
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
