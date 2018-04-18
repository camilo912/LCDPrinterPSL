# LCD refactor


Objetivo: Crear un programa que imprime números en estilo de una pantalla LCD

Entrada: La entrada contiene varias líneas. Cada línea contiene 2 números separados por coma. El primer número representa el tamaño de la impresión (entre 1 y 10, esta variable se llama “size”). El segundo número es el número a mostrar en la pantalla. Para terminar, se debe digitar 0,0. Esto terminará la aplicación.

Salida: Imprimir los números especificados usando el caracter “-“ para los caracteres horizontales, y “|” para los verticales. Cada dígito debe ocupar exactamente size+2 columnas y 2*size + 3 filas.

Entre cada impresión debe haber una línea blanca.

Ejemplo:
Entrada:
2,12345
3,67890
0,0

Salida:   
 <pre>  
   _ _  _ _        _ _
|     |    | |  | |
|  _ _| _ _| |__| |_ _
| |        |    |     |
| |_ _  _ _|    |  _ _|

 _ _ _  _ _ _   _ _ _   _ _ _   _ _ _
|            | |     | |     | |     |
|            | |     | |     | |     |
|_ _ _       | |_ _ _| |_ _ _| |     |
|     |      | |     |       | |     |
|     |      | |     |       | |     |
|_ _ _|      | |_ _ _|  _ _ _| |_ _ _|


Para la ejecución se debe primero definir debidamente las variables de ambiente JAVA_HOME,
PATH, JUNIT_HOME y CLASSPATH

Ejemplo para Ubuntu:
export JAVA_HOME = /usr/local/java-current
export PATH = $PATH:$JAVA_HOME/bin/
export JUNIT_HOME = /usr/local/JUNIT
export CLASSPATH = $CLASSPATH:$JUNIT_HOME/junit4.12.jar:.
