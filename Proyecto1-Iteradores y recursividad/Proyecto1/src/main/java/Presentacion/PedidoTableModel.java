/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;
import Entidades.Pedido;


/**
 *
 * @author Gorte
 */
public class PedidoTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Tipo de camiseta", "Talla", "Cantidad", "Código de diseño", "Tipo", "Dirección", "Forma de pago", "Número telefónico", "Nombre"};
    private Pedido[] pedidos;

    public PedidoTableModel(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getRowCount() {
        return pedidos.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = pedidos[rowIndex];
        switch (columnIndex) {
            case 0:
                return pedido.getId();
            case 1:
                return pedido.getTipoCamiseta();
            case 2:
                return pedido.getTalla();
            case 3:
                return pedido.getCantidad();
            case 4:
                return pedido.getCodigoDiseno();
            case 5:
                return pedido.getTipoPedido();
            case 6:
                return pedido.getDireccionEntrega();
            case 7:
                return pedido.getFormaPago();
            case 8:
                return pedido.getTelefonoCliente();
            case 9:
                return pedido.getNombreCliente();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
