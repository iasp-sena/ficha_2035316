/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao;

import edu.sena.f2025316.appwebmaven01.dao.def.MunicipioDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.exeception.enums.ConexionExcpetionEnum;
import edu.sena.f2025316.appwebmaven01.modelo.Municipio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ismael
 */
@Stateless
public class MunicipioDAOJPA extends GenericDAO<Municipio, Integer> implements MunicipioDAO{
    
    public MunicipioDAOJPA(){
        super(Municipio.class);
    }

    @Override
    public List<Municipio> consularPorDepartamentoId(Integer idDepartamento) throws ConexionExcpetion {
        try{
            TypedQuery<Municipio> tq = em.createNamedQuery("Municipio.findByDepartamentoId", classs);
            tq.setParameter("departamentoId", idDepartamento);
            return tq.getResultList();
        } catch (Exception e){
            throw new ConexionExcpetion(ConexionExcpetionEnum.ERROR_CONEXION, e);
        }
    }
    
}
