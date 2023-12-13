/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/*
 * Klasa SeqToOutApp jest aplikacją do generowania ciągów i wypisywania ich do terminala.
 * Rozszerza funkcjonalność klasy SeqToFileApp.
 * Działa jako aplikacja uruchamiana z wiersza poleceń, generująca i wyświetlająca ciągi w terminalu.
 * Korzysta z narzędzi z klasy SequenceTools do generowania ciągów.
 * @author adams
 * @version 1.0.0
 */
package pwo.app;

import pwo.utils.SequenceTools;

public class SeqToOutApp extends SeqToFileApp {
    
    /**
     * Metoda getArgs pobiera argumenty i sprawdza ich poprawność dla aplikacji uruchamianej z wiersza poleceń.
     * Sprawdza, czy podane argumenty są poprawne dla generowania ciągu do wyświetlenia w terminalu.
     *
     * @param args Argumenty z linii poleceń: seqName from to.
     *             seqName - rodzaj ciągu, from - początek zakresu, to - koniec zakresu.
     * @return Prawda, jeśli argumenty są poprawne; w przeciwnym razie fałsz.
     */
    @Override
    protected boolean getArgs(String[] args) {

        if (super.getArgs(args)) {
            return true;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda wirteSeq generuje ciąg na podstawie argumentów i wyświetla go w terminalu.
     * Wykorzystuje metodę getTermsAsColumn z klasy SequenceTools do uzyskania ciągu w kolumnie.
     *
     * @return Prawda, jeśli generowanie ciągu i wyświetlanie w terminalu przebiegło pomyślnie; w przeciwnym razie fałsz.
     */
    @Override
    protected boolean wirteSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(seqType.getGenerator(), from, to));

        return true;
    }

     /**
     * Metoda run uruchamia aplikację SeqToOutApp.
     * Wyświetla informację o uruchomieniu aplikacji i sprawdza poprawność argumentów.
     * W przypadku niepoprawnych argumentów wyświetla informację o poprawnym użyciu aplikacji.
     *
     * @param args Argumenty z linii poleceń: seqName from to.
     *             seqName - rodzaj ciągu, from - początek zakresu, to - koniec zakresu.
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n" + "Legal usage: seqName from to");
            return;
        }

        wirteSeq();
    }

}
