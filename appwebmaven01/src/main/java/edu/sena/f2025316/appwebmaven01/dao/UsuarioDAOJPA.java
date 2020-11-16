/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao;

import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author ismael
 */
@Stateless
public class UsuarioDAOJPA extends GenericDAO<Usuario, Integer>implements UsuarioDAO{
    
    public UsuarioDAOJPA(){
        super(Usuario.class);
    }

    @Override
    public Usuario consularPorUsuarioClave(String usuario, String clave) throws ConexionExcpetion {
        return null;
    }
    
}
