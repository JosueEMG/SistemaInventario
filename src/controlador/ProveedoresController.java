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
import util.MySQLConexion;
import modelo.Proveedores;
/**
 *
 * @author Lenovo
 */
public class ProveedoresController {
    
    
    public List<Proveedores> listaProveedores(String nombre) {
        List<Proveedores> lis = new ArrayList<>();
        Connection conn = null;

        try {
            if (nombre != null) {
                conn = MySQLConexion.getConexion();
                String sql = "select Id_proveedores, Nombre_proveedores from proveedores where Nombre_proveedores like ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, "%"+nombre+"%");
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Proveedores p = new Proveedores();
                    p.setId_proveedores(rs.getInt(1));
                    p.setNombre_proveedores(rs.getString(2));
                    lis.add(p);
                }
            } else {
                conn = MySQLConexion.getConexion();
                String sql = "select Id_proveedores, Nombre_proveedores from proveedores";
                PreparedStatement st = conn.prepareStatement(sql);
                //st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Proveedores p = new Proveedores();
                    p.setId_proveedores(rs.getInt(1));
                    p.setNombre_proveedores(rs.getString(2));
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
    
    public int getIdProveedor(String nombre) {
        int idProveedor = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id_proveedores from proveedores where nombre_proveedores = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                idProveedor = rs.getInt(1);
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
        return idProveedor;
    }
    
    public List<Proveedores> listaProveedoresCB() {
        List<Proveedores> lis = new ArrayList<>();
        Connection conn = null;

        try {
                conn = MySQLConexion.getConexion();
                String sql = "select Id_proveedores, Nombre_proveedores from proveedores";
                PreparedStatement st = conn.prepareStatement(sql);
                //st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Proveedores p = new Proveedores();
                    p.setId_proveedores(rs.getInt(1));
                    p.setNombre_proveedores(rs.getString(2));
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
    
    public void añadirProveedores(Proveedores p) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "insert into proveedores (Nombre_proveedores) values (?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getNombre_proveedores());
            st.executeUpdate();

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
    
    public void actualizarProveedores(String nombre, int id) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "Update proveedores set Nombre_proveedores=? where Id_proveedores=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombre);
            st.setInt(2, id);
            st.executeUpdate();

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
    
    public void eliminarProveedores(int cod) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "delete from proveedores where Id_proveedores=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, cod);
            st.executeUpdate();

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
}
