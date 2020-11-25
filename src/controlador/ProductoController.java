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
import modelo.Productos;
import util.MySQLConexion;

/**
 *
 * @author Lenovo
 */
public class ProductoController {
    
    
    public List<Productos> listaProductoxCategoria(int cod) {
        List<Productos> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre "
                    + " from productos p, proveedores pro, usuario u, categoria c "
                    + " where p.Id_proveedores=pro.Id_proveedores "
                    + " and p.Id_Usuario=u.Id "
                    + " and p.Id_categoria=c.Id_categoria "
                    + " and p.Id_categoria=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, cod);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Productos p = new Productos();
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setPrecio(rs.getDouble(4));
                p.setFecha_ingreso(rs.getString(5));
                p.setFecha_vencimiento(rs.getString(6));
                p.setNombre_categoria(rs.getString(7));
                p.setNombre_proveedores(rs.getString(8));
                p.setNombre(rs.getString(9));
                lis.add(p);
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
    
    public List<Productos> listaProducto() {
        List<Productos> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre "
                    + " from productos p, proveedores pro, usuario u, categoria c "
                    + " where p.Id_proveedores=pro.Id_proveedores "
                    + " and p.Id_Usuario=u.Id "
                    + " and p.Id_categoria=c.Id_categoria ";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Productos p = new Productos();
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setPrecio(rs.getDouble(4));
                p.setFecha_ingreso(rs.getString(5));
                p.setFecha_vencimiento(rs.getString(6));
                p.setNombre_categoria(rs.getString(7));
                p.setNombre_proveedores(rs.getString(8));
                p.setNombre(rs.getString(9));
                lis.add(p);
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
    
    public List<Productos> listaProductoxNombre(String consulta) {
        List<Productos> lis = new ArrayList<>();
        Connection conn = null;

        try {
            if(consulta!=null){
                conn = MySQLConexion.getConexion();
                String sql = "select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre "
                        + " from productos p, proveedores pro, usuario u, categoria c "
                        + " where p.Id_proveedores=pro.Id_proveedores "
                        + " and p.Id_Usuario=u.Id "
                        + " and p.Id_categoria=c.Id_categoria "
                        + " and Nombre_Producto like ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, "%"+consulta+"%");
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Productos p = new Productos();
                    p.setId_producto(rs.getInt(1));
                    p.setNombre_producto(rs.getString(2));
                    p.setStock(rs.getInt(3));
                    p.setPrecio(rs.getDouble(4));
                    p.setFecha_ingreso(rs.getString(5));
                    p.setFecha_vencimiento(rs.getString(6));
                    p.setNombre_categoria(rs.getString(7));
                    p.setNombre_proveedores(rs.getString(8));
                    p.setNombre(rs.getString(9));
                    lis.add(p);
                }
            }else{
                conn = MySQLConexion.getConexion();
                String sql = "select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre "
                        + " from productos p, proveedores pro, usuario u, categoria c "
                        + " where p.Id_proveedores=pro.Id_proveedores "
                        + " and p.Id_Usuario=u.Id "
                        + " and p.Id_categoria=c.Id_categoria";
                PreparedStatement st = conn.prepareStatement(sql);
                //st.setInt(1, cod);
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Productos p = new Productos();
                    p.setId_producto(rs.getInt(1));
                    p.setNombre_producto(rs.getString(2));
                    p.setStock(rs.getInt(3));
                    p.setPrecio(rs.getDouble(4));
                    p.setFecha_ingreso(rs.getString(5));
                    p.setFecha_vencimiento(rs.getString(6));
                    p.setNombre_categoria(rs.getString(7));
                    p.setNombre_proveedores(rs.getString(8));
                    p.setNombre(rs.getString(9));
                    lis.add(p);
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
