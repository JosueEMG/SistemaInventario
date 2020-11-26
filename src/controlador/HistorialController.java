/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Historial;
import util.MySQLConexion;

/**
 *
 * @author Josue Emmanuel Medina Garcia
 */
public class HistorialController {

    public List<Historial> listadoHistorial(String nombre) {
        List<Historial> lis = new ArrayList<>();
        Connection conn = null;

        try {
            if (nombre != null) {
                conn = MySQLConexion.getConexion();
                String sql = "select h.id_historial, p.fecha_ingreso, fecha_salida, cantidad, p.nombre_producto, estado\n"
                        + "from historial h inner join productos p\n"
                        + "on h.id_producto = p.id_producto and p.nombre_producto LIKE ?;";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, "%" + nombre + "%");
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Historial h = new Historial();
                    h.setId_Historial(rs.getInt(1));
                    h.setFecha_entrada(rs.getString(2));
                    h.setFecha_salida(rs.getString(3));
                    h.setCantidad(rs.getInt(4));
                    h.setNombreProducto(rs.getString(5));
                    h.setEstado(rs.getString(6));
                    lis.add(h);
                }
            } else {
                conn = MySQLConexion.getConexion();
                String sql = "select h.id_historial, p.fecha_ingreso, fecha_salida, cantidad, p.nombre_producto, estado \n"
                        + "from historial h inner join productos p\n"
                        + "on h.id_producto = p.id_producto";
                PreparedStatement st = conn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Historial h = new Historial();
                    h.setId_Historial(rs.getInt(1));
                    h.setFecha_entrada(rs.getString(2));
                    h.setFecha_salida(rs.getString(3));
                    h.setCantidad(rs.getInt(4));
                    h.setNombreProducto(rs.getString(5));
                    h.setEstado(rs.getString(6));
                    lis.add(h);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lis;
    }
}
