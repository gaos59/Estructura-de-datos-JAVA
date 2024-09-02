/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentación;

import javax.swing.table.AbstractTableModel;
import Entidades.Pelicula;


/**
 *
 * @author Gorte
 */
public class PeliculaTableModel extends AbstractTableModel {
    private final String[] columnNames = {"DNI", "Nombre", "Genero", "Tipo Audiencia"};
    private Pelicula[] peliculas;

    public PeliculaTableModel(Pelicula[] peliculas) throws Exception {
         if (peliculas == null){
            throw new Negocio.ExcepcionPersonalizada ("No hay películas registradas");
        }
        if (peliculas[0] == null){
            throw new Negocio.ExcepcionPersonalizada ("No hay películas registradas");
        }
        this.peliculas = peliculas;
    }

    @Override
    public int getRowCount() {
        return peliculas.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pelicula pelicula = peliculas[rowIndex];
        return switch (columnIndex) {
            case 0 -> pelicula.getDNI();
            case 1 -> pelicula.getNombre();
            case 2 -> pelicula.getGenero();
            case 3 -> pelicula.getTipoAudiencia();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
