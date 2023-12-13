package pwo.utils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SequenceTools {
    /**
    * Klasa narzędziowa służąca do obsługi obiektów<br>
    * implementujących interfejs {@link SequenceGenerator}
    *
    * @author adams
    * @version 1.0.0
    */

    private static String getTerms(SequenceGenerator sg,
            int from, int to, String sep) {

        int i = from, stop = to, step = from > to ? -1 : 1;
        String terms = "";

        while (true) {
            terms += sg.getTerm(i) + sep;
            if (i == stop) {
                return terms.trim();
            }
            i += step;
        }
    }

    public static String getTermsAsColumn(SequenceGenerator sg,
            int from, int to) {
        /**
    * Zamienia wyrazy ciągu na tekst.<br>
    * Wyrazy ciągu tworzą kolumnę.
    *
    * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
    * @param from Początkowy wyraz ciągu
    * @param to Końcowy wyraz ciągu
    * @return Wyrazy ciągu w postaci tekstu tworzącego kolumnę
    * @see #getTermsAsLine(pwo.utils.SequenceGenerator, int, int)
    */
        return getTerms(sg, from, to, "\n");
    }

    public static String getTermsAsLine(SequenceGenerator sg,
            int from, int to) {
        /**
        * Zamiania wyrazy ciągu na tekst.<br>
        * Wyrazy ciągu tworzą wiersz.
        *
        * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
        * @param from Początkowy wyraz ciągu
        * @param to Końcowy wyraz ciągu
        * @return Wyrazy ciągu w postaci tekstu tworzącego wiersz
        * @see #getTermsAsColumn(pwo.utils.SequenceGenerator, int, int)
        */
        return getTerms(sg, from, to, " ");
    }

    public static boolean writeToFile(SequenceGenerator sg,
            int from, int to, String fileName) {
        /**
        * Zapisuje wyrazy ciągu do pliku w postaci kolumny.
        *
        * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
        * @param from Początkowy wyraz ciągu
        * @param to Końcowy wyraz ciągu
        * @param fileName Nazwa pliku
        * @return true jeżeli udało się zapisać plik,
        * false w przeciwnym wypadku
        */
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
}
