/*
 * Clase que se encarga de albergar el tablero o matriz donde se almacena 
 * en forma de numeros las fichas que cada jugador tira.
 */
package conecta4;

/**
 *
 * @author Geraldine Lopez Villaneda Neydor Avila Navarrete
 *
 */
public class Tablero {

    /**
     * Atributos donde definen los numeros de filas y columnas de la matriz
     * Estos son siempre estaticos
     */
    private int filas = 6, columnas = 7;
    private int matriz[][] = new int[filas][columnas];

    /**
     * Constructor de la clase Tablero()
     */
    public Tablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.matriz[i][j] = 0;
            }
        }

    }

    /**
     * Metodo que retorna la matriz donde se almacena los movimientos de las
     * fichas de los jugadores
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * Metodo que retorna el numero de filas de la matriz
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Metodo que retorna el numero de columnas de la matriz
     */
    public int getColumnas() {
        return columnas;
    }

}
