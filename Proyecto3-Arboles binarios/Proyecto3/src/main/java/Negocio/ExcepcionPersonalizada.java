/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Gorte
 */
public  class ExcepcionPersonalizada extends Exception {
    public ExcepcionPersonalizada() {
        super();
    }

    public ExcepcionPersonalizada(String message) {
        super(message);
    }

    public ExcepcionPersonalizada(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionPersonalizada(Throwable cause) {
        super(cause);
    }
    
}
