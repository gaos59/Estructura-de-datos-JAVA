/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Gorte
 */
import java.util.ArrayList;
import Entidades.Pedido;

public class Pedidos {
    private final ArrayList<Pedido> pedidos = new ArrayList<>();


    public void AgregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void EliminarPedido(int id) {
        pedidos.removeIf(pedido -> pedido.getId() == id);
    }
    
    public int CantidadPedidos(){
        return pedidos.size();
    }
    
    public Pedido ObtenerPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null; 
    }
    
    public void EditarPedido (int i, Pedido pedido){
        pedidos.set(i, pedido);
    }
    
    public ArrayList<Pedido> ObtenerPedidos (){
        return pedidos;
    }
    
    public boolean IsEmpty (){
        return pedidos.isEmpty();
    }
    
    
    public void VaciarPedidos(){
        pedidos.clear();
    }
}
