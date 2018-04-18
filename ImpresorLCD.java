import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private String[][] matrizImpr;

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    private int size; // Tamaño del numero
    private int filasDig; // Numero de filas por digito
    private int columDig; // Numero de columnas por digito
    private int totalFilas; // Numero total de filas de todos los digitos
    private int totalColum; // Numero total de columnas de todos los digitos

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento
     */
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {
        // Agregar linea horizontal
        if (posFija.equalsIgnoreCase(POSICION_X))
        {
            for (int y = 1; y <= size; y++)
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        }
        else // Agregar linea vertical
        {
            for (int i = 1; i <= size; i++)
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }

    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la
     * matriz
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {

        // Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
    }

    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    private void imprimirNumero(int size, String numeroImp, int espacio)
    {
        int pivotX = 0;
        char[] digitos;

        // Se calculan las variables globales
        calcularVariables(size, espacio, numeroImp);

        // Crea el arreglo de digitos
        digitos = numeroImp.toCharArray();

        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }

        // Procesa cada digito
        for (char digito : digitos) {

            // Numero que representa el caracter
            int numero = digito - 48;

            // Se calculan los puntos fijos del digito
            calcularPuntosFijos(pivotX);

            pivotX = pivotX + this.columDig + espacio;

            adicionarDigito(numero);
        }

        // Imprime matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }

     /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del
     * segmento de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */
    public void procesar(String comando, int espacioDig) {

        String[] parametros;

        int tam;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }

        // Se hace el split de la cadena
        parametros = comando.split(",");

        // Valida la cantidad de parametros
        if(parametros.length>2)
        {
           throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracteres , que los necesarios(1)");
        }

        // Valida la cantidad de parametros
        if(parametros.length<2)
        {
           throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }

        // Valida que el parametro size sea numerico
        if(isNumeric(parametros[0]))
        {
            tam = Integer.parseInt(parametros[0]);

            // Se valida que el size este entre 1 y 10
            if(tam <1 || tam >10)
            {
                throw new IllegalArgumentException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size ["
                    + parametros[0] + "] no es un numero");
        }

        // Valida que el parametro numero a imprimir sea numerico
        if(isNumeric(parametros[1]))
        {
          // Realiza la impresion del numero
          imprimirNumero(tam, parametros[1],espacioDig);
        }
        else
        {
          throw new IllegalArgumentException("Parametro numero ["
                  + parametros[1] + "] contiene caracteres no digitos");
        }
    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     *
     * Metodo que calcula las varaibles globales a usar
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    private void calcularVariables(int size, int espacio, String numeroImp){

      this.size = size;

      // Calcula el numero de filas cada digito
      this.filasDig = (2 * this.size) + 3;

      // Calcula el numero de columna de cada digito
      this.columDig = this.size + 2;

      // Calcula el total de filas de la matriz en la que se almacenaran los
      // digitos
      this.totalFilas = this.filasDig;

      // Calcula el total de columnas de la matriz en la que se almacenaran los
      // digitos
      this.totalColum = (this.columDig * numeroImp.length())
              + (espacio * (numeroImp.length()-1));

      // crea matriz para almacenar los numero a imprimir
      this.matrizImpr = new String[this.totalFilas][this.totalColum];

    }

    /**
     *
     * Metodo que calcula los puntos fijos
     *
     * @param pivotX pivote en el eje X
     */
    private void calcularPuntosFijos(int pivotX) {

      this.pf1[0] = 0;
      this.pf1[1] = 0 + pivotX;

      this.pf2[0] = (this.filasDig / 2);
      this.pf2[1] = 0 + pivotX;

      this.pf3[0] = (this.filasDig - 1);
      this.pf3[1] = 0 + pivotX;

      this.pf4[0] = (this.columDig - 1);
      this.pf4[1] = (this.filasDig / 2) + pivotX;

      this.pf5[0] = 0;
      this.pf5[1] = (this.columDig - 1) + pivotX;

    }

    /**
     *
     * Metodo que retorna variables globales
     *
     */
     public int[] getVaraiblesGlobales(){
       int [] vars = new int [4];
       vars[0] = filasDig;
       vars[1] = columDig;
       vars[2] = totalFilas;
       vars[3] = totalColum;
       return vars;
     }

    /**
     *
     * Metodo que retorna los puntos fijos
     *
     */
     public int[][] getPuntosFijos(){
       int [][] puntos = new int [5][2];
       puntos[0] = pf1;
       puntos[1] = pf2;
       puntos[2] = pf3;
       puntos[3] = pf4;
       puntos[4] = pf5;
       return puntos;
     }

     /**
      *
      * Metodo que retorna la matriz de imrpesion
      *
      */
      public String[][] getMatriz(){
        return matrizImpr;
      }
}
