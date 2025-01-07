import java.util.Scanner;

public class ToewijzingVliegtuig {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vraag of de gebruiker een reiziger of een werknemer is
        System.out.print("Ben je een werknemer?(Ja/Nee): ");
        String rol = scanner.nextLine();

        if (rol.equalsIgnoreCase("Ja")) {
            // Als de gebruiker een werknemer is, vragen we of ze een piloot zijn
            System.out.print("Ben je een piloot? (Ja/Nee): ");
            String isPilot = scanner.nextLine();

            if (isPilot.equalsIgnoreCase("Ja")) {
                // Als de gebruiker een piloot is, krijgt hij een vlucht toegewezen
                System.out.print("Geef het vluchtnummer (bijvoorbeeld 200): ");
                int vluchtnummer = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                System.out.print("Van welke luchthaven vertrek je? ");
                String vertrek = scanner.nextLine();

                System.out.print("Naar welke bestemming vlieg je? ");
                String bestemming = scanner.nextLine();

                // Vluchtinformatie weergeven
                System.out.println("De piloot heeft de vlucht " + vluchtnummer + " van " + vertrek + " naar " + bestemming + " toegewezen gekregen.");
            } else {
                System.out.println("Je hebt geen piloot toegewezen.");
            }


            scanner.close();
        }
    }
}


