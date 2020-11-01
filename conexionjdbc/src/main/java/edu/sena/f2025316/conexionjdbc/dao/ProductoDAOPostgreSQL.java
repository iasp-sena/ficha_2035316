/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao;

import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class ProductoDAOPostgreSQL implements ProductoDAO{

    @Override
    public void registrar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarPorId(Integer id) throws ConexionExcpetion {
        System.out.println("Hago conexión a postgresql");
        System.out.println("Consulto usuario de posgresql: " + id);
        Usuario u = new Usuario();
        u.setId(id);
        u.setNombres("Pedro");
        u.setApellidos("Díaz");
        return u;
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
