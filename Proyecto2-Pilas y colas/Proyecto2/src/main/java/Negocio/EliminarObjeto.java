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
public class EliminarObjeto {
    public static <T> T[] EliminarObjeto(T[] objects) throws Exception { 
        
        if (objects == null || objects.length == 0 || objects[0] == null) {
            throw new ExcepcionPersonalizada("El array está vacío");
        }
        
        if (objects.length - 1 <= 0){
            return null;
        }
        
        T[] objectsDel = (T[]) Array.newInstance(objects.getClass().getComponentType(), objects.length - 1);
        
        System.arraycopy(objects, 0, objectsDel, 0, objectsDel.length);
        
        return objectsDel;
    }
    
}
