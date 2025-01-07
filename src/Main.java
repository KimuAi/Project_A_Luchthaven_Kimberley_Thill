import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckInSysteem incheckSysteem = new CheckInSysteem();

        while (true) {
            System.out.println("\n--- Hoofdmenu ---");
            System.out.println("1. Voeg passagier toe");
            System.out.println("2. Voeg vliegtuig toe");
            System.out.println("3. Boek een ticket");
            System.out.println("4. Check in passagier");
            System.out.println("5. Toon alle tickets");
            System.out.println("6. Verlaat programma");
            System.out.print("Maak een keuze: ");

            int keuze;
            try {
                keuze = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer een nummer in.");
                continue;
            }

            switch (keuze) {
                case 1:
                    System.out.print("Voer naam van passagier in: ");
                    String naam = scanner.nextLine();

                    int leeftijd;
                    while (true) {
                        System.out.print("Voer leeftijd in: ");
                        try {
                            leeftijd = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ongeldige invoer. Alleen nummers zijn toegestaan. Probeer opnieuw.");
                        }
                    }

                    Passagier passagier = new Passagier(naam, leeftijd);
                    incheckSysteem.voegPassagierToe(passagier);
                    System.out.println("Passagier succesvol toegevoegd.");
                    break;

                case 2:
                    System.out.print("Voer vertrekplaats in: "); String vertrek = scanner.nextLine();

                    System.out.print("Voer bestemming in: ");
                    String bestemming = scanner.nextLine();

                    System.out.print("Aantal economy stoelen: ");
                    int economyStoelen = Integer.parseInt(scanner.nextLine());

                    System.out.print("Aantal business stoelen: ");
                    int businessStoelen = Integer.parseInt(scanner.nextLine());

                    Vliegtuig vliegtuig = new Vliegtuig(vertrek, bestemming, economyStoelen, businessStoelen);
                    incheckSysteem.voegVliegtuigToe(vliegtuig);
                    System.out.println("Vliegtuig succesvol toegevoegd. Code: " + vliegtuig.getVliegtuigCode());
                    break;

                case 3:
                    System.out.print("Voer passagiersnaam in: ");
                    String passagierNaam = scanner.nextLine();
                    Passagier passagierVoorTicket = incheckSysteem.krijgPassagierOpNaam(passagierNaam);

                    if (passagierVoorTicket != null) {
                        System.out.print("Voer ticketklasse in (economy/business): ");
                        String ticketKlasse = scanner.nextLine();

                        System.out.print("Voer vliegtuigcode in: ");
                        String ticketVliegtuigCode = scanner.nextLine();
                        Vliegtuig vliegtuigVoorTicket = incheckSysteem.krijgVliegtuigOpCode(ticketVliegtuigCode);

                        if (vliegtuigVoorTicket != null) {
                            boolean isGereseveerd = false;

                            if ("economy".equalsIgnoreCase(ticketKlasse)) {
                                isGereseveerd = vliegtuigVoorTicket.reserveerEconomy();
                            } else if ("business".equalsIgnoreCase(ticketKlasse)) {
                                isGereseveerd =
                                        vliegtuigVoorTicket.reserveerBusiness();
                            }

                            if (isGereseveerd) {
                                Ticket ticket = new Ticket(passagierVoorTicket, ticketKlasse, vliegtuigVoorTicket);
                                incheckSysteem.voegTicketToe(ticket);
                                System.out.println("Ticket succesvol geboekt en geprint:");
                                System.out.println(ticket);
                            } else {
                                System.out.println("Geen beschikbare stoelen in de gekozen klasse.");
                            }
                        } else {
                            System.out.println("Vliegtuig niet gevonden.");
                        }
                    } else {
                        System.out.println("Passagier niet gevonden.");
                    }
                    break;

                case 4:
                    System.out.print("Voer ticketnummer in: ");
                    int ticketNummer = Integer.parseInt(scanner.nextLine());
                    boolean ingecheckt = incheckSysteem.checkInPassagier(ticketNummer);

                    if (ingecheckt) {
                        System.out.println("Passagier succesvol ingecheckt.");
                    } else {
                        System.out.println("Check-in mislukt. Controleer ticketgegevens.");
                    }
                    break;

                case 5:
                    incheckSysteem.toonAlleTickets();
                    break;

                case 6:
                    System.out.println("Programma beëindigd.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }
    }
}
