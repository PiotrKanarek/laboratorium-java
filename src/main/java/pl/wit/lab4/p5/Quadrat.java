package pl.wit.lab4.p5;

public class Quadrat {
    //Stała definiująca liczbę boków prostokąta
    public final static int NUMBER_OF_SIDES = 2;

    /**
     * Metoda statyczna obliczająca
     * pole prostokąta
     *
     * @param a
     * @param b
     * @return
     */
    public static double area(double a, double b) {
        return a * b;
    }
}
