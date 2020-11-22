/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.services;

import edu.sena.f2025316.appwebmaven01.dao.def.MunicipioDAO;
import edu.sena.f2025316.appwebmaven01.dao.def.TipoDocumentoDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Municipio;
import edu.sena.f2025316.appwebmaven01.modelo.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ismael
 */
@Stateless
public class MunicipioService {
    
    @EJB
    private MunicipioDAO municipioDAO;
    
    public List<Municipio> consultaPorDepartamentoId(Integer idDepartamento) throws ConexionExcpetion{
        List<Municipio> municipios = municipioDAO.consularPorDepartamentoId(idDepartamento);
        return municipios;
    }
    
}
