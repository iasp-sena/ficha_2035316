/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc;

import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import edu.sena.f2025316.conexionjdbc.modelo.builders.UsuarioBuilder;
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
public class Main2 {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplo_PU");
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, 2);
        System.out.println(usuario);
        
        
        
        Usuario u = UsuarioBuilder.builder()
                .id(3)
                .tipoDocumentoId(1)
                .nombres("Diana")
                .apellidos("Castro")
                .nombreUsuario("dcastro@app.com")
                .clave("123")
                .build();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(em.merge(u));
            et.commit();
        } catch (Exception e){
            et.rollback();
        }
        System.out.println(u);
        
        
        //JPQL
        //String sql = "SELECT tbl_u.* FROM tbl_usuario tbl_u";
        String jpql = "SELECT u FROM Usuario u WHERE u.nombreUsuario=:correo";
        TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
        
        q.setParameter("correo", "dcastro@app.com");
        
        List<Usuario> usuarios = q.getResultList();
        
        usuarios.forEach(System.out::println);
        
        
        em.close();
    }
    
}
