package pwo.app;

/**
 * Klasa Sequence zawiera metodę main.
 * Jest to klasa uruchomieniowa aplikacji do generowania ciągów.
 * Przyjmuje argumenty z linii poleceń i na ich podstawie uruchamia odpowiednią aplikację.
 * @author adams
 * @version 1.0.0
 */
public class Sequence {

    public static void main(String[] args) {

        switch (args.length) {
            case 3:
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                (new SeqToFileApp()).run(args);
                break;
            default:
                System.out.println("!Illegal arguments\n" + "Legal usage: seqName from to [fileName]");
        }
    }
}
