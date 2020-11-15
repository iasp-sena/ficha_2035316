/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao.fabricas;

import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAO;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAOJPA;
import edu.sena.f2025316.conexionjdbc.dao.TipoDocumentoDAO;
import edu.sena.f2025316.conexionjdbc.dao.TipoDocumentoDAOJPA;

/**
 *
 * @author Ismael
 */
public class FactoryDAOJPA implements FactoryDAO {

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOJPA();
    }

    @Override
    public TipoDocumentoDAO getTipoDocumentoDAO() {
        return new TipoDocumentoDAOJPA();
    }
    
}
