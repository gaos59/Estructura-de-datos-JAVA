/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Productora;

/**
 * En está clase se agregan productoras simulando una pila
 * @author Gorte
 */
public class AgregarProductora {

    public Productora[] AgregarProductora(Productora[] productoras,Productora productoraAdd) {
       
        if (productoras == null){
            Productora[] productorasAdd = new Productora[1];
            productorasAdd[0] = productoraAdd;
            return productorasAdd;
        }
        
        Productora[] productorasAdd = new Productora [productoras.length + 1];
        for (int i = 0; i < productorasAdd.length; i++){
            if (i < productorasAdd.length - 1){
               productorasAdd[i] = productoras[i];
            }
            else {
               productorasAdd[i] = productoraAdd;
            }
        }
       return productorasAdd;
    }
    
}
