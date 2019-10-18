/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class pacMan2D {

    private Nodo nodo = new Nodo();
    private Arc2D pMan;

    public pacMan2D() {
        super();
    }
/*
    Debe setear las aristas adyacentes constantemenente 
    */


    public pacMan2D(double x, double y, double w, double h, double angSt, double angExt, int closure) {
        pMan = new Arc2D.Double(x, y, w, h, angSt, angExt, closure);
        
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Arc2D getpMan() {
        return pMan;
    }

    public void setpMan(Arc2D pMan) {
        this.pMan = pMan;
    }
    
    

}
