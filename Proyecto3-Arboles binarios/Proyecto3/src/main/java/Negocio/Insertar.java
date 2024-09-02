/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Impresora;
import Entidades.Nodo;

/**
 *
 * @author Gorte
 */
public class Insertar {
    public void Insertar(Impresora impresora, Nodo raiz) throws ExcepcionPersonalizada {
        if (!insertarRec(raiz, impresora)) {
            throw new ExcepcionPersonalizada("No se guardó la impresora");
        }
    }

    private boolean insertarRec(Nodo actual, Impresora impresora) {
        if (impresora.getId() < actual.getImpresora().getId()) {
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(new Nodo(impresora));
                return true;
            } else {
                return insertarRec(actual.getIzquierda(), impresora);
            }
        } else if (impresora.getId() > actual.getImpresora().getId()) {
            if (actual.getDerecha() == null) {
                actual.setDerecha(new Nodo(impresora));
                return true;
            } else {
                return insertarRec(actual.getDerecha(), impresora);
            }
        }
        return false; // Este caso cubre cuando el id es igual, aunque en un árbol binario de búsqueda no deberían haber IDs iguales.
    }
}