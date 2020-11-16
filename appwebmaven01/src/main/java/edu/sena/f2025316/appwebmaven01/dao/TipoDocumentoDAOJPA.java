/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao;

import edu.sena.f2025316.appwebmaven01.modelo.TipoDocumento;
import javax.ejb.Stateless;

/**
 *
 * @author Ismael
 */
@Stateless
public class TipoDocumentoDAOJPA extends GenericDAO<TipoDocumento, Integer> implements TipoDocumentoDAO{
    
    public TipoDocumentoDAOJPA(){
        super(TipoDocumento.class);
    }
    
}
