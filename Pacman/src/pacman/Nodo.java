/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class Nodo{
    private final List <Arista> aristas_Adyacentes = new ArrayList<>();
    private final List <Nodo> nodos_Adyacentes = new ArrayList<>();
    
    public Nodo() {
    }
    
    private Point2D point2D = new Point2D() {
        
        double x;
        double y;

        @Override
        public double getX() {
            return this.x;
        }

        @Override
        public double getY() {
            return this.y;
        }

        @Override
        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }
    };

    Nodo(Double posx, Double posy) {
        point2D.setLocation(posx, posy);
    }

    public Point2D getPoint2D() {
        return point2D;
    }

    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;
    }
    
    public void distancia() {
        this.point2D.distance(point2D);
    }

    public List<Arista> getAristas_Adyacentes() {
        return aristas_Adyacentes;
    }

    public List<Nodo> getNodos_Adyacentes() {
        return nodos_Adyacentes;
    }
    
    
}
