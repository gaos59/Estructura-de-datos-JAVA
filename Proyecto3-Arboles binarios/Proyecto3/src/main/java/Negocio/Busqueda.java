/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Nodo;

/**
 *
 * @author Gorte
 */
public class Busqueda {

    public Nodo Busqueda(int id, Nodo raiz) throws ExcepcionPersonalizada {
        try {
            return busquedaRec(raiz, id);
        } catch (ExcepcionPersonalizada ex) {
            throw new ExcepcionPersonalizada(ex.getMessage());
        }
    }

    private Nodo busquedaRec(Nodo actual, int id) throws ExcepcionPersonalizada {
        if (actual == null) {
            throw new ExcepcionPersonalizada("No se encontró impresora con el ID brindado");
        }

        if (id == actual.getImpresora().getId()) {
            return actual;
        } else if (id < actual.getImpresora().getId()) {
            return busquedaRec(actual.getIzquierda(), id);
        } else {
            return busquedaRec(actual.getDerecha(), id);
        }
    }
}