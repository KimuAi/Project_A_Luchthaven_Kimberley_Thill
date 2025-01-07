public class Bagage {
    double gewicht;
    double maat;

    public Bagage(double gewicht, double maat) {
        this.gewicht = gewicht;
        this.maat = maat;
    }

    @Override
    public String toString() {
        return "Gewicht: " + gewicht + "kg, Maat: " + maat + "m³";
    }
}