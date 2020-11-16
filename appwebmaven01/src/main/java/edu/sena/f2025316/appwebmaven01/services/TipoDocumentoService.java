/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.services;

import edu.sena.f2025316.appwebmaven01.dao.TipoDocumentoDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
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
public class TipoDocumentoService {
    
    @EJB
    private TipoDocumentoDAO tipoDocumentoDAO;
    
    public List<TipoDocumento> consultaTodos() throws ConexionExcpetion{
        /*
        List<TipoDocumento> tipos = new ArrayList<>();
        
        TipoDocumento td = new TipoDocumento();
        td.setId(1);
        td.setCodigo("CC");
        td.setDescripcion("Cédula de ciudadanía");
        
        TipoDocumento td2 = new TipoDocumento();
        td2.setId(2);
        td2.setCodigo("CE");
        td2.setDescripcion("Cédula de extranjería");
        
        tipos.add(td);
        tipos.add(td2);
        */
        List<TipoDocumento> tipos = tipoDocumentoDAO.consultarTodos();
        return tipos;
    }
    
}
