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
import javax.swing.text.AbstractDocument;
import javax.swing.JOptionPane;
import java.util.Iterator;
import Entidades.Pedido;
import Negocio.CustomDocumentFilter;
import Negocio.Pedidos;
import Negocio.ConvertirABinario;
import Negocio.OrdenamientoPedidos;


public final class MostrarEditarPedidos extends javax.swing.JFrame {

    /**
     * Creates new form MostrarEditarPedidos
     * @param menuPrincipal
     * @param pedidos
     */
    
    MenuPrincipal menuPrincipal;
    PedidoTableModel tableModel;
    EdicionPedido edicionPedido;
           
    public MostrarEditarPedidos(MenuPrincipal menuPrincipal, Pedidos pedidos) {    
        initComponents();
        
        this.menuPrincipal = menuPrincipal;
        
        try {                      
           RefrescarPedidos(pedidos);
            // Agregar un listener para habilitar el botón en la ventana principal cuando se cierre esta ventana
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                   menuPrincipal.setMostrarEditarPedidosBtnEnabled(true);
                }
            });
            
            BtnRefrescarTabla.addActionListener((ActionEvent e) -> {
                LimpiarTabla();
                RefrescarPedidos(pedidos);
            });
            
            BtnEditar.addActionListener((ActionEvent e) -> {
                Pedido pedidoSeleccionado =  obtenerValorSeleccionado(pedidos);
                //JOptionPane.showMessageDialog(BtnEditar, "Pedido seleccionado: " + pedidoSeleccionado.getId(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                try {
                    if (edicionPedido == null || !edicionPedido.isDisplayable()) {
                        edicionPedido = new  EdicionPedido(MostrarEditarPedidos.this, pedidoSeleccionado);
                        edicionPedido.setVisible(true);
                        BtnEditar.setEnabled(false);
                    }
                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(BtnEditar, "No se puede abrir obción de editar pedidos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            
            BtnConvertirDecimalBinario.addActionListener((ActionEvent e) -> {
                Pedido pedidoSeleccionado =  obtenerValorSeleccionado(pedidos);
                //JOptionPane.showMessageDialog(BtnEditar, "Pedido seleccionado: " + pedidoSeleccionado.getId(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                convertirDecimalBinario(pedidoSeleccionado);
            });
            
            BtnOrdenAscendente.addActionListener((ActionEvent e) -> {
                try {
                    Pedidos pedidosEnOrden = new Pedidos();
                    for (int i = 0; i < pedidos.CantidadPedidos(); i++) {
                        Pedido pedido = pedidos.ObtenerPedido(i+1);
                        pedidosEnOrden.AgregarPedido(pedido);
                    }
                    OrdenamientoPedidos.OrdenamientoPedidos(true ,pedidosEnOrden);
                    LimpiarTabla();
                    RefrescarPedidos(pedidosEnOrden);
                    
                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(BtnOrdenAscendente, "No se puede ordenar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            
            BtnOrdenDescendente.addActionListener((ActionEvent e) -> {
                try {
                    Pedidos pedidosEnOrden = new Pedidos();
                    for (int i = 0; i < pedidos.CantidadPedidos(); i++) {
                        Pedido pedido = pedidos.ObtenerPedido(i+1);
                        pedidosEnOrden.AgregarPedido(pedido);
                    }
                    OrdenamientoPedidos.OrdenamientoPedidos(false ,pedidosEnOrden);
                    LimpiarTabla();
                    RefrescarPedidos(pedidosEnOrden);
                    
                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(BtnOrdenDescendente, "No se puede ordenar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Error en la opcion mostrar y editar pedidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        AbstractDocument documentOchoDigitos = (AbstractDocument) TxfBusquedaTelefono.getDocument();
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
    
    public void EditarPedido(Pedido pedido){
        menuPrincipal.EditarPedido(pedido);
    }
    
    public void LimpiarTabla () {
        TblMostrarPedidos.removeAll();
    }
    
    public void RefrescarPedidos (Pedidos pedidos){
        Pedido[] pedidosArray = new Pedido[pedidos.CantidadPedidos()];
        Iterator <Pedido> IteradorPedidos = pedidos.ObtenerPedidos().iterator();
        for (int i = 0; IteradorPedidos.hasNext(); i++){
            pedidosArray[i] = IteradorPedidos.next();
        }
        tableModel = new PedidoTableModel(pedidosArray);
        TblMostrarPedidos.setModel(tableModel);
    }
        
    private Pedido obtenerValorSeleccionado(Pedidos pedidosSelect) {
        int selectedRow = TblMostrarPedidos.getSelectedRow();

        if (selectedRow != -1) {
            int selectedValue = Integer.parseInt(String.valueOf(TblMostrarPedidos.getValueAt(selectedRow, 0)));
            return pedidosSelect.ObtenerPedido(selectedValue);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna celda.");
            return null;
        }
    }
    
    private void convertirDecimalBinario (Pedido pedido) {
        try {
            TxtCantidadBinario.setText("ID del pedido: " + pedido.getId() + "\nCantidad: " + pedido.getCantidad() + "\nValor binario: " + ConvertirABinario.ConvertirABinario(pedido.getCantidad()));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(BtnConvertirDecimalBinario, "No se logro realizar la converción", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setEditarBtnEnabled(boolean enabled) {
        BtnEditar.setEnabled(enabled);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlControl = new javax.swing.JPanel();
        LblBusquedaTelefono = new javax.swing.JLabel();
        TxfBusquedaTelefono = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnConvertirDecimalBinario = new javax.swing.JButton();
        LblConvertirDecimalBinario = new javax.swing.JLabel();
        LblOrden = new javax.swing.JLabel();
        BtnOrdenAscendente = new javax.swing.JButton();
        BtnOrdenDescendente = new javax.swing.JButton();
        PnlVisualizacion = new javax.swing.JPanel();
        SclContenedorTablaPedidos = new javax.swing.JScrollPane();
        TblMostrarPedidos = new javax.swing.JTable();
        SclContenedorCantidadBinario = new javax.swing.JScrollPane();
        TxtCantidadBinario = new javax.swing.JTextArea();
        PnlGestionVentana = new javax.swing.JPanel();
        BtnRegresar = new javax.swing.JButton();
        BtnRefrescarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar y editar pedidos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        setResizable(false);

        LblBusquedaTelefono.setText("Buscar pedido por le número de telefono:");

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnEditar.setBackground(new java.awt.Color(209, 255, 254));
        BtnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnEditar.setText("Editar");

        BtnConvertirDecimalBinario.setText("Convertir");

        LblConvertirDecimalBinario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblConvertirDecimalBinario.setText("Convertir la cantidad del pedido seleccionado a binario:");

        LblOrden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblOrden.setText("Ordenar pedidos por:");

        BtnOrdenAscendente.setText("Acendente por telefóno");

        BtnOrdenDescendente.setText("Descendente por código de diseño");

        javax.swing.GroupLayout PnlControlLayout = new javax.swing.GroupLayout(PnlControl);
        PnlControl.setLayout(PnlControlLayout);
        PnlControlLayout.setHorizontalGroup(
            PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlControlLayout.createSequentialGroup()
                        .addComponent(LblBusquedaTelefono)
                        .addGap(18, 18, 18)
                        .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxfBusquedaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnlControlLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BtnBuscar))))
                    .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlControlLayout.createSequentialGroup()
                        .addComponent(LblOrden)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PnlControlLayout.createSequentialGroup()
                        .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnOrdenAscendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnOrdenDescendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblConvertirDecimalBinario)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlControlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnConvertirDecimalBinario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        PnlControlLayout.setVerticalGroup(
            PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlControlLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblBusquedaTelefono)
                    .addComponent(TxfBusquedaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblOrden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlControlLayout.createSequentialGroup()
                        .addComponent(BtnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblConvertirDecimalBinario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(BtnConvertirDecimalBinario))
                    .addGroup(PnlControlLayout.createSequentialGroup()
                        .addComponent(BtnOrdenAscendente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnOrdenDescendente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PnlVisualizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SclContenedorTablaPedidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TblMostrarPedidos.setBackground(new java.awt.Color(241, 249, 255));
        TblMostrarPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblMostrarPedidos.setCellSelectionEnabled(true);
        TblMostrarPedidos.setShowGrid(false);
        SclContenedorTablaPedidos.setViewportView(TblMostrarPedidos);

        TxtCantidadBinario.setEditable(false);
        TxtCantidadBinario.setColumns(20);
        TxtCantidadBinario.setRows(5);
        SclContenedorCantidadBinario.setViewportView(TxtCantidadBinario);

        javax.swing.GroupLayout PnlVisualizacionLayout = new javax.swing.GroupLayout(PnlVisualizacion);
        PnlVisualizacion.setLayout(PnlVisualizacionLayout);
        PnlVisualizacionLayout.setHorizontalGroup(
            PnlVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlVisualizacionLayout.createSequentialGroup()
                .addComponent(SclContenedorTablaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SclContenedorCantidadBinario)
                .addContainerGap())
        );
        PnlVisualizacionLayout.setVerticalGroup(
            PnlVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlVisualizacionLayout.createSequentialGroup()
                .addComponent(SclContenedorTablaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PnlVisualizacionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(SclContenedorCantidadBinario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnRegresar.setBackground(new java.awt.Color(255, 153, 153));
        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        BtnRefrescarTabla.setText("Actualizar");
        BtnRefrescarTabla.setActionCommand("");

        javax.swing.GroupLayout PnlGestionVentanaLayout = new javax.swing.GroupLayout(PnlGestionVentana);
        PnlGestionVentana.setLayout(PnlGestionVentanaLayout);
        PnlGestionVentanaLayout.setHorizontalGroup(
            PnlGestionVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlGestionVentanaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnRegresar)
                .addContainerGap())
            .addGroup(PnlGestionVentanaLayout.createSequentialGroup()
                .addGap(517, 517, 517)
                .addComponent(BtnRefrescarTabla)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlGestionVentanaLayout.setVerticalGroup(
            PnlGestionVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlGestionVentanaLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(BtnRefrescarTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRegresar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlGestionVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlVisualizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlGestionVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        if (TxfBusquedaTelefono.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Favor verificar el número telefonico faltan digitos", "Telefono incorrecto", JOptionPane.WARNING_MESSAGE);
            TxfBusquedaTelefono.requestFocusInWindow();
            return;
        }
        try {
            String Telefono = TxfBusquedaTelefono.getText();
            menuPrincipal.BuscarPedidosPorTelefono(Telefono);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnConvertirDecimalBinario;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnOrdenAscendente;
    private javax.swing.JButton BtnOrdenDescendente;
    private javax.swing.JButton BtnRefrescarTabla;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JLabel LblBusquedaTelefono;
    private javax.swing.JLabel LblConvertirDecimalBinario;
    private javax.swing.JLabel LblOrden;
    private javax.swing.JPanel PnlControl;
    private javax.swing.JPanel PnlGestionVentana;
    private javax.swing.JPanel PnlVisualizacion;
    private javax.swing.JScrollPane SclContenedorCantidadBinario;
    private javax.swing.JScrollPane SclContenedorTablaPedidos;
    private javax.swing.JTable TblMostrarPedidos;
    private javax.swing.JTextField TxfBusquedaTelefono;
    private javax.swing.JTextArea TxtCantidadBinario;
    // End of variables declaration//GEN-END:variables
}
