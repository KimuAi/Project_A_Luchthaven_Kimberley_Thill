public class Passagier {
    private String naam;
    private int leeftijd;
    private String adres;
    private double bagageGewicht;

    // Constructor aangepast om ook het adres en bagagegewicht te accepteren
    public Passagier(String naam, int leeftijd, String adres, double bagageGewicht) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
        this.bagageGewicht = bagageGewicht;
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
    // als ik later het gewicht zou willen aanpassen
    public void setBagageGewicht(double bagageGewicht) {
        this.bagageGewicht = bagageGewicht;
    }

    // als ik later het adres zou willen aanpassen
    public void setAdres(String adres) {
        this.adres = adres;
    }
}
