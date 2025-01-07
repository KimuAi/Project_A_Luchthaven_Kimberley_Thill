public class Ticket {
    private static int ticketCounter = 1;
    private int ticketNummer;
    private Passagier passagier;
    private String ticketKlasse;
    private Vliegtuig vliegtuig;

    public Ticket(Passagier passagier, String ticketKlasse, Vliegtuig vliegtuig) {
        this.ticketNummer = ticketCounter++;
        this.passagier = passagier;
        this.ticketKlasse = ticketKlasse;
        this.vliegtuig = vliegtuig;
    }

    public int getTicketNummer() {
        return ticketNummer;
    }

    public String toString() {
        return "Ticketnummer: " + ticketNummer +
                "\nPassagier: " + passagier.getNaam() +
                "\nLeeftijd: " + passagier.getLeeftijd() +
                "\nKlasse: " + ticketKlasse +
                "\nVliegtuigcode: " + vliegtuig.getVliegtuigCode();
    }
}