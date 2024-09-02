/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Pelicula;

/**
 * En esta clase se agregan las películas simulando una cola.
 * @author Gorte
 */
public class AgregarPelicula {
     public Pelicula[] AgregarPelicula(Pelicula[] peliculas,Pelicula peliculaAdd) {
       
        if (peliculas == null){
            Pelicula[] peliculasAdd = new Pelicula[1];
            peliculasAdd[0] = peliculaAdd;
            return peliculasAdd;
        }
        
        Pelicula[] peliculasAdd = new Pelicula [peliculas.length + 1];
        for (int i = peliculas.length; i > 0; i--){
            peliculasAdd[i] = peliculas[i-1];
        }
        peliculasAdd[0] = peliculaAdd;
       return peliculasAdd;
    }
}
