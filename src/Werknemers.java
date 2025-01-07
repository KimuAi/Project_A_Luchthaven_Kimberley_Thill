import java.util.Scanner;

public class Werknemers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vraag of de gebruiker een reiziger of een werknemer is
        System.out.print("Ben je een werknemer? (Ja/Nee): ");
        String rol = scanner.nextLine();

        if (rol.equalsIgnoreCase("Ja")) {
            // Vraag naar naam, leeftijd en adres van de werknemer
            System.out.print("Wat is je naam? ");
            String naam = scanner.nextLine();

            System.out.print("Wat is je leeftijd? ");
            int leeftijd = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            System.out.print("Wat is je adres? ");
            String adres = scanner.nextLine();

            // Vraag de specifieke rol van de werknemer
            System.out.print("Ben je een piloot, stewardess of bagagepersoneel? ");
            String functie = scanner.nextLine();

            System.out.println("Werknemer: " + naam + ", Leeftijd: " + leeftijd );

            // Afhankelijk van de functie van de werknemer
            switch (functie.toLowerCase()) {
                case "piloot":
                    // Als de gebruiker een piloot is, krijgt hij specifieke vragen over de vlucht
                    System.out.print("Geef het vluchtnummer: ");
                    int vluchtnummer = scanner.nextInt();
                    scanner.nextLine(); // consume newline character

                    System.out.print("Van welke luchthaven vertrek je? ");
                    String vertrek = scanner.nextLine();

                    System.out.print("Naar welke bestemming vlieg je? ");
                    String bestemming = scanner.nextLine();

                    // Vluchtinformatie weergeven
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
        } else {
            System.out.println("Je hebt geen toegang tot vluchttoewijzingen als reiziger.");
        }

        scanner.close();
    }
}
