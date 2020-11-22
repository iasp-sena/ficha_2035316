/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.controllers;

import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Departamento;
import edu.sena.f2025316.appwebmaven01.services.DepartamentoService;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ismael
 */
@Named
@ViewScoped
public class DepartamentoController implements Serializable {

    @EJB
    private DepartamentoService departamentoService;

    private List<Departamento> departamentos;

    public List<Departamento> getDepartamentos() {
        try {
            if (Objects.isNull(departamentos)) {
                departamentos = departamentoService.consultaTodos();
            }
        } catch (ConexionExcpetion ex) {
            ex.printStackTrace();
        }
        return departamentos;

    }

}
