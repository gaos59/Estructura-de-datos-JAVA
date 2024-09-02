/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Gorte
 */
public class Pelicula {
    private final String  DNI;
    private String Nombre;
    private String Genero;
    private String TipoAudiencia;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getTipoAudiencia() {
        return TipoAudiencia;
    }

    public void setTipoAudiencia(String TipoAudiencia) {
        this.TipoAudiencia = TipoAudiencia;
    }

    public Pelicula(String DNI, String Nombre, String Genero, String TipoAudiencia) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.TipoAudiencia = TipoAudiencia;
    }
}
