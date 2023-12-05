import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ControlloInput {

    private int intero;
    private float virgola1;
    private double virgola2;
    private String stringa;
    private Boolean bool;
    private char carattere;

    //metodi stringhe
    public void setStringa(String s) {
        stringa = s;
    }

    public String getStringa() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setStringa(tastiera.readLine());
                err = false;
            } catch (Exception e) {
                System.out.println("errore");
                err = true;
            }
        } while (err);

        return stringa;
    }

    public String getStringaLetterale() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setStringa(tastiera.readLine());
                err = false;

                for (int i = 0; i < stringa.length(); i++) {
                    char c = stringa.charAt(i);
                    if (!Character.isLetter(c)) {
                        System.out.print("la stringa inserita contiene dei caratteri non validi, riprova: ");
                        err = true;
                    }
                }

            } catch (Exception e) {
                System.out.println("errore");
                err = true;
            }
        } while (err);

        return stringa;
    }

    //metodi interi
    public void setIntero(int i) {
        intero = i;
    }

    public int getIntero() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));
                err = false;
            } catch (Exception e) {
                System.out.println("errore");
                err = true;
            }
        } while (err);

        return intero;
    }

    public int getInteroRange(int min, int max) {
        //oggetti input
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        //variabili locali
        boolean err = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));

                //controllo se é troppo piccolo
                if (intero < min || intero > max) {
                    System.out.print("il numero inserito non rientra nel range [" + min + "]-" + "[" + max + "] | Riprova:");
                    err = true;
                } else err = false;

            } catch (Exception e) {
                System.out.print("input non valido | Riprova: ");
                err = true;
            }
        } while (err);

        return intero;
    }

    public int getInteroPositivo() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setIntero(Integer.valueOf(tastiera.readLine()));
                err = false;

                if (intero < 0) {
                    System.out.print("numero negativo non valido, riprova: ");
                    err = true;
                }
            } catch (Exception e) {
                System.out.print("errore, inserire un input valido: ");
                err = true;
            }
        } while (err);

        return intero;
    }

    //metodi double
    public void setDouble(double d) {
        this.virgola2 = d;
    }

    public double getDouble() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setDouble(Double.valueOf(tastiera.readLine()));
                err = false;
            } catch (Exception e) {
                System.out.print("errore | riprova:");
                err = true;
            }
        } while (err);

        return virgola2;
    }

    public double getDoublePositivo() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setDouble(Double.valueOf(tastiera.readLine()));
                err = false;

                if (virgola2 < 0) {
                    System.out.print("numero negativo non valido | riprova: ");
                    err = true;
                }
            } catch (Exception e) {
                System.out.print("errore | inserire un input valido: ");
                err = true;
            }
        } while (err);

        return virgola2;
    }

    //metodi booleani
    public void setBool(boolean b) {
        bool = b;
    }

    public boolean getBool() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        boolean err = false;

        do {
            try {
                setBool(Boolean.valueOf(tastiera.readLine()));
                err = false;
            } catch (Exception e) {
                System.out.println("errore");
                err = true;
            }
        } while (err);

        return bool;
    }
}
