/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Gorte
 */
public class Pedido {
    
    private int id;
    private String tipoCamiseta;
    private String talla;
    private int cantidad;
    private String codigoDiseno;
    private String tipoPedido;
    private String direccionEntrega;
    private String formaPago;
    private String telefonoCliente;
    private String nombreCliente;
    
    public Pedido(int id, String tipoCamiseta, String talla, int cantidad, String codigoDiseno, String tipoPedido, String direccionEntrega, String formaPago, String telefonoCliente, String nombreCliente) {
        this.id = id;
        this.tipoCamiseta = tipoCamiseta;
        this.talla = talla;
        this.cantidad = cantidad;
        this.codigoDiseno = codigoDiseno;
        this.tipoPedido = tipoPedido;
        this.direccionEntrega = direccionEntrega;
        this.formaPago = formaPago;
        this.telefonoCliente = telefonoCliente;
        this.nombreCliente = nombreCliente;
    }

    
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCamiseta() {
        return tipoCamiseta;
    }

    public void setTipoCamiseta(String tipoCamiseta) {
        this.tipoCamiseta = tipoCamiseta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoDiseno() {
        return codigoDiseno;
    }

    public void setCodigoDiseno(String codigoDiseno) {
        this.codigoDiseno = codigoDiseno;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
