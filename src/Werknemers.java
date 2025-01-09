import java.util.Scanner;

/**
 * De Werknemers klasse simuleert een eenvoudig systeem voor werknemers om hun gegevens in te voeren
 * en hun functie binnen een luchtvaartmaatschappij te registreren. Afhankelijk van hun functie worden
 * verschillende vragen gesteld en wordt specifieke informatie over hun werk weergeven.
 */
public class Werknemers {

    /**
     * Het hoofdingangspunt van de applicatie. Het vraagt de gebruiker of hij een werknemer is en
     * op basis van zijn functie (piloot, stewardess, bagagepersoneel of onbekend) worden verdere
     * vragen gesteld om relevante informatie te verzamelen en weer te geven.
     *
     * @param args Command-line argumenten (worden niet gebruikt in deze implementatie).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vraag of de gebruiker een werknemer is
        System.out.print("Ben je een werknemer? (Ja/Nee): ");
        String rol = scanner.nextLine();

        // Indien ja, vraag naar de informatie van de werknemer
        if (rol.equalsIgnoreCase("Ja")) {

            // Vraag naar naam, leeftijd en adres van de werknemer
            System.out.print("Wat is je naam? ");
            String naam = scanner.nextLine();

            System.out.print("Wat is je leeftijd? ");
            int leeftijd = scanner.nextInt();
            scanner.nextLine();  // Consumeert de newline karakter na het invoeren van leeftijd

            System.out.print("Wat is je adres? ");
            String adres = scanner.nextLine();

            // Vraag naar de specifieke rol van de werknemer
            System.out.print("Ben je een piloot, stewardess, bagagepersoneel of Check-in? ");
            String functie = scanner.nextLine();

            // Toon basisinformatie van de werknemer
            System.out.println("Werknemer: " + naam + ", Leeftijd: " + leeftijd );

            // Gebruik een switch statement om specifieke vragen te stellen op basis van de functie
            switch (functie.toLowerCase()) {
                case "piloot":
                    // Als de gebruiker een piloot is, worden specifieke vragen gesteld over de vlucht
                    System.out.print("Geef het vluchtnummer: ");
                    int vluchtnummer = scanner.nextInt();
                    scanner.nextLine(); // Consumeert de newline na het invoeren van vluchtnummer

                    System.out.print("Van welke luchthaven vertrek je? ");
                    String vertrek = scanner.nextLine();

                    System.out.print("Naar welke bestemming vlieg je? ");
                    String bestemming = scanner.nextLine();

                    // Toon de vluchtinformatie voor de piloot
                    System.out.println("De piloot heeft de vlucht " + vluchtnummer + " van " + vertrek + " naar " + bestemming + " toegewezen gekregen.");
                    break;

                case "stewardess":
                    // Bericht voor de stewardess
                    System.out.println("Je bent toegewezen als stewardess. Veel succes!");
                    break;

                case "bagagepersoneel":
                    // Bericht voor het bagagepersoneel
                    System.out.println("Je bent toegewezen als bagagepersoneel. Veel succes!");
                    break;

                default:
                    // Bericht voor een onbekende functie
                    System.out.println("Onbekende functie. Probeer opnieuw.");
                    break;
            }
        } else {
            // Bericht voor niet-werknemers
            System.out.println("Je hebt geen toegang tot vluchttoewijzingen als reiziger.");
        }

        // Sluit de scanner om geheugenlekken te voorkomen
        scanner.close();
    }
}
