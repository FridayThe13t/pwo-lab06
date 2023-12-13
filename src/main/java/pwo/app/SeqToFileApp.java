

/*
 * Klasa SeqToFileApp reprezentuje aplikację do generowania ciągów i zapisywania ich do pliku.
 * Obsługuje zapisywanie wyników ciągów do pliku tekstowego.
 * Klasa zawiera metody umożliwiające pobieranie argumentów z linii poleceń i zapisywanie ciągów do pliku.
 * @author adams
 * @version 1.0.0
 */


package pwo.app;



import pwo.seq.SeqType;
import pwo.utils.SequenceTools;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;


    /**
     * Metoda getArgs pobiera argumenty z linii poleceń i sprawdza ich poprawność dla aplikacji zapisującej ciągi do pliku.
     * Sprawdza, czy podane argumenty są poprawne do generowania ciągu do zapisu w pliku.
     *
     * @param args Argumenty z linii poleceń: seqName from to fileName.
     *             seqName - rodzaj ciągu, from - początek zakresu, to - koniec zakresu, fileName - nazwa pliku.
     * @return Prawda, jeśli argumenty są poprawne; w przeciwnym razie fałsz.
     */
class SeqToFileApp {

    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException
                | NumberFormatException ex) {
            return false;
        }

        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda writeSeq generuje ciąg na podstawie argumentów i zapisuje go do pliku.
     * Wykorzystuje metodę writeToFile z klasy SequenceTools do zapisu ciągu do pliku.
     *
     * @return Prawda, jeśli zapis ciągu do pliku przebiegł pomyślnie; w przeciwnym razie fałsz.
     */
    protected boolean wirteSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }

    /**
     * Metoda run uruchamia aplikację SeqToFileApp.
     * Wyświetla informację o uruchomieniu aplikacji i sprawdza poprawność argumentów.
     * W przypadku niepoprawnych argumentów wyświetla informację o poprawnym użyciu aplikacji.
     *
     * @param args Argumenty z linii poleceń: seqName from to fileName.
     *             seqName - rodzaj ciągu, from - początek zakresu, to - koniec zakresu, fileName - nazwa pliku.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }

        if (!wirteSeq()) {
            System.out.println("!Write to the file: " + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
