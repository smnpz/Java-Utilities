import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ControlloInput {

    //oggetti input
    static InputStreamReader input = new InputStreamReader(System.in);
    static BufferedReader tastiera = new BufferedReader(input);

    private int intero;
    private double reale;
    private String stringa;

    // METODI per le STRINGHE
    private void setStringa(String stringa) {
        this.stringa = stringa;
    }

    //metodo input stringa generica
    public String inputStringa() {
        
        boolean error = false;

        do {
            try {
                setStringa(tastiera.readLine());
                error = false;
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return stringa;
    }

    //metodo input stringa letterale
    public String inputStringaLetterale() {

        boolean error = false;

        do {
            try {
                setStringa(tastiera.readLine());
                error = false;

                //for per scorrerela stringa
                for (int i = 0; i < stringa.length(); i++) {
                    char c = stringa.charAt(i);
                    if (!Character.isLetter(c)) {
                        System.out.print("Errore | La stringa contiene caratteri non validi [a/A - z/Z].\nRiprova: ");
                        error = true;
                    }
                }

            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return stringa;
    }

    //metodo booleano scelta binaria (x y)
    public String inputScelta(String x, String y) {

        boolean error = false;

        do {
            try {
                setStringa(tastiera.readLine());

                if (!stringa.equals(x) || !stringa.equals(y)) error = false;
                else {
                    System.out.print("Errore | Scelta non contemplata [" + x + "/" + y + "].\nRiprova: ");
                    error = true;
                }

            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return stringa;
    }

    // METODI per gli INTERI
    public void setIntero(int intero) {
        this.intero = intero;
    }

    public int inputIntero() {

        boolean error = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));
                error = false;
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return intero;
    }

    //metodo intero in un range
    public int inputInteroRange(int min, int max) {

        boolean error = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));

                if (intero < min || intero > max) {
                    System.out.print("Errore | Il numero inserito non rientra nel range [" + min + " - " + max + "].\nRiprova:");
                    error = true;
                } else error = false;

            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return intero;
    }

    //metodo numeri interi positivi
    public int inputInteroPositivo() {

        boolean error = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));
                error = false;

                if (intero < 0) {
                    System.out.print("Errore | Numero negativo non valido.\nRiprova: ");
                    error = true;
                }
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return intero;
    }

    //metodo numeri interi negativi
    public int inputInteroNegativo() {

        boolean error = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));
                error = false;

                if (intero > 0) {
                    System.out.print("Errore | Numero positivo non valido.\nRiprova: ");
                    error = true;
                }
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return intero;
    }

    // METODI per i DOUBLE
    public void setDouble(double reale) {
        this.reale = reale;
    }

    public double inputDouble() {

        boolean error = false;

        do {
            try {
                setDouble(Double.valueOf(tastiera.readLine()));
                error = false;
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return reale;
    }

    //metodo double positivo
    public double inputDoublePositivo() {

        boolean error = false;

        do {
            try {
                setDouble(Double.valueOf(tastiera.readLine()));
                error = false;

                if (reale < 0) {
                    System.out.print("Errore | Numero negativo non valido.\nRiprova: ");
                    error = true;
                }
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return reale;
    }

    //metodo double negativo
    public double inputDoubleNegativo() {

        boolean error = false;

        do {
            try {
                setDouble(Double.valueOf(tastiera.readLine()));
                error = false;

                if (reale > 0) {
                    System.out.print("Errore | Numero positivo non valido.\nRiprova: ");
                    error = true;
                }
            } catch (Exception e) {
                System.out.print("Eccezione | Input non valido.\nRiprova: ");
                error = true;
            }
        } while (error);

        return reale;
    }
}
