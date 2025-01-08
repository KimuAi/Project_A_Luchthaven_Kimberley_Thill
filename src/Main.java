import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckInSysteem incheckSysteem = new CheckInSysteem();

        // Vraag of de gebruiker een werknemer of passagier is
        System.out.print("Ben je een werknemer? (Ja/Nee): ");
        String rol = scanner.nextLine();

        do {
            // De vraag wordt alleen herhaald als de invoer ongeldig is
            if (!rol.equalsIgnoreCase("Ja") && !rol.equalsIgnoreCase("Nee")) {
                System.out.println("Ongeldige invoer. Typ 'Ja' of 'Nee'.");
                System.out.print("Ben je een werknemer? (Ja/Nee): ");
                rol = scanner.nextLine();
            } else {
                // Als de invoer geldig is, breek je de lus & ga je nr de volgende
                break;
            }
            // Dit zorgt ervoor dat de vraag maximaal één keer herhaald wordt
        } while (true);

        if (rol.equalsIgnoreCase("Ja")) {
            // Verwerk de informatie van de werknemer
            System.out.print("Voer je naam in: ");
            String werknemerNaam = scanner.nextLine();

            int werknemerLeeftijd;
            while (true) {
                System.out.print("Voer je leeftijd in: ");
                try {
                    werknemerLeeftijd = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ongeldige invoer. Alleen nummers zijn toegestaan. Probeer opnieuw.");
                }
            }

            System.out.print("Voer je adres in: ");
            String werknemerAdres = scanner.nextLine();

            System.out.print("Wat is je functie? (piloot/stewardess/bagagepersoneel/Check-in): ");
            String functie = scanner.nextLine();

            System.out.println("Werknemer " + werknemerNaam + " van " + werknemerLeeftijd + " jaar en met de functie " + functie + " succesvol geregistreerd.");

            switch (functie.toLowerCase()) {
                case "piloot":
                    System.out.print("Geef het vluchtnummer: ");
                    String vluchtnummer = scanner.nextLine();

                    System.out.print("Van welke luchthaven vertrek je? ");
                    String vertrek = scanner.nextLine();

                    System.out.print("Naar welke bestemming vlieg je? ");
                    String bestemming = scanner.nextLine();

                    System.out.println("De piloot heeft de vlucht " + vluchtnummer + " van " + vertrek + " naar " + bestemming + " toegewezen gekregen.");
                    break;

                case "stewardess":
                    System.out.println("Je bent toegewezen als stewardess. Veel succes!");
                    break;

                case "bagagepersoneel":
                    System.out.println("Je bent toegewezen als bagagepersoneel. Veel succes!");
                    break;

                default:
                    System.out.println("Onbekende functie. Probeer opnieuw.");
                    break;
            }
        } else if (rol.equalsIgnoreCase("Nee")) {
            System.out.println("Welkom, passagier!");
        }


        while (true) {
            System.out.println("\n---- Hoofdmenu ----");
            System.out.println("1. Voeg passagier toe");
            System.out.println("2. Voeg vliegtuig toe");
            System.out.println("3. Boek een ticket");
            System.out.println("4. Check in passagier");
            System.out.println("5. Toon alle tickets");
            System.out.println("6. Verlaat programma");
            System.out.println("---------------------");
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
                    // Voeg passagier toe, vraag naam, leeftijd en adres
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

                    System.out.print("Voer je adres in: ");
                    String adres = scanner.nextLine();

                    Passagier passagier = new Passagier(naam, leeftijd, adres, 0.0);
                    incheckSysteem.voegPassagierToe(passagier);
                    System.out.println("Passagier " + naam + " succesvol toegevoegd.");
                    break;

                case 2:
                    System.out.print("Voer vertrekplaats in: ");
                    String vertrekplaats = scanner.nextLine();

                    System.out.print("Voer bestemming in: ");
                    String bestemmingVliegtuig = scanner.nextLine();

                    // Aantal stoelen is nu hardgecodeerd
                    int economyStoelen = 100;
                    int businessStoelen = 20;

                    Vliegtuig vliegtuig = new Vliegtuig(vertrekplaats, bestemmingVliegtuig, economyStoelen, businessStoelen);
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

                        // Toon het aantal beschikbare stoelen in de gekozen klasse
                        if (ticketKlasse.equalsIgnoreCase("economy")) {
                            System.out.println("Er zijn 260 economy stoelen beschikbaar.");
                        } else if (ticketKlasse.equalsIgnoreCase("business")) {
                            System.out.println("Er zijn 120 business stoelen beschikbaar.");
                        }

                        String stoelType;
                        do {
                            System.out.print("Wil je een aisle seat of een window seat? ");
                            stoelType = scanner.nextLine();
                            if (!stoelType.equalsIgnoreCase("aisle seat") && !stoelType.equalsIgnoreCase("window seat")) {
                                System.out.println("U heeft een foute invoer gegeven, probeer het opnieuw.");
                            }
                        } while (!stoelType.equalsIgnoreCase("aisle seat") && !stoelType.equalsIgnoreCase("window seat"));



                        System.out.print("Voer vliegtuigcode in: ");
                        String ticketVliegtuigCode = scanner.nextLine();
                        Vliegtuig vliegtuigVoorTicket = incheckSysteem.krijgVliegtuigOpCode(ticketVliegtuigCode);

                        if (vliegtuigVoorTicket != null) {
                            boolean isGereseveerd = false;

                            if ("economy".equalsIgnoreCase(ticketKlasse)) {
                                isGereseveerd = vliegtuigVoorTicket.reserveerEconomy();
                            } else if ("business".equalsIgnoreCase(ticketKlasse)) {
                                isGereseveerd = vliegtuigVoorTicket.reserveerBusiness();
                            }

                            if (isGereseveerd) {
                                // Genereer ticketnummer
                                String ticketNummer = String.valueOf(incheckSysteem.genereerTicketNummer());

                                // Vraag naar het gewicht van de tas
                                System.out.print("Voer het gewicht van je tas in (in kg): ");
                                double tasGewicht = Double.parseDouble(scanner.nextLine()); // Voer het gewicht in

                                // Controleer of het gewicht van de tas groter is dan 35 kg
                                if (tasGewicht > 35.0) {
                                    System.out.println("Je bagage is te zwaar! Je mag niet op het vliegtuig. Het max. gewicht is 35Kg");
                                    break;  // Stop het verdere proces als bagage te zwaar is
                                }

                                // Maak het ticket en geef het stoeltype mee
                                Ticket ticket = new Ticket(passagierVoorTicket, ticketKlasse, vliegtuigVoorTicket, stoelType, ticketNummer, tasGewicht);
                                incheckSysteem.voegTicketToe(ticket);
                                System.out.println("Ticket succesvol geboekt:");
                                System.out.println(ticket);
                                System.out.println("Je ticketnummer is: " + ticketNummer);
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
                    String ticketNummer = scanner.nextLine(); // Ticketnummer als string invoeren
                    boolean ingecheckt = incheckSysteem.checkInPassagier(ticketNummer); // Aanpassen aan string

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
