/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.exepciones.enums;

/**
 *
 * @author Ismael
 */
public enum FactoryExcpetionEnum {
    
    ERROR_FABRICA_DAO("20001", "Error al instanciar la fabrica DAO.");
    
    private String codigo;
    private String mensaje;

    private FactoryExcpetionEnum(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
}
