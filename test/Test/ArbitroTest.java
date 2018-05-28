/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import conecta4.Arbitro;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neydo
 */
public class ArbitroTest extends TestCase {

    private Arbitro arbitro;

    public ArbitroTest(String name) {
        super(name);
    }

    public void setUp() {
        arbitro = new Arbitro();
    }

    public void tearDown() {
        arbitro = null;
    }

    public void testGetTablero() {

        arbitro.getTablero().getMatriz();
        //tablero.getMatriz()[1][1]=3;
        for (int i = 0; i < arbitro.getTablero().getFilas(); i++) {
            for (int j = 0; j < arbitro.getTablero().getColumnas(); j++) {
                if (arbitro.getTablero().getMatriz()[i][j] != 0) {
                    fail("No se inicialiazo la matriz con ceros.");
                }
            }
        }
        assertTrue("Matriz inicializada con numeros ceros", true);
    }

    public void testValidarJugador() {
        String jugador1 = "J1";
        String jugador2 = "J2";
        assertTrue(arbitro.validarJugador(jugador1) == 1
                && arbitro.validarJugador(jugador1) == 1);
    }

    public void testPintatFicha() {
        int x = 430, y = 264;
        assertTrue(arbitro.pintarFichaTablero(4, 2).getCoordenadaX() == x
                && arbitro.pintarFichaTablero(4, 2).getCoordenadaY() == y);
    }
    
}
