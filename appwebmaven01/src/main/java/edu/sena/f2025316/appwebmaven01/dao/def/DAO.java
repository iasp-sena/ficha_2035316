/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao.def;

import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import java.util.List;

/**
 *
 * @author ismael
 */
public interface DAO<T,PK> {
    
    void registrar(T usuario) throws ConexionExcpetion;
    
    T consultarPorId(PK id) throws ConexionExcpetion;
    
    List<T> consultarTodos() throws ConexionExcpetion;
    
    void actualizar(T usuario) throws ConexionExcpetion;
    
    void eliminarPorId(PK id) throws ConexionExcpetion;
    
}
