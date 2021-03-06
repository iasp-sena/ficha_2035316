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
public class UsuarioDAOMySql implements UsuarioDAO{

    @Override
    public void registrar(Usuario usuario) throws ConexionExcpetion{
        try{
            PreparedStatement ps = Conexion.getInstance()
                    .prepareStatement("INSERT INTO tbl_usuarios(tipo_documento_id,numero_documento,nombres,apellidos,nombre_usuario,clave) VALUES(?,?,?,?,?,?)");
            //ps.setInt(1, usuario.getTipoDocumentoId());
            ps.setInt(1, usuario.getTipoDocumento().getId());
            ps.setString(2, usuario.getDocumento());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getApellidos());
            ps.setString(5, usuario.getNombreUsuario());
            ps.setString(6, usuario.getClave());
            ps.execute();
            ps.close();
        } catch(SQLException ex){
            throw new ConexionExcpetion(ConexionExcpetionEnum.ERROR_ACTUALIZA, ex);
        }
    }

    @Override
    public Usuario consultarPorId(Integer id) throws ConexionExcpetion {
        try {
            PreparedStatement ps = Conexion.getInstance()
                    .prepareStatement("SELECT * FROM tbl_usuarios WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Usuario u = null;
            if(rs.next()){
                u = new Usuario();
                u.setId(rs.getInt("id"));
                //u.setTipoDocumentoId(rs.getInt("tipo_documento_id"));
                u.setTipoDocumento(null);
                u.setDocumento(rs.getString("numero_documento"));
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
    public void actualizar(Usuario usuario) throws ConexionExcpetion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consularPorUsuarioClave(String usuario, String clave) throws ConexionExcpetion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
