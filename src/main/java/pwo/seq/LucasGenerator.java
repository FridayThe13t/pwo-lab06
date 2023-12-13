package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa LucasGenerator reprezentuje generator ciągu liczb Lucasa.
 * Jest to klasa dziedzicząca po klasie Generator.
 * Generuje kolejne wartości ciągu Lucasa.
 *
 * @author adams
 * @version 1.0.0
 */
public class LucasGenerator extends Generator {
    /**
    * Konstruktor klasy LucasGenerator.
    * Inicjalizuje wartości początkowe dla ciągu Lucasa.
    */
    public LucasGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(2);
    }

    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(2);
    }
    
    /**
     * Metoda nextTerm generuje kolejną wartość w ciągu.
     * Oblicza kolejne wyrazy ciągu Lucasa.
     *
     * @return Następny wyraz ciągu
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_2; 
            f_2 = f_1.subtract(f_2); 
            f_1 = current; 
        } else if (lastIndex == 1) {
            current = new BigDecimal(2);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex--;
        return current;
    }
}
