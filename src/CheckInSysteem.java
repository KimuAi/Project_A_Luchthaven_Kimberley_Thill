import java.util.ArrayList;
import java.util.List;

public class CheckInSysteem {
    private static int ticketNummerCounter = 1; // Start bij 1
    private ArrayList<Passagier> passagiers = new ArrayList<>();
    private ArrayList<Vliegtuig> vliegtuigen = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    // Methode om een uniek ticketnummer te genereren
    public int genereerTicketNummer() {
        return ticketNummerCounter++;
    }

    public void voegPassagierToe(Passagier passagier) {
        passagiers.add(passagier);
    }

    public void voegVliegtuigToe(Vliegtuig vliegtuig) {
        vliegtuigen.add(vliegtuig);
    }

    public void voegTicketToe(Ticket ticket) {
        tickets.add(ticket);
    }

    public Passagier krijgPassagierOpNaam(String naam) {
        for (Passagier p : passagiers) {
            if (p.getNaam().equalsIgnoreCase(naam)) {
                return p;
            }
        }
        return null;
    }

    public Vliegtuig krijgVliegtuigOpCode(String code) {
        for (Vliegtuig v : vliegtuigen) {
            if (v.getVliegtuigCode().equalsIgnoreCase(code)) {
                return v;
            }
        }
        return null;
    }

    // Aangepaste checkInPassagier methode om ticketnummer als String te behandelen
    public boolean checkInPassagier(String ticketNummer) {
        for (Ticket t : tickets) {
            if (t.getTicketNummer().equals(ticketNummer)) { // Vergelijk ticketnummers als Strings
                Passagier passagier = t.getPassagier();
                double bagageGewicht = passagier.getBagageGewicht();
                double maxGewicht = 35.0;

                if (bagageGewicht > maxGewicht) {
                    System.out.println("Je bagage is te zwaar! Het maximale gewicht is " + maxGewicht + " kg.");
                    return false; // Bagage is te zwaar, kan niet inchecken
                } else {
                    System.out.println("Je bagage is goedgekeurd voor check-in.");
                    return true; // Bagage is goedgekeurd
                }
            }
        }
        return false; // Ticketnummer niet gevonden
    }

    public void toonAlleTickets() {
        for (Ticket t : tickets) {
            System.out.println(t);
            System.out.println("____________________________");
        }
    }
}
