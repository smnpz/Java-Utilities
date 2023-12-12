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
    public String Stringa() {
        
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
    public String StringaLetterale() {

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
    public String Scelta(String x, String y) {

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

    public String Data() {
        int giorno = 0, mese = 0, anno = 0;
        int giornoMax = 0;
        boolean err = false;
        boolean bisestile = false;

        String giornoStr = "", meseStr = "", annoStr = "";

        do {
            String data = Stringa();

            // Dividi la stringa della data utilizzando i caratteri '/' o '-'
            String[] partiData = data.split("[./-]");

            if (partiData.length == 3) {
                try {
                    giorno = Integer.valueOf(partiData[0]);
                    mese = Integer.valueOf(partiData[1]);
                    anno = Integer.valueOf(partiData[2]);

                    err = false;
                } catch (Exception e) {
                    System.out.print("Errore | Valori inseriti non numerici. [gg/mm/aaaa]\nRiprova:");
                    err = true;
                }
                
            } else {
                System.out.println("Formato data non valido.");
                err = true;
            }
        } while (err);

        err = false;

        //anno
        if (anno % 4 == 0) bisestile = true;

        //mese
        if (mese < 1 || mese > 12) {
            System.out.println("Errore | Mese non valido.\nRiprova: ");
            mese = InteroRange(1, 12);

            switch (mese) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    giornoMax = 31;
                    break;
                }
                case 2: {
                    if (bisestile) giornoMax = 29;
                    else giornoMax = 28;
                    break;
                }
                default: {
                    giornoMax = 30;
                    break;
                }
            }
        }

        //giorno
        if (giorno < 1 || giorno > giornoMax) {
            System.out.println("Errore | Giorno non valido.\nRiprova:");
            giorno = InteroRange(1, giornoMax);
        }

        //padding
        if (giorno < 10) giornoStr = ("0" + String.valueOf(giorno));
        else giornoStr = (String.valueOf(giorno));

        if (mese < 10) meseStr = ("0" + String.valueOf(mese));
        else meseStr = (String.valueOf(mese));

        switch(String.valueOf(anno).length()) {
            case 1: {
                annoStr = "000" + String.valueOf(anno);
                break;
            }
            case 2: {
                annoStr = "00" + String.valueOf(anno);
                break;
            }
            case 3: {
                annoStr = "0" + String.valueOf(anno);
                break;
            }
            default: {
                annoStr = String.valueOf(anno);
            }
        }

        //creazione stringa di output
        return (giornoStr + "/" + meseStr + "/" + annoStr);
    }

    // METODI per gli INTERI
    public void setIntero(int intero) {
        this.intero = intero;
    }

    public int Intero() {

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
    public int InteroRange(int min, int max) {

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
    public int InteroPositivo() {

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
    public int InteroNegativo() {

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
    public double DoublePositivo() {

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
    public double DoubleNegativo() {

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
