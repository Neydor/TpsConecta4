/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import conecta4.Fichas;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neydo
 */
public class FichasTest extends TestCase {

    private Fichas ficha;

    public FichasTest(String name) {
        super(name);
    }

    public void setUp() {
        ficha = new Fichas();
    }

    public void tearDown() {
        ficha = null;
    }

    public void testFicha() {
        assertTrue(ficha.getCoordenadaX()==0);
    }

}
