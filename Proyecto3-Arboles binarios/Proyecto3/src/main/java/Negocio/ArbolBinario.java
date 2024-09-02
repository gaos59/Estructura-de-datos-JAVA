/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Gorte
 */

import Entidades.Impresora;
import Entidades.Nodo;
import java.util.ArrayList;

public class ArbolBinario {
    private Nodo raiz;
    private int cantidadNodos;

    public ArbolBinario() {
        this.raiz = null;
        this.cantidadNodos = 0;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(Impresora impresora) throws ExcepcionPersonalizada {
        if (raiz == null) {
            raiz = new Nodo(impresora);
            cantidadNodos++;
        } else {
            new Insertar().Insertar(impresora, raiz);
            cantidadNodos++;
        }
    }
    
    public Impresora busqueda(int id) throws ExcepcionPersonalizada {
        if (raiz == null) {
            throw new ExcepcionPersonalizada("El arbol se encuentra vacío"); 
        } else {
            return new Busqueda().Busqueda(id, raiz).getImpresora();
        }
    }
    
    public void eliminar (int id) throws ExcepcionPersonalizada {
        try{            
            new Eliminar().eliminar(id, raiz); 
        }
        catch (ExcepcionPersonalizada ex){
            throw new ExcepcionPersonalizada(ex.getMessage());
        }
        
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }
    
    public String Recorrido (int tipo) throws ExcepcionPersonalizada{
        ArrayList<Impresora> resultados = new ArrayList<>();
        switch (tipo) {
            case 0 -> new Recorridos().recorridoInOrden(raiz, resultados);
            case 1 -> new Recorridos().recorridoPostOrden(raiz, resultados);
            case 2 -> new Recorridos().recorridoPreOrden(raiz, resultados);
            default -> throw new ExcepcionPersonalizada("tipo de recorrido no reconocido");
        }
        String recorrido = "";
        for(Impresora impresora:resultados){
            if (impresora.getId() != resultados.get(0).getId()) recorrido = recorrido  + " - "; 
            recorrido = recorrido + impresora.getId();
        }
        return recorrido;
    }
}
