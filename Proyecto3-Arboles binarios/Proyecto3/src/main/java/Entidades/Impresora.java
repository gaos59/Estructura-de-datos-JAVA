/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Gorte
 */
public class Impresora {
    private final int id;
    private final String marca;
    private final String tipo;
    private final double peso;

    public Impresora(int id, String marca, String tipo, double peso) {
        this.id = id;
        this.marca = marca;
        this.tipo = tipo;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }
    
}
