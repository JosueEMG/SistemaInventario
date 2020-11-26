/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author geanl
 */
public class Historial {

    private int Id_Historial;
    private String Fecha_salida;
    private String Fecha_entrada;
    private int Cantidad;
    private int Id_producto;
    private String nombreProducto;
    private String estado;

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
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

    public int getId_Historial() {
        return Id_Historial;
    }

    public void setId_Historial(int Id_Historial) {
        this.Id_Historial = Id_Historial;
    }

    public String getFecha_entrada() {
        return Fecha_entrada;
    }

    public void setFecha_entrada(String Fecha_entrada) {
        this.Fecha_entrada = Fecha_entrada;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

}
