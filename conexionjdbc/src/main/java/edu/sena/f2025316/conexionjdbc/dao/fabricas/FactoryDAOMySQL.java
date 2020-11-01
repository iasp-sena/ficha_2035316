/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao.fabricas;

import edu.sena.f2025316.conexionjdbc.dao.ProductoDAO;
import edu.sena.f2025316.conexionjdbc.dao.ProductoDAOMySql;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAO;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAOMySql;

/**
 *
 * @author Ismael
 */
public class FactoryDAOMySQL implements FactoryDAO {

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOMySql();
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return new ProductoDAOMySql();
    }
    
}