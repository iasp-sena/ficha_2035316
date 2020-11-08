/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao;

import edu.sena.f2025316.conexionjdbc.conexion.Conexion;
import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.exepciones.enums.ConexionExcpetionEnum;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class ProductoDAOMySql implements ProductoDAO{

    @Override
    public void registrar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarPorId(Integer id) throws ConexionExcpetion {
        try {
            PreparedStatement ps = Conexion.getInstance()
                    .prepareStatement("SELECT * FROM tbl_usuario WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Usuario u = null;
            if(rs.next()){
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNombreUsuario(rs.getString("nombre_usuario"));
                u.setClave(rs.getString("clave"));
            }
            
            return u;
        } catch (SQLException ex) {
            throw new ConexionExcpetion(ConexionExcpetionEnum.ERROR_CONSULTA, ex);
        }
    }

    @Override
    public List<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
