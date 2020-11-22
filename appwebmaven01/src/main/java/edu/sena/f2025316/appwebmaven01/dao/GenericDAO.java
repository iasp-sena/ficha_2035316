/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao;

import edu.sena.f2025316.appwebmaven01.dao.def.DAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ismael
 */
public abstract class GenericDAO<T,PK> implements DAO<T, PK>{
    
    public static final String PU = "ejemplo_PU";
    
    @PersistenceContext(unitName = PU)
    protected EntityManager em;
    protected Class<T> classs;
    
    public GenericDAO(Class<T> classs){
        this.classs = classs;
    }
    
    @Override
    public void registrar(T obj) {
        System.out.println("Estamos registrando con JPA....");
        em.persist(em.merge(obj));
    }

    @Override
    public List<T> consultarTodos() {
        TypedQuery<T> tq = em.createNamedQuery(classs.getSimpleName() + ".findAll", classs);
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
