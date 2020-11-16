/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.services;

import edu.sena.f2025316.appwebmaven01.dao.TipoDocumentoDAO;
import edu.sena.f2025316.appwebmaven01.dao.UsuarioDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.TipoDocumento;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ismael
 */
@Stateless
public class UsuarioService {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    
    public List<Usuario> consultaTodos() throws ConexionExcpetion{
        List<Usuario> usuarios = usuarioDAO.consultarTodos();
        return usuarios;
    }
    
    public void registrar(Usuario usuario) throws ConexionExcpetion{
        usuarioDAO.registrar(usuario);
    }
    
}
