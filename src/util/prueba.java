package util;

import controlador.ProductoController;

public class prueba {

    public static void main(String[] args) {
        MySQLConexion.getConexion();
        controlador.ProductoController p = new ProductoController();
        System.out.println(p.getProducto(1));
    }
    
}
