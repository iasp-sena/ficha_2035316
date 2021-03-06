/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao.fabricas;

import edu.sena.f2025316.conexionjdbc.exepciones.FactoryException;
import edu.sena.f2025316.conexionjdbc.exepciones.enums.FactoryExcpetionEnum;

/**
 *
 * @author Ismael
 */
public class Factory {
    
    private static final String MY_SQL = "edu.sena.f2025316.conexionjdbc.dao.fabricas.FactoryDAOMySQL";
    private static final String JPA = "edu.sena.f2025316.conexionjdbc.dao.fabricas.FactoryDAOJPA";
    
    private Factory(){
        
    }
    
    public static FactoryDAO getFactoryDAO() throws FactoryException{
        try {
            FactoryDAO factoryDAO = (FactoryDAO) Class
                    .forName(JPA)
                    .newInstance();
            return factoryDAO;
        } catch (Exception ex) {
            throw new FactoryException(FactoryExcpetionEnum.ERROR_FABRICA_DAO, ex);
        }
    }
            
    
}
