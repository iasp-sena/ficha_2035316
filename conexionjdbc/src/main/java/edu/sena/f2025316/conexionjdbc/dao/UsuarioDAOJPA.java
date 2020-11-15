/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao;

import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ismael
 */
public class UsuarioDAOJPA extends GenericDAO<Usuario, Integer>implements UsuarioDAO{
    
    public UsuarioDAOJPA(){
        super(Usuario.class);
    }

    @Override
    public Usuario consularPorUsuarioClave(String usuario, String clave) throws ConexionExcpetion {
        return null;
    }
    
}
