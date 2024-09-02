/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Gorte
 */
public class ConvertirABinario {
    
    public static String ConvertirABinario(int n) {
        return switch (n) {
            case 0 -> "0";
            case 1 -> "1";
            default -> ConvertirABinario(n / 2) + (n % 2);
        };
    }
}
