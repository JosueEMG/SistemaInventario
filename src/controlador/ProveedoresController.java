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
    
    
    public List<Proveedores> listaProveedores() {
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
