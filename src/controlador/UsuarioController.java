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
import josueemg.SimpleAlert;
import modelo.Usuario;
import util.MySQLConexion;

/**
 *
 * @author Lenovo
 */
public class UsuarioController {
    
    
    public List<Usuario> listaUsuarios(String nombre) {
        List<Usuario> lis = new ArrayList<>();
        Connection conn = null;

        try {
            if (nombre != null) {
                conn = MySQLConexion.getConexion();
                String sql = "select Id, Nombre, DNI, Correo, Nombre_tipo from usuario u inner join tipo_usuario t where u.Id_tipo=t.Id_tipo and Nombre like ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, "%"+nombre+"%");
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Usuario p = new Usuario();
                    p.setId(rs.getInt(1));
                    p.setNombre(rs.getString(2));
                    p.setDni(rs.getInt(3));
                    p.setCorreo(rs.getString(4));
                    p.setNombre_tipo(rs.getString(5));
                    lis.add(p);
                }
            } else {
                conn = MySQLConexion.getConexion();
                String sql = "select Id, Nombre, DNI, Correo, Nombre_tipo from usuario u inner join tipo_usuario t where u.Id_tipo=t.Id_tipo";
                PreparedStatement st = conn.prepareStatement(sql);
                //st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                //llenar el arraylist con la clase entidad
                while (rs.next()) {
                    Usuario p = new Usuario();
                    p.setId(rs.getInt(1));
                    p.setNombre(rs.getString(2));
                    p.setDni(rs.getInt(3));
                    p.setCorreo(rs.getString(4));
                    p.setNombre_tipo(rs.getString(5));
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
    
    public void añadirUsuarios(Usuario u) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "insert into usuario (Nombre, DNI, Contraseña, Correo, Id_tipo) values (?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getNombre());
            st.setInt(2, u.getDni());
            st.setString(3, u.getContraseña());
            st.setString(4, u.getCorreo());
            st.setInt(5, 2);
            st.executeUpdate();

        } catch (Exception ex) {
            SimpleAlert.showMessaje(null, true, "El DNI ya se encuentra registrado en el sistema");
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
    }
    
    public void eliminarUsuarios(int cod) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "delete from usuario where Id=?";
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
    
    public int userVerify(String dni, String passWord) {
        Connection conn = null;
        String userPassWord = "";
        int id = 0;
        int userId = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id, contraseña from usuario where DNI = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                userPassWord = rs.getString(2);
            }
            if (userPassWord.equals(passWord)) {
                userId = id;
            }
            else {
                userId = 0;
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
        return userId;
    }
    
    public Usuario getUsuario(int id) {
        Usuario u = null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id, nombre, dni ,contraseña, correo, t.nombre_tipo, u.id_tipo \n"
                    + "from usuario u inner join tipo_usuario t \n"
                    + "on u.id_tipo = t.id_tipo where id = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setDni(rs.getInt(3));
                u.setContraseña(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setNombre_tipo(rs.getString(6));
                u.setId_tipo(rs.getInt(7));
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
        return u;
    }
    
    public void actualizarUsuario(String nombre, int dni, String contra, String correo, int id) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "Update usuario set Nombre=?, DNI=?, Contraseña=?, Correo=? where Id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombre);
            st.setInt(2, dni);
            st.setString(3, contra);
            st.setString(4, correo);
            st.setInt(5, id);
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
