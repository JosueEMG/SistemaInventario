/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author geanl
 */
public class Detalle {

    private int Id_Detalle;
    private String Fecha_salida;
    private int Cantidad;
    private int Id_producto;

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public int getId_Detalle() {
        return Id_Detalle;
    }

    public void setId_Detalle(int Id_Detalle) {
        this.Id_Detalle = Id_Detalle;
    }

    public String getFecha_salida() {
        return Fecha_salida;
    }

    public void setFecha_salida(String Fecha_salida) {
        this.Fecha_salida = Fecha_salida;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

  

}
