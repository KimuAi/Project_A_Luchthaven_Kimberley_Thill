import java.util.ArrayList;

public class CheckInSysteem {
    private ArrayList<Passagier> passagiers = new ArrayList<>();
    private ArrayList<Vliegtuig> vliegtuigen = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

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

    public boolean checkInPassagier(int ticketNummer) {
        for (Ticket t : tickets) {
            if (t.getTicketNummer() == ticketNummer) {
                return true;
            }
        }
        return false;
    }

    public void toonAlleTickets() {
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }
}