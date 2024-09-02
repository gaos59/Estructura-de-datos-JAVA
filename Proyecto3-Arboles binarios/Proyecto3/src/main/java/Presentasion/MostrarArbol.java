/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentasion;

import Entidades.Nodo;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gorte
 */
public class MostrarArbol extends javax.swing.JFrame {

    private javax.swing.JButton BtnRegresar;
    Nodo raiz;
    
    public MostrarArbol(String title, MenuPrincipal menuPrincipal, Nodo raiz) throws HeadlessException {
        super(title);
        this.raiz = raiz;
        initComponents();
        addWindowListener(new WindowAdapter() {                        
            @Override                
            public void windowClosed(WindowEvent e) {            
                menuPrincipal.setMostrarBtnEnabled(true);                
            }            
        });
    }
         
    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.dispose();
    }  
    
    private void initComponents() {
        BtnRegresar = new javax.swing.JButton();
        GraficarArbol ga = new GraficarArbol(raiz);
        setResizable(false);
        
        BtnRegresar.setBackground(new java.awt.Color(255, 204, 204));
        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ga)))
                        .addGap(0, 574, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnRegresar)
                .addContainerGap())
        );

        pack();
    }
}
