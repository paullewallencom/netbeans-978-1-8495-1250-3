/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package mycdcapp;


import java.awt.*;

/**
 * @author bobby
 */
public class Main extends Frame {

    public Main () {
        initComponents();
    }

    private void initComponents() {
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("Hello, World!", 80, 50);
    }
}
