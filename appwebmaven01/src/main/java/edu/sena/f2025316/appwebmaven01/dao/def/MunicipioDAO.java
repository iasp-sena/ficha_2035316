/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao.def;

import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Municipio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ismael
 */
@Local
public interface MunicipioDAO extends DAO<Municipio, Integer>{
    
    List<Municipio> consularPorDepartamentoId(Integer idDepartamento) throws ConexionExcpetion;
    
}
