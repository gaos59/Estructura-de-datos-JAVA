/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Impresora;
import Entidades.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Gorte
 */
public class Recorridos {
    public void recorridoPreOrden(Nodo nodo, ArrayList<Impresora> resultado) {
        if (nodo != null) {
            resultado.add(nodo.getImpresora());
            recorridoPreOrden(nodo.getIzquierda(), resultado);
            recorridoPreOrden(nodo.getDerecha(), resultado);
        }
    }

    public void recorridoPostOrden(Nodo nodo, ArrayList<Impresora> resultado) {
        if (nodo != null) {
            recorridoPostOrden(nodo.getIzquierda(), resultado);
            recorridoPostOrden(nodo.getDerecha(), resultado);
            resultado.add(nodo.getImpresora());
        }
    }

    public void recorridoInOrden(Nodo nodo, ArrayList<Impresora> resultado) {
        if (nodo != null) {
            recorridoInOrden(nodo.getIzquierda(), resultado);
            resultado.add(nodo.getImpresora());
            recorridoInOrden(nodo.getDerecha(), resultado);
        }
    }
}
