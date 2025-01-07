public class Ticket {
    private static int ticketCounter = 1; // Teller voor het ticketnummer
    private String ticketNummer;         // Ticketnummer als string
    private Passagier passagier;
    private String ticketKlasse;
    private Vliegtuig vliegtuig;
    private String stoelType;            // Nieuw veld voor stoeltype (aisle/window)

    public Ticket(Passagier passagier, String ticketKlasse, Vliegtuig vliegtuig, String stoelType, String ticketNummer, double tasGewicht) {
        // Genereer eenvoudig ticketnummer met een prefix en de tellerwaarde
        this.ticketNummer = "TKT" + String.format("%03d", ticketCounter++);
        this.passagier = passagier;
        this.ticketKlasse = ticketKlasse;
        this.vliegtuig = vliegtuig;
        this.stoelType = stoelType;  // Stel stoelType in
    }

    public String getTicketNummer() {
        return ticketNummer;
    }

    public Passagier getPassagier() {
        return passagier;  // Getter voor de passagier
    }

    // Aangepaste toString() om stoelType toe te voegen aan de ticketinformatie
    public String toString() {
        return "Ticketnummer: " + ticketNummer +
                "\nPassagier: " + passagier.getNaam() +
                "\nLeeftijd: " + passagier.getLeeftijd() +
                "\nKlasse: " + ticketKlasse +
                "\nVliegtuigcode: " + vliegtuig.getVliegtuigCode() +
                "\nStoeltype: " + stoelType;  // Weergeeft het stoeltype
    }
}
