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
import javax.persistence.TypedQuery;

/**
 *
 * @author ismael
 */
public abstract class GenericDAO<T,PK> implements DAO<T, PK>{
    
    public static final String PU = "ejemplo_PU";
    
    protected EntityManager em;
    protected Class<T> classs;
    
    public GenericDAO(Class<T> classs){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
        this.classs = classs;
    }
    
    @Override
    public void registrar(T obj) {
        System.out.println("Estamos registrando con JPA....");
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(em.merge(obj));
            et.commit();
        } catch (Exception e){
            et.rollback();
        }
    }

    @Override
    public List<T> consultarTodos() {
        TypedQuery<T> tq = em.createNamedQuery(classs.getSimpleName() + ".consultarTodos", classs);
        return tq.getResultList();
    }

    @Override
    public T consultarPorId(PK id) throws ConexionExcpetion {
        System.out.println("Estamos consultando con JPA....");
        return em.find(this.classs, id);
    }
    
    @Override
    public void actualizar(T obj) throws ConexionExcpetion {
        registrar(obj);
    }

    @Override
    public void eliminarPorId(PK id) throws ConexionExcpetion {
        T obj = consultarPorId(id);
        em.remove(obj);
    }
}
