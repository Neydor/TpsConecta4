/**
 *Clase que se encarga de validar los turnos de los jugadores, de interactuar con el tablero y las fichas para determinar que jugador ha de ganar
 * De igual forma determina las coordenadas de las 4 fichas que otorgan la victoria, para asi dibujarlas en la ventana o JFrame
 */
package conecta4;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Geraldine Lopez Villaneda Neydor Avila Navarrete
 *
 */
public class Arbitro {

    /**
     * Atributos
     */
    private Tablero tablero;
    private Fichas fichas;
    private Point conecto4[];

    /**
     * Contructor de la clase Arbitro()
     */
    public Arbitro() {
        this.tablero = new Tablero();
        this.fichas = new Fichas();
        this.conecto4 = new Point[4];
    }

    /**
     * Metodo que retorna un objeto de la Clase Tablero()
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Metodo que retorna un objeto de la Clase Fichas()
     */
    public Fichas getFichas() {
        return fichas;
    }

    /**
     * Metodo que recibe un objeto de la Clase Fichas()
     */
    public void setFichas(Fichas fichas) {
        this.fichas = fichas;
    }

    /**
     * Metodo que retorna un objeto de Clase Point() el cual sirve para obtener
     * dos coordenadas
     */
    public Point[] getConecto4() {
        return conecto4;
    }

    /**
     * Metodo que recibe un objeto de Clase Point() el cual sirve para guardar
     * dos coordenadas
     */
    public void setConecto4(Point[] conecto4) {
        this.conecto4 = conecto4;
    }

    /**
     * Metodo que recibe la posicion en la matriz para guardar que ficha fue
     * jugada en dicha matriz
     */
    public void colocarFicha(int fila, int columna, int jugador) {
        if (jugador == 1) {
            this.tablero.getMatriz()[fila][columna] = 1;
        } else {
            this.tablero.getMatriz()[fila][columna] = 2;
        }
    }

    /**
     * Metodo que valida que jugador sigue en el turno
     */
    public int validarJugador(String jugador) {
        if (jugador.equals("J1")) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Metodo que recibe dos coordenadas de matriz y transforma estas en
     * coordenadas para la ventana o JFrame
     */
    public Fichas pintarFichaTablero(int x, int y) {
        Fichas f = new Fichas();
        if (x == 100 || y == 100) {
            f.setCoordenadaX(100);
            f.setCoordenadaY(100);
        }
        if (x == 0) {
            f.setCoordenadaX(86);
        } else if (x == 1) {
            f.setCoordenadaX(172);
        } else if (x == 2) {
            f.setCoordenadaX(258);
        } else if (x == 3) {
            f.setCoordenadaX(344);
        } else if (x == 4) {
            f.setCoordenadaX(430);
        } else if (x == 5) {
            f.setCoordenadaX(515);
        } else if (x == 6) {
            f.setCoordenadaX(600);
        }
        if (y == 0) {
            f.setCoordenadaY(91);
        } else if (y == 1) {
            f.setCoordenadaY(179);
        } else if (y == 2) {
            f.setCoordenadaY(264);
        } else if (y == 3) {
            f.setCoordenadaY(351);
        } else if (y == 4) {
            f.setCoordenadaY(437);
        } else if (y == 5) {
            f.setCoordenadaY(524);
        }

        return f;
    }

    /**
     * Metodo que valida si hay empate
     */
    public boolean empate() {
        for (int i = 0; i < this.getTablero().getColumnas(); i++) {
            if (this.getTablero().getMatriz()[0][i] == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que valida si hay un ganador
     */
    public int verificarGanadorJuego() {
        int inicio = 0;
        //Si es en columna
        for (int filas = this.getTablero().getFilas() - 1; filas >= 0; filas--) {
            for (int col = 0; col < this.getTablero().getColumnas() - 3; col++) {
                inicio = this.getTablero().getMatriz()[filas][col];
                if (inicio != 0 && inicio == this.getTablero().getMatriz()[filas][col + 1]
                        && inicio == this.getTablero().getMatriz()[filas][col + 2]
                        && inicio == this.getTablero().getMatriz()[filas][col + 3]) {
                    for (int i = 0; i < 4; i++) {
                        this.getConecto4()[i] = new Point(filas, col + i);
                    }
                    return inicio;
                }
            }
        }

        //Si es en fila
        for (int filas = this.getTablero().getFilas() - 1; filas >= 3; filas--) {
            for (int col = 0; col < this.getTablero().getColumnas(); col++) {
                inicio = this.getTablero().getMatriz()[filas][col];
                if (inicio != 0
                        && inicio == this.getTablero().getMatriz()[filas - 1][col]
                        && inicio == this.getTablero().getMatriz()[filas - 2][col]
                        && inicio == this.getTablero().getMatriz()[filas - 3][col]) {
                    for (int i = 0; i < 4; i++) {
                        this.getConecto4()[i] = new Point(filas - i, col);
                    }
                    return inicio;
                }
            }
        }

        //Si es en diagonal de izquierda inferior y derecha arriba
        for (int filas = this.getTablero().getFilas() - 1; filas >= 3; filas--) {
            for (int col = 0; col < this.getTablero().getColumnas() - 3; col++) {
                inicio = this.getTablero().getMatriz()[filas][col];
                if (inicio != 0
                        && inicio == this.getTablero().getMatriz()[filas - 1][col + 1]
                        && inicio == this.getTablero().getMatriz()[filas - 2][col + 2]
                        && inicio == this.getTablero().getMatriz()[filas - 3][col + 3]) {
                    for (int i = 0; i < 4; i++) {
                        this.getConecto4()[i] = new Point(filas - i, col + i);
                    }
                    return inicio;
                }
            }
        }

        //Si es en diagonal de izquierda arriba y derecha inferior
        for (int filas = this.getTablero().getFilas() - 1; filas >= 3; filas--) {
            for (int col = this.getTablero().getColumnas() - 1; col >= 3; col--) {
                inicio = this.getTablero().getMatriz()[filas][col];
                if (inicio != 0
                        && inicio == this.getTablero().getMatriz()[filas - 1][col - 1]
                        && inicio == this.getTablero().getMatriz()[filas - 2][col - 2]
                        && inicio == this.getTablero().getMatriz()[filas - 3][col - 3]) {
                    for (int i = 0; i < 4; i++) {
                        this.getConecto4()[i] = new Point(filas - i, col - i);
                    }
                    return inicio;
                }
            }
        }

        return 0;
    }

    /**
     * Metodo que recibe un componente para pintar las 4 fichas que dan la
     * ganancia
     */
    public void dibujarConecta4Ganador(Graphics g) {
        ImageIcon j = this.getFichas().getVerde();

        for (int i = 0; i < this.getConecto4().length; i++) {
            Fichas f = this.pintarFichaTablero(this.getConecto4()[i].y, this.getConecto4()[i].x);
            g.drawImage(j.getImage(), f.getCoordenadaX() - 91, f.getCoordenadaY() + 45, null);
        }
    }

    /**
     * Mrecibe una coordenada en X y el jugador que dio clic en esa coordenada
     * retorna una coordenada matricial
     */
    public Fichas colocarFicha(int x, String jugador) {
        int player = validarJugador(jugador);
        int coorX = 100, coorY = 100;
        if (x <= 86) {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][0] == 0) {
                    this.tablero.getMatriz()[i][0] = player;
                    coorX = i;
                    coorY = 0;

                    break;
                }
            }
        } else if (x <= 172) {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][1] == 0) {
                    this.tablero.getMatriz()[i][1] = player;
                    coorX = i;
                    coorY = 1;
                    break;
                }
            }
        } else if (x <= 258) {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][2] == 0) {
                    this.tablero.getMatriz()[i][2] = player;
                    coorX = i;
                    coorY = 2;
                    break;
                }
            }
        } else if (x <= 344) {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][3] == 0) {
                    this.tablero.getMatriz()[i][3] = player;
                    coorX = i;
                    coorY = 3;
                    break;
                }
            }
        } else if (x <= 430) {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][4] == 0) {
                    this.tablero.getMatriz()[i][4] = player;
                    coorX = i;
                    coorY = 4;
                    break;
                }
            }
        } else if (x <= 515) {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][5] == 0) {
                    this.tablero.getMatriz()[i][5] = player;
                    coorX = i;
                    coorY = 5;
                    break;
                }
            }
        } else {
            for (int i = this.tablero.getFilas() - 1; i >= 0; i--) {
                if (this.tablero.getMatriz()[i][6] == 0) {
                    this.tablero.getMatriz()[i][6] = player;
                    coorX = i;
                    coorY = 6;
                    break;
                }
            }
        }

        return this.pintarFichaTablero(coorY, coorX);
    }

}
