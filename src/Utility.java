public class Utility {
    
    //metodo pulisci schermo
    static void pulisciSchermo() {
        System.out.print("\033[H\033[2J"); //sequenza ANSI per ripulire il terminale
        System.out.flush();
    }

    //metodo testo rosso
    static void testoRosso() {
        System.out.println("\033[31m"); //sequenza ANSI per cambiare il colore a rosso
    }

    //metodo testo giallo
    static void testoGiallo() {
        System.out.println("\033[33m"); //sequenza ANSI per cambiare il colore a giallo
    }

    //metodo testo verde
    static void testoVerde() {
        System.out.println("\033[32m"); //sequenza ANSI per cambiare il colore a verde
    }

    //metodo colore default
    static void resettaTesto(){
        System.out.println("\u001B[0m"); //sequenza ANSI per tornare al colore precedente
    }
}
