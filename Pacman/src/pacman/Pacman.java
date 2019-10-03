/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import javax.swing.JFrame;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class Pacman {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        second s = new second();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
    }
    
}
