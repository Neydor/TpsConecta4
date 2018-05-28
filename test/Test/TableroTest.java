/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import conecta4.Tablero;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neydo
 */
public class TableroTest extends TestCase {

    private Tablero tablero;

    public TableroTest(String name) {
        super(name);
    }

    public void setUp() {
        tablero = new Tablero();
        
    }

    public void tearDown() {
        tablero=null;
    }
    
    public void testInicializarTablero() {
        tablero.getMatriz();
        //tablero.getMatriz()[1][1]=3;
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if(tablero.getMatriz()[i][j] != 0){
                   fail("No se inicialiazo la matriz con ceros.");
                }
            }
        }
        assertTrue("Matriz inicializada con numeros ceros", true);
    }
}
