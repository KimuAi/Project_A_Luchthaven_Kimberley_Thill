import org.w3c.dom.ls.LSOutput;

/**
 * De Ticket klasse vertegenwoordigt een ticket voor een passagier op een specifiek vliegtuig.
 * Het ticket bevat details zoals het ticketnummer, de passagier, de klasse van het ticket, het vliegtuig
 * waarin de passagier reist, en het stoeltype dat de passagier heeft gereserveerd.
 */
public class Ticket {

    // Teller voor het ticketnummer, begint bij 1
    private static int ticketCounter = 1;

    // Ticketnummer dat uniek wordt gegenereerd voor elke nieuwe ticket
    private String ticketNummer;

    // De passagier die dit ticket heeft geboekt
    private Passagier passagier;

    // De klasse van het ticket (bijvoorbeeld economy of business)
    private String ticketKlasse;

    // Het vliegtuig waarin de passagier reist
    private Vliegtuig vliegtuig;

    // Het type stoel dat is gereserveerd door de passagier (bijvoorbeeld aisle seat of window seat)
    private String stoelType;

    /**
     * Constructor voor het maken van een nieuw ticket.
     * Het ticketnummer wordt automatisch gegenereerd met behulp van een teller.
     *
     * @param passagier De passagier die het ticket heeft geboekt.
     * @param ticketKlasse De klasse van het ticket (bijvoorbeeld economy of business).
     * @param vliegtuig Het vliegtuig waarin de passagier reist.
     * @param stoelType Het type stoel dat de passagier heeft gekozen (bijvoorbeeld aisle seat of window seat).
     * @param ticketNummer Een ticketnummer (hoeft niet te worden opgegeven omdat deze automatisch wordt gegenereerd).
     * @param tasGewicht Het gewicht van de tas van de passagier (gebruikt voor verdere validatie in andere systemen).
     */
    public Ticket(Passagier passagier, String ticketKlasse, Vliegtuig vliegtuig, String stoelType, String ticketNummer, double tasGewicht) {
        // Genereert een ticketnummer met een tellerwaarde
        this.ticketNummer = "TKT" + String.format("%03d", ticketCounter++);
        this.passagier = passagier;
        this.ticketKlasse = ticketKlasse;
        this.vliegtuig = vliegtuig;
        this.stoelType = stoelType;
    }

    /**
     * Haalt het ticketnummer op van het ticket.
     *
     * @return Het ticketnummer van het ticket.
     */
    public String getTicketNummer() {
        return ticketNummer;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    /**
     * Maakt een tekstuele weergave van het ticket, inclusief ticketnummer, passagiersinformatie,
     * ticketklasse, vliegtuigcode en stoeltype.
     *
     * @return Een stringrepresentatie van het ticket.
     */
    @Override
    public String toString() {
        return "Ticketnummer: " + ticketNummer +
                "\nPassagier: " + passagier.getNaam() +
                "\nLeeftijd: " + passagier.getLeeftijd() +
                "\nKlasse: " + ticketKlasse +
                "\nVliegtuigcode: " + vliegtuig.getVliegtuigCode() +
                "\nStoeltype: " + stoelType;
    }
}
