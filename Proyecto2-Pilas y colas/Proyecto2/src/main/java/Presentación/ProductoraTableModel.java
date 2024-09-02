/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentación;

import javax.swing.table.AbstractTableModel;
import Entidades.Productora;


/**
 *
 * @author Gorte
 */
public class ProductoraTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Descripcion"};
    private Productora[] productoras;

    public ProductoraTableModel(Productora[] productoras) throws Exception {
        if (productoras == null){
            throw new Negocio.ExcepcionPersonalizada("No hay productoras registradas");
        }
        if (productoras[0] == null){
            throw new Negocio.ExcepcionPersonalizada("No hay productoras registradas");
        }
        this.productoras = productoras;
    }

    @Override
    public int getRowCount() {
        return productoras.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Productora productora = productoras[rowIndex];
        return switch (columnIndex) {
            case 0 -> productora.getID();
            case 1 -> productora.getDescripcion();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
