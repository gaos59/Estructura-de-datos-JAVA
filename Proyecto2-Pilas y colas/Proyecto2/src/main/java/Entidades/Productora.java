/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


/**
 *
 * @author Gorte
 */
public class Productora {
    private final int ID;
    private String Descripcion;
    private Pelicula[] peliculas = null;

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public Productora(int ID, String Descripcion) {
        this.ID = ID;
        this.Descripcion = Descripcion;
    }

    public int getID() {
        return ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
