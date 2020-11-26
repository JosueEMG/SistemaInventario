package util;

import controlador.ProductoController;
import modelo.Productos;
public class prueba {

    public static void main(String[] args) {
        ProductoController pc = new ProductoController();
        /*Productos p = new Productos();
        p.setNombre_producto("Kgada");
        p.setStock(100);
        p.setPrecio(2000);
        p.setFecha_ingreso("2020-12-10");
        p.setFecha_vencimiento("2021-12-10");
        p.setId_categoria(1);
        p.setId_proveedores(2);
        pc.anadirProducto(p, 7);*/
        
        pc.retirarProducto(100, 4);
        
    }
    
}
