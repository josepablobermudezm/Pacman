/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.geom.Point2D;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class Nodo{
    
    Point2D point2D = new Point2D() {
        
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
    
    

    public void distancia() {
        this.point2D.distance(point2D);
    }
}
