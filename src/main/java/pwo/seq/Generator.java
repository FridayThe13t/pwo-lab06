package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;
/**
 * Abstrakcyjna klasa Generator implementująca interfejs SequenceGenerator.
 * Jest to podstawowa klasa do generowania ciągów liczbowych.
 * Klasy dziedziczące po niej mogą implementować różne rodzaje ciągów.
 * @author adams
 * @version 1.0.0
 */
abstract class Generator implements SequenceGenerator {

    // Zmienne przechowujące aktualny stan ciągu
    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Metoda reset zeruje indeks ostatniego wygenerowanego elementu w ciągu.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }
    
    /**
     * Metoda getTerm zwraca i-ty wyraz ciągu.
     * Jeśli i < 0, metoda zgłasza wyjątek IllegalArgumentException.
     * Jeśli i jest mniejsze od lastIndex, resetuje ciąg do stanu początkowego.
     * Następnie generuje kolejne wyrazy ciągu do momentu osiągnięcia indeksu i.
     *
     * @param i Indeks wyrazu w ciągu, którego wartość jest zwracana.
     * @return Wyraz ciągu o indeksie i.
     * @throws IllegalArgumentException Jeśli i < 0.
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
