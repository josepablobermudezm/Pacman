/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author Jose Pablo Bermudez
 */
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class second extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 434, y = 392, velx = 0, vely = 0;
    int code = 39;//por default a la derecha
    int cont = 0;
    int gameStatus = 0;
    int xAux = 434;
    int yAux = 392;
    int jAux = 14;
    int iAux = 14;
    boolean up = false, down = false, left = false, right = false;

    public second() {
        //inicializa los listener

        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    char Mapa[][]
            = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', '*', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', '*', '*', '*', '*', '*', '*', '*', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    //Los asteriscos son para que no aparezcan puntos dentro de la casa de los fantasmas
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //GameStatus es como para saber en que pantalla se está
        if (gameStatus == 0) {//gameStatus = 0 significa que se está en la pantalla del menú
            File f = new File(".");
            String dir = f.getAbsolutePath();
            ImageIcon i = new ImageIcon(dir + "\\src\\resources\\fondo3.jpg");
            i.paintIcon(this, g, 0, 0);
            g.setFont(new Font("Arial", 1, 40));
            g.setColor(Color.WHITE);
            g.drawString("Presione espacio para continuar", 170, 590);
        }
        if (gameStatus == 1) {//gameStatus = 1 significa que está en el nivel 1
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fill(new Rectangle(0, 0, 900, 645));//fondo
            //los System.out.print son para imprimir la matriz lógica, de hecho no está funcionando por el cambio de los puntos
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 29; j++) {
                    if (Mapa[i][j] == 'X') {//pared
                        //System.out.print("X");
                        g2.setColor(new Color(46, 55, 130));
                        g2.fillRect(j * 31, i * 28, 31, 28);//tamaño y posición del cada uno de los rectangulos
                    } else if (Mapa[i][j] == '@') {//pacman
                        //System.out.print("@");
                        g2.setColor(Color.YELLOW);
                        g2.fill(new Arc2D.Double(x, y, 23, 23, (code == 39) ? 30 : (code == 37) ? 210 : (code == 38) ? 120 : 300, 300, Arc2D.PIE));
                        //x, y son las posiciones del pacman, van a ir cambiando dependiendo de que tecla se use
                    } else if (Mapa[i][j] == ' ') {//espacio en blanco
                        g2.setColor(Color.WHITE);
                        g2.fillOval(j * 31 + 10, i * 29 + 5, 4, 4);
                        //Aquí están los puntos para comerse, hay que ver como acomodarlos,
                        //System.out.print(" ");
                    }
                }
                //System.out.print("\n");
            }
            //System.out.println();
            g.setFont(new Font("Showcard Gothic", 1, 20));
            g.setColor(Color.WHITE);
            g.drawString("Puntos: " + cont*10, 0, 585);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        //reviza que si hay un campo al frente, atras, derecha o a la izquierda y ese campo es X, osea una pared. En el caso que pase eso y no se este yendo en 
        //esa dirección aumenta sin ningún problema
        if ((Mapa[iAux][jAux + 1] != 'X' && right) || (Mapa[iAux][jAux - 1] != 'X' && left) || (Mapa[iAux + 1][jAux] != 'X' && down) || (Mapa[iAux - 1][jAux] != 'X' && up)) {
            x += velx;
            y += vely;
        } else {
            //está tratando de ir contra una pared
        }
        //iAux y jAux, empiezan en 14, que es la posición del pacman en la matriz,
        //la resta y suma de 31 y 28 y por el tamaño de los rectangulos en el mapa

        //Si la posición del pacman es 31/28 pixeles(un rectangulo) menos/mas que la posición que tenía anterior lo muevo en la matriz, después actualizo la posición
        if (x == xAux - 31) {
            if (Mapa[iAux][jAux - 1] == ' ') {//cont sería la suma de los puntos totales, en el caso que sea un espacio en blanco quiere decir que nunca se ha pasado por ahí
                cont++;
            }
            Mapa[iAux][jAux - 1] = '@';
            Mapa[iAux][jAux] = '.';//Poniendo un punto después de que el pacman haya estado en ese lugar hace no se vayan a repintar los puntos
            jAux--;
            xAux = xAux - 31;
        }
        if (x == xAux + 31) {
            if (Mapa[iAux][jAux + 1] == ' ') {//cont sería la suma de los puntos totales, en el caso que sea un espacio en blanco quiere decir que nunca se ha pasado por ahí
                cont++;
            }
            Mapa[iAux][jAux + 1] = '@';
            Mapa[iAux][jAux] = '.';
            jAux++;
            xAux = xAux + 31;
        }
        if (y == yAux - 28) {
            if (Mapa[iAux-1][jAux] == ' ') {//cont sería la suma de los puntos totales, en el caso que sea un espacio en blanco quiere decir que nunca se ha pasado por ahí
                cont++;
            }
            Mapa[iAux - 1][jAux] = '@';
            Mapa[iAux][jAux] = '.';
            iAux--;
            yAux = yAux - 28;
        }
        if (y == yAux + 28) {
            if (Mapa[iAux+1][jAux] == ' ') {//cont sería la suma de los puntos totales, en el caso que sea un espacio en blanco quiere decir que nunca se ha pasado por ahí
                cont++;
            }
            Mapa[iAux + 1][jAux] = '@';
            Mapa[iAux][jAux] = '.';
            iAux++;
            yAux = yAux + 28;
        }
    }

    ///La velocidad a la que se mueve el pacman por cada "frame"
    public void up() {
        vely = -1;
        velx = 0;
    }

    public void down() {
        vely = 1;
        velx = 0;
    }

    public void left() {
        velx = -1;
        vely = 0;
    }

    public void right() {
        velx = 1;
        vely = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            up = true;
            up();
        } else {
            up = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            down = true;
            down();
        } else {
            down = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            right = true;
            right();
        } else {
            right = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            left = true;
            left();
        } else {
            left = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            gameStatus = 1;//lo envía al primer nivel
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
