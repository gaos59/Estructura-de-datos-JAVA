/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

/**
 *
 * @author Gorte
 */

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import Entidades.Pedido;
import Negocio.CustomDocumentFilter;
import java.awt.HeadlessException;

public class RegistroPedido extends javax.swing.JFrame {

    /**
     * Creates new form RegistroPedido
     */
    
 
    private Pedido nuevoPedido;
    MenuPrincipal menuPrincipal;
    
    public RegistroPedido(MenuPrincipal menuPrincipal) {
        initComponents();
        this.menuPrincipal = menuPrincipal;
        // Agregar un listener para habilitar el botón en la ventana principal cuando se cierre esta ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                menuPrincipal.setRegistrarPedidoBtnEnabled(true);

            }
        });
        
        CbxTipoPedido.addActionListener((ActionEvent e) -> {
            // Verificar la opción seleccionada
            String selectedOption = (String) CbxTipoPedido.getSelectedItem();
            if ("Envío a domicilio".equals(selectedOption)) {
                TxfDireccionEntrega.setEnabled(true);
            } else {
                TxfDireccionEntrega.setEnabled(false);
                TxfDireccionEntrega.setText("");
            }
        });        
        
        //Documentos que permiten modificar los valores ingresados por el usuario
        AbstractDocument documentDosDigitos = (AbstractDocument) TxfCantidad.getDocument();
        documentDosDigitos.setDocumentFilter(new CustomDocumentFilter(text -> {
            if (text.length() > 2) {
                return false;
            }
            try {
                int number = Integer.parseInt(text);
                return number >= 0 && number <= 99;
            } catch (NumberFormatException e) {
                return false;
            }
        }));
        AbstractDocument documentAlfaNumerico = (AbstractDocument) TxfCodigoDiseno.getDocument();
        documentAlfaNumerico.setDocumentFilter(new CustomDocumentFilter(text -> {
            return text.matches("[a-zA-Z0-9]*");
        }));
        AbstractDocument documentOchoDigitos = (AbstractDocument) TxfTelefonoCliente.getDocument();
        documentOchoDigitos.setDocumentFilter(new CustomDocumentFilter(text -> {
            if (text.length() > 8) {
                return false;
            }
            try {
                int number = Integer.parseInt(text);
                return number >= 0 && number <= 99999999;
            } catch (NumberFormatException e) {
                return false;
            }
        }));
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblTipoCamiseta = new javax.swing.JLabel();
        LblTalla = new javax.swing.JLabel();
        LblCantidad = new javax.swing.JLabel();
        LblCodigoDiseno = new javax.swing.JLabel();
        LblTipoPedido = new javax.swing.JLabel();
        LblDireccionEntrega = new javax.swing.JLabel();
        LblFormaPago = new javax.swing.JLabel();
        LblNumeroCliente = new javax.swing.JLabel();
        LblNombreCliente = new javax.swing.JLabel();
        CbxTipoCamiseta = new javax.swing.JComboBox<>();
        CbxTalla = new javax.swing.JComboBox<>();
        TxfCantidad = new javax.swing.JTextField();
        BtnRegresar = new javax.swing.JButton();
        TxfCodigoDiseno = new javax.swing.JTextField();
        CbxTipoPedido = new javax.swing.JComboBox<>();
        TxfDireccionEntrega = new javax.swing.JTextField();
        CbxFormaPago = new javax.swing.JComboBox<>();
        TxfTelefonoCliente = new javax.swing.JTextField();
        TxfNombreCliente = new javax.swing.JTextField();
        BtnAgregarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar pedido");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setName(""); // NOI18N
        setResizable(false);

        LblTipoCamiseta.setText("Tipo de camiseta:");

        LblTalla.setText("Talla:");

        LblCantidad.setText("Cantidad:");

        LblCodigoDiseno.setText("Codigo de diseño:");

        LblTipoPedido.setText("Tipo de pedido:");

        LblDireccionEntrega.setText("Dirección de entrega:");

        LblFormaPago.setText("Forma de pago:");

        LblNumeroCliente.setText("Número telefónico del cliente:");

        LblNombreCliente.setText("Nombre completo del cliente:");

        CbxTipoCamiseta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lisa manga larga", "Polo manga corta", "Estampado manga corta", "Lisa manga corta", "Deportiva manga larga", "Deportiva manga corta", "Deportiva sin mangas" }));

        CbxTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "2XL" }));

        BtnRegresar.setBackground(new java.awt.Color(255, 153, 153));
        BtnRegresar.setLabel("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        CbxTipoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recoger en tienda", "Envío a domicilio" }));

        TxfDireccionEntrega.setEnabled(false);

        CbxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Sinpe móvil", "Transferencia bancaria", "Tarjeta de débito/crédito" }));

        BtnAgregarPedido.setBackground(new java.awt.Color(204, 255, 255));
        BtnAgregarPedido.setText("Registrar pedido");
        BtnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarPedidoActionPerformed(evt);
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
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblNombreCliente)
                            .addComponent(LblNumeroCliente)
                            .addComponent(LblFormaPago)
                            .addComponent(LblDireccionEntrega)
                            .addComponent(LblTipoPedido)
                            .addComponent(LblCodigoDiseno)
                            .addComponent(LblCantidad)
                            .addComponent(LblTalla)
                            .addComponent(LblTipoCamiseta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbxTipoCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxfCodigoDiseno, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxfDireccionEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(BtnAgregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTipoCamiseta)
                    .addComponent(CbxTipoCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTalla)
                    .addComponent(CbxTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCantidad)
                    .addComponent(TxfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCodigoDiseno)
                    .addComponent(TxfCodigoDiseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTipoPedido)
                    .addComponent(CbxTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDireccionEntrega)
                    .addComponent(TxfDireccionEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblFormaPago)
                    .addComponent(CbxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNumeroCliente)
                    .addComponent(TxfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNombreCliente)
                    .addComponent(TxfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnAgregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(BtnRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void BtnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarPedidoActionPerformed
        
        if (TxfCodigoDiseno.getText().isEmpty() || TxfCantidad.getText().isEmpty() || TxfTelefonoCliente.getText().isEmpty() || TxfNombreCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor verificar los datos brindados", "Datos pendientes", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (TxfTelefonoCliente.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Favor verificar el número telefonico faltan digitos", "Telefono incorrecto", JOptionPane.WARNING_MESSAGE);
            TxfTelefonoCliente.requestFocusInWindow();
            return;
        }
        if ("Envío a domicilio".equals(String.valueOf(CbxTipoPedido.getSelectedItem())) && TxfDireccionEntrega.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor la dirección brindada", "Sin información", JOptionPane.WARNING_MESSAGE);
            TxfDireccionEntrega.requestFocusInWindow();
            return;
        }
        if (Integer.parseInt(TxfCantidad.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Favor verificar la cantidad", "Cantidad incorrecta", JOptionPane.WARNING_MESSAGE);
            TxfCantidad.requestFocusInWindow();
            return;
        }
        try {
            int id = menuPrincipal.GetCantidadPedidos() + 1; // Asignar un ID secuencial;
            String tipoCamiseta =(String) CbxTipoCamiseta.getSelectedItem();
            String talla =(String) CbxTalla.getSelectedItem() ;
            int cantidad =  Integer.parseInt(TxfCantidad.getText());
            String codigoDiseno = TxfCodigoDiseno.getText();
            String tipoPedido = (String) CbxTipoPedido.getSelectedItem();
            String direccionEntrega = TxfDireccionEntrega.getText();
            String formaPago = (String) CbxFormaPago.getSelectedItem();
            String telefonoCliente = TxfTelefonoCliente.getText();
            String nombreCliente = TxfNombreCliente.getText();
            
            nuevoPedido = new Pedido( id, tipoCamiseta, talla, cantidad, codigoDiseno, tipoPedido, direccionEntrega, formaPago, telefonoCliente, nombreCliente);
        
            menuPrincipal.AgregarPedido(nuevoPedido);
            
            
            JOptionPane.showMessageDialog(null, "Pedido agregado ID: " + nuevoPedido.getId() + "\n" + nuevoPedido.getTipoCamiseta(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos brindados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_BtnAgregarPedidoActionPerformed
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarPedido;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JComboBox<String> CbxFormaPago;
    private javax.swing.JComboBox<String> CbxTalla;
    private javax.swing.JComboBox<String> CbxTipoCamiseta;
    private javax.swing.JComboBox<String> CbxTipoPedido;
    private javax.swing.JLabel LblCantidad;
    private javax.swing.JLabel LblCodigoDiseno;
    private javax.swing.JLabel LblDireccionEntrega;
    private javax.swing.JLabel LblFormaPago;
    private javax.swing.JLabel LblNombreCliente;
    private javax.swing.JLabel LblNumeroCliente;
    private javax.swing.JLabel LblTalla;
    private javax.swing.JLabel LblTipoCamiseta;
    private javax.swing.JLabel LblTipoPedido;
    private javax.swing.JTextField TxfCantidad;
    private javax.swing.JTextField TxfCodigoDiseno;
    private javax.swing.JTextField TxfDireccionEntrega;
    private javax.swing.JTextField TxfNombreCliente;
    private javax.swing.JTextField TxfTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
