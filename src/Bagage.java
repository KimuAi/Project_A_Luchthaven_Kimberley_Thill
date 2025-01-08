public class Bagage {
    double gewicht;  // Gewicht van de tas in kg

    // Constante voor het maximale gewicht
    private static final double MAX_GEWICHT = 35.0;

    // Constructor die het gewicht en de maat van de tas instelt
    public Bagage(double gewicht, double maat) {
        // Controleer of het gewicht groter is dan het maximale gewicht
        if (gewicht > MAX_GEWICHT) {
            System.out.println("Waarschuwing: Het gewicht van de tas is te groot. Het wordt beperkt tot " + MAX_GEWICHT + " kg.");
            this.gewicht = MAX_GEWICHT;  // Stel het gewicht in op het maximale gewicht
        } else {
            this.gewicht = gewicht;  // Gebruik het opgegeven gewicht als het kleiner of gelijk is aan het maximale gewicht
        }

    }

    // ToString methode om de eigenschappen van de tas weer te geven (het gewicht)
    @Override
    public String toString() {
        return "Gewicht: " + gewicht + "kg";
    }
}
