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
public class Eliminar {
    public void eliminar(int id, Nodo raiz) throws ExcepcionPersonalizada {
        try {
            eliminarRec(id, raiz, null);
        } catch (ExcepcionPersonalizada ex) {
            throw new ExcepcionPersonalizada(ex.getMessage());
        }
    }

    private void eliminarRec(int id, Nodo actual, Nodo padre) throws ExcepcionPersonalizada {
        if (actual == null) {
            throw new ExcepcionPersonalizada("Nodo no encontrado en el árbol.");
        }

        if (id < actual.getImpresora().getId()) {
            
            eliminarRec(id, actual.getIzquierda(), actual);
            
        } else if (id > actual.getImpresora().getId()) {
            
            eliminarRec(id, actual.getDerecha(), actual);
            
        } else {

            if (actual.getIzquierda() != null && actual.getDerecha() != null) {
                
                throw new ExcepcionPersonalizada("No se puede eliminar el nodo porque tiene 2 hijos.");
                
            } else if (actual.getIzquierda() != null) {
                
                reemplazarNodoEnPadre(padre, actual, actual.getIzquierda());
                
            } else if (actual.getDerecha() != null) {
                
                reemplazarNodoEnPadre(padre, actual, actual.getDerecha());
                
            } else {
                reemplazarNodoEnPadre(padre, actual, null);
                
            }
        }
    }

    private void reemplazarNodoEnPadre(Nodo padre, Nodo actual, Nodo nuevoNodo) {
        if (padre.getIzquierda() == actual) {
            padre.setIzquierda(nuevoNodo);
        } else if (padre.getDerecha() == actual) {
            padre.setDerecha(nuevoNodo);
        }
    }
}