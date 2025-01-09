import java.util.ArrayList;
import java.util.List;

/**
 * De CheckInSysteem klasse beheert passagiers, vliegtuigen en tickets voor het inchecken van passagiers.
 * Het biedt methoden om passagiers, vliegtuigen en tickets toe te voegen, tickets te genereren,
 * passagiers op naam te zoeken, vliegtuigen op code te zoeken en passagiers in te checken.
 */
public class CheckInSysteem {

    // Startnummer voor het genereren van unieke ticketnummers
    private static int ticketNummerCounter = 1;

    // Lijst van passagiers die geregistreerd zijn in het systeem
    private ArrayList<Passagier> passagiers = new ArrayList<>();

    // Lijst van vliegtuigen die geregistreerd zijn in het systeem
    private ArrayList<Vliegtuig> vliegtuigen = new ArrayList<>();

    // Lijst van tickets die geboekt zijn in het systeem
    private ArrayList<Ticket> tickets = new ArrayList<>();

    /**
     * Genereert een uniek ticketnummer voor elke nieuwe ticket.
     * Het ticketnummer wordt verhoogd bij elke oproep van deze methode.
     *
     * @return Het gegenereerde ticketnummer.
     */
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

    /**
     * Zoekt een passagier op naam.
     *
     * @param naam De naam van de passagier.
     * @return De gevonden passagier of null als geen passagier met de opgegeven naam wordt gevonden.
     */
    public Passagier krijgPassagierOpNaam(String naam) {
        for (Passagier p : passagiers) {
            if (p.getNaam().equalsIgnoreCase(naam)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Zoekt een vliegtuig op de unieke vliegtuigcode.
     *
     * @param code De code van het vliegtuig.
     * @return Het gevonden vliegtuig of null als geen vliegtuig met de opgegeven code wordt gevonden.
     */
    public Vliegtuig krijgVliegtuigOpCode(String code) {
        for (Vliegtuig v : vliegtuigen) {
            if (v.getVliegtuigCode().equalsIgnoreCase(code)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Checkt een passagier in op basis van het ticketnummer.
     * Controleert of het gewicht van de bagage van de passagier binnen de toegestane limiet is.
     *
     * @param ticketNummer Het ticketnummer van de passagier die ingecheckt moet worden.
     * @return true als de check-in succesvol is, false als de check-in is mislukt (bijvoorbeeld door te zware bagage).
     */
    public boolean checkInPassagier(String ticketNummer) {
        for (Ticket t : tickets) {
            if (t.getTicketNummer().equals(ticketNummer)) {
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

    /**
     * Toon alle tickets die geboekt zijn in het systeem.
     * De tickets worden in de console weergegeven, met elke ticket gescheiden door een lijn.
     */
    public void toonAlleTickets() {
        for (Ticket t : tickets) {
            System.out.println(t);
            System.out.println("____________________________");
        }
    }
}
