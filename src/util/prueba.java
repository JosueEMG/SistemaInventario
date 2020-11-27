package util;

import controlador.HistorialController;
import controlador.ProductoController;
import controlador.ProveedoresController;
import modelo.Productos;
public class prueba {

    public static void main(String[] args) {
        HistorialController h = new HistorialController();
        
        h.listadoHistorial("").forEach((p)->{
            System.out.println(p.getCantidad());
        });
        
    }
    
}
