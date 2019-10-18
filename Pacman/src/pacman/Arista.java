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
public class Arista {

    private Integer peso;
    private Integer pesoOriginal;
    private Nodo origen;
    private Nodo destino;
    private Integer pesoCambio;

    public Arista() {
    }

    public Arista(Integer peso, Integer pesoOriginal, Nodo origen, Nodo destino, Integer pesoCambio) {
        this.peso = peso;
        this.pesoOriginal = pesoOriginal;
        this.origen = origen;
        this.destino = destino;
        this.pesoCambio = pesoCambio;
    }

    /*public void agregarNodos(List<Nodo> nodos) {

        Point2D inicio = new Point2D(0, 0);
        Point2D fin = new Point2D(0, 0);
        Nodo aux = new Nodo();
        Nodo aux2 = new Nodo();
        for (Nodo nodo : nodos) {
            if (nodo.getCenterX() == getStartX() && nodo.getCenterY() == getStartY()) {
                setOrigen(nodo);
                nodo.getAristasAdyacentes().add(this);
                inicio = nodo.getPuntoMapa();
                aux = nodo;
            } else if (nodo.getCenterX() == getEndX() && nodo.getCenterY() == getEndY()) {
                setDestino(nodo);
                nodo.getAristasAdyacentes().add(this);
                fin = nodo.getPuntoMapa();
                aux2 = nodo;
            }
        }
        Double p = inicio.distance(fin);
        this.peso = p.intValue();
        this.pesoOriginal = this.peso;
    }*/

    Arista(Double posx, Double posy, Double posx2, Double posy2) {
        //Creo los nodos origen y destino de la ariata 
        this.origen = new Nodo(posx, posy);
        this.destino = new Nodo(posx2, posy2);
        Double p = origen.getPoint2D().distance(destino.getPoint2D());
        this.pesoOriginal  = p.intValue();
        this.peso  = p.intValue();
    }

}
