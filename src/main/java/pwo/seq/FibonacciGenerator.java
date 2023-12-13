package pwo.seq;



import java.math.BigDecimal;

/**
 * Klasa FibonacciGenerator reprezentuje generator ciągu liczb Fibonacciego.
 * Jest to klasa dziedzicząca po klasie Generator.
 * Generuje kolejne wartości ciągu Fibonacciego.
 * @author adams
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }
    /**
     * Przesłonięcie metody reset.
     * Resetuje wartości ciągu do początkowych.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }
    /**
     * Metoda nextTerm generuje kolejną wartość w ciągu.
     * Oblicza kolejne wyrazy ciągu Fibonacciego.
     *
     * @return Następny wyraz ciągu
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_2; 
            f_1 = f_2.subtract(f_1);
            f_2 = current; 
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex--;
        return current;
    }
}
