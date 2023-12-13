package pwo.seq;

import java.math.BigDecimal;

    /**
    * Klasa TribonacciGenerator reprezentuje generator ciągu liczb Tribonacciego.
    * Dziedziczy po klasie Generator.
    * Generuje kolejne wartości ciągu Tribonacciego.
    *
    * @author adams
    * @version 1.0.0
    */
public class TribonacciGenerator extends Generator {

    /**
     * Konstruktor klasy TribonacciGenerator.
     * Inicjalizuje wartości dla ciągu Tribonacciego.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }
    
    /**
     * Metoda nextTerm generuje kolejną wartość w ciągu.
     * Oblicza kolejne wyrazy ciągu Tribonacciego.
     *
     * @return Następny wyraz ciągu
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_3; 
            f_3 = f_2.subtract(f_3).subtract(f_1); 
            f_1 = f_2;
            f_2 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex--;
        return current;
    }
}
