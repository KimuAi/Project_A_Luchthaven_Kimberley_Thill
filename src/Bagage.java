/**
 * De Bagage klasse vertegenwoordigt een tas met een gewicht en bevat functionaliteit
 * om het gewicht te controleren ten opzichte van een maximumgewicht.
 * Als het gewicht van de tas groter is dan het toegestane maximum, wordt het beperkt tot dat maximum.
 */
public class Bagage {

    // Gewicht van de tas in kg
    double gewicht;

    // Constante voor het maximale gewicht (35 kg)
    private static final double MAX_GEWICHT = 35.0;

    /**
     * Constructor voor de Bagage klasse.
     * De constructor stelt het gewicht van de tas in, maar controleert eerst
     * of het gewicht niet groter is dan het toegestane maximumgewicht.
     *
     * Als het gewicht groter is dan het maximum, wordt het gewicht ingesteld op het maximumgewicht.
     *
     * @param gewicht Het gewicht van de tas in kilogram.
     * @param maat De maat van de tas (niet gebruikt in deze versie van de klasse).
     */
    public Bagage(double gewicht, double maat) {
        // Controleer of het gewicht groter is dan het maximale gewicht
        if (gewicht > MAX_GEWICHT) {
            System.out.println("Waarschuwing: Het gewicht van de tas is te groot. Het wordt beperkt tot " + MAX_GEWICHT + " kg.");
            this.gewicht = MAX_GEWICHT;  // Stel het gewicht in op het maximale gewicht
        } else {
            this.gewicht = gewicht;  // Gebruik het opgegeven gewicht als het kleiner of gelijk is aan het maximale gewicht
        }
    }

    @Override
    public String toString() {
        return "Gewicht: " + gewicht + "kg";
    }
}
