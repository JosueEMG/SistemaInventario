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
import modelo.Categoria;
import util.MySQLConexion;

/**
 *
 * @author Josue Emmanuel Medina Garcia
 */
public class CategoriaControlller {

    public List<Categoria> listadoCategoria() {
        List<Categoria> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id_categoria, nombre_categoria from categoria;";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(rs.getInt(1));
                c.setNombre_Categoria(rs.getString(2));
                lis.add(c);
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
    
    public int getIdCategoria(String nombre) {
        int idCategoria = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id_categoria from categoria where nombre_categoria = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                idCategoria = rs.getInt(1);
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
        return idCategoria;
    }
    
    public void addCategoria(String nombre) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "insert into categoria (nombre_categoria) values (?);";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombre);
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
    
    public void removeCategoria(String nombre) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "delete from categoria where nombre_categoria = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombre);
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
}
