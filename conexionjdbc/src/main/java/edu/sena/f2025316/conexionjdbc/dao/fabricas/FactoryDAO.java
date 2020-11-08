/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao.fabricas;

import edu.sena.f2025316.conexionjdbc.dao.ProductoDAO;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAO;

/**
 *
 * @author Ismael
 */
public interface FactoryDAO {
    
    UsuarioDAO getUsuarioDAO();
    
    ProductoDAO getProductoDAO();
    
}
