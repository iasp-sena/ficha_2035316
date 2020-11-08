/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc;

import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        em.close();
    }
    
}
