/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.services;

import edu.sena.f2025316.appwebmaven01.dao.def.DepartamentoDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Departamento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ismael
 */
@Stateless
public class DepartamentoService {
    
    @EJB
    private DepartamentoDAO departamentoDAO;
    
    public List<Departamento> consultaTodos() throws ConexionExcpetion{
        List<Departamento> departamentos = departamentoDAO.consultarTodos();
        return departamentos;
    }
    
}
