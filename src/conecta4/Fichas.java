/**
 *Esta clase se encarga de precargar las imagenes de las fichas, ademas de interactuar
 * con las coordenadas donde el usuario de clic para colocar la ficha
 */
package conecta4;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Geraldine Lopez Villaneda Neydor Avila Navarrete
 *
 */
public class Fichas {

    /**
     * Estos atributos almacenan las coordenada a ser usada para pintar en la
     * ventana ademas guardan las imagenenes de las fichas a usar
     */
    private int coordenadaX;
    private int coordenadaY;
    private ImageIcon rojo;
    private ImageIcon amarillo;
    private ImageIcon verde;

    /**
     * Constructor de la clase Fichas() instancia los atributos con las rutas
     * relativas de las imagenes
     */
    public Fichas() {
        this.coordenadaX = 0;
        this.coordenadaY = 0;
        this.rojo = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/naranja.png")).getImage().getScaledInstance(113, 74, Image.SCALE_DEFAULT));
        this.verde = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/verde.png")).getImage().getScaledInstance(113, 74, Image.SCALE_DEFAULT));
        this.amarillo = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/Amarillo.png")).getImage().getScaledInstance(113, 74, Image.SCALE_DEFAULT));
    }

    /**
     * Metodo que retorna la coordenada en el eje X de la Ventana o Jframe
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Metodo recibe una coordenada X y la almacena en el atributo "coordenadaX"
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * Metodo que retorna la coordenada en el eje Y de la Ventana o Jframe
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Metodo recibe una coordenada Y y la almacena en el atributo "coordenadaY"
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * Metodo que retorna la imagen de la ficha
     */
    public ImageIcon getRojo() {
        return rojo;
    }

    /**
     * Metodo que retorna la imagen de la ficha
     */
    public ImageIcon getAmarillo() {
        return amarillo;
    }

    /**
     * Metodo que retorna la imagen de la ficha
     */
    public ImageIcon getVerde() {
        return verde;
    }

}
