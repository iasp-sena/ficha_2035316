/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.controllers;

import edu.sena.f2025316.appwebmaven01.dao.def.MunicipioDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Municipio;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ismael
 */
@Named
@ViewScoped
public class MunicipioController implements Serializable {

    @EJB
    private MunicipioDAO municipioDAO;

    private Integer idDepartamentoSeleccionado;
    private List<Municipio> municipiosDepartamentoSeleccionado;

    public Integer getIdDepartamentoSeleccionado() {
        return idDepartamentoSeleccionado;
    }

    public void setIdDepartamentoSeleccionado(Integer idDepartamentoSeleccionado) {
        try {
            if (Objects.nonNull(idDepartamentoSeleccionado)) {
                municipiosDepartamentoSeleccionado = municipioDAO
                        .consularPorDepartamentoId(idDepartamentoSeleccionado);
            } else{
                municipiosDepartamentoSeleccionado = null;
            }
        } catch (ConexionExcpetion cx) {
            cx.printStackTrace();
        }
        this.idDepartamentoSeleccionado = idDepartamentoSeleccionado;
    }

    public List<Municipio> getMunicipiosDepartamentoSeleccionado() {
        return municipiosDepartamentoSeleccionado;
    }

}
