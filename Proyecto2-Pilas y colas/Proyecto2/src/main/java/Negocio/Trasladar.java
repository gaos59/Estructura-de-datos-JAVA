/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.lang.reflect.Array;

/**
 *
 * @author Gorte
 */
public class Trasladar {
    public static <T> T[] Trasladar(T[] objetosOrigen, T[] objetosDestino) throws Exception { 
        if (objetosOrigen == null || objetosOrigen.length == 0 || objetosOrigen[0] == null) {
            throw new ExcepcionPersonalizada("El array de origen está vacío o es nulo");
        }
                
        if (objetosDestino == null) {
            T[] objectsDel = (T[]) Array.newInstance(objetosOrigen.getClass().getComponentType(), objetosOrigen.length);
        
        
            System.arraycopy(objetosOrigen, 0, objectsDel, 0, objetosOrigen.length);
        
        
            return objectsDel;
        }

        
        T[] objectsDel = (T[]) Array.newInstance(objetosOrigen.getClass().getComponentType(), objetosOrigen.length + objetosDestino.length);
        
        
        System.arraycopy(objetosOrigen, 0, objectsDel, 0, objetosOrigen.length);
        
        System.arraycopy(objetosDestino, 0, objectsDel, objetosOrigen.length, objetosDestino.length);
        
        return objectsDel;
    }
}
