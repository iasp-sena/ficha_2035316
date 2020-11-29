/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.filtros;

import java.util.Objects;

/**
 *
 * @author ismael
 */
public class FiltroUsuario {

    private Integer tipoDocumentoId;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;

    public Integer getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Integer tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isValid() {
        return (Objects.nonNull(tipoDocumentoId) && Objects.nonNull(numeroDocumento))
                || Objects.nonNull(nombres) || Objects.nonNull(apellidos);
    }

}
