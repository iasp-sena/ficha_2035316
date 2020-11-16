/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.controllers;

import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.TipoDocumento;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import edu.sena.f2025316.appwebmaven01.services.TipoDocumentoService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ismael
 */
@Named
@ViewScoped
public class TipoDocumentoController implements Serializable{
    
    @EJB
    private TipoDocumentoService tipoDocumentoService;
    
    private List<TipoDocumento> tiposDocumentos;

    public TipoDocumentoController() {
    }
    
    @PostConstruct
    public void init(){
        try {
            tiposDocumentos = tipoDocumentoService.consultaTodos();
        } catch (ConexionExcpetion ex) {
            System.out.println("Error en la consulta de los tipos de documentos...");
            ex.printStackTrace();
        }
    }

    public List<TipoDocumento> getTiposDocumentos() {
        return tiposDocumentos;
    }
    
}
