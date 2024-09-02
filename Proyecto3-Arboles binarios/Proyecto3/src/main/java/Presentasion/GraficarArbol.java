/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentasion;

import Entidades.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Gorte
 */
public class GraficarArbol extends JComponent {
    private Nodo raiz;

    public GraficarArbol(Nodo raiz) {
        this.raiz = raiz;
    }
        
    protected void paintComponent(Graphics g) {
        /*Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(50,75,100,250);
        g2d.setColor(Color.red);
        g2d.fill(r);*/
        super.paintComponent(g);        
        if (raiz != null) {
            g.setFont(new Font("Arial", Font.BOLD, 14));
            dibujarNodo(g, raiz, getWidth() / 2, 30, getWidth() / 4);
        }
    }
    
    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int xOffset) {
        if (nodo == null) return;

        // Dibuja la línea de la izquierda
        if (nodo.getIzquierda() != null) {
            g.drawLine(x, y, x - xOffset, y + 50);
            dibujarNodo(g, nodo.getIzquierda(), x - xOffset, y + 50, xOffset / 2);
        }

        // Dibuja la línea de la derecha
        if (nodo.getDerecha() != null) {
            g.drawLine(x, y, x + xOffset, y + 50);
            dibujarNodo(g, nodo.getDerecha(), x + xOffset, y + 50, xOffset / 2);
        }
        
        // Dibuja el nodo
        g.setColor(Color.YELLOW);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(nodo.getImpresora().getId()), x - 5, y + 5);
    }
}
