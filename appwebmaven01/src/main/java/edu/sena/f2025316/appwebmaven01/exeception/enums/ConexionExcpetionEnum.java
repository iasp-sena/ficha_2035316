/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.exeception.enums;

/**
 *
 * @author Ismael
 */
public enum ConexionExcpetionEnum {
    
    ERROR_CONEXION("10001", "Error al conectarse a la base de datos."),
    ERROR_CONSULTA("100002","Error al realizar la consulta."),
    ERROR_ACTUALIZA("100003","Error al realizar la actualización.");
    
    private String codigo;
    private String mensaje;

    private ConexionExcpetionEnum(String codigo, String mensaje) {
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
