public class Passagier {
    private String naam;
    private int leeftijd;
    private String adres;  // Nieuw veld voor het adres
    private double bagageGewicht;  // Nieuw veld voor het bagagegewicht

    // Constructor aangepast om ook het adres en bagagegewicht te accepteren
    public Passagier(String naam, int leeftijd, String adres, double bagageGewicht) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
        this.bagageGewicht = bagageGewicht;  // Bagagegewicht wordt hier ingesteld
    }

    // Getters voor naam, leeftijd, adres en bagagegewicht
    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getAdres() {
        return adres;
    }

    public double getBagageGewicht() {
        return bagageGewicht;
    }

    // Optioneel: Setter voor bagagegewicht als je het later wilt aanpassen
    public void setBagageGewicht(double bagageGewicht) {
        this.bagageGewicht = bagageGewicht;
    }

    // Optioneel: Setter voor adres als je het later wilt aanpassen
    public void setAdres(String adres) {
        this.adres = adres;
    }
}
