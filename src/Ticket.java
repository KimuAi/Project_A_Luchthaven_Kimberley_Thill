import org.w3c.dom.ls.LSOutput;

public class Ticket {
    private static int ticketCounter = 1; // Teller voor het ticketnummer
    private String ticketNummer;
    private Passagier passagier;
    private String ticketKlasse;
    private Vliegtuig vliegtuig;
    private String stoelType;

    public Ticket(Passagier passagier, String ticketKlasse, Vliegtuig vliegtuig, String stoelType, String ticketNummer, double tasGewicht) {
        // maakt een eenvoudig ticketnummer met een tellerwaarde (Opgezocht op google hoe dit moest)
        this.ticketNummer = "TKT" + String.format("%03d", ticketCounter++);
        this.passagier = passagier;
        this.ticketKlasse = ticketKlasse;
        this.vliegtuig = vliegtuig;
        this.stoelType = stoelType;
    }

    public String getTicketNummer() {
        return ticketNummer;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    // wat de uitgave voor na het maken van het ticket
    public String toString() {
        return "Ticketnummer: " + ticketNummer +
                "\nPassagier: " + passagier.getNaam() +
                "\nLeeftijd: " + passagier.getLeeftijd() +
                "\nKlasse: " + ticketKlasse +
                "\nVliegtuigcode: " + vliegtuig.getVliegtuigCode() +
                "\nStoeltype: " + stoelType;
    }
}

