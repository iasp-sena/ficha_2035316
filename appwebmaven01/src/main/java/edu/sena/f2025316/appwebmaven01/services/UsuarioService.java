/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.services;

import edu.sena.f2025316.appwebmaven01.dao.def.TipoDocumentoDAO;
import edu.sena.f2025316.appwebmaven01.dao.def.UsuarioDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.filtros.FiltroUsuario;
import edu.sena.f2025316.appwebmaven01.modelo.TipoDocumento;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Usuario consultarPorUsuarioYClave(String nombreUsuario, String clave) throws ConexionExcpetion {
        return usuarioDAO.consularPorUsuarioClave(nombreUsuario, clave);
    }

    public List<Usuario> buscarPorFiltro(FiltroUsuario filtro) throws ConexionExcpetion {
        if(filtro.isValid()){
            return usuarioDAO.consultarPorFiltro(filtro);
        } 
        return new ArrayList<>();
    }
    
}
