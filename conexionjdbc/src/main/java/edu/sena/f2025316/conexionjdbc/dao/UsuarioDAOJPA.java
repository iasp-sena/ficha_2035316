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
public class UsuarioDAOJPA implements UsuarioDAO{
    
    public static final String PU = "ejemplo_PU";
    
    private EntityManager em;
    
    public UsuarioDAOJPA(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
    }

    @Override
    public void registrar(Usuario usuario) throws ConexionExcpetion {
        System.out.println("Estamos registrando con JPA....");
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(em.merge(usuario));
            et.commit();
        } catch (Exception e){
            et.rollback();
        }
    }

    @Override
    public Usuario consultarPorId(Integer id) throws ConexionExcpetion {
        System.out.println("Estamos consultando con JPA....");
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Usuario usuario) throws ConexionExcpetion {
        registrar(usuario);
    }

    @Override
    public void eliminarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
