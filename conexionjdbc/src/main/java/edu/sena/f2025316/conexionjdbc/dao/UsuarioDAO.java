/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao;

import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface UsuarioDAO extends DAO<Usuario, Integer>{
    
    Usuario consularPorUsuarioClave(String usuario, String clave) throws ConexionExcpetion;
    
}
