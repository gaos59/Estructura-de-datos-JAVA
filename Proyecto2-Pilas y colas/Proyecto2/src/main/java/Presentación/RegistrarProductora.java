/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentación;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import Entidades.Productora;

/**
 *
 * @author Gorte
 */
public class RegistrarProductora extends javax.swing.JFrame {
    
    MostrarProductoras mostrarProductoras;
    private int cantidadProductoras;
    /**
     * Creates new form RegistrarProductora
     * @param cantidadProductoras
     * @param mostrarProductoras
     * @throws java.lang.Exception
     */
    public RegistrarProductora(int cantidadProductoras, MostrarProductoras mostrarProductoras) throws Exception {
        initComponents();
        try {
            this.mostrarProductoras = mostrarProductoras;
            this.cantidadProductoras = cantidadProductoras;
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    mostrarProductoras.setRegistroProductoraBtnEnabled(true);

                }
            });
            
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlRegistrarProductora = new javax.swing.JPanel();
        LblDescripcion = new javax.swing.JLabel();
        TxfDescripcion = new javax.swing.JTextField();
        BtnRegresar = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar productoras");
        setResizable(false);

        LblDescripcion.setText("Descripción de la productora:");

        javax.swing.GroupLayout PnlRegistrarProductoraLayout = new javax.swing.GroupLayout(PnlRegistrarProductora);
        PnlRegistrarProductora.setLayout(PnlRegistrarProductoraLayout);
        PnlRegistrarProductoraLayout.setHorizontalGroup(
            PnlRegistrarProductoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlRegistrarProductoraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PnlRegistrarProductoraLayout.setVerticalGroup(
            PnlRegistrarProductoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlRegistrarProductoraLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(PnlRegistrarProductoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDescripcion)
                    .addComponent(TxfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        BtnRegresar.setBackground(new java.awt.Color(255, 204, 204));
        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        BtnRegistrar.setBackground(new java.awt.Color(204, 255, 255));
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlRegistrarProductora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnRegistrar)
                        .addGap(132, 132, 132)
                        .addComponent(BtnRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnlRegistrarProductora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(BtnRegresar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnRegistrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        if (TxfDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor verificar los datos brindados", "Datos pendientes", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = cantidadProductoras + 1; // Asignar un ID secuencial;
            String descripcion = TxfDescripcion.getText();
            
            Productora nuevaProductora = new Productora( id, descripcion);
        
            mostrarProductoras.RegistrarProductora(nuevaProductora);
            cantidadProductoras++;
            
            //JOptionPane.showMessageDialog(null, "Pedido agregado ID: " + nuevaProductora.getID() + "\n" + nuevaProductora.getDescripcion(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos brindados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JLabel LblDescripcion;
    private javax.swing.JPanel PnlRegistrarProductora;
    private javax.swing.JTextField TxfDescripcion;
    // End of variables declaration//GEN-END:variables
}
