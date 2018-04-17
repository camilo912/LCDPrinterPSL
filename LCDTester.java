import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//import javax.swing.JOptionPane;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {

        List<String> listaComando = new ArrayList<>();
        String comando;
        int espacioDig;

        try {
            Scanner lector = new Scanner(System.in);

            System.out.print("Espacio entre Digitos (0 a 5): ");
            comando = lector.next();

            // valida que el comando ingresado si es un numero
            if (ImpresorLCD.isNumeric(comando))
            {
                espacioDig = Integer.parseInt(comando);

                // se valida que el espaciado este entre 0 y 5
                if(espacioDig <0 || espacioDig >5)
                {
                    throw new IllegalArgumentException("El espacio entre "
                            + "digitos debe estar entre 0 y 5");
                }

            }
            else
            {
                throw new IllegalArgumentException("Cadena " + comando
                        + " no es un entero");
            }

            //lee cada comando
            System.out.print("Entrada: ");
            comando = lector.next();
            while(!comando.equalsIgnoreCase(CADENA_FINAL)){
              listaComando.add(comando);
              System.out.print("Entrada: ");
              comando = lector.next();
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();

            //procesa cada comando
            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext())
            {
              impresorLCD.procesar(iterator.next(), espacioDig);
            }
        } catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }

}
