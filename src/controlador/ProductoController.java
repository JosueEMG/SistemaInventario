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
    
    public void modificarProducto(Productos p, int idProducto) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "update productos set nombre_producto = ?, precio = ?, fecha_ingreso = ?, fecha_vencimiento = ?, id_categoria = ?, id_proveedor = ?, stock = ? where id_producto = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getNombre_producto());
            st.setDouble(2, p.getPrecio());
            st.setString(3, p.getFecha_ingreso());
            st.setString(4, p.getFecha_vencimiento());
            st.setInt(5, p.getId_categoria());
            st.setInt(6, p.getId_proveedores());
            st.setInt(7, p.getStock());
            st.executeUpdate();
            //llenar el arraylist con la clase entidad
            
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
    }
    
    public Productos getProducto(int idProducto) {
        Productos p = null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select  nombre_producto, precio, fecha_ingreso, fecha_vencimiento, nombre_categoria, nombre_proveedores, stock \n" +
            "from productos p, proveedores pro, usuario u, categoria c \n" +
            "where p.Id_proveedores=pro.Id_proveedores \n" +
            "and p.Id_Usuario=u.Id \n" +
            "and p.Id_categoria=c.Id_categoria\n" +
            "and id_producto = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idProducto);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            if (rs.next()) {
                p = new Productos();
                p.setNombre_producto(rs.getString(1));
                p.setPrecio(rs.getDouble(2));
                p.setFecha_ingreso(rs.getString(3));
                p.setFecha_vencimiento(rs.getString(4));
                p.setNombre_categoria(rs.getString(5));
                p.setNombre_proveedores(rs.getString(6));
                p.setStock(rs.getInt(3));
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
        return p;
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
