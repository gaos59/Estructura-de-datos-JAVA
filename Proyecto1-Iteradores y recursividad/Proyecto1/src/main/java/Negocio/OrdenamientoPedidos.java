/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Gorte
 */
import Entidades.Pedido;
import java.util.ArrayList;

public class OrdenamientoPedidos {

    public static ArrayList<Pedido> OrdenamientoPedidos(boolean tipoOrdenamiento, Pedidos pedidos) {
        
        ArrayList<Pedido> pedidosList = pedidos.ObtenerPedidos();
        // Copiar los datos a un arreglo primitivo de cadenas de texto
        String[] telefonosArray = new String[pedidosList.size()];
        String[] codigosDisenoArray = new String[pedidosList.size()];
        for (int i = 0; i < pedidosList.size(); i++) {
            telefonosArray[i] = pedidosList.get(i).getTelefonoCliente();
            codigosDisenoArray[i] = pedidosList.get(i).getCodigoDiseno();
        }
        
        // Elegir el tipo de ordenamiento
        if (tipoOrdenamiento){
            // Ordenar por "Número telefónico del cliente" utilizando el algoritmo por inserción
            insertionSort(telefonosArray, pedidosList); 
        }
        else {
            // Ordenar por "Código de diseño" utilizando el algoritmo Merge Sort
            mergeSort(codigosDisenoArray, 0, codigosDisenoArray.length - 1, pedidosList);    
        }
        
        return pedidosList;
    }

    // Método para el algoritmo de ordenamiento por inserción
    public static void insertionSort(String[] array, ArrayList<Pedido> pedidos) {
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            Pedido keyPedido = pedidos.get(i);
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                pedidos.set(j + 1, pedidos.get(j));
                j = j - 1;
            }
            array[j + 1] = key;
            pedidos.set(j + 1, keyPedido);
        }
    }

    // Método para el algoritmo Merge Sort
    public static void mergeSort(String[] array, int left, int right, ArrayList<Pedido> pedidos) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, pedidos);
            mergeSort(array, mid + 1, right, pedidos);
            merge(array, left, mid, right, pedidos);
        }
    }
    private static void merge(String[] array, int left, int mid, int right, ArrayList<Pedido> pedidos) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];
        Pedido[] leftPedidos = new Pedido[n1];
        Pedido[] rightPedidos = new Pedido[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
            leftPedidos[i] = pedidos.get(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
            rightPedidos[j] = pedidos.get(mid + 1 + j);
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) >= 0) {
                array[k] = leftArray[i];
                pedidos.set(k, leftPedidos[i]);
                i++;
            } else {
                array[k] = rightArray[j];
                pedidos.set(k, rightPedidos[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            pedidos.set(k, leftPedidos[i]);
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            pedidos.set(k, rightPedidos[j]);
            j++;
            k++;
        }
    }
}