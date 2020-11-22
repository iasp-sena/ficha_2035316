/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao;

import edu.sena.f2025316.appwebmaven01.dao.def.DepartamentoDAO;
import edu.sena.f2025316.appwebmaven01.modelo.Departamento;
import javax.ejb.Stateless;

/**
 *
 * @author Ismael
 */
@Stateless
public class DepartamentoDAOJPA extends GenericDAO<Departamento, Integer> implements DepartamentoDAO{
    
    public DepartamentoDAOJPA(){
        super(Departamento.class);
    }
    
}
